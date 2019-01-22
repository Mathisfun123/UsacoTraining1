import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class guess {
	public static int max=0;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner( new File("guess.in"));
		PrintWriter out = new PrintWriter( new File("guess.out"));
		int n  = sc.nextInt();sc.nextLine();
		ArrayList<Animal> groups = new ArrayList<>();
		ArrayList<String > allTraits = new ArrayList<>();
		for(int i = 0; i< n; i++){
			String []ln = (sc.nextLine()).split(" ");
			Animal item = new Animal(ln[0]);
			for(int j = 0; j< Integer.parseInt(ln[1]); j++){
				if(!allTraits.contains(ln[2+j])){
					allTraits.add(ln[2+j]);
				}
				item.addCharac(ln[2+j]);
			}
			groups.add(item);
		}

		for(int i =0; i< groups.size()-1; i++){
			for(int j = i+1; j< groups.size();j++){
				ArrayList<String> t = groups.get(i).charas;
				ArrayList<String> f = groups.get(j).charas;
				ArrayList<String> res= new ArrayList<>(t);
				res.retainAll(f);
				max= Math.max(res.size(),max);
			}
		}

		out.println(max+1);
		out.close();
	}

	static class Animal{
		public String name;
		public ArrayList<String> charas;
		public Animal(String n ){
			name= n;
			charas= new ArrayList<>();
		}
		public void addCharac(String t) {
			charas.add(t);
		}

		@Override
		public String toString() {
			return name + " "+ charas;
		}
	}

}
