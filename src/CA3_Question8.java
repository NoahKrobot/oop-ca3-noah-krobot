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
    //3. if char is ( add it to operationStack
    //4. if the char is ), check if the last operator was not ( or )

    /*
        Reads in an equation from the user
     */
    public static void main(String[] args) {
        String equation;
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter equation");
        equation = in.nextLine().trim();


        Stack<Integer> numberStack = new Stack<>();
        Stack<String> operationStack = new Stack<>();

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

            if (currentCharacterString.equals("(")) {
                lastCharIsNumber = false;
                operationStack.push(currentCharacterString);
            }else if(currentCharacterString.equals(")")){
                lastCharIsNumber = false;
                if(!operationStack.peek().equals("(")  && !operationStack.peek().equals(")")){
                  runOperations(operationStack,numberStack);
                }
                operationStack.pop();
            } else if (currentCharacterString.equals("+")) {
                lastCharIsNumber = false;
                handleOperator("+", 1, operationStack, numberStack);
            } else if (currentCharacterString.equals("-")) {
                lastCharIsNumber = false;
                handleOperator("-", 1, operationStack, numberStack);
            } else if (currentCharacterString.equals("*")) {
                lastCharIsNumber = false;
                handleOperator("*", 2, operationStack, numberStack);
            } else if (currentCharacterString.equals("/")) {
                lastCharIsNumber = false;
                handleOperator("/", 2, operationStack, numberStack);
            }

            if (i == equation.length() - 1)
                while (!operationStack.isEmpty()) {
                    runOperations( operationStack, numberStack);
            }
        }

        System.out.println("Result: " + numberStack.pop());
    }

    private static void handleOperator(String operator, int precedence, Stack<String> operationStack, Stack<Integer> numberStack) {
        //1. give proper precedence to operators
        //2. check if the precedence is higher for * and /,
        //then


        int operatorPrecedenceTopOfStack;
        int operatorPrecedenceNotOnStack;

        if (!operationStack.isEmpty()) {
            String operatorTopOfStack = operationStack.peek();

            if (operatorTopOfStack.equals("*") || operatorTopOfStack.equals("/")) {
                operatorPrecedenceTopOfStack = 2;
            } else {
                operatorPrecedenceTopOfStack = 1;
            }

            if (precedence == 2) {
                operatorPrecedenceNotOnStack = 2;
            } else {
                operatorPrecedenceNotOnStack = 1;
            }

            if (operatorPrecedenceTopOfStack > operatorPrecedenceNotOnStack) {
                runOperations( operationStack, numberStack);
            }
        }
        operationStack.push(operator);
    }

    public static void runOperations(Stack<String> operationStack, Stack<Integer> numberStack) {
        //1. get numbers
        //2. get result for each action

        int number1 = numberStack.pop();
        int number2 = numberStack.pop();
        int miniResult = 0;
        String singleOperaton = operationStack.pop();

        if ("+".equals(singleOperaton)) {
            miniResult = number1 + number2;
        } else if ("-".equals(singleOperaton)) {
            miniResult = number2 - number1;
        } else if ("*".equals(singleOperaton)) {
            miniResult = number1 * number2;
        } else if ("/".equals(singleOperaton)) {
            miniResult = number2 / number1;
        }

        numberStack.push(miniResult);
    }


}
