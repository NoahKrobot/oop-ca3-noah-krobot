import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 *  Name: Noah Krobot
 *  Class Group: SD2B
 */

public class CA3_Question3
{
    public static void readFile(String fileName) throws FileNotFoundException {

        File file = new File(fileName);
        Scanner key = new Scanner(file);
        key.useDelimiter("[^A-Za-z0-9_]+");

        int lineNumb= 0;
        String singleLine = "";


        Map< Integer, String> numberedLinesMap;
        numberedLinesMap = new TreeMap< Integer, String>();
        //I'm using a TreeMap, so I can order the lines later
        //  -> Used a hashMap at first, but it doesn't sort line by numbers and it looks odd.

        while (key.hasNextLine()) {
            singleLine = key.nextLine().trim();
            lineNumb++;

            //I added this so empty lines are skipped.
            if (!singleLine.isEmpty()) {
                numberedLinesMap.put(lineNumb, singleLine);
            }
        }
        Set<Integer> keySet = numberedLinesMap.keySet();
        for (Integer oneKey : keySet) {
                String value = numberedLinesMap.get(oneKey);
                System.out.println("Line " + oneKey + ": " +  value+ "\n");
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        readFile("src/CA3_Question1.java");
    }
}
