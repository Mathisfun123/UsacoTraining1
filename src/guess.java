import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class guess {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc= new Scanner(new File("guess.in"));
		System.out.println(sc.nextInt());

	}
}