package pk1;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.GregorianCalendar;

public abstract class Medium implements Comparable<Medium>{

	private int id = 0;
	private String titel;
	private int jahr;
	
	public Medium(int id, String titel, int jahr){
		this.id = id;
		this.titel = titel;
		this.jahr = jahr;
	}

	public int alter(){
		GregorianCalendar gl = new GregorianCalendar();
		return this.jahr - gl.get(GregorianCalendar.YEAR);
	}
	
	public abstract void druckenDaten();
	public abstract void druckenDaten(OutputStream stream);
	
	public int compereTo(Medium other){
		if(this.jahr == other.getJahr()) return 0;
		if(this.jahr <= other.getJahr()) return -1;
		return 1;
	}
	
	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public int getJahr() {
		return jahr;
	}

	public void setJahr(int jahr) {
		this.jahr = jahr;
	}

	public int getId() {
		return id;
	}
	
	public void serialisierung(Medium m, File f){
		try(FileOutputStream fos = new FileOutputStream(f);
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
				oos.writeObject(m);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				
			} catch (IOException e) {
				e.printStackTrace();
				
			}
	}
}