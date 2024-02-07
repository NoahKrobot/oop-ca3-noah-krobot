//Tutorials:
    //get the ascii codes:
        //https://www.baeldung.com/java-character-ascii-value


import java.util.Scanner;
import java.util.Stack;

/**
 *  Name: Noah Krobot
 *  Class Group: SD2B
 */


public class CA3_Question8 {

    //1. loop thru the equation
    //2. if char is number -> put it to the stack
    //4. if char is ( create

    /*
        Reads in an equation from the user
     */
    public static void main(String[] args) {
        String equation;
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter equation");
        equation = in.nextLine().trim();


        Stack<Integer> numberStack = new Stack<>();
        Stack<Integer> operationStack = new Stack<>();

//        String currentCharacter = "";
        for(int i=0; i<equation.length();i++){
            char currentCharacter = equation.charAt(i);
            int asciiValue = (int) currentCharacter;
            System.out.println("current ascii " + asciiValue);
        }





        System.out.println("Numbers in the stack: " + numberStack);
    }
}
