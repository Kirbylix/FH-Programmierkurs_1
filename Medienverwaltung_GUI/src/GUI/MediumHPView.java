package GUI;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;

import Controller.MedienVerwaltung;
import Model.*;

public class MediumHPView extends JFrame{
	//Button bAddAudio, bAddBild, bShowAllMedien, baverageEyear, bsaveList, bloadList, bExit;
	JMenuBar menu;
	JMenu jmDatei, jmMedium, jmAnzeige, jmNeu;
	JMenuItem jmiSpeichern, jmiLaden, jmiBeenden, jmiAendern, jmiDelete, jmiAddBild, jmiAddAudio, jmiDErscheinungsjahr, jmiShowBild, jmiShowAudio, jmiNewMedium;
	JTable tMedien, tAudio, tBild;
	JPanel pMain, pMedien, pBild, pAudio;
	JScrollPane spMedien, spAudio, spBild;
	MedienVerwaltung mv;
	MedienTableModel mMedien;
	BildTableModel mBild;
	AudioTableModel mAudio;
	CardLayout cardLayout;
	
	public MediumHPView(MedienVerwaltung mv){
		this.mv = mv;
		this.initComponents();		
		this.display();
	}
	
	public void display(){
		this.setSize(500, 300);
		this.setTitle("Medienverwaltung");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void initComponents(){
		pMedien = new JPanel();//MedienListeView(mv);
		pMedien.setName("MEDIEN");
		mMedien = new MedienTableModel(mv.getMedien());
		mMedien.fireTableDataChanged();
		mMedien.fireTableStructureChanged();  
		tMedien = new JTable(mMedien);
		tMedien.setAutoCreateRowSorter(true);
		spMedien = new JScrollPane(tMedien);
		pMedien.add(spMedien, BorderLayout.CENTER);
		
		pAudio = new JPanel();
		pAudio.setName("AUDIO");
		mAudio = new AudioTableModel(mv.getAudios());
		mAudio.fireTableDataChanged();
		mAudio.fireTableStructureChanged();  
		tAudio = new JTable(mAudio);
		tAudio.setAutoCreateRowSorter(true);
		spAudio = new JScrollPane(tAudio);
		pAudio.add(spAudio, BorderLayout.CENTER);
		
		pBild = new JPanel();
		pBild.setName("BILD");
		mBild = new BildTableModel(mv.getBilder());
		mBild.fireTableDataChanged();
		mBild.fireTableStructureChanged();  
		tBild = new JTable(mBild);
		tBild.setAutoCreateRowSorter(true);
		spBild = new JScrollPane(tBild);
		pBild.add(spBild, BorderLayout.CENTER);
		
		//Menu
		menu = new JMenuBar();
		jmDatei = new JMenu("Datei");
		jmMedium = new JMenu("Medium");
		jmAnzeige = new JMenu("Anzeige");
		jmNeu = new JMenu("Neu");
		jmiSpeichern = new JMenuItem("Speichern"); 
		jmiLaden = new JMenuItem("Laden");
		jmiBeenden = new JMenuItem("Beenden");
		jmiAendern = new JMenuItem("Aendern");
		jmiDelete  = new JMenuItem("Loeschen");
		jmiAddBild  = new JMenuItem("Bild");
		jmiAddAudio = new JMenuItem("Audio");
		jmiDErscheinungsjahr  = new JMenuItem("durchschnittliches Erscheinungsjahr");
		jmiShowBild = new JMenuItem("Zeige alle Bilder");
		jmiShowAudio  = new JMenuItem("Zeige alle Audios");
		jmiNewMedium  = new JMenuItem("Zeige neustes Medium");
		
		jmiSpeichern.addActionListener(new ALSpeichern()); 
		jmiLaden.addActionListener(new ALLaden());
		jmiBeenden.addActionListener(new ALBeenden());
		jmiAendern.addActionListener(new ALAendern(tMedien));
		jmiDelete.addActionListener(new ALDelete(tMedien));
		jmiAddBild.addActionListener(new ALAddBild());
		jmiAddAudio.addActionListener(new ALAddAudio());
		jmiDErscheinungsjahr.addActionListener(new ALDErscheinungsjahr());
		jmiShowBild.addActionListener(new ALShowBild());
		jmiShowAudio.addActionListener(new ALShowAudio());
		jmiNewMedium.addActionListener(new ALNewMedium());
		
		jmDatei.add(jmiSpeichern);
		jmDatei.add(jmiLaden);
		jmDatei.add(jmiBeenden);
		jmNeu.add(jmiAddBild);
		jmNeu.add(jmiAddAudio);
		jmMedium.add(jmNeu);
		jmMedium.add(jmiAendern);
		jmMedium.add(jmiDelete);
		jmAnzeige.add(jmiDErscheinungsjahr);
		jmAnzeige.add(jmiShowBild);
		jmAnzeige.add(jmiShowAudio);
		jmAnzeige.add(jmiNewMedium);
		jmDatei.addSeparator();
		menu.add(jmDatei);
		menu.add(jmMedium);
		menu.add(jmAnzeige);
		setJMenuBar(menu);
		
		cardLayout = new CardLayout();
		pMain = new JPanel(cardLayout);
		pMain.add(pMedien, "MEDIEN");
		pMain.add(pAudio, "AUDIO");
		pMain.add(pBild, "BILD");
		
		this.add(pMain);
		cardLayout.show(pMain, "AUDIO");
		
	}
	
	public String getCurrentPanel(){
		JPanel card = null;
		for (Component comp : pMain.getComponents()) {
		    if (comp.isVisible() == true) {
		        card = (JPanel) comp;
		    }
		}
		return card.getName();
	}
	
	public void updateTable(){
		String currentPanel = getCurrentPanel();
		switch(currentPanel){
			case "MEDIEN":
				System.out.println("update: Table Medien");
				this.updateTableMedien();
				break;
			case "AUDIO":
				System.out.println("update: Table Audio");
				this.updateTableAudio();
				break;
			case "BILD":
				System.out.println("update: Table Bild");
				this.updateTableBild();
				break;
			default:
				System.err.println("FEHLER: MediumHPVews -> updateTable: falscher Panelname: " + currentPanel);
		}
	}
	
	public void updateTableMedien() {
		tMedien.setModel(mMedien);
		((MedienTableModel) tMedien.getModel()).fireTableDataChanged();        
	}
	
	public void updateTableAudio() {
	     tAudio.setModel(mAudio);
	    ((AudioTableModel) tAudio.getModel()).fireTableDataChanged();        
	}
	
	public void updateTableBild() {
	     tBild.setModel(mBild);
	    ((BildTableModel) tBild.getModel()).fireTableDataChanged();        
	}
	
	public class ALSpeichern implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(mv.saveInFile(new File("save//saveMedien.txt"))){
				JOptionPane.showMessageDialog(null, "Die Medienliste wurde erfolgreich gespeichert", "Info", JOptionPane.INFORMATION_MESSAGE);
			}else{
				JOptionPane.showMessageDialog(null, "Beim speichern der Medienliste ist ein Fehler aufgetreten", "Fehler", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public class ALLaden implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(mv.loadFromFile(new File("save/saveMedien.txt"))){
				JOptionPane.showMessageDialog(null, "Die Medienliste wurde erfolgreich geladen", "Info", JOptionPane.INFORMATION_MESSAGE);
			}else{
				JOptionPane.showMessageDialog(null, "Beim speichern der Medienliste ist ein Fehler aufgetreten", "Fehler", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public class ALBeenden implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
		}
	}

	public class ALAendern implements ActionListener{
		JTable table;
		public ALAendern(JTable _table){
			table = _table;
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int row = table.getSelectedRow();
			int id = Integer.parseInt((String) table.getValueAt(row, 0));
			if(table.getValueAt(row, 5) == "Bild"){
				BildErfassungView beView = new BildErfassungView(mv, (Bild) mv.getMedium(id));
			}else{
				AudioErfassungView aeView = new AudioErfassungView(mv, (Audio) mv.getMedium(id));
			}
		}
	}

	public class ALDelete implements ActionListener{
		JTable table;
		public ALDelete(JTable _table){
			this.table = _table;
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int row = table.getSelectedRow();
			int id = Integer.parseInt((String) table.getValueAt(row, 0));
			System.out.println("row: " + row + " id: " + id);
			if(mv.deleteMedium(mv.getMedium(id))){
				JOptionPane.showMessageDialog(null, "Das Medium wurde erfolgreich gel�scht", "Info", JOptionPane.INFORMATION_MESSAGE);
			}else{
				JOptionPane.showMessageDialog(null, "Beim L�schen ist ein Fehler aufgetreten!", "Fehler", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public class ALAddBild implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			BildErfassungView aeView = new BildErfassungView(mv, null);
		}
	}

	public class ALAddAudio implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			AudioErfassungView aeView = new AudioErfassungView(mv, null);
		}
	}

	public class ALDErscheinungsjahr implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			JOptionPane.showMessageDialog(null, "das durchschnittliche Erscheinungsjahr betr�gt: " + mv.berechneErscheinungsjahr(), "Info", JOptionPane.INFORMATION_MESSAGE);	
		}
	}

	public class ALShowBild implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			cardLayout.show(pMain, "BILD");
		}
	}

	public class ALShowAudio implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			cardLayout.show(pMain, "AUDIO");
		}
	}

	public class ALNewMedium implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}	
}