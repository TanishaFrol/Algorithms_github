package HashTable;

public class MyHashTableDemo {

    public static void main(String[] args) {
        MyHashTable<Object, Object> hashTable = new MyHashTable<>(5);
        MyHashTableChainMethod<Object, Object> hashTableChainMethod = new MyHashTableChainMethod<>(5);
        /*put(hashTable);*/
        put(hashTableChainMethod);
        /*test(hashTable);*/
        test(hashTableChainMethod);

    }

    private static void test(MyHashTableChainMethod hashTable) {
        System.out.println("Size is " + hashTable.size());
        hashTable.display();
        System.out.println("Potato price is " + hashTable.get(new Product(21, "Potato")));
        System.out.println("Banana price is " + hashTable.get(new Product(77, "Banana")));
        System.out.println("Carrot price is " + hashTable.get(new Product(67, "Carrot")));

        hashTable.remove(new Product(21, "Potato"));
        hashTable.remove(new Product(77, "Banana"));
        System.out.println("Potato price is " + hashTable.get(new Product(21, "Potato")));
        System.out.println("Banana price is " + hashTable.get(new Product(77, "Banana")));
        System.out.println("Carrot price is " + hashTable.get(new Product(67, "Carrot")));
        hashTable.put(new Product(47, "Pineapple"), 228);
        hashTable.display();
    }

    static void put(MyHashTableChainMethod hashTable){
        hashTable.put(new Product(1, "Orange"), 150);
        hashTable.put(new Product(77, "Banana"), 100);
        hashTable.put(new Product(67, "Carrot"), 228);
        hashTable.put(new Product(60, "Lemon"), 250);
        hashTable.put(new Product(51, "Milk"), 120);
        hashTable.put(new Product(21, "Potato"), 67);
    }
}
