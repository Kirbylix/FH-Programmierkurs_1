package pk1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Menue {
	
	//private static Scanner sc;
	private static Medienverwaltung mv;
	static JFrame frame = new JFrame("");

	public static void main(String[] args) {
		
		mv = new Medienverwaltung();
		
		//TEST
		mv.aufnehmen(new Audio(1, "erste", 111, "Heinz", 11));
		mv.aufnehmen(new Audio(2, "zweite", 222, "Heinz", 22));
		mv.aufnehmen(new Audio(3, "dritte", 333, "Heinz", 33));
		mv.aufnehmen(new Audio(4, "vierte", 444, "Heinz", 44));
		
		
		
		printMenue();
	}
	
	public static void printMenue(){
		int choise=0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. Audio aufnehmen");
		System.out.println("2. Bild aufnehmen");
		System.out.println("3. Zeige alle Medien");
		System.out.println("4. Medienliste in Datei schreiben");
		System.out.println("5. Zeige neues Medium");
		System.out.println("6. Berechne durchschnittliche Erscheinungsjahr");
		System.out.println("7. Beenden \n");
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
			mv.aufnehmen(inputAudio());
			printMenue();
			break;
		case 2:			// Bild aufnehmen
			mv.aufnehmen(inputBild());
			printMenue();
			break;
		case 3:			// Zeige alle Medien
			mv.zeigeMedien();
			printMenue();
			break;
		case 4:			//Medienliste in Datei schreiben
			if(writeMedienFile() == true){
				JOptionPane.showMessageDialog(frame, "Die Datei wurde erfolgreich beschrieben", "Efolg", JOptionPane.WARNING_MESSAGE);
			}else{
				JOptionPane.showMessageDialog(frame, "Es ist ein Fehler aufgetreten, bitte wiederholen", "ERROR", JOptionPane.WARNING_MESSAGE);
			}
			break;
		case 5:			// Zeige neues Medium
			mv.sucheNeuesMedium();
			printMenue();
			break;
		case 6:			// durchschnittliche E. Jahr
			System.out.println("D. Jahr = " + mv.berechneErscheinungsjahr());
			printMenue();
			break;
		case 7:			// Beenden
			System.exit(0);
			break;
		default:
			printMenue();
		}
	}
	
	public static Audio inputAudio(){
		int id = 0, jahr = 0, dauer = 0;
		String titel = null, interpret = null, eingabe = null;
		// ID:
		do{
			eingabe = JOptionPane.showInputDialog(frame,"ID:");
			if(eingabe == null){printMenue();}
			try{
				id = Integer.parseInt(eingabe);
			}catch(NumberFormatException e)
			{
				JOptionPane.showMessageDialog(frame, "Bitte gültige ID eingeben", "ERROR", JOptionPane.WARNING_MESSAGE);
			}
		}while(id==0);
		// Titel
		eingabe = null;
		eingabe = JOptionPane.showInputDialog(frame,"Titel:");
		if(eingabe == null){printMenue();}
		titel = eingabe;
		
		// Erscheinungsjahr
		eingabe = null;
		do{
			eingabe = JOptionPane.showInputDialog(frame,"Jahr:");
			if(eingabe == null){printMenue();}
			try{
				jahr = Integer.parseInt(eingabe);
			}catch(NumberFormatException e)
			{
				JOptionPane.showMessageDialog(frame, "Bitte gültiges Erscheinungsjahr eingeben", "ERROR", JOptionPane.WARNING_MESSAGE);
			}
		}while(jahr==0);
		// Interpret
		eingabe = null;
		eingabe = JOptionPane.showInputDialog(frame,"Interpret:");
		if(eingabe == null){printMenue();}
		interpret = eingabe;
		//Dauer
		eingabe = null;
		do{
			eingabe = JOptionPane.showInputDialog(frame,"Dauer:");
			if(eingabe == null){printMenue();}
			try{
				dauer = Integer.parseInt(eingabe);
			}catch(NumberFormatException e)
			{
				JOptionPane.showMessageDialog(frame, "Bitte eine gültige Dauer eingeben", "ERROR", JOptionPane.WARNING_MESSAGE);
			}
		}while(dauer==0);		
		return new Audio(id, titel, jahr, interpret, dauer);
	}
	
	public static Bild inputBild(){
		int id = 0, jahr = 0;
		String titel = null, ort = null, eingabe = null;
		//ID
		eingabe = JOptionPane.showInputDialog(frame,"ID:");
		do{
			eingabe = JOptionPane.showInputDialog(frame,"ID:");
			if(eingabe == null){printMenue();}
			try{
				id = Integer.parseInt(eingabe);
			}catch(NumberFormatException e)
			{
				JOptionPane.showMessageDialog(frame, "Bitte gültige ID eingeben", "ERROR", JOptionPane.WARNING_MESSAGE);
			}
		}while(id==0);
		// Titel
		eingabe = null;
		eingabe = JOptionPane.showInputDialog(frame,"Titel:");
		if(eingabe == null){printMenue();}
		titel = eingabe;
		// Jahr
		eingabe = null;
		do{
			eingabe = JOptionPane.showInputDialog(frame,"Jahr:");
			if(eingabe == null){printMenue();}
			try{
				jahr = Integer.parseInt(eingabe);
			}catch(NumberFormatException e)
			{
				JOptionPane.showMessageDialog(frame, "Bitte gültiges Erscheinungsjahr eingeben", "ERROR", JOptionPane.WARNING_MESSAGE);
			}
		}while(jahr==0);
		// Ort
		eingabe = null;
		eingabe = JOptionPane.showInputDialog(frame,"Ort:");
		if(eingabe == null){printMenue();}
		ort = eingabe;
		
		return new Bild(id, titel, jahr, ort);
	}
	
	public static boolean writeMedienFile()
	{
		String fileName = JOptionPane.showInputDialog(frame,"Dateiname:");
		File file = new File(fileName + ".txt");
		/*try(FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
			oos.writeObject(mv.liste);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}*/
		mv.
		return true;
	}
}
