import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class tshirts {
   public static HashMap<Integer, ArrayList<String>> getLastYrShirtsBasedOnSize = new HashMap<>();
   public static HashMap<Integer, ArrayList<String>> ThisyrShirtsBasedOnSize = new HashMap<>();
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("tshirt.in"));
        boolean sameszie = true;
        int numchanges = 0;
        int n = sc.nextInt(); sc.nextLine();
        initialize(n, sc,sameszie);
            if (sameszie) {
                HashSet<Integer> lookTrhought = new HashSet(getLastYrShirtsBasedOnSize.keySet());
                for (Integer p : lookTrhought) {
                    ArrayList<String> old = getLastYrShirtsBasedOnSize.get(p);
                    ArrayList<String> newyr = ThisyrShirtsBasedOnSize.get(p);
                    for (int i = 0; i < old.size(); i++) {
                        if (newyr.contains(old.get(i))) {
                            newyr.remove(old.get(i));
                            old.remove(old.get(i));
                            i--;
                        }
                    }
                    numchanges+= old.size();
                }
            }
            System.out.println(numchanges);
            System.out.println();

    }
    public static void initialize(int n, Scanner sc, boolean sameszie){
        for (int i = 0; i < n; i++) {
            String p = sc.nextLine();
            if (getLastYrShirtsBasedOnSize.containsKey(p.length())) {
                ArrayList<String> item = getLastYrShirtsBasedOnSize.get(p.length());
                item.add(p);
                getLastYrShirtsBasedOnSize.put(p.length(), item);
            } else {
                ArrayList<String> item = new ArrayList<>();
                item.add(p);
                getLastYrShirtsBasedOnSize.put(p.length(), item);
            }
        }
        for (int i = 0; i < n; i++) {
            String p = sc.nextLine();
            if (ThisyrShirtsBasedOnSize.containsKey(p.length())) {
                ArrayList<String> item = ThisyrShirtsBasedOnSize.get(p.length());
                item.add(p);
                ThisyrShirtsBasedOnSize.put(p.length(), item);
            } else {
                if (!getLastYrShirtsBasedOnSize.containsKey(p.length())) {
                    sameszie = false;
                }
                ArrayList<String> item = new ArrayList<>();
                item.add(p);
                ThisyrShirtsBasedOnSize.put(p.length(), item);
            }
        }
    }
}
