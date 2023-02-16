package module_11;

//Метод приймає на вхід список імен. Необхідно повернути рядок вигляду 1. Ivan, 3. Peter... лише з тими іменами, що стоять під непарним індексом (1, 3 тощо)

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task1 {
    public static String getNamesByOddIndex(List<String> names) {
        return IntStream.range(0, names.size() + 1)
                .filter(i -> i % 2 != 0)
                .peek(i -> System.out.println("i = " + i))
                .mapToObj(i -> i + ". " + names.get(i-1))
                .collect(Collectors.joining(", "));
    }

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ivan", "Mary", "Peter", "John", "Kate");
        String result = getNamesByOddIndex(names);
        System.out.println(result);
    }
}
