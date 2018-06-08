/*
ID: sairaja
LANG: JAVA
TASK: dualpal
*/
import java.util.*;
import java.io.*;

public class dualpal {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(new File("dualpal" + ".in"));
        PrintWriter out = new PrintWriter(new File("dualpal" + ".out"));
        int n  = sc.nextInt();
        int beg = sc.nextInt();
        int leftOver = n;
        for(int i = beg+1; leftOver>0; i++){
            if(checkNum(i)){
                 out.println(i);
                 leftOver--;
            }
        }

        out.close();
    }
    public static boolean isPalindrome(String item){
        if(item.charAt(0) =='0' || item.charAt(item.length()-1)=='0'){
            return false;
        }
        String newitem = new StringBuilder(item).reverse().toString();
        return item.equals(newitem);
    }
    public static String convertBase(int newBase, int val){
        return Integer.toString(val,newBase);
    }
    public static boolean checkNum(int num){
        int numbTimesChecked = 0;
        for(int i = 2; i<= 10; i++){
            if(isPalindrome(convertBase(i,num))){
                numbTimesChecked++;
            }
        }
        return numbTimesChecked>=2;
    }
}
