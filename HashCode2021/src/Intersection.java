import java.util.ArrayList;

public class Intersection {
	
	private int id;
	private ArrayList<Street> in;
	private ArrayList<Street> out;

	public Intersection(int i) {
		id = i;
	}
	
	public void addIn(Street s) {
		in.add(s);
	}
	
	public void addOut(Street s) {
		out.add(s);
	}
}
