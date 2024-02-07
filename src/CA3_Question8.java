//Tutorials:
    //get the ascii codes:
        //https://www.baeldung.com/java-character-ascii-value
    //ascii table
        //https://www.cs.cmu.edu/~pattis/15-1XX/common/handouts/ascii.html
    //Deque
        //https://docs.oracle.com/javase/8/docs/api/java/util/Deque.html

import java.util.ArrayDeque;
import java.util.Deque;
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

            String currentCharacterString = "";
           char currentCharacter = 0;
           boolean lastCharIsNumber= false;
           String combinedNumber = "";
        for(int i=0; i<equation.length();i++){
            currentCharacter = equation.charAt(i);
            currentCharacterString = String.valueOf(currentCharacter);

            int asciiValue = (int) currentCharacter;
//            System.out.println("current ascii " + asciiValue);

            if (Character.isDigit(currentCharacter)) {
                if(lastCharIsNumber){
                    combinedNumber = String.valueOf(numberStack.pop()+currentCharacterString);
                    numberStack.push(Integer.valueOf(combinedNumber));
                }else{
                    numberStack.push(Integer.valueOf(currentCharacterString));
                }
                lastCharIsNumber = true;
            }

//            Deque<Integer> tempStack = new ArrayDeque<>(numberStack);
//
//            while (!tempStack.isEmpty()) {
//                System.out.println(tempStack.pop());
//            }



        }





        System.out.println("Numbers in the stack: " + numberStack);
    }
}
