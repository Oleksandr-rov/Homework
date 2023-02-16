package module_11;

//Використовуючи Stream.iterate, створіть безкінечний стрім випадкових чисел, але не використовуючи Math.random().
//        Реалізуйте свій лінійний конгруентний генератор. Для цього почніть з x[0] = seed, і далі кожний наступний елемент рахуйте за формулою на зразок x[n + 1] = 1 (a x[n] + c) % m для коректних значень a, c, та m.
//        Необхідно імплементувати метод, що приймає на вхід параметри a, c, та m, і повертає Stream<Long>.
//        Для тесту використовуйте такі дані:
//        a = 25214903917
//        c = 11
//        m = 2^48 (2в степені48`)

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task4 {

    public static List<Long> randomStream(){
        long a = 25214903917L;
        long c = 11L;
        long m = (long) Math.pow(2, 48);
        long seed = 0L;
        int limit = 10;

        Stream<Long> stream = Stream.iterate(seed, x -> (a * x + c) % m);
        return stream
                .limit(limit)
                .collect(Collectors.toList());
    }
    public static void main(String[] args) {
        randomStream().forEach(System.out::println);
    }
}
