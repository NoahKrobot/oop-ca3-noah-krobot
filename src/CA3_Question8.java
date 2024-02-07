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
        System.out.println("Equation: " + equation);

        Stack<Integer> numberStack = new Stack<>();



        System.out.println("Numbers in the stack: " + numberStack);
    }
}
