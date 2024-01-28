import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

/**
 *  Name: Noah Krobot
 *  Class Group: SD2B
 */

public class CA3_Question1
{
    static Stack<Integer> driveway = new Stack<Integer>();
    static Stack<Integer> street = new Stack<Integer>();


    public static void runSimulation()
    {
        Scanner key = new Scanner(System.in);
        int command = 0;

        int counter =1;
        boolean runWhile=true;

        while(runWhile){


            System.out.println("\n\n--- STEP "+counter+" ---");


            System.out.println("Driveway: ");
            System.out.println(driveway);

            System.out.println("Street: ");
            System.out.println(street);

            System.out.println("Enter a number: ");
            command = key.nextInt();

           if(command ==0) {
               runWhile=false;

               System.out.println("Final sets");
               System.out.println("Driveway: ");
               System.out.println(driveway);

               System.out.println("Street: ");
               System.out.println(street);
           }
           if(command < 0){
               removeCar(command);
           }if(command >0){
               addCar(command);
            }
            counter++;
        }
    }

    public static void main(String[] args) {
        runSimulation();
    }


    public static void addCar(int newCar){
        Scanner key = new Scanner(System.in);
        boolean runWhile = true;

            if(driveway.contains(newCar)){
                System.out.println("This car is already in the driveway.");
            }else{
                driveway.add(newCar);
                if(street.contains(newCar)){
                    street.removeElement(newCar);
                }
                System.out.println(newCar+" added to the driveway.");
            }
    }


    public static void removeCar(int removeCar){

        removeCar=removeCar*-1;
        boolean runWhile= true;
        System.out.println("remove car: "+removeCar);

            if(driveway.contains(removeCar)){
                System.out.println("This car is in the driveway.");




                while(runWhile){
                    Iterator<Integer> itr = driveway.iterator();
                    int lastElement = itr.next();
                    while(itr.hasNext()){
                        lastElement = itr.next();
                    }

                    driveway.removeElement(lastElement);
                    System.out.println(lastElement +" removed from the driveway.");

                    street.add(lastElement);



                    if(lastElement == removeCar){
                         runWhile= false;
                    }
                }
            }else{
                System.out.println("This car is not in the driveway.");
            }
    }
}
