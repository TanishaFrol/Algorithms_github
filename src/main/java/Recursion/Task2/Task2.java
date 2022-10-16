package Recursion.Task2;

/*2. Написать программу «Задача о рюкзаке» с помощью рекурсии.*/

public class Task2 {

    private static int backpackWeight = 0;
    private static int totalBackpackPrice = 0;

    public static void main(String[] args) {
        Goods[] shop = Goods.itemGenerator(10);
        System.out.println("List of goods in the store: [(weight ; price),...]");
        Goods.print(shop);
        Goods[] myBackpack = new Goods[shop.length];
        System.out.println("Max weight of the backpack is " + findBackpackSize(shop) + " kg");
        fillBackpack(myBackpack, shop, findBackpackSize(shop));
    }

    static Goods[] fillBackpack(Goods[] myBackpack, Goods[] shop, int maxBackpackWeight) {
        System.out.println("\tsorted by price arr:");
        Goods.print(sortInsert(shop));
        System.out.println();
        for (int i = 0; i < myBackpack.length; i++) {
            if ((backpackWeight + shop[i].getWeight()) <= maxBackpackWeight) {
                myBackpack[i] = shop[i];
                System.out.println("\t put into backpack: [" + myBackpack[i].getWeight() + "   " + myBackpack[i].getPrice() + "]");
                backpackWeight += shop[i].getWeight();
                totalBackpackPrice += shop[i].getPrice();
                System.out.println("backpackWeight: " + backpackWeight + "\ntotalBackpackPrice: " + totalBackpackPrice);
            }
        }
        return myBackpack;
    }

    public static Goods[] sortInsert(Goods[] shop) {
        int in, out;
        for (out = 1; out < shop.length; out++) {
            Goods temp = shop[out];
            in = out;
            while (in > 0 && shop[in - 1].getPrice() <= temp.getPrice()) {
                shop[in] = shop[in - 1];
                --in;
            }
            shop[in] = temp;
        }
        return shop;
    }

    static int findBackpackSize(Goods[] shop) {
        int goodsWeightSum = 0;
        for (int i = 0; i < shop.length; i++) {
            goodsWeightSum += shop[i].getWeight();
        }
        return goodsWeightSum / 3 * 2;
    }
}
