//Tutorial: containsKey -> https://www.geeksforgeeks.org/hashmap-containskey-method-in-java/



import java.util.*;

/**
 *  Name: Noah Krobot
 *  Class Group: SD2B
 */

public class CA3_Question7
{


    /*
    Will repeatedly ask the user to enter the commands in the format
    buy qty price
    or
    sell qty price
    or
    quit
     */
    public static void main(String[] args) {
        Map<String, Queue<Block>> symbolShares = new HashMap<>();
        Scanner in = new Scanner(System.in);
        String command = "";

        do {
            System.out.print(">");
            command = in.next();

            if (command.equalsIgnoreCase("buy")) {


            } else if (command.equalsIgnoreCase("sell")) {
                System.out.println("symbol: ");
                String symbol = in.next();

                boolean doesSymbolExists = symbolShares.containsKey(symbol);

                if (doesSymbolExists) {
                    sellShares(symbol, symbolShares);
                } else {
                    System.out.println("Symbol " + symbol + " does not exist.");
                }
            }

            System.out.println("\n***** SHARES *****\n");

            // Display all shares
            for (Map.Entry<String, Queue<Block>> entry : symbolShares.entrySet()) {
                String symbol = entry.getKey();
                Queue<Block> shares = entry.getValue();

                System.out.println("Symbol: " + symbol);
                for (Block block : shares) {
                    System.out.println(block.toString());
                }
            }

        } while (!command.equalsIgnoreCase("quit"));
    }

    public static void sellShares(String symbol, Map<String, Queue<Block>> symbolShares) {

    }

    public static class Block {
        private int quantity;
        private double price;

        public Block(int quantity, double price) {
            this.quantity = quantity;
            this.price = price;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getPrice() {
            return price;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        @Override
        public String toString() {

            return "Block{" +
                    "quantity=" + quantity +
                    ", price=" + price +
                    '}';
        }
    }



    public static int validInt(){
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

    public static double validDouble(){
        double number = 0;
        boolean runWhile = true;

        while(runWhile){
            Scanner keyValidDouble = new Scanner(System.in);
            if(keyValidDouble.hasNextDouble()){
                number = keyValidDouble.nextDouble();
                runWhile=false;
            }else{
                System.out.println("Number has to be double value.");
            }
        }
        return number;
    }

}