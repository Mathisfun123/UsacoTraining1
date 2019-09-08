import java.util.*;
import java.io.*;

public class sleepy1 {
	public static ArrayList<Integer> sortedArr;
	public static int m = Integer.MAX_VALUE;
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(new File("sleepy" + ".in"));
		PrintWriter out = new PrintWriter(new File("sleepy" + ".out"));

		int n = sc.nextInt();
		if(n==1){
			out.println(1);
			out.close();
		}
		ArrayList<Integer> values = new ArrayList<>();
		for(int i =0; i< n; i++){
			values.add(sc.nextInt());
		}
		sortedArr= new ArrayList<>(values);
		Collections.sort(sortedArr);

		move(values,0);
		out.println(m+1);


		out.close();
	}
	public static int move(ArrayList<Integer> val,int nummoves){
		if(nummoves>val.size()-1){
			return nummoves;
		}
		boolean match = true;
		for(int i = 0; i< val.size(); i++){
			if(!val.get(0).equals(sortedArr.get(i))){
				match = false;
			}
		}

		if(match){
			return nummoves;
		}else{
			int num = val.remove(0);
			for(int i = 1; i<= val.size(); i++){
				ArrayList <Integer> now = new ArrayList<>(val);
				now.add(i,num);

				move(now, nummoves+1);
			}
		}
		return nummoves;
	}
}
