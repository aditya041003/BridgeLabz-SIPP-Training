public class CountingSortStudentAges {
    public static void main(String[] args) {
        int[] ages = {12, 14, 11, 12, 15, 14, 13, 10, 11, 18};
        int maxAge = 18;
        int minAge = 10;

        int[] count = new int[maxAge - minAge + 1];
        for (int age : ages) {
            count[age - minAge]++;
        }

        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i]-- > 0) {
                ages[index++] = i + minAge;
            }
        }

        System.out.println("Sorted Ages:");
        for (int age : ages) {
            System.out.print(age + " ");
        }
    }
}