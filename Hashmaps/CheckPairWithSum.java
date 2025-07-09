import java.util.*;
public class CheckPairWithSum {
    public static void main(String[] args) {
        int[] arr = {8, 4, 1, 6};
        int target = 10;
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(target - num)) {
                System.out.println("Pair found: " + num + ", " + (target - num));
                return;
            }
            set.add(num);
        }
        System.out.println("No pair found.");
    }
}