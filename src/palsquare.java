/*
ID: sairaja
LANG: JAVA
TASK: palsquare
*/
import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class palsquare {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(new File("palsquare" + ".in"));
        PrintWriter out = new PrintWriter(new File("palsquare" + ".out"));
        int n = sc.nextInt();
        for(int i = 1; i<=300; i++){
            if(isPalidrome(convertPowBases(10,n,i*i))){
                out.println(convertPowBases(10,n,i)+ " "+ convertPowBases(10,n,i*i));
            }
        }

        out.close();
    }
    public static boolean isPalidrome (String txt){
        String reverse = new StringBuilder(txt).reverse().toString();
        if(txt.equals(reverse)){
            return true;
        }
        return false;
    }
    public static String convertPowBases(int num1, int  num2convertto, int val){
        String p = Integer.toString(Integer.parseInt((Integer.toString((int)Math.pow(val,1))),num1),num2convertto);
        return p.toUpperCase();
    }
}
