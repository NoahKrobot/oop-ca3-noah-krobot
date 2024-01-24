import java.util.Scanner;
import java.util.Stack;

/**
 *  Name:
 *  Class Group:
 */
public class CA3_Question1
{
    static Stack<Integer> driveway = new Stack<Integer>();
    static Stack<Integer> street = new Stack<Integer>();


    public static void runSimulation()
    {
        int command = 0;

        boolean runWhile=true;

        while(runWhile){
           if(command ==0) {
               runWhile=false;
               System.out.println("Driveway: ");
               System.out.println(driveway);

               System.out.println("Street: ");
               System.out.println(street);
           }
           if(command <0){
               removeCar(command);
           }if(command >0){
               addCar(command);

            }


        }

        System.out.println("Entering a number.");

    }

    public static void main(String[] args) {
        runSimulation();
    }

    public static void stackOperations(){
        driveway.push(1);
        driveway.push(2);
        driveway.push(3);
        driveway.push(4);
        driveway.push(5);

        street.push(-1);
        street.push(-2);
        street.push(-3);
        street.push(-4);
        street.push(-5);

        int newVehicle = 0;
        int topOfDriveway = 0;
    }

    public static void addCar(int newCar){
        Scanner key = new Scanner(System.in);
        boolean runWhile = true;

        while(runWhile){
            newCar = 0;
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


    public static void removeCar(int removeCar){
        Scanner key = new Scanner(System.in);
        boolean runWhile = true;

        while(runWhile){
            System.out.println("Add a new car: ");
            removeCar = key.nextInt();
            if(driveway.contains(removeCar)){

                lifoProblem(removeCar);

            }else{
                System.out.println("This car is not in the driveway.");
            }

        }
    }

    public static void lifoProblem(int removeCar){
        int simulationCommand = 0;

        removeCar= removeCar*-1;

        if(driveway.pop() == removeCar){
            System.out.println("Car has been removed");
            simulationCommand =  removeCar*-1;
        }else{
            for(Integer car: driveway){
                if(driveway.pop() == car){
                    if(car != removeCar){
                        simulationCommand= car*-1;
                    }else{
                        break;
                    }
                }

            }
        }
    }
}
