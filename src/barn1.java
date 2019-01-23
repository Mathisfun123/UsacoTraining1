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
        int initial = stalls;
        int boardsused = 0;

        for(int i = 0; i< filledStalls; i++){

                int val = sc.nextInt();
                initial= Math.min(val,initial);
                stallsarr[val] =true;

        }

        boolean condition = true;
        for(int i = initial+1; i< stallsarr.length; i++){
            if(!condition){
                if(stallsarr[i]){
                    condition=true;
            }
            }else{
                if(!stallsarr[i]){
                    condition= false; boardsused++;
                }
            }
        }
        if(stallsarr[stallsarr.length-1]){
            boardsused++;
        }

//        System.out.println(stallsarr[99] + " "+ stallsarr[100] + initial);
//        for (int i = 0; i < stallsarr.length; i++) {
//            boolean b = stallsarr[i];
//            System.out.print(b?1:0);
//        }
//        System.out.println();
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
//        System.out.println(gapsremainnig);
        //Start Identifying which gaps need to be covered up
        while(boardsused>board){
            Gap item = gapsremainnig.remove(0);
            for(int i = item.beg; i<=item.end; i++){
                stallsarr[i]= true;
            }
            boardsused--;
        }
        int count = 0;
        for(int i = initial; i< stallsarr.length; i++){
            if(stallsarr[i]){
//                System.out.println(i);
                count++;
            }
        }
        out.println(count);
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