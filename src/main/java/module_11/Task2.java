package module_11;

// Метод приймає на вхід список рядків (можна взяти список із Завдання 1). Повертає список цих рядків у верхньому регістрі, і відсортованих за спаданням (від Z до A).

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Task2 {
    public static String getLineUpperSortedRevers(List<String> lines){
        return lines.stream()
                .map(String::toUpperCase)
                .peek(System.out::println)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining(", "));
    }
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ivan", "Mary", "Peter", "John", "Kate");
        String result = getLineUpperSortedRevers(names);
        System.out.println(result);
    }
}
