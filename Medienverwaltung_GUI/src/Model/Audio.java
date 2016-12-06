package Model;
import java.io.Serializable;


public class Audio extends Medium implements Serializable{

	/**
	 * Variablen deklaration
	 */
	private String interpret;
	private int dauer;
	private String[] outputs;
	
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
	
	public void update(String _titel, int _jahr, String _interpret, int _dauer){
		this.setTitel(_titel);
		this.setJahr(_jahr);
		this.setInterpret(_interpret);
		this.setDauer(_dauer);
	}
	
	public String[] toStringArray(){
		String[] outputs = new String[5];
		outputs[0] = "" + this.getId();
		outputs[1] = this.getTitel();
		outputs[2] = "" + this.getJahr();
		outputs[3] = this.getInterpret();
		outputs[4] = "" + this.getDauer();		
		return outputs;
	}
}
