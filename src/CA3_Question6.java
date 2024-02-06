
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
                int qty = in.nextInt();
                double price = in.nextDouble();
                Block addBlock = new Block(qty, price);
                shares.add(addBlock);

            }
            else if(command.equals("sell"))
            {
                int qty = in.nextInt();
                double price = in.nextDouble();

                seellShares(qty, price, shares);
            }

            System.out.println("\n***** SHARES *****\n");

            for(Block block: shares){
                System.out.println(block.toString());
            }

        }while(!command.equalsIgnoreCase("quit"));
    }

    public static void seellShares(int qty, double price,Queue<Block> shares){
        int remainingQuantity=0;
        double profit = 0;
        int counter = 1;
        for(Block block: shares){

            if(counter==1){

            qty = qty - block.getQuantity();
            price = price-block.getPrice();

            if(qty<=0){
                shares.remove(block);
                remainingQuantity=qty*-1;
            }else{
                remainingQuantity= qty-block.getQuantity();
            }
            }else{
                remainingQuantity = remainingQuantity - block.getQuantity();
                price = price-block.getPrice();

                if(qty<=0){
                    shares.remove(block);
                    remainingQuantity=qty*-1;
                }else{
                    remainingQuantity= qty-block.getQuantity();
                }
            }

            profit = remainingQuantity*price;
            counter++;
        }

        System.out.println("Profit =" +profit);
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
            return "Block [quantity=" + quantity + ", price=" + price + "]";
        }

    }

}