import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine();
		String[] s = input.split(" ");
		int time = Integer.parseInt(s[0]);
		int intersec = Integer.parseInt(s[1]);
		int streets = Integer.parseInt(s[2]);
		int cars = Integer.parseInt(s[3]);
		int pts = Integer.parseInt(s[4]);
		
		//streets
		for(int i = 0; i < streets; ++i) {
			input = sc.nextLine();
			s = input.split(" ");
			int start = Integer.parseInt(s[0]);
			int end = Integer.parseInt(s[1]);
			String name = s[2];
			int dist = Integer.parseInt(s[3]);
		}
		
		//cars
		ArrayList<String> path = new ArrayList<String>();
		for(int i = 0; i < cars; ++i) {
			input = sc.nextLine();
			s = input.split(" ");
			int st = Integer.parseInt(s[0]);
			for(int j = 1; j <= st; ++j) {
				path.add(s[j]);
			}
		} 
	}
}
