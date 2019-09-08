import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class fenceplan {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("fenceplan" + ".in"));
		int n = sc.nextInt(); //number of cows
		int m = sc.nextInt(); //number of connections
		HashMap<ArrayList<Integer>, Points> groups = new HashMap<>();
		for(int i =1; i<=n; i++){
			ArrayList<Integer> t = new ArrayList<>();
			t.add(i);
			int x = sc.nextInt();
			int y = sc.nextInt();
			groups.put(t, new Points(x,y,x,y));
		}
		for(int i= 0; i< m; i++){

		}
		System.out.println(groups);


	}
	static class Points{
		int minX, minY, maxX,maxY;
		public Points(int mx, int my, int Mx,int My){
			minX= mx;
			minY= my;
			maxX= Mx;
			maxY= My;
		}

		@Override
		public String toString() {
			return "Min: " +"("+ minX +","+minY+")"+" Max: " +"("+ maxX +","+maxY+")" ;
		}
	}
}
