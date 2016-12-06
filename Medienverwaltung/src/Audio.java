import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Serializable;

public class Audio extends Medium implements Serializable{

	/**
	 * Variablen deklaration
	 */
	private String interpret;
	private int dauer;
	
	/**
	 * Konstruktor
	 * @param _id
	 * @param _titel
	 * @param _jahr
	 * @param _interpret
	 * @param _dauer
	 */
	public Audio(String _titel, int _jahr, String _interpret, int _dauer) {
		super(_titel, _jahr);
		this.interpret = _interpret;
		this.dauer = _dauer;
	}
	
	/**
	 * Mediendaten auf der Konsole ausgeben
	 */
	@Override
	public void druckenDaten() {
		System.out.println(	"ID = " + super.getId() + " " +  super.getTitel() + " von " + this.interpret + " aus " + super.getJahr() + " Spieldauer: " + this.dauer + " sek.");
	}
	
	/**
	 * Mediendaten in dem gewünschten Outputstream ausgeben
	 */
	@Override
	public void druckenDaten(OutputStream stream) {
		PrintStream ps = new PrintStream(stream);
		ps.printf("ID= %s %s von %s aus %d Spieldauer %d sek. \n", super.getId(), super.getTitel(), this.interpret, super.getJahr(), this.dauer);
		ps.flush();
	}

	/**
	 * Getter & Setter
	 */
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
}