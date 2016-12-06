package GUI;
import java.awt.Button;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import Controller.MedienVerwaltung;
import Model.*;

public class BildErfassungView extends JDialog{

	Label lTitel, lErscheinungsjahr, lOrt;
	TextField tfTitel, tfErscheinungsjahr, tfOrt;
	Button bOK, bAbbrechen;
	Bild bild;
	Boolean option = true;
	MedienVerwaltung mv;
	
	public BildErfassungView(MedienVerwaltung _mv, Bild _bild){
		this.mv = _mv;
		this.bild = _bild;
		if(bild != null){
			option = false;
			this.tfTitel.setText(bild.getTitel());
			this.tfErscheinungsjahr.setText(""+bild.getJahr());
			this.tfOrt.setText(bild.getOrt());
		}
		
		this.initComponents();
		this.display();	
	}
	
	public void display(){
		setTitle("Bild Erfassung");
		setSize(300, 250);	
		setVisible(true);
	}
	
	public void initComponents(){
		GridBagLayout gbl = new GridBagLayout();
		setLayout(gbl);
		GridBagConstraints gbc = new GridBagConstraints();
		
		lTitel = new Label("Titel");
		lErscheinungsjahr = new Label("Erscheinungsjahr");
		lOrt = new Label("Ort");
		tfTitel = new TextField();
		tfErscheinungsjahr = new TextField();
		tfOrt = new TextField();
		bOK = new Button("OK");
		bAbbrechen = new Button("Abbrechen");
		
		gbc = configGBC(0, 0, 1, 1, 100 , 100, GridBagConstraints.NONE);
		gbl.setConstraints(lTitel, gbc);
		add(lTitel);
		gbc = configGBC(1, 0, 1, 1, 100 , 100, GridBagConstraints.HORIZONTAL);
		gbl.setConstraints(tfTitel, gbc);
		add(tfTitel);
		gbc = configGBC(0, 1, 1, 1, 100 , 100, GridBagConstraints.NONE);
		gbl.setConstraints(lErscheinungsjahr, gbc);
		add(lErscheinungsjahr);
		gbc = configGBC(1, 1, 1, 1, 100 , 100, GridBagConstraints.HORIZONTAL);
		gbl.setConstraints(tfErscheinungsjahr, gbc);
		add(tfErscheinungsjahr);
		gbc = configGBC(0, 2, 1, 1, 100 , 100, GridBagConstraints.NONE);
		gbl.setConstraints(lOrt, gbc);
		add(lOrt);
		gbc = configGBC(1, 2, 1, 1, 100 , 100, GridBagConstraints.HORIZONTAL);
		gbl.setConstraints(tfOrt, gbc);
		add(tfOrt);
		gbc = configGBC(0, 3, 1, 1, 100 , 100, GridBagConstraints.NONE);
		bOK.addActionListener(new ALOk(option));
		gbl.setConstraints(bOK, gbc);
		add(bOK);
		gbc = configGBC(1, 3, 1, 1, 100 , 100, GridBagConstraints.NONE);
		bAbbrechen.addActionListener(new ALAbbrechen());
		gbl.setConstraints(bAbbrechen, gbc);
		add(bAbbrechen);
	}
	
	public GridBagConstraints configGBC (int gridx, int gridy, int gridwidth, int gridheight, int weightx, int weighty, int skal){
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = gridx;
		gbc.gridy = gridy;
		gbc.gridwidth = gridwidth;
		gbc.gridheight = gridheight;
		gbc.weightx = weightx;
		gbc.weighty = weighty;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.fill = skal;
		
		return gbc;
	}	
	
	public class ALOk implements ActionListener{
		Boolean option;
		public ALOk(Boolean _option){
			this.option = _option;
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int EJahr = 0;
			
			//Pr�fen auf Inhalt
			if(tfTitel.getText().length() == 0){
				JOptionPane.showMessageDialog(null, "Es wurde kein Titel eingegeben", "Fehler", JOptionPane.ERROR_MESSAGE);
			}
			if(tfErscheinungsjahr.getText().length() == 0){
				JOptionPane.showMessageDialog(null, "Es wurde kein Erscheinungsjahr eingegeben", "Fehler", JOptionPane.ERROR_MESSAGE);
			}
			if(tfOrt.getText().length() == 0){
				JOptionPane.showMessageDialog(null, "Es wurde kein Ort eingegeben", "Fehler", JOptionPane.ERROR_MESSAGE);
			}
			// String -> Int
			try{
				EJahr = Integer.parseInt(tfErscheinungsjahr.getText());
			}catch(NumberFormatException e){
				JOptionPane.showMessageDialog(null, "Benutzten Sie nur Zahlen f�r das Erscheinungsjahr", "Fehler", JOptionPane.ERROR_MESSAGE);
			}
			bild = new Bild(tfTitel.getText(), EJahr, tfOrt.getText());
			if(option == true){
				System.out.println("Neu");
				mv.addMedium(new Bild(tfTitel.getText(), EJahr, tfOrt.getText()));
			}else{
				System.out.println("Change");
				mv.changeMedium(new Bild(tfTitel.getText(), EJahr, tfOrt.getText()));
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