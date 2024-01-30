import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *  Name: Noah Krobot
 *  Class Group: SD2B
 */


public class CA3_Question5
{
    static Scanner key = new Scanner(System.in);

    static Queue<String> takeoffQueue = new LinkedList<>();
    static Queue<String> landingQueue = new LinkedList<>();

    public static void main(String[] args)
    {
//        System.out.println("test");

        String singleCommand = "";
        String flightNumber = "";
        System.out.println("Enter the command: ");

        singleCommand = key.nextLine();
        if(singleCommand.equals("takeoff")){
            flightNumber = enterFlight();
            System.out.println(flightNumber);
        }

//        else if(singleCommand.equals("land"){
//
//
//    }else if(singleCommand.equals("next"){
//
//    }else if(singleCommand.equals("quit"){
//
//    }
    }

    public static String enterFlight(){
        System.out.println("Enter a flight number: ");
        int flightNumber = 0;
        flightNumber = validInput();
        String fullFlightName = "Flight-";
        fullFlightName += flightNumber;
        return fullFlightName;
    }

    public static int validInput(){
        int number = 0;
        boolean runWhile = true;

        while(runWhile){
            Scanner keyValid = new Scanner(System.in);

            if(keyValid.hasNextInt()){
                number = keyValid.nextInt();
                runWhile=false;
            }else{
                System.out.println("Number has to be integer value.");
            }
        }
        return number;
    }
}
