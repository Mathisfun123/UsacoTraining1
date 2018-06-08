/*
ID: sairaja
LANG: JAVA
TASK: milk
*/
import java.util.*;
import java.io.*;

public class milk {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(new File("milk" + ".in"));
        PrintWriter out = new PrintWriter(new File("milk" + ".out"));
        int amtMiklkwanted = sc.nextInt();
        int maxFarmers = sc.nextInt();
        sc.nextLine();
        ArrayList<Farmer> possFarmers = new ArrayList<>();
        for (int i = 0; i < maxFarmers; i++) {
            possFarmers.add(new Farmer(sc.nextInt(), sc.nextInt()));
            if (i != maxFarmers - 1)
                sc.nextLine();
        }
        Collections.sort(possFarmers);
        int GreedYCost = 0;
        int unitsSoFar = 0;
        for(int i = 0; i< possFarmers.size(); i++){
            Farmer current = possFarmers.get(i);
            if(unitsSoFar< amtMiklkwanted){
                if(current.amt + unitsSoFar <= amtMiklkwanted){
                    unitsSoFar+= current.amt;
                    GreedYCost+= current.amt* current.costPerUnit;

                }else{
                    int required = amtMiklkwanted- unitsSoFar;
                    unitsSoFar+= required;
                    GreedYCost += current.costPerUnit* required;
                }
            }
        }
        out.println(GreedYCost);
        out.close();
    }
    static class Farmer implements  Comparable<Farmer>{
        public int costPerUnit;
        public int amt;
        public Farmer(int costPerUnit, int amt) {
            this.costPerUnit = costPerUnit;
            this.amt = amt;
        }
        public int compareTo(Farmer o) {
            return costPerUnit- o.costPerUnit ;
        }
    }
}
