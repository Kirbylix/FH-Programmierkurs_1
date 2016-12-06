import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fenster extends Frame implements ActionListener{
	Button ende;
	public Fenster(){
		setSize(500, 500);
		
		GridBagLayout gbl = new GridBagLayout();
		setLayout(gbl);
		GridBagConstraints gbc = new GridBagConstraints();
		
		List list = new List();
		for(int i=0; i<20; i++){
			list.add("This is item " + i);
		}
		Label label1 = new Label("Label 1");
		Label label2 = new Label("Label 2");
		TextField tf1 = new TextField("TextField 1");
		TextField tf2 = new TextField("TextField 2");
		TextField tf3 = new TextField("TextField 3");
		Button start = new Button("Start");
		ende = new Button("Ende");
		
		gbc = configGBC(0, 0, 1, 3, 100, 300, GridBagConstraints.BOTH);
		gbl.setConstraints(list, gbc);
		add(list);
		gbc = configGBC(1, 0, 1, 1, 100, 100, GridBagConstraints.NONE);
		gbl.setConstraints(label1, gbc);
		add(label1);
		gbc = configGBC(1, 1, 1, 1, 100, 100, GridBagConstraints.NONE);
		gbl.setConstraints(label2, gbc);
		add(label2);
		gbc = configGBC(2, 0, 1, 1, 100, 100, GridBagConstraints.HORIZONTAL);
		gbl.setConstraints(tf1, gbc);
		add(tf1);
		gbc = configGBC(2, 1, 1, 1, 100, 100, GridBagConstraints.HORIZONTAL);
		gbl.setConstraints(tf2, gbc);
		add(tf2);
		gbc = configGBC(2, 2, 1, 1, 100, 100, GridBagConstraints.HORIZONTAL);
		gbl.setConstraints(tf3, gbc);
		add(tf3);
		gbc = configGBC(1, 3, 1, 1, 100, 100, GridBagConstraints.NONE);
		gbl.setConstraints(start, gbc);
		add(start);
		gbc = configGBC(2, 3, 1, 1, 100, 100, GridBagConstraints.NONE);
		ende.addActionListener(this);
		gbl.setConstraints(ende, gbc);
		add(ende);
		
		pack();
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ende)
			dispose();
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
