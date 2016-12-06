package Model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class MedienTableModel extends AbstractTableModel{
	private static final String[] COLHEADING = {"ID", "Titel", "Interpret", "Jahr", "Dauer", "Ort", "Typ"};
	private final List<Medium> medien;
	
	public MedienTableModel(final List<Medium> medien){
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
		Medium m = medien.get(row);
		String[] input = m.toStringArray();
		switch(col){
		case 0:// ID
			return input[0];
		case 1: // Titel
			return input[1];
		case 3: // Jahr
			return input[2];
		default:
			if(m.getClass() == Bild.class){
				switch(col){
					case 2: // Interpret
						return "";
					case 4: // Dauer
						return "";
					case 5: // Ort
						return input[3];
					case 6: // Typ
						return "Bild";
				}
			}else{
				switch(col){
					case 2: // Jahr
						return input[3];
					case 4: // Dauer
						return input[4];
					case 5: // Ort
						return "";
					case 6: // Typ
						return "Audio";
				}
			}
		}
		throw new IllegalArgumentException("Ungültiger Index col = " + col);
	}
}