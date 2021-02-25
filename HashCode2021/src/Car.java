import java.util.ArrayList;

public class Car {
	
	private int id;
	private ArrayList<String> path;
	
	public Car(int i, ArrayList<String> p) {
		id = i;
		path = p;
	}
	
	public ArrayList<String> getPath() {
		return path;
	}

}
