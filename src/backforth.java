import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class backforth {
	public static HashSet<Integer> finalAnswers = new HashSet<>();
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("backforth.in"));
		PrintWriter out = new PrintWriter(new File("backforth.out"));
		ArrayList<Integer> bucket1 = new ArrayList<>();
		ArrayList<Integer> bucket2= new ArrayList<>();

		for(int i = 0; i< 10; i++){
			bucket1.add(sc.nextInt());
		}
		for(int i = 0; i< 10; i++){
			bucket2.add(sc.nextInt());
		}
		//System.out.println(bucket1 + " " + bucket2); CLEAR On USER Input
		Tuesday(1000,bucket1, bucket2);
		Iterator itr = finalAnswers.iterator();
		/*while(itr.hasNext()) {
			Object element = itr.next();
			System.out.print(element + " ");
		}*/
		out.println(finalAnswers.size());
		out.close();
	}
	public static void Tuesday(int amtb1, ArrayList<Integer> b1, ArrayList<Integer>b2){
		for(int i = 0; i< 10; i++){
			ArrayList<Integer> newArry1 = new ArrayList<>(b1);
			ArrayList<Integer> newArry2 = new ArrayList<>(b2);
			int bucket = newArry1.remove(i);
			int var = amtb1;
			var-= bucket;
			newArry2.add(bucket);
			//System.out.println(var + " " + newArry1);
			Wednesday(var, newArry1, newArry2);
		}
	}
	public static void Wednesday(int amtb1, ArrayList<Integer> b1, ArrayList<Integer> b2){
		for(int i = 0; i<= 10; i++){
			ArrayList<Integer> newArry1 = new ArrayList<>(b1);
			ArrayList<Integer> newArry2 = new ArrayList<>(b2);
			int bucket = newArry2.remove(i);
			int var = amtb1;
			var+= bucket;
			newArry1.add(bucket);
			Thursday(var, newArry1, newArry2);
		}
	}
	public static void Thursday(int amtb1, ArrayList<Integer> b1, ArrayList<Integer> b2){
		for(int i = 0; i< 10; i++){
			ArrayList<Integer> newArry1 = new ArrayList<>(b1);
			ArrayList<Integer> newArry2 = new ArrayList<>(b2);
			int bucket = newArry1.remove(i);
			int var = amtb1;
			var-= bucket;
			newArry2.add(bucket);
			Friday(var, newArry1, newArry2);
		}
	}
	public static void Friday(int amtb1, ArrayList<Integer> b1, ArrayList<Integer> b2){
		for(int i = 0; i< 10; i++){
			ArrayList<Integer> newArry2 = new ArrayList<>(b2);
			int bucket = newArry2.remove(i);
			int var = amtb1;
			var+=bucket;

			finalAnswers.add(var);

		}
	}

}

