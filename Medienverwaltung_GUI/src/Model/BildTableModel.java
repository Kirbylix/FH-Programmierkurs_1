package Model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class BildTableModel extends AbstractTableModel{
	private static final String[] COLHEADING = {"ID", "Titel", "Jahr", "Ort"};
	private final List<Bild> medien;
	
	public BildTableModel(final List<Bild> medien){
		this.medien = medien;
	}

	@Override
	public int getColumnCount() {
		return COLHEADING.length;}

	@Override
	public int getRowCount() {
		return medien.size();}
	
	@Override
	public String getColumnName(final int index){
		return COLHEADING[index];
	}

	@Override
	public Object getValueAt(final int row,final int col) {
		Bild m = medien.get(row);
		switch(col){
		case 0:// ID
			return m.getId();
		case 1: // Titel
			return m.getTitel();
		case 2: // Jahr
			return m.getJahr();
		case 3: // Ort
			return m.getOrt();
		}
	throw new IllegalArgumentException("Ungültiger Index col = " + col);
	}
}