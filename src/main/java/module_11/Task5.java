package module_11;

// Напишіть метод public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) який "перемішує" елементи зі стрімів first та second, зупиняючись тоді, коли у одного зі стрімів закінчаться елементи.

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task5 {
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second){
        List<T> result = new ArrayList<>();
        Iterator<T> iteratorFirst = first.iterator();
        Iterator<T> iteratorSecond = second.iterator();
        while (iteratorFirst.hasNext() && iteratorSecond.hasNext()) {
            result.add(iteratorFirst.next());
            result.add(iteratorSecond.next());
        }
        return result.stream();
    }
    public static void main(String[] args) {
        Stream<Integer> firstStream = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> secondStream = Stream.of(50, 60, 70);

        Stream<Integer> zip = zip(firstStream, secondStream);
        System.out.println(zip.collect(Collectors.toList()));
    }
}
