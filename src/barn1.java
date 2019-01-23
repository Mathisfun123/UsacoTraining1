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
        //Input Output
        Scanner sc = new Scanner( new File("barn1.in"));
        PrintWriter out = new PrintWriter(new File("barn1.out"));
        int board = sc.nextInt();
        int stalls = sc.nextInt(); int filledStalls = sc.nextInt();
        //Input Output done
        boolean [] stallsarr =new boolean[stalls+1]; //+1 is to make it easier -> ignoring stallsarr[0] because inputs do not include 0
        int initial = stalls; // Set max value -> look if the max value has a board (must have at least one board)
        //Initialize array with covered -> true or not covered -> false
        for(int i = 0; i< filledStalls; i++){
                int val = sc.nextInt();
                initial= Math.min(val,initial); //Initial set to first occupied stall-> use in loops
                stallsarr[val] =true;
        }
        //End Initialization of array
        //Count the number of Boards used without excess stall covers
        int boardsused = 0;
        boolean condition = true;
        for(int i = initial+1; i< stallsarr.length; i++){
            if(!condition){
                if(stallsarr[i]){
                    condition=true;
            }
            }else{
                if(!stallsarr[i]){
                    condition= false; boardsused++; //Counts on the previous spot being a occupied stall but not the current one
                }
            }
        }
        if(stallsarr[stallsarr.length-1]){
            boardsused++;
        }
        //ex: 011-> need one board (not shown w/out the check on the last stall)

/*        Output the stalls
        for (int i = 0; i < stallsarr.length; i++) {
            boolean b = stallsarr[i];
            System.out.print(b?1:0);
        }
       System.out.println();*/
        //Record gaps present in stalls (eliminate gaps -> reduce boards needed to cover)
        ArrayList <Gap> gapsremainnig = new ArrayList<>();
        for(int i = initial; i<= stalls; i++){
            if(!stallsarr[i]){
                int origin = i;
                while(i<stalls && !stallsarr[i]){
                    i++;
                }
                gapsremainnig.add(new Gap(origin,i , i-origin));
                //Once start of unoccupied, keep going till hit occupied
                //End up storing coordinates of empty -> first occupied
            }
        }

        //Sort by distance (want to cover the least distance/stalls)
        Collections.sort(gapsremainnig);
//        System.out.println(gapsremainnig);
        //Start Identifying which gaps need to be covered up
        while(boardsused>board){
            //Remove the least distance gaps
            Gap item = gapsremainnig.remove(0);
            for(int i = item.beg; i<=item.end; i++){
                //Fill the stalls with imaginary cows
                stallsarr[i]= true;
            }
            boardsused--;
        }
        //count counts number of stalls filled
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
            //Constructor with beg, end, and distance (sort by distance)
        }
        @Override
        public int compareTo(Object o) {
            return this.distance- ((Gap)o).distance;
            //Able to sort with least distance
        }

        @Override
        public String toString() {
            return beg+ " "+ end+ " " + distance + " ";
            //just for checking purposes
        }
    }
}