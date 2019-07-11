package race;

import java.util.Scanner;


/**
 * This program is designed to simulate the famous race between a Tortoise and
 * Hare. 
 * 
 * @author Karthik Mysore
 * 
 */

public class Race {

   /**
    * Program entry point.
    * @param args the command line arguments
    * 
    */
   
   public static void main(String[] args) {
      
      //Initialize random variables for tortoise and hare
      int randNumTort;
      int randNumHare;
      
      //Create Tortoise, Hare, and Race objects
      Tortoise tort = new Tortoise();
      Hare hare = new Hare();
      Race race = new Race();
      
      //Create scanner for user input
      Scanner input = new Scanner(System.in);
      
      //Print race header and intial starting positions of the race
      race.printHeader();
      String [] boardTort = tort.getRace();  //Create race board for Tortoise
      String [] boardHare = hare.getRace();  //Create race board for Hare
      race.printBoard(boardTort, boardHare); //Print the initial race board
      System.out.println("\nPress ENTER to continue!");  //Allow user to press ENTER to continue
      input.nextLine();
      
      //While there is no winner, continue to loop through race board
      while (!race.isWinner(boardTort, boardHare))
      {
         //Generate random number for tortoise from 1 to 10 
         randNumTort = (int) (10 * Math.random()) + 1;
         //Set the tortoise position based on random number generated
         tort.setNewPosition(boardTort, randNumTort);
         
         //Generate random number for hare from 1 to 10
         randNumHare = (int) (10 * Math.random()) + 1;
         //Set the hare positon based on the random number generated
         hare.setNewPosition(boardHare, randNumHare);  
         
         //Print the updated race board
         race.printBoard(boardTort, boardHare);
         System.out.println();
         
         //Print the race feedback, and types of moves by Tortoise and Hare
         race.printFeedback(boardTort, boardHare);
         tort.printMove(randNumTort);
         hare.printMove(randNumHare);
         
         //Allow user to continue the race until winner is determined
         System.out.println("\nPress ENTER to continue!");
         
         input.nextLine();
         

      }
      //Print winner of race
      race.printWinner(boardTort, boardHare);

      
   } //end main()
   

   /**
    * This method will return a boolean when either Tortoise or Hare reaches the
    * end of the race. It will be used as a condition to loop through the race,
    * until a winner is determined.
    * 
    * @param boardTort is the race board containing Tortoise
    * @param boardHare is the race board containing Hare
    * @return true when either Tortoise or Hare or both reaches the end of race
    * 
    * precondition: boardTort is array of type string that contains Tortoise.
    * precondition: boardHare is array of type string that contains Hare.
    * 
    */
   
   public boolean isWinner(String [] boardTort, String [] boardHare)
   {
      //If last position of boardTort contains 'T' or last position of boardHare contains 'H'
      if (boardTort[boardTort.length - 1].equals("T") || boardHare[boardHare.length - 1].equals("H"))
      {  
         //Return True
         return true;
      }
      else
      {
         //Return false
         return false;
      }
      
   } //End isWinner
   
   /**
    * This method will print the winner of the race; the one that reaches the 
    * last position first. If both tortoise and hare reach the last position on 
    * the final turn, a 'Tie' will be printed.
    * 
    * @param boardTort is the race board containing the Tortoise
    * @param boardHare is the race board containing the Hare
    * 
    * precondition: boardTort is array of type string that contains Tortoise.
    * precondition: boardHare is array of type string that contains Hare.
    * 
    */
   
   public void printWinner(String [] boardTort, String [] boardHare)
   {
      //When both the tortoise and hare reach the final position of their respective board
      if (boardTort[boardTort.length - 1].equals("T") & boardHare[boardHare.length - 1].equals("H"))
      {
         //Print a 'Tie'
         System.out.println("IT'S A TIE!");
      }
      else if(boardHare[boardHare.length - 1].equals("H"))
      {
         //Print Hare wins if only Hare reaches end
         System.out.println("HARE WINS!");
      }
      else
      {
         //Print 'Tortoise Wins' if only tortoise reaches end
         System.out.println("TORTOISE WINS!");
      }
   }
   
   /**
    * This method will print a race feedback after each turn of the race. The
    * feedback will contain information regarding which character is in the lead
    * and by how many spaces.
    * 
    * @param boardTort is a race board that contains Tortoise
    * @param boardHare is a race board that contains Hare
    * 
    * precondition: boardTort is array of type string that contains Tortoise.
    * precondition: boardHare is array of type string that contains Hare.
    * 
    */
   
   public void printFeedback(String [] boardTort, String [] boardHare)
   {
      //Create Tortoise and Hare object
      Tortoise tort = new Tortoise();
      Hare hare = new Hare();
      
      //Initialize variables
      int diff = 0;     //Variable will store the difference in spaces betweeen Tortoise and Hare
      int posTort = tort.getPosition(boardTort);   //Store current position of Tortoise
      int posHare = hare.getPosition(boardHare);   //Store current position of Hare
      
      //Print Feedback
      System.out.print("Feedback: ");
      
      //If Tortoise and Hare share the same position
      if (posTort == posHare)
      {
         //Tortoise bites Hare, print the following
         System.out.print("OUCH! Tortoise bites Hare!");
      }
      else if (posTort > posHare)
      {
         //If Tortoise leads Hare
         diff = posTort - posHare;  //Calculate the lead for Tortoise
         //Print Tortoise is in the lead
         System.out.print("Tortoise is in the lead by " + diff + " spaces");
      }
      else
      {
         //If Hare leads Tortoise
         diff = posHare - posTort;  //Calculate lead for Hare
         //Print Hare is in the lead
         System.out.print("Hare is in the lead by " + diff + " spaces");
      }
      
      
      System.out.println();
      
   } //End printFeedback
   
   
   /**
    * This method will print the race header. The header will provide an 
    * introduction for the race and set up the two main characters for the race. 
    * 
    */
   
   public void printHeader()
   {
      //Initialize iteratro variable
      int index = 0;
      
      //Print title of the race
      System.out.println("\t\t\t\t\t Tortoise and Hare Race");
      
      //Underline the title
      while (index <= 100)
      {
         System.out.print("-");
         index++;
      }
      //Print race introduction
      System.out.println("\nWelcome to the race of the century! It's the mighty Hare "
              + "versus the steady Tortoise. Below is the format\nof the race. "
              + "Both competitors will line up at the starting space and the first "
              + "one to reach the final\nspace will be crowned winner. "
              + "Who will win?\nReady, Set, Go!!!!!\n");
      
   } //End printHeader
   
   /**
    * This method will print the Tortoise and Hare race boards. 
    * 
    * @param boardTort is a race board containing Tortoise
    * @param boardHare is a race board containing Hare
    * 
    * precondition: boardTort is array of type string that contains Tortoise.
    * precondition: boardHare is array of type string that contains Hare.
    * 
    */
   
   public void printBoard(String [] boardTort, String [] boardHare)
   {
      //Initialize iterator variables for boardTort and boardHare
      int indexTort;
      int indexHare;
      
      //Iterate through boardTort
      for (indexTort = 0; indexTort < boardTort.length; indexTort++)
      {
         //Print boardTort
         System.out.print(boardTort[indexTort] + " ");
      }
      
      System.out.println();
      
      //Iterate through boardHare
      for (indexHare = 0; indexHare < boardHare.length; indexHare++)
      {
         //Print boardHare
         System.out.print(boardHare[indexHare] + " ");
      }
      
      System.out.println();
      
   } //end printBoard

}  //end Race
   
 
   

