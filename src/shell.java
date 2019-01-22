import javafx.geometry.Pos;

import javax.swing.text.Position;
import java.util.*;
import java.io.*;

public class shell {
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(new File("shell" + ".in"));
		PrintWriter out = new PrintWriter(new File("shell" + ".out"));
		int n = sc.nextInt();
		ArrayList<Position> spots = new ArrayList<>();
		spots.add(0,new Position(1)); spots.add(1,new Position(2)); spots.add(2,new Position(3));
		for(int i = 0; i< n; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			//Get Spot 1
			Position item1 = spots.get(0);
			if(item1.position==a){
				item1.position= b;
			}else if(item1.position ==b){
				item1.position=a;
			}
			Position item2 = spots.get(1);
			if(item2.position==a){
				item2.position=b;
			}else if(item2.position==b){
				item2.position=a;
			}
			Position item3 = spots.get(2);
			if(item3.position==a){
				item3.position=b;
			}else if(item3.position==b){
				item3.position=a;
			}
			int guess = sc.nextInt();
			if(item1.position==guess){
				item1.val++;
			}else if(item2.position==guess){
				item2.val++;
			}else if(item3.position==guess){
				item3.val++;
			}
			spots.set(0,item1); spots.set(1,item2); spots.set(2,item3);
		}
		int max = 0;
		for (int i = 0; i < spots.size(); i++) {
			Position position =  spots.get(i);
			max = Math.max(max,position.val);
		}
		out.println(max);
		out.close();
	}
	static class Position {
		public int position,val;
		public Position(int n){
			position= n;
			val=0;
		}

		@Override
		public String toString() {
			return ""+val;
		}
	}
}
