import java.util.Scanner;
import java.util.Stack;

/**
 *  Name:
 *  Class Group:
 */
public class CA3_Question1
{

    public static void runSimulation()
    {

    }

    public static void main(String[] args) {
        runSimulation();
    }

    public static void stackOperations(){
        Stack<Integer> driveway = new Stack<Integer>();
        driveway.push(1);
        driveway.push(2);
        driveway.push(3);
        driveway.push(4);
        driveway.push(5);

        Stack<Integer> street = new Stack<Integer>();
        street.push(-1);
        street.push(-2);
        street.push(-3);
        street.push(-4);
        street.push(-5);

        int newVehicle = 0;
        int topOfDriveway = 0;
    }

    public static void addCar(){
        Stack<Integer> driveway = new Stack<Integer>();
        Scanner key = new Scanner(System.in);
        boolean runWhile = true;

        while(runWhile){
            int newCar = 0;
            System.out.println("Add a new car: ");
            newCar = key.nextInt();
            if(driveway.contains(newCar)){
                System.out.println("This car is already in the driveway.");
            }else{
                driveway.add(newCar);
                runWhile=false;
            }
        }
    }

    public static void removeCar(){
        Stack<Integer> driveway = new Stack<Integer>();
        Scanner key = new Scanner(System.in);
        boolean runWhile = true;

        while(runWhile){
            int removeCar = 0;
            System.out.println("Add a new car: ");
            removeCar = key.nextInt();
            if(driveway.contains(removeCar)){



            }else{
                System.out.println("This car is not in the driveway.");
            }

        }
    }

    public static void lifoProblem(){

    }
}
