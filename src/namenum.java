/*
ID: sairaja
LANG: JAVA
TASK: namenum
*/
import java.util.*;
import java.io.*;

public class namenum {
    private static HashMap<String,String> convert = new HashMap<>();
    public static void set(){
        convert.put("A","2"); convert.put("B","2"); convert.put("C","2");
        convert.put("D","3"); convert.put("E","3"); convert.put("F","3");
        convert.put("G","4"); convert.put("H","4"); convert.put("I","4");
        convert.put("J","5"); convert.put("K","5"); convert.put("L","5");
        convert.put("M","6"); convert.put("N","6"); convert.put("O","6");
        convert.put("P","7"); convert.put("R","7"); convert.put("S","7");
        convert.put("T","8"); convert.put("U","8"); convert.put("V","8");
        convert.put("W","9"); convert.put("X","9"); convert.put("Y","9");
    }

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(new File("dict" + ".txt"));
        PrintWriter out = new PrintWriter(new File("namenum" + ".out"));
        String abc[] = new String[4617];
        set();
        for(int i = 0; i< abc.length; i++){
            String item =sc.nextLine();
            abc[i]= item;
        }
        sc = new Scanner(new File("namenum.in"));
        String itm = sc.nextLine();
        boolean happ = false;
        for (int i = 0; i < abc.length; i++) {
            String s = abc[i];
            if(convertString(s) .equals(itm)){
                out.println(s); happ = true;
            }
        }
        if(!happ){
            out.println("NONE");
        }
        out.close();
    }
    public static boolean binarySearchexist(String arr[], String val){
        int start = 0; int end = arr.length-1;
        while(start<= end){
            int mid = (start+end)/2;
            if(arr[mid].equals(val)){
                return true;
            }else if(arr[mid].compareTo(val)<0){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return false;
    }
    public static String convertString(String t){
        StringBuilder item = new StringBuilder();
        for(int i = 0; i< t.length(); i++){
            item.append(convert.get(t.substring(i,i+1)));
        }
        return item.toString();
    }
}
