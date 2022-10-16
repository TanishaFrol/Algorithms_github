package Recursion.Task2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task2_v2 {

    /**
     * Есть рюкзак, который вмещает x кг чего-то.
     * Есть n вещей. У каждой вещи есть ее вес p и стоимость q. p, q > 0.
     * <p>
     * Требуется максимизировать сумарную стоимость с учетом не превышения сумарного веса.
     * <p>
     * Найти самый дорогой вмещаемый набор.
     */

    public static void main(String[] args) {
        new Task2_v2().solve();
    }

    public void solve() {
        int weight = 20;
        Bag bag = new Bag(weight);
        System.out.println("Box.x = " + weight);

        List<Thing> things = generate(4);
        things.forEach(System.out::println);


        List<Thing> best = findBest(bag, things);
        System.out.println(best);
        System.out.println(sumBy(best, Thing::getP));
        System.out.println(sumBy(best, Thing::getQ));

    }

    private List<Thing> findBest(Bag bag, List<Thing> things) {
        int weightOfThings = sumBy(things, Thing::getP);
        if (weightOfThings <= bag.x) {
            return List.copyOf(things);
        }

        List<List<Thing>> candidates = new ArrayList<>();
        List<Thing> copy = new ArrayList<>(things);
        int size = copy.size();
        for (int i = 0; i < size; i++) {
            Thing thing = copy.get(i);
            copy.remove(thing);
            candidates.add(findBest(bag, copy));
            copy.add(i, thing);
        }

        return candidates.stream()
                .max((l1, l2) -> Integer.compare(sumBy(l1, Thing::getQ), sumBy(l2, Thing::getQ)))
                .orElse(List.of());
    }

    private <T> int sumBy(List<T> list, ToIntFunction<T> mapper) {
        return list.stream().mapToInt(mapper).sum();
    }

    private static List<Thing> generate(int n) {
        return IntStream.range(0, n)
                .mapToObj(it -> new Thing(generateRandomInt(), generateRandomInt()))
                .collect(Collectors.toList());
    }

    private static int generateRandomInt() {
        return 5 + ThreadLocalRandom.current().nextInt(10);
    }


    static class Bag {
        private int x;

        public Bag(int x) {
            this.x = x;
        }
    }

    static class Thing {
        private int p, q;

        public Thing(int p, int q) {
            this.p = p;
            this.q = q;
        }

        public int getP() {
            return p;
        }

        public int getQ() {
            return q;
        }

        @Override
        public String toString() {
            return "Thing{" +
                    "p=" + p +
                    ", q=" + q +
                    '}';
        }
    }

    // x = 10
    // [p, q]: [3, 6], [3, 4], [10, 9]

}
