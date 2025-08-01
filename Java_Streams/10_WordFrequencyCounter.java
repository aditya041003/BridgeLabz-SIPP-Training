import java.io.*;
import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        Map<String, Integer> frequencyMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("textfile.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase().split("\W+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        frequencyMap.entrySet().stream()
            .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
            .limit(5)
            .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}