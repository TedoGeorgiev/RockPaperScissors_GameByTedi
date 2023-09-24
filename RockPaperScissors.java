
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    private static final String ROCK = "Rock";
    private static final String PAPER = "Paper";
    private static final String SCISSORS = "Scissors";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int wins = 0;
        int loses = 0;
        int draws = 0;
        boolean isValid = true;

        System.out.println("Choose [r]ock, [p]aper, [s]cissors or [E]nds the game");
        String playerMove = scanner.nextLine();

        while (!"E".equalsIgnoreCase(playerMove)) {


            if (playerMove.equals("r") || playerMove.equals("rock")) {
                playerMove = ROCK;
            } else if (playerMove.equals("p") || playerMove.equals("paper")) {
                playerMove = PAPER;
            } else if (playerMove.equals("s") || playerMove.equals("scissors")) {
                playerMove = SCISSORS;
            } else {
                isValid = false;
                System.out.println("Invalid input. Try again...");
            }


            Random random = new Random();
            int computerRandomNumber = random.nextInt(3);
            String computerMove = "";

            switch (computerRandomNumber) {
                case 0:
                    computerMove = "Rock";
                    break;
                case 1:
                    computerMove = "Paper";
                    break;
                case 2:
                    computerMove = "Scissors";
                    break;
            }
            System.out.printf("The computer choose %s.%n", computerMove);

            if ((playerMove.equals(ROCK) && computerMove.equals(SCISSORS)) ||
                    (playerMove.equals(PAPER) && computerMove.equals(ROCK)) ||
                    (playerMove.equals(SCISSORS) && computerMove.equals(PAPER))) {
                ++wins;
                System.out.println("You win.");
            } else if ((computerMove.equals(ROCK) && playerMove.equals(SCISSORS)) ||
                    (computerMove.equals(PAPER) && playerMove.equals(ROCK)) ||
                    (computerMove.equals(SCISSORS) && playerMove.equals(PAPER))) {
                ++loses;
                System.out.println("You lose.");
            } else {
                ++draws;
                System.out.println("This game was a draw.");
            }
            System.out.println("Choose [r]ock, [p]aper, [s]cissors or [E]nds the game");
            playerMove = scanner.nextLine();
        }
        System.out.printf("Game Ends with the following result:%n");
        System.out.printf("WINS: %d%n", wins);
        System.out.printf("LOSES: %d%n", loses);
        System.out.printf("DRAWS: %d%n", draws);
        if (wins > loses) {
            System.out.println("You are FINAL Winner!");
        } else if (loses > wins) {
            System.out.println("Computer is FINAL Winner!");
        } else {
            System.out.println("No FINAL Winner - game is a DRAW");
        }

    }
}
