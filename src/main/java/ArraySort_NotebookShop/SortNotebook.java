package ArraySort_NotebookShop;

import java.util.Comparator;

public class SortNotebook {
    public static Notebook[] sortSelect(Notebook[] shop) {
        int out, in, mark;
        for (out = 0; out < shop.length; out++) {
            mark = out;
            for (in = out + 1; in < shop.length; in++) {
                if (shop[in].getPrice() < shop[mark].getPrice()) {
                    mark = in;
                }
                if (shop[in].getPrice() == shop[mark].getPrice()) {
                    if (shop[in].getRam() < shop[mark].getRam()) {
                        mark = in;
                    }
                    if (shop[in].getRam() == shop[mark].getRam()) {
                        if (shop[in].getBrand().compare(shop[in], shop[mark]) < 0) {
                            mark = in;
                        }
                    }
                }
            }
            change(shop, out, mark);
        }
        return shop;
    }


    public static Notebook[] sort(Notebook[] shop, Comparator<Notebook> tComparator) {
        int out, in, mark;
        for (out = 0; out < shop.length; out++) {
            mark = out;
            for (in = out + 1; in < shop.length; in++) {
                if (tComparator.compare(shop[in], shop[mark]) < 0) {
                    mark = in;
                }
            }
            change(shop, out, mark);
        }
        return shop;
    }


    private static void change(Notebook[] shop, int a, int b) {
        Notebook tmp = shop[a];
        shop[a] = shop[b];
        shop[b] = tmp;
    }
}
