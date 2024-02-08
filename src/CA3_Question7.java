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
        //1. get that the output is:
                //symbol1
                //block1
                //symbol2
                //block2           -done

        Queue<Block> shares = new LinkedList<>();

        Map<String, Queue<Block>> symbolShares = new HashMap<>();
        Scanner in = new Scanner(System.in);
        String command = "";

        do {
            System.out.print(">");
            command = in.next();

            if (command.equalsIgnoreCase("buy")) {
                System.out.println("symbol: ");
                String symbol = in.next().trim();


                    System.out.println("quantity: ");
                    int qty = validInt();
                    System.out.println("price: ");
                    double price = validDouble();

                    Block addBlock = new Block(qty, price);

                    if(symbolShares.containsKey(symbol)){
                        Queue<Block> symbolBlocks = symbolShares.get(symbol);
                        symbolBlocks.add(addBlock);
                    }else{
                        Queue<Block> stocks = new LinkedList<>();
                        stocks.add(addBlock);
                        symbolShares.put(symbol, stocks);
                    }
//                    shares.add(addBlock);
//                    symbolShares.put(symbol, shares);

            } else if (command.equalsIgnoreCase("sell")) {
                System.out.println("symbol: ");
                String symbol = in.next().trim();
                System.out.println("quantity: ");
                int qty = validInt();
                System.out.println("price: ");
                double price = validDouble();

                Queue<Block> symbolBlocks = null;

                sellShares(symbol, qty, price, symbolBlocks);


                boolean doesSymbolExists = symbolShares.containsKey(symbol);

                if (doesSymbolExists) {
                    sellShares(symbol, symbolShares);
                } else {
                    System.out.println("Symbol " + symbol + " does not exist.");
                }
            }

            System.out.println("\n***** SHARES *****\n");

            Set<String> keySet = symbolShares.keySet();
            for (String key : keySet) {
                Queue<Block> value = symbolShares.get(key);
                System.out.println("Symbol: "+key +" "+ value);
            }

        } while (!command.equalsIgnoreCase("quit"));
    }

    public static void sellShares(String symbol, int qty, double price,   Queue<Block> symbolBlocks) {
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
            CA3_Question6.Block block = shares.remove();

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