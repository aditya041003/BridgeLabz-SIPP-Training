import java.util.*;

public class RotateList {
    public static void rotate(List<Integer> list, int k) {
        int n = list.size();
        k = k % n;
        List<Integer> rotated = new ArrayList<>(list.subList(k, n));
        rotated.addAll(list.subList(0, k));
        list.clear();
        list.addAll(rotated);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        rotate(list, 2);
        System.out.println("Rotated List: " + list);
    }
}