
public class Counter {
	private int c;
	public synchronized void printLine(){
		c++;
		System.out.println(c + " Sekunden lauft das Programm");
	}
}
