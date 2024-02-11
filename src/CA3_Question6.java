
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 *  Name: Noah Krobot
 *  Class Group: SD2B
 */

public class CA3_Question6
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
        Queue<Block> shares = new LinkedList<>();

        Scanner in = new Scanner(System.in);
        String command="";
        do {


            System.out.print(">");
            command = in.next();
            if(command.equalsIgnoreCase("buy"))
            {
                System.out.println("quantity: ");
                int qty = validInt();
                System.out.println("price: ");
                double price = validDouble();
                Block addBlock = new Block(qty, price);
                shares.add(addBlock);

            }
            else if(command.equals("sell"))
            {
                int qty = validInt();
                double price = validDouble();

                seellShares(qty, price, shares);
            }

            System.out.println("\n***** SHARES *****\n");

            for(Block block: shares){
                System.out.println(block.toString());
            }

        }while(!command.equalsIgnoreCase("quit"));
    }

    public static void seellShares(int qty, double price,Queue<Block> shares){
        //1. qty cant be 0 and shares cant be empty
        //2. if qty is smaller than block quantity, put qty value to quantityToSell variable
            //reversed if else
        //3. set the new value of qty
        //4. implement profit = profit + quantityToSell *(price - blockPrice)
        //5. it should stop if qty is 0 or less - while



        int quantityToSell =0;
        int blockQty =0;

        double profit = 0;

        while (qty > 0 && !shares.isEmpty()) {
            Block block = shares.remove();

            blockQty = block.getQuantity();
            if(qty < blockQty){
                quantityToSell=qty;
            }else{
                quantityToSell=blockQty;
            }

            qty = qty-quantityToSell;
            profit =profit + quantityToSell * (price - block.getPrice());

            if (quantityToSell < block.getQuantity()) {
                block.setQuantity(block.getQuantity() - quantityToSell);
                shares.add(block);
            }
        }

        System.out.println("Profit = " + profit);

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