package module_11;

//Є масив: ["1, 2, 0", "4, 5"]. Необхідно отримати з масиву всі числа, і вивести їх у відсортованому вигляді через кому , наприклад: "0, 1, 2, 4, 5"

import java.util.Arrays;
import java.util.stream.Collectors;

public class Task3 {
    public static String getArraySorted(String[] arr){
        return Arrays.stream(arr)
                .map(s -> s.split(", "))
                .flatMap(Arrays::stream)
                .map(Integer::valueOf)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

    }
    public static void main(String[] args) {
        String[] arr = {"1, 2, 0", "4, 5", "2"};
        String result = getArraySorted(arr);
        System.out.println(result);
    }
}
