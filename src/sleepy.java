
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class sleepy {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("sleepy.in"));
		PrintWriter out = new PrintWriter(new File("sleepy.out"));
		int n = sc.nextInt();
		ArrayList<Integer> values= new ArrayList<>();
		for(int i = 0; i< n; i++){
			values.add(sc.nextInt());
		}
		ArrayList <Integer> sorted = new ArrayList<>(values);
		Collections.sort(sorted); int amt = 0;
		if(n==1 || checkArry(sorted,values)){
			out.println(0);
		}else{
			while(!checkArry(sorted,values)){
				int pos1 = values.remove(0);
				int diff = Integer.MAX_VALUE; int place= values.size();
				for(int i = 1;i< values.size();i++){
					if(values.get(i)>pos1){
						if(values.get(i)-pos1 < diff){
							diff= values.get(i)- pos1; place= i;
						}
					}
				}
				values.add(place,pos1);
				amt++;
			}
			out.println(amt);
		}
		out.close();

		//System.out.println(values);
	}
	public static boolean checkArry ( ArrayList <Integer> s1, ArrayList< Integer> s2){
		for(int i = 0;i<s1.size(); i++){
			if(s1.get(i)!=s2.get(i)){
				return false;
			}
		}
		return  true;
	}
}
