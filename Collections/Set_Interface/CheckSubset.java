import java.util.*;

public class CheckSubset {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3, 4));

        System.out.println("Is set1 a subset of set2? " + set2.containsAll(set1));
    }
}