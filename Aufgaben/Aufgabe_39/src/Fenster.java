import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Fenster extends Frame{

	public Fenster(){
		setSize(250,150);
		Panel panel = new Panel();
		Button rot = new Button("rot");
		Button blau = new Button("blau");
		
		rot.addActionListener(new Listener(this, Color.red));
		blau.addActionListener(new Listener(this, Color.blue));
		
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel.add(rot);
		panel.add(blau);
		add(panel, BorderLayout.SOUTH);
		
		setVisible(true);

	}
}

class Listener implements ActionListener{
	private Frame frame;
	private Color color;
	public Listener(Frame frame, Color color){
		this.frame = frame;
		this.color = color;
	}
	public void actionPerformed(ActionEvent e){
		frame.setBackground(color);
	}
}
