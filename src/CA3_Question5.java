import java.sql.SQLOutput;
import java.util.*;

/**
 *  Name: Noah Krobot
 *  Class Group: SD2B
 */


public class CA3_Question5
{
    static Scanner key = new Scanner(System.in);

    static Queue<String> takeoffQueue = new LinkedList<>();
    static Queue<String> landingQueue = new LinkedList<>();

    static ArrayList <Integer> listOfNumbers = new ArrayList<>();

    public static void main(String[] args)
    {

        ArrayList<Integer> flightSet = new ArrayList<>();

//        System.out.println("test");

        String singleCommand = "";
        String flightNumber = "";
        boolean runWhile = true;

        while(runWhile){
            flightNumber = " ";

        System.out.println("Enter the command: ");


        singleCommand = key.nextLine();
        if(singleCommand.equals("takeoff")){
            flightNumber = enterFlight(flightSet);
            takeoffQueue.add(flightNumber);
//            System.out.println(flightNumber);
        }else if(singleCommand.equals("land")){
            flightNumber = enterFlight(flightSet);
            landingQueue.add(flightNumber);
        }else if(singleCommand.equals("next")){
            clearArrayList();
             if (landingQueue.isEmpty()) {
                 if(takeoffQueue.isEmpty()){
                     System.out.println("There's no planes in takeoff or landing queue.");
                 }else{
                     System.out.println("Plane " + flightNumber + " is taking off.");
                     takeoffQueue.remove(flightNumber);
                 }
             }else {
                 landingQueue.remove(flightNumber);
                 System.out.println("Plane " + flightNumber + " is landing.");
             }


        }else if(singleCommand.equals("quit")){
            runWhile = false;

        }
            System.out.println("Takeoff Queue: " + takeoffQueue);
            System.out.println("Landing Queue: " + landingQueue);
        }


    }

    public static String enterFlight(ArrayList<Integer> flightSet){
        System.out.println("Enter a flight number: ");
        int flightNumber = 0;
        flightNumber = validInput(flightSet);
        String fullFlightName = "Flight-";
        fullFlightName += flightNumber;

        return fullFlightName;
    }

    public static void clearArrayList(){
        listOfNumbers.clear();
    }

    public static int validInput(ArrayList<Integer> flightSet){
        int number = 0;
        boolean runWhile = true;
        boolean error = false;

        while(runWhile){
            error = false;
            Scanner keyValid = new Scanner(System.in);

            if(keyValid.hasNextInt()){
                number = keyValid.nextInt();

                System.out.println(number);

                for (Integer integer : listOfNumbers) {
                    if(number == integer){
                        error=true;
                        break;
                    }
                }
                listOfNumbers.add(number);

                if(!error){
                    break;
                }else{
                    System.out.println("That flight already exists.");
                    System.out.println("Enter a flight number: ");
                }


//
//                for (Integer integer : flightSet) {
//                    System.out.println("flightSet.get(i): " + integer);
//                    System.out.println("number " + number);
//                    if (integer == number) {
//                        error = true;
//                        break;
//                    }
//                }
//
//                if(error){
//                    System.out.println("That flight already exists.");
//                }else{
//                    runWhile=false;
//                }

            }else{
                System.out.println("Number has to be integer value.");
            }
        }
        return number;
    }
}
