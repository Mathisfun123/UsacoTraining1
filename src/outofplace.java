import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class outofplace {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("outofplace.in"));
		PrintWriter out = new PrintWriter(new File("outofplace.out"));
		int n = sc.nextInt(); sc.nextLine();
		int [] arr = new int[n];
		ArrayList <Integer> keypoints = new ArrayList<>();

		arr[0]= Integer.parseInt(sc.nextLine());
		for(int i = 1; i< n; i++){
			arr[i]= Integer.parseInt(sc.nextLine());
			if(arr[i]< arr[i-1]){
				keypoints.add(i);
			}
		}
		int amtswitches= 0;
		while(keypoints.size()>0) {
			System.out.println(keypoints + ""+ arr[keypoints.get(0)]);
			int currentindex = keypoints.remove(0); int pos= currentindex;
			int val = arr[currentindex];
			currentindex--;
			while (val < arr[currentindex]){
				while(arr[currentindex]==arr[currentindex-1]){
					currentindex--;
				}
				int temp = arr[currentindex];
				arr[currentindex]= val;
				arr[pos]= temp;
				amtswitches++;
				if(currentindex!=0 && arr[currentindex]<arr[currentindex-1]){
					keypoints.add(currentindex);
				}
			}

		}
		System.out.println(amtswitches);
		out.close();
	}
}
