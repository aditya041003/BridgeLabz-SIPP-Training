import java.util.*;

public class Q16_RockPaperScissors {

    static String getComputerChoice() {
        String[] choices = {"rock", "paper", "scissors"};
        return choices[new Random().nextInt(3)];
    }

    static String getResult(String user, String computer) {
        if (user.equals(computer)) return "Draw";
        if ((user.equals("rock") && computer.equals("scissors")) ||
            (user.equals("paper") && computer.equals("rock")) ||
            (user.equals("scissors") && computer.equals("paper")))
            return "User";
        return "Computer";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of games: ");
        int n = sc.nextInt();
        int userWins = 0, compWins = 0, draws = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter your choice (rock/paper/scissors): ");
            String user = sc.next().toLowerCase();
            String computer = getComputerChoice();
            String winner = getResult(user, computer);

            if (winner.equals("User")) userWins++;
            else if (winner.equals("Computer")) compWins++;
            else draws++;

            System.out.println("Computer chose: " + computer + " => " + winner + " wins this round.");
        }

        System.out.println("User Wins: " + userWins + ", Computer Wins: " + compWins + ", Draws: " + draws);
        System.out.println("User Win %: " + (userWins * 100.0 / n) + "%, Computer Win %: " + (compWins * 100.0 / n) + "%");
        sc.close();
    }
}