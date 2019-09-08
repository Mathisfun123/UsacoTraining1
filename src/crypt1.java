/*
ID: sairaja
LANG: JAVA
TASK: crypt1
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class crypt1 {
	public static int arr[];
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc =new Scanner( new File("crypt1.in"));
		PrintWriter out = new PrintWriter( new File("crypt1.out"));
		int n = sc.nextInt();
		arr= new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i]= sc.nextInt();
		}
		HashSet<String> poss = new HashSet<>();
//		ijk
//		 lm
		for(int i: arr){
			for(int j: arr){
				for(int k: arr){
					for(int l: arr){
						for(int m: arr){
							//conditions
							if(m*k < 10 && m*i <10 && m*j<10){ //3 digit top
								if(l*k<10 && l*i<10 && l*j<10){//3 digit bot
									int ans1 = (m*k)*1 + (m*i)*100 + (m*j)*10;
									int ans2 = (l*k)*10 + (l*i)*1000 + (l*j)*100;
									BigInteger ans = BigInteger.ZERO; ans = ans.add(BigInteger.valueOf(ans1)); ans = ans.add(BigInteger.valueOf(ans2));
									String val = ans.toString();
									if(val.length()==4){
										boolean cond = true;
										for (int o = 0; o < val.length(); o++) {
											if(!contains(Integer.parseInt(val.substring(o,o+1))))
												cond=false;
										}
										if(cond){
											poss.add(ans.toString());
										}
									}
								}
							}
						}
					}
				}
			}
		}
		out.println(poss.size());
		out.close();
	}
	public static boolean contains(int val){
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]==val){
				return true;
			}
		}
		return false;
	}
}
