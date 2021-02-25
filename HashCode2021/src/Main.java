import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static int time;
	static int pts;
	static ArrayList<Intersection> intersecs;
	static ArrayList<Car> cars;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine();
		String[] s = input.split(" ");
		
		time = Integer.parseInt(s[0]);
		int intersec = Integer.parseInt(s[1]);
		for(int i = 0; i < intersec; ++i) {
			intersecs.add(new Intersection(i));
		}
		int streets = Integer.parseInt(s[2]);
		int numcars = Integer.parseInt(s[3]);
		pts = Integer.parseInt(s[4]);
		
		//streets
		for(int i = 0; i < streets; ++i) {
			input = sc.nextLine();
			s = input.split(" ");
			int start = Integer.parseInt(s[0]);
			int end = Integer.parseInt(s[1]);
			String name = s[2];
			int t = Integer.parseInt(s[3]);
			
			Street st = new Street(name, t);
			intersecs.get(start).addOut(st);
			intersecs.get(end).addIn(st);
		}
		
		//cars
		for(int i = 0; i < numcars; ++i) {
			input = sc.nextLine();
			s = input.split(" ");
			int sts = Integer.parseInt(s[0]);
			
			ArrayList<String> path = new ArrayList<String>(sts);
			for(int j = 1; j <= sts; ++j) {
				path.add(s[j]);
			}
			cars.add(new Car(i,path));
		}
		
		
	}
}
