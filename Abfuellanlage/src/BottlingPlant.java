public class BottlingPlant implements Runnable{
	
	public Conveyor band;
	
	public BottlingPlant(Conveyor band){
		this.band = band;
	}

	@Override
	public void run() {
		while(true){
			try{
				synchronized(band){
					if(band.isOverloaded()){
						System.out.println("Abfuellanlage:  Warten, da Foerderband voll");
						band.wait();
					}else{
						band.load(new Bottle());
						System.out.println("Abfuellanlage: Neue Flasche abgefuellt, " + band.anzahl());
						band.notifyAll();
					}
				}
				Thread.sleep((int) (100.0));
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}	
	}
}