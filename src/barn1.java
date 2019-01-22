/*
ID: sairaja
LANG: JAVA
TASK: barn1
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class barn1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner( new File("barn1.in"));
        PrintWriter out = new PrintWriter(new File("barn1.out"));
        int board = sc.nextInt();
        int stalls = sc.nextInt(); int filledStalls = sc.nextInt();
        boolean [] stallsarr =new boolean[stalls+1];
        int initial = 1;
        int boardsused = 0;

        for(int i = 0; i< filledStalls; i++){
            if(i==0){
                initial= sc.nextInt();
                stallsarr[initial] =true;
            }else{
                stallsarr[sc.nextInt()] = true;
            }
        }

        for (int i = 0; i < stallsarr.length; i++) {
            boolean b = stallsarr[i];
            System.out.print(b?1:0);
        }
        System.out.println();
        ArrayList < Gap> gapsremainnig = new ArrayList<>();
        for(int i = initial; i<= stalls; i++){
            if(!stallsarr[i]){
                int origin = i;
                while(i<stalls && !stallsarr[i]){
                    i++;
                }
                gapsremainnig.add(new Gap(origin,i , i-origin));

            }
        }

        Collections.sort(gapsremainnig);
        System.out.println(gapsremainnig);
        //Start Identifying which gaps need to be covered up 

        out.close();
    }
    static class Gap implements  Comparable{
        public int beg,end, distance;
        public Gap(int a, int b, int c){
            beg = a; end = b; distance =c;
        }
        @Override
        public int compareTo(Object o) {
            return this.distance- ((Gap)o).distance;
        }

        @Override
        public String toString() {
            return beg+ " "+ end+ " " + distance + " ";
        }
    }
}