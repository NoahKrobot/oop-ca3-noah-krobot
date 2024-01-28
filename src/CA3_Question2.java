import java.util.Scanner;
import java.util.Stack;

/**
 *  Name: Noah Krobot
 *  Class Group: SD2B
 */

public class CA3_Question2
{

    static Scanner key = new Scanner(System.in);
    static Stack<Integer> floodSpaces = new Stack<Integer>();
    static Stack<Pair> floodStack = new Stack<Pair>();


    public static class Pair {
        int collumn;
        int row;


        Pair(int row, int collumn) {
            this.row = row;
            this.collumn = collumn;
        }
    }

    /*
        Starter function to create the 2D array and populate it with 0

     */



    public static int[][]  floodFillStart() {
        Scanner kb = new Scanner(System.in);
        int[][] arr = new int[10][10];
        for (int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 10; y++)
            {
                arr[x][y] = 0;
            }
        }
       return arr;
    }
    /*
        Helper function to display the image
     */
    public static void display(int[][] arr)
    {
        for (int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 10; y++)
            {
                System.out.printf("%4d", arr[x][y]);
            }
            System.out.println();
        }
    }
    private static void fill(int r, int c, int[][] arr)
    {

        //1. enter the coordinates - done
        //2. find the coordinates in the array - done
        //3. increment the numbers in that row - done
        //4. set that the numbers in the rows under it have starting point +1


        floodStack.push(new Pair(r, c));
        Pair lastPair = floodStack.pop();

            int row = lastPair.row;
            int col = lastPair.collumn;
            if (arr[row][col] == 0) {
                arr[row][col] = 1;
                pushUnfilledNeighbors(floodStack, arr, row, col, lastPair);
            }

        display(arr);
    }


    private static void pushUnfilledNeighbors(Stack<Pair> stack, int[][] arr, int row, int col, Pair lastPair) {
        int incrementInt = 2;
        int loopCounter = 1;
        boolean runWhile=true;


        while(runWhile){
            loopCounter++;



            for (int i = 0; i < 10; i++) {
                col++;
                stack.push(new Pair(row, col));

                if(arr[row][col] == 0){
                    arr[row][col] = incrementInt;
                }
                incrementInt++;
                if(col==9){
                    break;
                }
            }

            incrementInt=loopCounter;

            col =-1;
            row++;

            if(row==10){
                runWhile=false;
            }
        }

//        System.out.println("Row is: "+row+1);
    }

    public static void start() {
        int[][] arr = floodFillStart();

        int row = 0;
        int column = 0;

        boolean runWhile= true;


        while (runWhile) {

            System.out.println("Note: if you enter 0 for either row or column, the simulation will stop.");


            row=validInput(true);

            if(row ==0) break;
            column=validInput(false);

            if(column ==0) break;

            System.out.println("Starting coordinates are: row " + row + ", column " + column + ".");

            fill(row - 1, column - 1, arr);

            if(row == 0 || column ==0){
                runWhile = false;
            }
        }


    }

    public static int validInput(boolean isRow){
        int number = 0;
        boolean runWhile = true;

        while(runWhile){
            Scanner keyValid = new Scanner(System.in);

            if(isRow){
                System.out.println("Enter the row number: ");
            }else{
                System.out.println("Enter the column number: ");
            }

            if(keyValid.hasNextInt()){
                number = keyValid.nextInt();
                if(number <11 && number>=0 ){
                    runWhile=false;
                }else{
                        System.out.println("The number can be from 1 to 10.");
                }
            }else{
                System.out.println("Number has to be integer value.");
            }


        }
        return number;
    }


    public static void main(String[] args) {
        start();
    }


}
