import javax.swing.JOptionPane;

public class main {

	public static void main(String[] args) {
		Counter c = new Counter();
		Thread t = new Thread(new Timer(c));
		t.start();
		
		JOptionPane.showMessageDialog(null, "Beenden");
		t.interrupt();
	}
}