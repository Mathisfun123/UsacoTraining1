import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class mixmilk {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("mixmilk.in"));
		PrintWriter out = new PrintWriter(new File("mixmilk.out"));
		int[] arr = new int[4]; ///SAI NOTE THAT THIS IS 4: last one is 3
		int[] maxval = new int[4];
		maxval[1] = sc.nextInt();
		arr[1] = sc.nextInt();
		maxval[2] = sc.nextInt();
		arr[2] = sc.nextInt();
		maxval[3] = sc.nextInt();
		arr[3] = sc.nextInt();

		int num= 0;  int curmilkcup = 1;
		while(num<100){
			int wanttopour = arr[curmilkcup];
			int canpour = 0;
			if(curmilkcup!=3){
				canpour= maxval[curmilkcup+1]- arr[curmilkcup+1];
			}else{
				canpour= maxval[1]- arr[1];
			}
			if(wanttopour>=canpour){
				if(curmilkcup==3){
					arr[1] = maxval[1];
					arr[curmilkcup]= arr[curmilkcup] - canpour;
				}else{
					arr[curmilkcup+1] = maxval[curmilkcup+1];
					arr[curmilkcup] = arr[curmilkcup]- canpour;
				}

			}else if(wanttopour<canpour){
				if(curmilkcup==3){
					arr[1] = arr[1]+wanttopour;
				}else{
					arr[curmilkcup+1] = arr[curmilkcup+1] + wanttopour;
				}
				arr[curmilkcup] = arr[curmilkcup]- wanttopour;
			}
			if(curmilkcup!=3){
				curmilkcup++;
			}else{
				curmilkcup=1;
			}
			num++;
		}
		for (int i = 1; i < arr.length; i++) {
			int i1 = arr[i];
			out.println(i1);
		}
		out.close();

	}
}
