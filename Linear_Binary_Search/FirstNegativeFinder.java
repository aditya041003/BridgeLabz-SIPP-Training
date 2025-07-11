public class FirstNegativeFinder {
    public static int findFirstNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] numbers = {4, 7, -3, 9, 0};
        System.out.println("First negative number is at index: " + findFirstNegative(numbers));
    }
}