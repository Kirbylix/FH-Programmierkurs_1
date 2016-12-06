import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.List;
import java.util.LinkedList;

public class Medienverwaltung {

	/**
	 * Variablen deklaration
	 */
	List<Medium> medien = new LinkedList<Medium>();
	
	/**
	 * ein neues Medium wird der Medienverwaltung hinzugefügt
	 */
	public void aufnehmen(Medium _medium){
		medien.add(_medium);
	}
	
	/**
	 * gibt die Daten aller Medien auf der Konsole aus
	 */
	public void zeigeMedien(){
		Collections.sort(medien, new JahrComperator());
		for(Medium medium: medien){
			medium.druckenDaten(System.out);
		}
	}
	
	/**
	 * gibt die Daten des Mediums mit dem jüngsten Erscheinungsjahr auf der Konsole aus
	 */
	public void sucheNeuesMedium(){
		Collections.sort(medien, new JahrComperator());
		medien.get(0).druckenDaten(System.out);
	}
	
	/**
	 * berechnet das durchschnittliche Erscheinungsjahr aller Medien
	 * @return 0.0 falls die Liste der Medien leer ist
	 */
	public double berechneErscheinungsjahr(){
		double jahr=0.0;
		if(medien.isEmpty()==false){
			for(Medium m: medien){
				jahr = jahr + m.getJahr();
			}
			jahr = jahr / medien.size();
		}
		return jahr;
	}
	
	/**
	 * Serializierung der Medienliste
	 * @param _file
	 * @return true bei erfolg, false bei Fehler
	 */
	public boolean saveInFile(File _file){
		try(FileOutputStream fos = new FileOutputStream(_file);
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
			
			oos.writeObject(medien);
		} catch (FileNotFoundException e) {
			System.err.println("Fehler beim speichern in die Datei:");
			return false;
		} catch (IOException e) {
			System.err.println("Fehler beim speichern in die Datei:");
			return false;
		}
		return true;
	}
	
	/**
	 * Deserializierung der Medienliste
	 * @param _file
	 * @return true bei erfolg, false bei Fehler
	 */
	public boolean loadFromFile(File _file){
		List<Medium> input = null;
		try(FileInputStream fis = new FileInputStream(_file);
				ObjectInputStream oos = new ObjectInputStream(fis)){
			
			input = (List<Medium>) oos.readObject();
			for(Medium medium: input){
				aufnehmen(medium);
			}
		} catch (FileNotFoundException e) {
			System.err.println("Die Datei wurde nicht gefunden! \n");
			return false;
		} catch (IOException e) {
			System.err.println("Fehler beim laden aus der Datei: \n");
			return false;
		} catch (ClassNotFoundException e) {
			System.err.println("Fehler beim laden aus der Datei: \n");
			return false;
		}
		return true;
	}
}
