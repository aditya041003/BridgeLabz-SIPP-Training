import java.util.*;

public class Q13_VoterEligibility {

    static int[] generateRandomAges(int n) {
        Random rand = new Random();
        int[] ages = new int[n];
        for (int i = 0; i < n; i++) {
            ages[i] = rand.nextInt(90);
        }
        return ages;
    }

    static String[][] checkVotingEligibility(int[] ages) {
        String[][] result = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            result[i][0] = String.valueOf(ages[i]);
            if (ages[i] >= 18) {
                result[i][1] = "true";
            } else {
                result[i][1] = "false";
            }
        }
        return result;
    }

    static void display2D(String[][] data) {
        System.out.println("Age	Can Vote?");
        for (String[] row : data) {
            System.out.println(row[0] + "	" + row[1]);
        }
    }

    public static void main(String[] args) {
        int[] ages = generateRandomAges(10);
        String[][] result = checkVotingEligibility(ages);
        display2D(result);
    }
}