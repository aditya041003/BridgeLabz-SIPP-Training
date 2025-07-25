import java.util.*;

public class NthFromEnd {
    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        Iterator<T> main = list.iterator();
        Iterator<T> ref = list.iterator();

        for (int i = 0; i < n; i++) {
            if (ref.hasNext()) ref.next();
            else return null;
        }

        while (ref.hasNext()) {
            main.next();
            ref.next();
        }

        return main.next();
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        int n = 2;
        System.out.println("Nth element from end: " + findNthFromEnd(list, n));
    }
}