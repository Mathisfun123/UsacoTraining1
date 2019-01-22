import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class multimoo {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner( new File("multimoo.in"));
		int n = sc.nextInt();
		int [][] matrix= new int[n][n];
		for(int i = 0; i< n; i++){
			for(int j = 0; j< n; j++){
				matrix[i][j]= sc.nextInt();
			}
		}


	}
	//Teams of Two
	static class Person{
		public ArrayList <Integer> possibilities;
		public Person(){
			possibilities= new ArrayList<>();
		}
	}
}
