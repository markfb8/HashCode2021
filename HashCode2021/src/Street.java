import java.util.LinkedList;
import java.util.Queue;

public class Street {
	
	private String name;
	private int time;
	private Queue<Car> q;
	
	public Street(String n, int t) {
		name = n;
		time = t;
		q = new LinkedList<Car>();
	}

}
