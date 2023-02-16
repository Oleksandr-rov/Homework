package module_10;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TestMod10 {
    public static void validNumbers() {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/text.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                isCorrectNumbers(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void isCorrectNumbers(String text) {
        String strReg = "(\\(\\d{3}\\)\\s\\d{3}-\\d{4}\\b|\\d{3}-\\d{3}-\\d{4}\\b)";
        Pattern p = Pattern.compile(strReg);
        Matcher m = p.matcher(text);
        if (m.find()) System.out.println(text);
    }

    public static void RepeatedWords() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/word.txt"))) {
            String str;
            Integer n = 0;
            while ((str = reader.readLine()) != null) {
                String[] line = str.split("\\s+");
                for (String s : line) {
                    if (map.isEmpty()) map.put(s, ++n);
                    else if ((n = map.get(s)) != null) {
                        map.put(s, ++n);
                    } else map.put(s, 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Set<Map.Entry<String, Integer>> set = map.entrySet();
        List<Map.Entry<String, Integer>> sorted = set.stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).collect(Collectors.toList());
        for (Map.Entry<String, Integer> gg : sorted)
            System.out.println(gg.getKey() + " " + gg.getValue());
    }

    public static void ObjectsToJson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<User> users = new ArrayList<>();

        try (InputStream fis = new FileInputStream("src/main/resources/file.txt");
             Scanner scanner = new Scanner(fis)) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] splitedLine = line.split(" ");
                if (splitedLine[1].matches("[-+]?\\d+")) {
                    users.add(new User(splitedLine[0], Integer.parseInt(splitedLine[1])));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter fileWriter = new FileWriter("src/main/resources/users.json")) {
            gson.toJson(users, fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Task #1");
        validNumbers();
        System.out.println("\nTask #2");
        RepeatedWords();
        System.out.println("\nTask #3");
        RepeatedWords();
    }
}