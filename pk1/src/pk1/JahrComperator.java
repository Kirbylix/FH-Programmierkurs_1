package pk1;
import java.util.Comparator;

public class JahrComperator implements Comparator<Medium>{

	@Override
	public int compare(Medium m1, Medium m2) {
		return m1.getJahr()- m2.getJahr();
	}
}
