public class LabelingMachine implements Runnable{

	private Conveyor band;
	
	public LabelingMachine(Conveyor band){
		this.band = band;
	}

	@Override
	public void run() {
		while(true){
			try {
				synchronized(band){
					if(band.isEmpty()){
						System.out.println("Etikettiermaschine: Warten, da Foerderband leer");
						band.wait();
					}else{
						Bottle bottle = band.withdraw();
						bottle.addLable("Bier", 2015);
						System.out.print("Etikettiermaschine: ");
						bottle.printLable();
						System.out.println(" " + band.anzahl());
						band.notifyAll();
					}
				}
				Thread.sleep((int) (400.0));
			}catch (InterruptedException e) {
				e.printStackTrace();	
			}
		}
	}
}