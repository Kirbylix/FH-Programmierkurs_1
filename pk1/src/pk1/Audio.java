package pk1;

import java.io.OutputStream;
import java.io.PrintStream;

public class Audio extends Medium {

	private String interpret;
	private int dauer;

	public Audio(int id, String titel, int jahr, String interpret, int dauer) {
		super(id, titel, jahr);
		this.interpret = interpret;
		this.dauer = dauer;
	}

	@Override
	public void druckenDaten() {
		System.out.println(	"ID = " + super.getId() + " " +  super.getTitel() + " von " + this.interpret + " aus " + super.getJahr() + " Spieldauer: " + this.dauer + " sek.");
	}
	
	@Override
	public void druckenDaten(OutputStream stream) {
		PrintStream ps = new PrintStream(stream);
		ps.printf("ID= %s %s von %s aus %d Spieldauer %d sek. \n", super.getId(), super.getTitel(), this.interpret, super.getJahr(), this.dauer);
		ps.flush();
	}
	
	public String getInterpret() {
		return interpret;
	}

	public void setInterpret(String interpret) {
		this.interpret = interpret;
	}

	public int getDauer() {
		return dauer;
	}

	public void setDauer(int dauer) {
		this.dauer = dauer;
	}

	@Override
	public int compareTo(Medium o) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}