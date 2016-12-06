import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Menue {

	/**
	 * Variablen deklaration
	 */
	private static Medienverwaltung mv;
	private static String buffer;
	
	/**
	 * Konstruktor
	 */
	public Menue(){
		mv = new Medienverwaltung();
		
		//TEST

		mv.aufnehmen(new Audio("erste", 111, "Heinz", 11));
		mv.aufnehmen(new Audio("zweite", 222, "Heinz", 22));
		mv.aufnehmen(new Audio("dritte", 333, "Heinz", 33));
		mv.aufnehmen(new Audio("vierte", 444, "Heinz", 44));
		
		printMenue();
	}
	
	/**
	 * Menue
	 */
	public static void printMenue(){
		int choise=0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. Audio aufnehmen");
		System.out.println("2. Bild aufnehmen");
		System.out.println("3. Zeige alle Medien");
		System.out.println("4. Medienliste in Datei schreiben");
		System.out.println("5. speichern");
		System.out.println("6. laden");
		System.out.println("7. Zeige neues Medium");
		System.out.println("8. Berechne durchschnittliche Erscheinungsjahr");
		System.out.println("9. Beenden \n");
		System.out.println("Bitte Menüpunkt wählen:");
		try{
			choise = sc.nextInt();
		}catch(InputMismatchException e)
		{
			System.out.println("KEINE BUCHSTABEN !!! \n");
			printMenue();
		}
		
		switch(choise){
		case 1:			// Audio aufnehmen
			mv.aufnehmen(new Audio(inputText("Titel"), inputNumber("Erscheinungsjahr"), inputText("Interpret"), inputNumber("Dauer")));
			printMenue();
			break;
		case 2:			// Bild aufnehmen
			mv.aufnehmen(new Bild(inputText("Titel"), inputNumber("Erscheinungsjahr"), inputText("Ort")));
			printMenue();
			break;
		case 3:			// Zeige alle Medien
			mv.zeigeMedien();
			System.out.println();
			printMenue();
			break;
		case 4:
			buffer = null;
			do{
				buffer = JOptionPane.showInputDialog(null, " Bitte geben Sie den Dateinamen ein:");
			}while(buffer == null || buffer.length() == 0);
			File file = new File("save/" + buffer +  ".txt");
			FileOutputStream fos;
			try {
				fos = new FileOutputStream(file);
				for(Medium medieum: mv.medien){
					medieum.druckenDaten(fos);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 5:			//Medienliste in Datei schreiben
			if(mv.saveInFile(new File("save/saveMedien.txt"))){
				System.out.println("Die Medienliste wurde erfolgreich gespeichert");
			}else{
				System.err.println("Beim speichern der Medienliste ist ein Fehler aufgetreten");
			}
			printMenue();
			break;
		case 6:			// Datei laden
			if(mv.loadFromFile(new File("save/" + buffer + ".txt"))){
				System.out.println("Die Medienliste wurde erfolgreich geladen");
			}else{
				System.err.println("Beim laden der Medienliste ist ein Fehler aufgetreten");
			}
			printMenue();
			break;
		case 7:			// Zeige neues Medium
			mv.sucheNeuesMedium();
			printMenue();
			break;
		case 8:			// durchschnittliche E. Jahr
			System.out.println("D. Jahr = " + mv.berechneErscheinungsjahr());
			printMenue();
			break;
		case 9:			// Beenden
			System.exit(0);
			break;
		default:
			printMenue();
		}
		sc.close();
	}
	
	/**
	 * Message Dialog für eingabe einer Nummer
	 * @param _target
	 * @return
	 */
	public static int inputNumber(String _target){
		int out = 0;
		String eingabe = null;
		do{
			eingabe = JOptionPane.showInputDialog(null, _target + ":");
			if(eingabe == null){printMenue();}
			try{
				out = Integer.parseInt(eingabe);
			}catch(NumberFormatException e)
			{
				JOptionPane.showMessageDialog(null, "Bitte gültiges " + _target + " eingeben", "ERROR", JOptionPane.WARNING_MESSAGE);
			}
		}while(out==0);
		return out;
	}
	
	/**
	 * Message Dialog für die eingabe eines Textes
	 * @param _target
	 * @return
	 */
	public static String inputText(String _target){
		
		String eingabe = null;
		eingabe = JOptionPane.showInputDialog(null,_target + ":");
		if(eingabe == null){printMenue();}
		return eingabe;
	}
}