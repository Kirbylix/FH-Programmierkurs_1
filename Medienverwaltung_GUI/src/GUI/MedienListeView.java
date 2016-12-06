package GUI;
import java.awt.Button;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import Controller.MedienVerwaltung;
import Model.*;

public class MedienListeView extends JPanel{

	JTable table;
	JScrollPane scrollPane;
	MedienVerwaltung mv;
	List<Medium> medien;
	
	public MedienListeView(MedienVerwaltung mv) {
		
		GridBagLayout gbl = new GridBagLayout();
		setLayout(gbl);
		GridBagConstraints gbc = new GridBagConstraints();
		
		this.mv = mv;
		medien = mv.getMedien();
		table = new JTable(new MedienTableModel(mv.getMedien()));
		table.setAutoCreateRowSorter(true);
		scrollPane = new JScrollPane(table);
		
		gbc = configGBC(0, 0, 3, 3, 1000, 500, GridBagConstraints.BOTH);
		gbl.setConstraints(scrollPane, gbc);
		add(scrollPane);
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
}
