package Controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;

import GUI.MediumHPView;
import Model.*;


public class MedienVerwaltung {
	
	/**
	 * Variablen deklaration
	 */
	List<Medium> medien = new LinkedList<Medium>();
	MediumHPView mHPView;
	
	public MedienVerwaltung(){
		mHPView = new MediumHPView(this);
		mHPView.setVisible(true);
		
		//TEST
		addMedium(new Audio("erste", 111, "Heinz", 11));
		addMedium(new Audio("zweite", 222, "Heinz", 22));
		addMedium(new Audio("dritte", 333, "Heinz", 33));
		addMedium(new Audio("vierte", 444, "Heinz", 44));
		
		List<Audio> audios = this.getAudios();
		for(Audio a: audios){
			System.out.println("Titel: " + a.getTitel());
		}
	}
	
	public void addMedium(Medium medium){
		medien.add(medium);
		System.out.println("Medium wurde hinzugef�gt");
		mHPView.updateTable();
	}
	
	public boolean deleteMedium(Medium medium){
		if(medien.remove(medium)){
			mHPView.updateTable();
			System.out.println("Medium wurde gel�scht");
			return true;
		}
		return false;
	}
	
	public boolean changeMedium(Medium _medium){
		//TODO Such Algo
		for(Medium m: this.medien){
			if(m.getId() == _medium.getId()){
				System.out.println("Medium wurde getauscht");
				m = _medium;
				return true;
			}
		}
		return false;
	}
	
	public List<Medium> getMedien() {
		return medien;
	}
	
	public List<Bild> getBilder(){
		List<Bild> bilder = new LinkedList<Bild>();
		for(Medium m: medien){
			if(m.getClass() == Bild.class){
				bilder.add((Bild)m);
			}
		}
		return bilder;
	}
	
	public List<Audio> getAudios(){
		List<Audio> audio = new LinkedList<Audio>();
		for(Medium m: medien){
			System.out.println("Class: " + m.getClass());
			if(m.getClass() == Audio.class){
				System.out.println("Titel: " + m.getTitel());
				audio.add((Audio)m);
			}
		}
		return audio;
	}
	
	public Medium getMedium(int id){
		for(Medium m: medien){
			if(m.getId() == id){
				return m;
			}
		}
		return null;
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
			System.err.println("1 Fehler beim speichern in die Datei");
			return false;
		} catch (IOException e) {
			System.err.println("2 Fehler beim speichern in die Datei");
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
				addMedium(medium);
			}
		} catch (FileNotFoundException e) {
			System.err.println("Die Datei wurde nicht gefunden! \n");
			return false;
		} catch (IOException e) {
			System.err.println("1 Fehler beim laden aus der Datei \n");
			return false;
		} catch (ClassNotFoundException e) {
			System.err.println("2 Fehler beim laden aus der Datei \n");
			return false;
		}
		return true;
	}
}
