import java.util.Random;
import java.util.Scanner;

public class guess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("=====================================");

        while (playAgain) {
            // Generate random number between 1 and 100
            int targetNumber = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 7;
            boolean hasWon = false;

            System.out.println("\nI'm thinking of a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it!");

            while (attempts < maxAttempts && !hasWon) {
                System.out.print("\nAttempt " + (attempts + 1) + "/" + maxAttempts + " - Enter your guess: ");

                try {
                    int guess = scanner.nextInt();
                    attempts++;

                    if (guess == targetNumber) {
                        hasWon = true;
                        System.out.println("🎉 Congratulations! You guessed it!");
                        System.out.println("The number was " + targetNumber);
                        System.out.println("You won in " + attempts + " attempts!");

                        // Calculate score based on attempts
                        int score = Math.max(0, (maxAttempts - attempts + 1) * 10);
                        System.out.println("Your score: " + score + " points");

                    } else if (guess < targetNumber) {
                        System.out.println("Too low! Try a higher number.");
                        if (attempts < maxAttempts) {
                            System.out.println("Attempts remaining: " + (maxAttempts - attempts));
                        }
                    } else {
                        System.out.println("Too high! Try a lower number.");
                        if (attempts < maxAttempts) {
                            System.out.println("Attempts remaining: " + (maxAttempts - attempts));
                        }
                    }

                } catch (Exception e) {
                    System.out.println("Please enter a valid number!");
                    scanner.nextLine(); // Clear the invalid input
                }
            }

            if (!hasWon) {
                System.out.println("\n💔 Game Over! You've used all your attempts.");
                System.out.println("The number was: " + targetNumber);
            }

            // Ask if player wants to play again
            System.out.print("\nWould you like to play again? (y/n): ");
            scanner.nextLine(); // Clear the buffer
            String response = scanner.nextLine().toLowerCase();

            if (!response.equals("y") && !response.equals("yes")) {
                playAgain = false;
                System.out.println("\nThanks for playing! Goodbye! 👋");
            }
        }

        scanner.close();
    }
}