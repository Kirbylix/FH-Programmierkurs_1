public class Lable {
	private String type;	//Getränkeart
	private int bestBefore; //Haltbarkeitsdatum
	
	public Lable(String type, int bestBefore){
		this.type = type;
		this.bestBefore = bestBefore;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getBestBefore() {
		return bestBefore;
	}

	public void setBestBefore(int bestBefore) {
		this.bestBefore = bestBefore;
	}
}
