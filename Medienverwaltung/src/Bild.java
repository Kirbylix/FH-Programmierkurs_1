import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Serializable;

public class Bild extends Medium implements Serializable{

	/**
	 * Variablen deklaration
	 */
	private String ort;
	
	/**
	 * Konstruktor
	 * @param _id
	 * @param _titel
	 * @param _jahr
	 * @param _ort
	 */
	public Bild(String _titel, int _jahr, String _ort) {
		super(_titel, _jahr);
		this.ort = _ort;
	}
	
	/**
	 * Mediendaten auf der Konsole ausgeben
	 */
	@Override
	public void druckenDaten() {
		System.out.println("ID = " + this.getId() + " " + super.getTitel() + " aufgenommen im Jahr " + super.getJahr() + " in " + this.ort);
	}

	/**
	 * Mediendaten in dem gewünschten Outputstream ausgeben
	 */
	@Override
	public void druckenDaten(OutputStream stream) {
		PrintStream ps = new PrintStream(stream);
		ps.printf("ID= %s %s aufgenommen im Jahr %d in %s\n", super.getId(), super.getTitel(), super.getJahr(), this.ort);
		ps.flush();		
	}

	/**
	 * Getter & Setter
	 */
	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	
}