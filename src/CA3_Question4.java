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



    static Stack<String> reverseStack = new Stack<String>();
    static Stack<String> htmlOpenedStack = new Stack<String>();
    static Stack<String> htmlClosedStack = new Stack<String>();

//   htmlOpenedStack: o1 o2 o3
//   htmlClosedStack:         o3 o2 o1
//   Therefore, if htmlClosedStack is the revesed one of html open, it is a valid data

    public static boolean validate(String filename) throws FileNotFoundException
    {
        System.out.println("\nvalidate: \n");

        File file = new File(filename);
        Scanner key = new Scanner(file);

        String singleLine = "";
        singleLine = key.nextLine().trim();

        extractHtmlStack(singleLine);

        System.out.println("\n\nreverseStack: ");
        reverseStackMethod(htmlOpenedStack);
        printStack(reverseStack);


        System.out.println("htmlOpenedStack: ");
        printStack(htmlOpenedStack);

        System.out.println("\n\nhtmlClosedStack: ");
        printStack(htmlClosedStack);
        System.out.println("\n\nhtmlClosedStack: ");
        printStack(htmlClosedStack);





        return htmlClosedStack.equals(reverseStack);
    }

    public static void reverseStackMethod(Stack<String> stack) {
        Stack<String> tempStack = new Stack<>();
        while (!stack.isEmpty()) {
            String element = stack.pop();
            System.out.println("element " + element);
            tempStack.push(element);
        }
        // Restore the original order in the stack
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

    public static void extractHtmlStack (String line){
        //1. check if there is < and > found in the line
        //2. check if there's "/", and if true add it to different stack

        System.out.println(line);

        int counter = 0;
        int openingArrowIndex = 0;
        int closingArrowIndex =0;
        String tag = "";

        while(counter < line.length()){
            openingArrowIndex = line.indexOf('<',counter);
//            System.out.println(openingArrowIndex);
            closingArrowIndex = line.indexOf('>',openingArrowIndex);
//            System.out.println(closingArrowIndex);
            if(openingArrowIndex != -1 || closingArrowIndex !=-1){
                tag = line.substring(openingArrowIndex+1, closingArrowIndex);
                if(tag.contains("/")){
                    tag = line.substring(openingArrowIndex+2, closingArrowIndex);
                    htmlClosedStack.add(tag);
                }else{
                    htmlOpenedStack.add(tag);
                }
                counter = closingArrowIndex + 1;
            }
        }
    }

    public static void printStack(Stack<String> stack) {
        Stack<String> tempStack = new Stack<>();
        String element = "";
        while (stack.size() > 0) {
            element = stack.pop();
            System.out.println(element);
            tempStack.add(element);
        }

        while (tempStack.size() > 0) {
            element = tempStack.pop();
            stack.add(element);
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
            if(validate(fName)){
                System.out.printf("HTML code is valid.");
            }else{
                System.out.printf("HTML code is invalid.");
            }
        }
    }
}
