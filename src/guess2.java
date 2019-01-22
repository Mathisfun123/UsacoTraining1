import java.util.*;
import java.io.*;

public class guess2 {
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(new File("guess" + ".in"));
		PrintWriter out = new PrintWriter(new File("guess" + ".out"));
		int n = sc.nextInt(); sc.nextLine();
		ArrayList<Animal> groups = new ArrayList<>();
		for(int i = 0; i< n; i++){
			String []ln = (sc.nextLine()).split(" ");
			Animal item = new Animal(ln[0]);
			for(int j = 0; j< Integer.parseInt(ln[1]); j++){
				item.addVal(ln[2+j]);
			}
			groups.add(item);
		}
		HashSet<String> pastQuestions = new HashSet<>();
		for(int i = 0; i< groups.size()-1; i++){
			for(int j = i+1; j< groups.size(); j++){
				ArrayList <String> a = new ArrayList<>(groups.get(i).Characs);
				ArrayList <String> b = groups.get(j).Characs;
				a.retainAll(b);
				System.out.println(a);
			}
		}
		System.out.println(groups );
		out.close();
	}
	static class Animal
	{
		public String name; //Seems useless
		public  ArrayList <String> Characs;
		public Animal(String n){
			name = n;
			Characs = new ArrayList<>();

		}
		public  void addVal(String item) {
			Characs.add(item);
		}


		@Override
		public String toString() {
			return name + Characs;
		}
	}
}
