package ArraySort_NotebookShop;

import java.util.Comparator;

/*Необходимо отсортировать массив, состоящий из экземпляров класса Notebook в количестве 10000 штук.

Класс Notebook содержит поля:
1. Стоимость - price, double [100, 200, 300, 400, 500, 600, 700]
2. Оперативная память - ram, integer [4, 8, 16, 20, 24]
3. Производитель - brand, enum
3.1. Перечисление Brand может принимать следующие значения: Lenuvo, Asos, MacNote, Eser, Xamiou. Сортировать нужно в этом же порядке (т.е. Lenuvo имеет наивысший приоритет).

Отсортировать:
1. По стоимости
2. По оперативной памяти
3. По бренду

*** Вынести логику сортировки в отдельное место. Пусть это место использует Comparator*/

public class Shop {
    private static Notebook[] shop;

    public static void main(String[] args) {

        shop = new Notebook[10000];

        for (int i = 0; i < shop.length; i++) {
            shop[i] = new Notebook();
        }

        Comparator<Notebook> notebookComparator = Comparator.comparingDouble(Notebook::getPrice)
                .thenComparingInt(Notebook::getRam)
                .thenComparing(Comparator.<Notebook>comparingInt(n -> n.getBrand().ordinal()).reversed())
                .reversed();

//       SortNotebook.sortSelect(shop);

        SortNotebook.sort(shop, notebookComparator);
        printNotebookArr(shop);
    }

    static void printNotebookArr(Notebook[] shop) {
        for (int i = 0; i < shop.length; i++) {
            System.out.printf("%s.\tprice: %s\tram: %s\t\tbrand: %s\n", i + 1, shop[i].getPrice(), shop[i].getRam(), shop[i].getBrand());
        }
    }
}
