// Name: Dylan Wilson
// Class: CS 145
// Lab: 1

import java.security.SecureRandom;
import java.util.Scanner;

public class Guessing {
    // main method begins
    public static void main (String[]args) {

        Scanner console = new Scanner(System.in);
        SecureRandom rando = new SecureRandom();

        int numberOfTries; // number of tries
        int sum = 0;
        int ans = 1;
        int gameCount = 0;
        int bestGame = 1000;

        introduction();

        while (ans == 1) {
            numberOfTries = game(rando, console);
            if (numberOfTries < bestGame) {
                bestGame = numberOfTries;
            }
            sum += numberOfTries;
            gameCount++;

            System.out.printf("Do you want to play again? ");
            String answer = console.next();
            if (answer.startsWith("Y") || answer.startsWith("y")) {
                ans = 1;
            } else {
                ans = 0;
            }
            report(gameCount, sum, bestGame);

        }

    } // end main method

    // intro method
    public static void introduction() {
        System.out.println("Guessing Game");
        System.out.println("I'm thinking of a number between 1 and 100...");
        System.out.println("Let's see how many guesses it takes you to guess my number.");
        System.out.println("I will tell you if your guess is lower or higher than my number");

    } // end intro

    // game method
    public static int game(SecureRandom rando, Scanner console) {
        int magicNumber = 1 + rando.nextInt(100);
        int numOfTries = 0;
        int userGuess;

        do {
            System.out.print("Enter your guess: ");
            userGuess = console.nextInt();
            numOfTries++;

            if (userGuess < magicNumber) {
                System.out.println("Too low, try again.");
            } else {
                System.out.println("Too high, try again.");
            }
        } while (userGuess != magicNumber);

        if (numOfTries == 1) {
            System.out.println("You guessed right in 1 guess");
        } else {
            System.out.println("You guessed correctly in " + numOfTries);
        }
        return numOfTries;
    }  // end game method

    // report method
    private static void report(int gameCount, int sum, int bestGame) {
        System.out.println();
        System.out.println("Overall results:");
        System.out.println("Total games played: " + gameCount);
        System.out.println("Total guesses made: " + sum);
        System.out.printf("Average guesses per game: %.1f", (double) sum / gameCount);
        System.out.println();
        System.out.println("Best game: " + bestGame + " guesses");
    } // end report method

} // end public class
