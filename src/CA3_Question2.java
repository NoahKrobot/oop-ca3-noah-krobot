import java.util.Scanner;

/**
 *  Name:
 *  Class Group:
 */
public class CA3_Question2
{

    static Scanner key = new Scanner(System.in);


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

        //1. enter the coordinates
        //2. find the coordinates in the array
        //3. increment the numbers in that row
        //4. set that the numbers in the rows under it have starting point +1


        display(arr);
    }

    public static void start()
    {
        int[][] arr = floodFillStart();

        int row=0;
        int column=0;
        System.out.println("Enter the row number: ");
        row = key.nextInt();

        System.out.println("Enter the row number: ");
        column = key.nextInt();

        System.out.println("Starting coordinates are: row " +row +", column "+column+".");

        fill(row+1, column+1, arr);


    }


    public static void main(String[] args) {
        start();
    }


}
