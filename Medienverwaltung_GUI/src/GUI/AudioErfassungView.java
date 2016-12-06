package GUI;
import java.awt.Button;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import Model.Audio;
import Model.Medium;
import Controller.*;

public class AudioErfassungView extends JDialog{
	
	Label lTitel, lErscheinungsjahr, lInterpret, lDauer;
	TextField tfTitel, tfErscheinungsjahr, tfInterpret, tfDauer;
	Button bOK, bAbbrechen;
	Audio audio;
	Boolean option = true;
	MedienVerwaltung mv;
	
	public AudioErfassungView(MedienVerwaltung _mv, Audio _audio){
		this.mv = _mv;
		this.audio = _audio;
		if(audio !=null){
			this.tfTitel.setText(audio.getTitel());
			this.tfInterpret.setText(audio.getInterpret());
			this.tfDauer.setText("" + audio.getDauer());
			this.tfErscheinungsjahr.setText("" + audio.getJahr());
			
			
			option = false;
		}
		
		this.initComponents();
		this.display();	
	}
	
	public void display(){
		setTitle("Audio Erfassung");
		setSize(300, 250);	
		setVisible(true);
	}
	
	public void initComponents(){
		GridBagLayout gbl = new GridBagLayout();
		setLayout(gbl);
		GridBagConstraints gbc = new GridBagConstraints();
		
		lTitel = new Label("Titel");
		lErscheinungsjahr = new Label("Erscheinungsjahr");
		lInterpret = new Label("Interpret");
		lDauer = new Label("Dauer");
		tfTitel = new TextField();
		tfErscheinungsjahr = new TextField();
		tfInterpret = new TextField();
		tfDauer = new TextField();
		bOK = new Button("OK");
		bAbbrechen = new Button("Abbrechen");
		
		gbc = configGBC(0, 0, 1, 1, 100 , 100, GridBagConstraints.NONE);
		gbl.setConstraints(lDauer, gbc);
		add(lDauer);
		gbc = configGBC(1, 0, 1, 1, 100 , 100, GridBagConstraints.HORIZONTAL);
		gbl.setConstraints(tfDauer, gbc);
		add(tfDauer);
		gbc = configGBC(0, 1, 1, 1, 100 , 100, GridBagConstraints.NONE);
		gbl.setConstraints(lErscheinungsjahr, gbc);
		add(lErscheinungsjahr);
		gbc = configGBC(1, 1, 1, 1, 100 , 100, GridBagConstraints.HORIZONTAL);
		gbl.setConstraints(tfErscheinungsjahr, gbc);
		add(tfErscheinungsjahr);
		gbc = configGBC(0, 2, 1, 1, 100 , 100, GridBagConstraints.NONE);
		gbl.setConstraints(lInterpret, gbc);
		add(lInterpret);
		gbc = configGBC(1, 2, 1, 1, 100 , 100, GridBagConstraints.HORIZONTAL);
		gbl.setConstraints(tfInterpret, gbc);
		add(tfInterpret);
		gbc = configGBC(0, 3, 1, 1, 100 , 100, GridBagConstraints.NONE);
		gbl.setConstraints(lTitel, gbc);
		add(lTitel);
		gbc = configGBC(1, 3, 1, 1, 100 , 100, GridBagConstraints.HORIZONTAL);
		gbl.setConstraints(tfTitel, gbc);
		add(tfTitel);
		gbc = configGBC(0, 4, 1, 1, 100 , 100, GridBagConstraints.NONE);
		bOK.addActionListener(new ALOk(option));
		gbl.setConstraints(bOK, gbc);
		add(bOK);
		gbc = configGBC(1, 4, 1, 1, 100 , 100, GridBagConstraints.NONE);
		bAbbrechen.addActionListener(new ALAbbrechen());
		gbl.setConstraints(bAbbrechen, gbc);
		add(bAbbrechen);
	}
	
	public GridBagConstraints configGBC (int _gridx, int _gridy, int _gridwidth, int _gridheight, int _weightx, int _weighty, int _skal){
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = _gridx;
		gbc.gridy = _gridy;
		gbc.gridwidth = _gridwidth;
		gbc.gridheight = _gridheight;
		gbc.weightx = _weightx;
		gbc.weighty = _weighty;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.fill = _skal;
		
		return gbc;
	}
		
	public class ALOk implements ActionListener{
		Boolean option;
		public ALOk(Boolean _option){
			this.option = _option;
			
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int EJahr = 0, dauer = 0;
			if(option){
				System.out.println("neu");
			}else{
				System.out.println("change");
			}
			//Pr�fen auf Inhalt
			if(tfTitel.getText().length() == 0){
				JOptionPane.showMessageDialog(null, "Es wurde kein Titel eingegeben", "Fehler", JOptionPane.ERROR_MESSAGE);
			}
			if(tfErscheinungsjahr.getText().length() == 0){
				JOptionPane.showMessageDialog(null, "Es wurde kein Erscheinungsjahr eingegeben", "Fehler", JOptionPane.ERROR_MESSAGE);
			}
			if(tfInterpret.getText().length() == 0){
				JOptionPane.showMessageDialog(null, "Es wurde kein Interpter eingegeben", "Fehler", JOptionPane.ERROR_MESSAGE);
			}
			if(tfDauer.getText().length() == 0){
				JOptionPane.showMessageDialog(null, "Es wurde keine Dauer eingegeben", "Fehler", JOptionPane.ERROR_MESSAGE);
			}
			try{
				EJahr = Integer.parseInt(tfErscheinungsjahr.getText());
			}catch(NumberFormatException e){
				JOptionPane.showMessageDialog(null, "Benutzten Sie nur Zahlen f�r das Erscheinungsjahr", "Fehler", JOptionPane.ERROR_MESSAGE);
			}
			try{
				dauer = Integer.parseInt(tfDauer.getText());
			}catch(NumberFormatException e){
				JOptionPane.showMessageDialog(null, "Benutzten Sie nur Zahlen f�r die Dauer", "Fehler", JOptionPane.ERROR_MESSAGE);
			}
			if(option == true){
				System.out.println("Neu");
				mv.addMedium(new Audio(tfTitel.getText(), EJahr, tfInterpret.getText(), dauer));
			}else{
				System.out.println("Change");
				mv.changeMedium(new Audio(tfTitel.getText(), EJahr, tfInterpret.getText(), dauer));
			}
			dispose();
		}
	}
		
	public class ALAbbrechen implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			dispose();
		}
	}
}