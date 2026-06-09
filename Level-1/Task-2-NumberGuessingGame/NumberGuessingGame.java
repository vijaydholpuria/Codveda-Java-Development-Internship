import java.util.Random;
import java.util.Scanner;

class GuessingGame {

    private final Scanner sc = new Scanner(System.in);

    public void startGame() {

        boolean playAgain = true;

        while (playAgain) {

            Random random = new Random();
            int secretNumber = random.nextInt(20) + 1;

            int maxAttempts = 7;
            int attempts = 0;
            boolean guessed = false;

            System.out.println("\n===== NUMBER GUESSING GAME =====");
            System.out.println("Guess a number between 1 and 20");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {

                System.out.print("\nEnter your guess: ");

                if (!sc.hasNextInt()) {
                    System.out.println("Invalid input! Please enter a valid number.");
                    sc.next();
                    continue;
                }

                int guess = sc.nextInt();
                attempts++;

                if (guess == secretNumber) {
                    System.out.println("\nCongratulations! You guessed the number.");
                    System.out.println("Attempts used: " + attempts);
                    guessed = true;
                    break;
                } else if (guess > secretNumber) {
                    System.out.println("Too High!");
                } else {
                    System.out.println("Too Low!");
                }

                System.out.println("Remaining Attempts: " + (maxAttempts - attempts));
            }

            if (!guessed) {
                System.out.println("\nGame Over!");
                System.out.println("The correct number was: " + secretNumber);
            }

            while (true) {

                System.out.println("\n===== MENU =====");
                System.out.println("1. Play Again");
                System.out.println("2. Exit");
                System.out.print("Enter your choice: ");

                if (!sc.hasNextInt()) {
                    System.out.println("Invalid input! Please enter 1 or 2.");
                    sc.next();
                    continue;
                }

                int choice = sc.nextInt();

                if (choice == 1) {
                    break;
                } else if (choice == 2) {
                    playAgain = false;
                    System.out.println("\nThank you for playing!");
                    break;
                } else {
                    System.out.println("Invalid choice! Please enter 1 or 2.");
                }
            }
        }
    }
}

public class NumberGuessingGame {

    public static void main(String[] args) {

        GuessingGame game = new GuessingGame();
        game.startGame();
    }
}