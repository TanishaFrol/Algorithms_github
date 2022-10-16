package ArraySort_NotebookShop;

import java.util.Comparator;
import java.util.Random;

public class Notebook {

    double price;
    int ram;
    brand brand;

    public Notebook() {
        this.price = getRandomPrice();
        this.ram = getRandomRam();
        this.brand = getRandomBrand();
    }

    public double getPrice() {
        return price;
    }

    public int getRam() {
        return ram;
    }

    public Notebook.brand getBrand() {
        return brand;
    }

    public enum brand implements Comparator<Notebook> {
        Lenuvo, Asos, MacNote, Eser, Xamiou;


        @Override
        public int compare(Notebook o1, Notebook o2) {
            if (o1.brand.ordinal() < o2.brand.ordinal())
                return -1;
            else if (o1.brand.ordinal() > o2.brand.ordinal())
                return 1;
            else
                return 0;
        }
    }

    public brand getRandomBrand() {
        final brand[] brands = brand.values();
        final int SIZE = brands.length;
        final Random RANDOM = new Random();
        return brands[RANDOM.nextInt(SIZE)];
    }

    public static double getRandomPrice() {
        final double[] prices = {100, 200, 300, 400, 500, 600, 700};
        final int SIZE = prices.length;
        final Random RANDOM = new Random();
        return prices[RANDOM.nextInt(SIZE)];
    }

    public static int getRandomRam() {
        final int[] rams = {4, 8, 16, 20, 24};
        final int SIZE = rams.length;
        final Random RANDOM = new Random();
        return rams[RANDOM.nextInt(SIZE)];
    }

}
