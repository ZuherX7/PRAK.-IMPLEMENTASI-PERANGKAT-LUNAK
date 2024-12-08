import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcepTest {
    public static void main(String args[]) {
        // 5.3.2: Single Catch Block
        try {
            int a[] = new int[2];
            System.out.println("Access element three :" + a[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception thrown :" + e);
        }
        System.out.println("Out of the block");

        // 5.3.3: Multiple Catch Blocks
        try {
            String fileName = "example.txt";
            FileInputStream file = new FileInputStream(fileName);
            int x = file.read();
        } catch (FileNotFoundException f) {
            f.printStackTrace();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
