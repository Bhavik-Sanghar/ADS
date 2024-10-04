import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        try {
            File file = new File("/Practical-1/input.txt");
            Scanner sc = new Scanner(file);

            while (sc.hasNext()) {
                // Check if the next token is an integer
                if (sc.hasNextInt()) {
                    int num = sc.nextInt();
                    System.out.println("Integer: " + num);
                } else if (sc.hasNextLine()) { // If not, read it as a string
                    String line = sc.nextLine();
                    System.out.println("String: " + line);
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}
