import java.io.*;
import java.util.Vector;

public class ListOfNumbers2 {
    private Vector<Integer> victor;
    private static final int SIZE = 10;

    public ListOfNumbers2() {
        victor = new Vector<>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            victor.add(i);
        }
        try {
            this.readList("infile.txt");
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        try {
            this.writeList();
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public void readList(String fileName) throws IOException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    Integer i = Integer.parseInt(line.trim());
                    System.out.println(i);
                    victor.add(i);
                } catch (NumberFormatException e) {
                    System.err.println("Invalid number format in file: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + fileName);
            throw e;
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    public void writeList() throws IOException {
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileWriter("outfile.txt"));
            for (int i = 0; i < victor.size(); i++) {
                out.println("Value at: " + i + " = " + victor.elementAt(i));
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Array index out of bounds: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("I/O error while writing to file: " + e.getMessage());
            throw e;
        } finally {
            if (out != null) {
                out.close();
                System.out.println("File successfully closed.");
            } else {
                System.err.println("PrintWriter not open.");
            }
        }
    }

    public static void main(String[] args) {
        new ListOfNumbers2();
    }
}
