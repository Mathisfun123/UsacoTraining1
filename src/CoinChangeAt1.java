import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.TreeSet;

public class CoinChangeAt1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> coinValues = new ArrayList<>();
    }
    public static void solve(int amt, ArrayList<Integer> Coinitms){
        int[] upToamt = new int[amt+1];
        int possEach[] = new int[amt+1];
        upToamt[0]= 0;
        for(int i = 1; i< upToamt.length; i++){
            upToamt[i]= Integer.MAX_VALUE;
        }


    }
}
