import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	static int time;
	static int pts;
	static ArrayList<Intersection> intersecs = new ArrayList<Intersection>();
	static ArrayList<Car> cars = new ArrayList<Car>();
	static HashMap<String,Integer> hm = new HashMap<String,Integer>();
	static HashMap<Integer, HashMap<String, Integer>> out = new HashMap<Integer,  HashMap<String, Integer>>();
	
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
		
			hm.put(name,0);
		}
		
		//cars
		for(int i = 0; i < numcars; ++i) {
			input = sc.nextLine();
			s = input.split(" ");
			int sts = Integer.parseInt(s[0]);
			
			ArrayList<String> path = new ArrayList<String>(sts);
			for(int j = 1; j <= sts; ++j) {
				path.add(s[j]);
				hm.put(s[j], hm.get(s[j]) + 1);
			}
			cars.add(new Car(i,path));
		}
		
		sc.close();
		try {
			scheduler();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void scheduler() throws IOException {
		
		//intersecs w/ just one in street
		for(int i = 0; i < intersecs.size(); ++i) {
			if(intersecs.get(i).getIns()==1) {
				HashMap<String,Integer> aux = new HashMap<String,Integer>();
				aux.put(intersecs.get(i).getInName(0), time);
				out.put(i,aux);
			} else {
				HashMap<String,Integer> aux = new HashMap<String,Integer>();
				for(int j = 0; j < intersecs.get(i).getIns(); ++j) {
					if(hm.get(intersecs.get(i).getInName(j)) != 0) {
						aux.put(intersecs.get(i).getInName(j), 1);
					}
				}
				if(aux.size() != 0) {
					out.put(i,aux);
				}
			}
		}
		
		File f = new File("./outputA.txt");
		f.createNewFile();
		FileWriter wr = new FileWriter(f);
		
		wr.write(String.valueOf(out.size())+"\n");
		for(int i = 0; i < intersecs.size(); ++i) {
			if(out.containsKey(i)) {
				wr.write(String.valueOf(i)+"\n");
				wr.write(String.valueOf(out.get(i).size())+"\n");
				for(int j = 0; j < intersecs.get(i).getIns(); ++j) {
					if(out.get(i).containsKey(intersecs.get(i).getInName(j))) {
						wr.write(intersecs.get(i).getInName(j) + " ");
						wr.write(String.valueOf(out.get(i).get(intersecs.get(i).getInName(j))) + "\n" );
					}
				}
			}
		}
		wr.close();
	}
}
