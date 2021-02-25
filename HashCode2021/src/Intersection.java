import java.util.ArrayList;

public class Intersection {
	
	private int id;
	private ArrayList<Street> in = new ArrayList<Street>();
	private ArrayList<Street> out = new ArrayList<Street>();

	public Intersection(int i) {
		id = i;
	}
	
	public void addIn(Street s) {
		in.add(s);
	}
	
	public void addOut(Street s) {
		out.add(s);
	}
	
	public int getIns() {
		return in.size();
	}
	
	public int getOuts() {
		return out.size();
	}
	
	public String getInName(int i) {
		return in.get(i).getName();
	}
	
	public String getOutName(int i) {
		return out.get(i).getName();
	}
}
