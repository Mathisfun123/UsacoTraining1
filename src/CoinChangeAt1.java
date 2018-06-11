import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CoinChangeAt1 {
    private  static int least = Integer.MAX_VALUE;
    private  static String leastCoins;
    public static void main(String[] args) {
        int coins1 []= {1,3,15,16};
        int appre [] = new int[coins1.length];
        solve(18,coins1,0, appre);
        System.out.println(least );
        System.out.println(leastCoins);
        /*
        OutPut explained:
        First Line : Least AMT coins to make target amt
        Second Line: List of coins needed to make target amt
         */
    }
    private static void solve(int amt, int coins [], int index , int appreaSoFar[]) {
        if (amt == 0) {
            int sum = 0;
            for (int i = 0; i < appreaSoFar.length; i++) {
                sum += appreaSoFar[i];
                //System.out.print("Values: "+  appreaSoFar[i] + " ");
            }
            //System.out.println();
            if(sum< least ) {
                StringBuilder item = new StringBuilder();
                for(int i: appreaSoFar){
                    item.append(i);
                }
                leastCoins= item.toString();
                least = sum;
            }
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
