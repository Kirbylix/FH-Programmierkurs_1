package pk1;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Medienverwaltung {

	List<Medium> liste = new LinkedList<Medium>();
	
	public void aufnehmen(Medium sMedium){
		liste.add(sMedium);
	}
	
	public void zeigeMedien(){
		Collections.sort(liste, new JahrComperator());
		for(Medium m: liste){
			m.druckenDaten(System.out);
		}
	}
	
	public void sucheNeuesMedium(){
		Collections.sort(liste, new JahrComperator());
		liste.get(0).druckenDaten(System.out);
	}
	
	public double berechneErscheinungsjahr(){
		double jahr=0.0;
		if(liste.isEmpty()==false){
			for(Medium m: liste){
				jahr = jahr + m.getJahr();
			}
			jahr = jahr / liste.size();
		}
		return jahr;
	}
}