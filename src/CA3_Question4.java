import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
/**
 *  Name: Noah Krobot
 *  Class Group: SD2B
 */

public class CA3_Question4 {

    /*
        filename: name of the file to test.
     */



    static Stack<String> htmlElementStack = new Stack<String>();
    static Stack<String> htmlOpenedStack = new Stack<String>();


    public static boolean validate(String filename) throws FileNotFoundException
    {
        System.out.println("\nvalidate: \n");

        File file = new File(filename);
        Scanner key = new Scanner(file);

        String singleLine = "";
        singleLine = key.nextLine().trim();

        extractHtmlStack(singleLine);





        return false;
    }


    public static void extractHtmlStack (String line){
        int counter = 0;
        int currentPosition= 0;
        int finalPosition = 0 ;
        while (counter < line.length()) {
            currentPosition = line.indexOf('<', counter);
            finalPosition= line.indexOf('>', currentPosition);

            if (currentPosition != -1 && finalPosition != -1) {
                String tag = line.substring(currentPosition, finalPosition + 1);
                System.out.println(tag);
                htmlElementStack.add(tag);
                counter = finalPosition + 1;
            } else {
                break;
            }
        }
    }

    /*
        This function tests the files in the files array to see if
         they are valid.
         tags_valid.txt should return true;
         tags_invalid.txt should output as invalid;
     */
    public static void main(String[] args) throws FileNotFoundException {
        String[] files = {"tags_valid.txt", "tags_invalid.txt"};
        for(String fName: files) {
//            System.out.print(fName +": ");
//            if (validate(fName)) {
//                System.out.println("This file is valid");
//            } else {
//                System.out.println("This file is invalid");
//            }
            validate(fName);
        }
    }
}
