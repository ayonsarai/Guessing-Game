//Programmer: Sarai
// Class: CS &145 virtual
// Date: 6/27/23
// Assignment: Lab 4 Guessing Game
/* Purpose: This assignment I will be working with while loops and pseudorandom numbers. 
I am writing a program that allows the user to play a simple guessing game in which the program 
thinks up an integer and allows the user to make guesses until the user gets it right. For each incorrect guess
it will tell the user whether the right answer is higher or lower. The program is required to exactly reproduce 
the format and behavior of the log of execution at the end of this write-up.
*/


import java.util.Scanner; 
import java.util.Random; // generates a random number for testing/demo, line 64

public class GuessingGame {

   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      
      String yesNo;
      int Guesses;
      int totalGuess = 0;
      int gameCount = 0;
      int bestGuess = 1000;
   
   // prompt
      instructions();
      System.out.println("Would you like to play a game? (yes/no): ");
      yesNo = input.next();
   
   // YES while loop - play game
      while (yesNo.equalsIgnoreCase("yes")) { 
         Guesses = playGame();
         if (Guesses < bestGuess) {
            bestGuess = Guesses;
         }  
         totalGuess = totalGuess + Guesses;
         gameCount++;
               
         System.out.println("Would you like to play again? (yes/no)");
         yesNo = input.next();
            
         if (yesNo.equalsIgnoreCase("yes")) { 
         } else {
            System.out.print("END GAME. Have a Great Day!");
            System.out.println();
         }
      }
     
      System.out.println();          
      results(gameCount, totalGuess, bestGuess);    
         
   }// end of main method 
   
    
 // play guessing game + counts++
   public static int playGame () {
   
      Scanner input = new Scanner(System.in);
      Random rand = new Random();
      int randomNumber = rand.nextInt(100) + 1;
      int playerGuess;
      int numGuess = 1;
      String yesNo;
   
   // start of game, loop if guess is too high, loop if guess is too low, break loop if guess is correct
   // displays how many tries it took to get the right answer
   
      //System.out.println("The Random Number is: " + randomNumber); //CHEAT
      System.out.println("I'm thinking of a number between 1 and 100");
      playerGuess = input.nextInt();
   
      while (playerGuess != randomNumber) {
         if (playerGuess > randomNumber) {
            System.out.println("Too High, try again"); 
            playerGuess = input.nextInt();
            numGuess++;
         } else {
            System.out.println("Too low, try again"); 
            playerGuess = input.nextInt();
            numGuess++;
         }
      } 
      System.out.println("Correct! Great Job"); 
      System.out.println("You guessed it in " + numGuess + " tries!"); 
      System.out.println();
      return numGuess;
   }
   
  // displays the results by collecting the return value of gameCount, totalGuess, bestGuess
   public static void results(int gameCount, int totalGuess, int bestGuess) {
      System.out.println("Overall Results: ");
      System.out.println("Total Games: " + gameCount);
      System.out.println("Total Guesses: " + totalGuess);
      System.out.println("Best Guess: " + bestGuess);
      System.out.println("Guesses / Game: " + (double) totalGuess / gameCount);
      return;
   }
   
    // introduction/prompt/instructions at the beginning of the game.
   public static void instructions() {
      System.out.println("This program allows you to play a guessing game.");
      System.out.println("I will think of a number between 1 and ");
      System.out.println("100 and will allow you to guess until ");
      System.out.println("you get it. For each guess, I will tell you ");
      System.out.println("whether the right answer is higher or lower ");
      System.out.println("than your guess. ");
      System.out.println(); 
      return;
   } 
   
   
 

}// end of class
