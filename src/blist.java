import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class blist {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("blist.in"));
		PrintWriter out = new PrintWriter(new File("blist.out"));
		int time [] = new int[1001];
		int n = sc.nextInt();
		Interval intervals[] = new Interval[n];
		int maxcupsneeded= 0;
		for(int i = 0; i< n; i++){
			intervals[i] = new Interval(sc.nextInt(),sc.nextInt(),sc.nextInt());
			maxcupsneeded = intervals[i].milkneeded;
		}
		Arrays.sort(intervals);

		for(int i = 0; i< intervals.length;i++){
			for(int j = intervals[i].start; j<= intervals[i].end;j++){
				time[j] += intervals[i].milkneeded;
			}
		}
		int max= 1;
		for (int i = 0; i < time.length; i++) {
			if(time[i]>max){
				max = time[i];
			}

		}
		out.println(max);
		out.close();
	}
}
class Interval implements Comparable{
	int start;
	int end;
	int milkneeded;
	public Interval(int s, int t,int c){
		start= s;
		end= t;
		milkneeded= c;
	}

	@Override
	public int compareTo(Object o) {
		return this.start- ((Interval) o).start;
	}

	@Override
	public String toString() {
		return start+ " "+ end+ " " + milkneeded;
	}
}