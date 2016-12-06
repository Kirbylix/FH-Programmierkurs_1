
public class main {

	public static void main(String[] args) {
		Conveyor band = new Conveyor();
		
		BottlingPlant bp = new BottlingPlant(band);
		LabelingMachine lm = new LabelingMachine(band);
		
		Thread tBP = new Thread(bp);
		Thread tLM = new Thread(lm);
		
		tBP.start();
		tLM.start();
	}
}