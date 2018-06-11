import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.TreeSet;

public class CoinChangeAt1 {
    private  static int least = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int coins1 []= {1,3,15,16};
        int appre [] = new int[coins1.length];
        solve(18,coins1,0, appre);
        System.out.println(least);
    }
    public static void solve(int amt, int coins [], int index , int appreaSoFar[]) {
        if (amt == 0) {
            int sum = 0;
            for (int i = 0; i < appreaSoFar.length; i++) {
                sum += appreaSoFar[i];
                //System.out.print("Values: "+  appreaSoFar[i] + " ");
            }
            //System.out.println();
            least = Math.min(sum, least);
        }
        if (index < coins.length) {
             int poss = amt / coins[index];
             for (int i = 0; i <= poss; i++) {
                    appreaSoFar[index] = i;
                    solve(amt - (coins[index] * i), coins, index + 1, appreaSoFar);
             }
         }
    }
}
