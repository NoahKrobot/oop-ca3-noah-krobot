import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *  Name:
 *  Class Group:
 */

public class CA3_Question3
{
    public static void readFile(String fileName)
    {

        File file = new File(fileName);
        Scanner key = new Scanner(fileName);
        key.useDelimiter("[^A-Za-z0-9_]+");

        int lineNumb= 0;
        String singleLine = "";

        while (key.hasNextLine()) {
            singleLine = key.nextLine();
            lineNumb++;
            System.out.println(lineNumb+": "+singleLine);
        }



    }

    public static void main(String[] args) throws FileNotFoundException {
        readFile("src/CA3_Question1.java");
    }
}
