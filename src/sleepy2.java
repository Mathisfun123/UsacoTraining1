import java.util.*;
import java.io.*;

public class sleepy2 {
	public static ArrayList<Integer> sortedArr;
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(new File("sleepy" + ".in"));
		PrintWriter out = new PrintWriter(new File("sleepy" + ".out"));
		int n = sc.nextInt();
		ArrayList<Integer> values = new ArrayList<>();
		for(int i =0; i< n; i++){
			values.add(sc.nextInt());
		}
		sortedArr= new ArrayList<>(values);
		Collections.sort(sortedArr);
		if(n==1 || checkEquality(sortedArr,values)){
			out.println(0);
			out.close();
		}
		int count = 0;
		while(!checkEquality(values,sortedArr)){
			int pos1= values.remove(0);
			int place= values.size(); int diff= Integer.MAX_VALUE;
			for(int i = 1; i< values.size(); i++){
				if(values.get(i)>pos1){
					if(values.get(i)- pos1 < diff ){
						diff = values.get(i)- pos1; place= i;
					}
				}
			}
			count+=1;
			values.add(place,pos1);
		}
		out.println(count);
		out.close();
	}
	public static boolean checkEquality(ArrayList<Integer> a, ArrayList <Integer> b){
		for(int i = 0; i< a.size(); i++){
			if(a.get(i)!= b.get(i)){
				return false;
			}
		}
		return true;
	}
}
