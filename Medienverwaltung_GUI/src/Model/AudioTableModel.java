package Model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class AudioTableModel extends AbstractTableModel{
	private static final String[] COLHEADING = {"ID", "Titel", "Interpret", "Jahr", "Dauer"};
	private final List<Audio> medien;
	
	public AudioTableModel(final List<Audio> _medien){
		this.medien = _medien;
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
		Audio m = medien.get(row);
		switch(col){
		case 0:// ID
			return m.getId();
		case 1: // Titel
			return m.getTitel();
		case 2: // Interpreter
			return m.getInterpret();
		case 3: // Jahr
			return m.getJahr();
		case 4: // Dauer
			return m.getDauer();
		}
		throw new IllegalArgumentException("Ungültiger Index col = " + col);
	}
}