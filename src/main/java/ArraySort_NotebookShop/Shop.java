package ArraySort_NotebookShop;

import java.util.Comparator;

/*���������� ������������� ������, ��������� �� ����������� ������ Notebook � ���������� 10000 ����.

����� Notebook �������� ����:
1. ��������� - price, double [100, 200, 300, 400, 500, 600, 700]
2. ����������� ������ - ram, integer [4, 8, 16, 20, 24]
3. ������������� - brand, enum
3.1. ������������ Brand ����� ��������� ��������� ��������: Lenuvo, Asos, MacNote, Eser, Xamiou. ����������� ����� � ���� �� ������� (�.�. Lenuvo ����� ��������� ���������).

�������������:
1. �� ���������
2. �� ����������� ������
3. �� ������

*** ������� ������ ���������� � ��������� �����. ����� ��� ����� ���������� Comparator*/

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
