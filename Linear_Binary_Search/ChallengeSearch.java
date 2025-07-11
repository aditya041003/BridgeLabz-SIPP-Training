import java.util.Arrays;

public class ChallengeSearch {
    public static int findFirstMissingPositive(int[] arr) {
        int n = arr.length;
        boolean[] present = new boolean[n + 1];
        for (int num : arr) {
            if (num > 0 && num <= n) {
                present[num] = true;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!present[i]) {
                return i;
            }
        }

        return n + 1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 1};
        System.out.println("First missing positive: " + findFirstMissingPositive(arr));

        Arrays.sort(arr);
        int target = 1;
        System.out.println("Index of " + target + ": " + binarySearch(arr, target));
    }
}