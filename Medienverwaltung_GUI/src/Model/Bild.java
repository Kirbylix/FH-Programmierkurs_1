package Model;
import java.io.Serializable;


public class Bild extends Medium implements Serializable{
	/**
	 * Variablen deklaration
	 */
	private String ort;
	private String[] outputs;
	
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

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}
	
	public void update(String _titel, int _jahr, String _ort){
		this.setTitel(_titel);
		this.setJahr(_jahr);
		this.setOrt(_ort);
	}
	
	public String[] toStringArray(){
		String[] outputs = new String[3];
		outputs[0] = "" + this.getId();
		outputs[1] = this.getTitel();
		outputs[2] = "" + this.getJahr();
		outputs[3] = this.ort;		
		return outputs;
	}
}
