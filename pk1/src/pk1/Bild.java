package pk1;

import java.io.OutputStream;
import java.io.PrintStream;

public class Bild extends Medium {
	
	private String ort;

	public Bild(int id, String titel, int jahr, String ort) {
		super(id, titel, jahr);
		this.ort = ort;
	}

	@Override
	public void druckenDaten() {
		System.out.println("ID = " + this.getId() + " " + super.getTitel() + " aufgenommen im Jahr " + super.getJahr() + " in " + this.ort);
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	@Override
	public int compareTo(Medium o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void druckenDaten(OutputStream stream) {
		PrintStream ps = new PrintStream(stream);
		ps.printf("ID= %s %s aufgenommen im Jahr %d in %s\n", super.getId(), super.getTitel(), super.getJahr(), this.ort);
		ps.flush();		
	}
}