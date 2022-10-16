package Recursion.Task2;

import java.util.Random;

public class Goods {

    private int price;
    private int weight;
    public static Goods[] shop;

    public Goods() {
        this.price = getRandomPrice();
        this.weight = getRandomWeight();
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

    public static int getRandomPrice() {
        final int[] prices = {10, 20, 30, 40, 50, 60, 70};
        final int SIZE = prices.length;
        final Random RANDOM = new Random();
        return prices[RANDOM.nextInt(SIZE)];
    }

    public static int getRandomWeight() {
        final int[] weights = {1, 2, 3, 4, 5, 8, 10};
        final int SIZE = weights.length;
        final Random RANDOM = new Random();
        return weights[RANDOM.nextInt(SIZE)];
    }

    static Goods[] itemGenerator(int count) {
        shop = new Goods[count];
        for (int i = 0; i < shop.length; i++) {
            shop[i] = new Goods();
        }
        return shop;
    }

    static void print(Goods[] shop) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < shop.length; i++) {
            String item = "(" + shop[i].getWeight() + " ; " + shop[i].getPrice() + ")";
            output.append(item).append(", ");
        }
        if (output.length() > 2) {
            output.deleteCharAt(output.length() - 1);
            output.deleteCharAt(output.length() - 1);
        }
        System.out.println("[" + output + "]");
    }
}
