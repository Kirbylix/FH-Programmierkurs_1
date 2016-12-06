
public class Bottle {
	public Lable lable = null;

	
	public void printLable(){
		System.out.print(lable.getType() + " mindestens haltbar bis " + lable.getBestBefore());
	}

	public void addLable(String typ, int bestBefore) {
		this.lable = new Lable(typ, bestBefore);
	}
}