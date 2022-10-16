package LinkedList;

public class MyIterator {
    public static void main(String[] args) {
        MyLinkedList<Integer> customLinkedList1 = new MyLinkedList<>();

        fillLinkedList(customLinkedList1, 5);

        for (Integer x : customLinkedList1) {
            System.out.println(x);
        }
    }

    private static MyLinkedList<Integer> fillLinkedList(MyLinkedList<Integer> customLinkedList, int linkedListSize) {
        for (int i = 0; i < linkedListSize; i++) {
            customLinkedList.addLast(i + 1);
        }
        return customLinkedList;
    }
}
