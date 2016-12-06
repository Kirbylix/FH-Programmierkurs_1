package Model;
import java.io.Serializable;
import java.util.GregorianCalendar;

public abstract class Medium implements Serializable{

	/**
	 * Variablen deklaration
	 */
	private int id = 0;
	private static int counter;
	private String titel;
	private int jahr;
	
	/**
	 * Konstruktor
	 * @param _id
	 * @param _titel
	 * @param _jahr
	 */
	public Medium(String _titel, int _jahr){
		this.id = counter++;
		this.titel = _titel;
		this.jahr = _jahr;
	}
	
	/**
	 * Berechnung des Medienalters
	 * @return
	 */
	public int alter(){
		GregorianCalendar gl = new GregorianCalendar();
		return this.jahr - gl.get(GregorianCalendar.YEAR);
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
	
	public abstract String[] toStringArray();
}
