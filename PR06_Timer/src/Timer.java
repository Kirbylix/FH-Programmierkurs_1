
public class Timer implements Runnable{
	private Counter c;
	public Timer(Counter c){
		this.c = c;
	}
	
	public void run(){
		while(!Thread.currentThread().isInterrupted()){
			c.printLine();
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				System.out.println("Interrupted");
				Thread.currentThread().interrupt();
			}
		}
	}
}
