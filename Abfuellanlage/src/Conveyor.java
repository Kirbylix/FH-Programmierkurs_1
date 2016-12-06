public class Conveyor {
	
	Bottle[] bottles;

	public Conveyor(){
		bottles = new Bottle[50];
	}
	
	public void load(Bottle bottle){
		for(int i=0; i<=50; i++){
			if(bottles[i] == null){
				bottles[i] = bottle;
				break;
			}
		}
	}
	
	public Bottle withdraw(){
		int i = 0;
		Bottle bottle = bottles[i];
		do{
			bottles[i] = bottles[i++];
		}while(bottles[i] != null && i != 49);
		bottles[i]=null;
		return bottle;
	}
	
	public boolean isEmpty(){
		if(this.bottles[0] == null){
			return true;
		}
		return false;
	}
	
	public boolean isOverloaded(){
		if(this.bottles[49] == null){
			return false;
		}
		return true;
	}
	
	public int anzahl(){
		int counter = 0;
		do{
			counter++;
		}while(bottles[counter] != null && counter != 49);
		return counter+1;
	}
}