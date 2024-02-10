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

                int totalBlockStocks = 0;
                double spent = 0;
                int remainingQuantity = qty;



                int quantityToSell =0;
                int blockQty =0;

                double profit = 0;

                if (symbolShares.containsKey(symbol)) {
                    symbolBlocks = symbolShares.get(symbol);
                    for (Block block : symbolBlocks) {
                        totalBlockStocks = totalBlockStocks + block.getQuantity();
                    }

                    while (qty > 0 && !symbolBlocks.isEmpty()) {
                       Block block = symbolBlocks.remove();

                        blockQty = block.getQuantity();
                        if(qty < blockQty){
                            quantityToSell=qty;
                        }else{
                            quantityToSell=blockQty;
                        }

                        qty = qty-quantityToSell;
                        profit =profit + quantityToSell * (price - block.getPrice());

//                        System.out.println("Quantitiy for block: " +block.getQuantity());
//                        System.out.println("Quantitiy to be sold: " +quantityToSell);

                        if (quantityToSell < block.getQuantity()) {
                            block.setQuantity(block.getQuantity() - quantityToSell);
                            symbolBlocks.add(block);
                        }else{
                            System.out.println("You want to sell a bigger amount than you have. Therefore, you will only sell " + block.getQuantity()+" stocks.");

                        }

                    }

                    System.out.println("Profit: " + profit);

                } else {
                    System.out.println("You don't have any shares with this symbol.");
                }
            }

            System.out.println("\n***** SHARES *****\n");

            Set<String> keySet = symbolShares.keySet();
            for (String key : keySet) {
                Queue<Block> value = symbolShares.get(key);
                if(!value.isEmpty()){
                    System.out.println("Symbol: "+key +" "+ value);

                }
            }

        } while (!command.equalsIgnoreCase("quit"));
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