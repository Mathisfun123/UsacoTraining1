import jdk.nashorn.api.tree.Tree;

import java.util.*;
import java.io.*;

public class barn1 {
// Note Sai: keep beg and endpoints and just keep going based on that
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(new File("barn1" + ".in"));
        PrintWriter out = new PrintWriter(new File("barn1.out"));
        int m = sc.nextInt();
        boolean arr [] = new boolean[sc.nextInt()];
        int lookup = sc.nextInt();
        sc.nextLine();
        arr[0]= true;
        int boardsused = lookup;
        int minpos = 1; int maxpos = 1;
        for (int i = 0; i < lookup; i++) {
            int val = Integer.parseInt(sc.nextLine());
            arr[val] = true;
            if(i == 0) {
                minpos= val;
            }
            if(i==lookup-1){
                maxpos= val;
            }
        }
        // Get info of filled cows: if filled classify spot as true
        ArrayList<Gaps> Gaplist = new ArrayList<>();

        for(int  i = minpos; i< maxpos; i++){
            if(!arr[i]){
                int j = i+1;
                while(j<maxpos && !arr[j] ){
                    j++;
                }
                int diff = j - i;
                Gaplist.add(new Gaps(diff,i,j));
                i=j;
            }
        }
        Collections.sort(Gaplist);
        //identify gaps between stalls
        for (int i = 0; i < Gaplist.size(); i++) {
            Gaps gaps =  Gaplist.get(i);
            System.out.println(gaps);
        }
        //keep removing gaps ( smallest distance ) till have max boards possible
        while(boardsused > m){
            Gaps item = Gaplist.remove(0);
            for (int i = item.intialspot; i < item.finalspot; i++) {
               arr[i] = true;
            }
            boardsused--;
        }
        int counter = 0;
        for (int i = minpos; i < maxpos; i++) {
            if(arr[i]){
                counter++;
            }
        }
        System.out.println(counter-minpos);



    }
    static class Gaps implements  Comparable{
        int gaplength, intialspot, finalspot;
        public Gaps(int gaplength, int intialspot, int finalspot) {
            this.gaplength = gaplength;
            this.intialspot = intialspot;
            this.finalspot = finalspot;
        }

        @Override
        public int compareTo(Object o) {
            Gaps p = (Gaps) o;
            return this.gaplength - p.gaplength;
        }
        public String toString(){
            return gaplength+ " "+ intialspot + " " + finalspot;
        }
    }
}

