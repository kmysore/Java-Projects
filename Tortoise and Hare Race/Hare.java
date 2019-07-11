package race;

/**
 * This class represents a Hare that can participate in a race against the 
 * Tortoise. 
 * 
 * @author Karthik Mysore
 */

public class Hare 
{
   /**
    * This method returns a race board with 50 spaces and the hare starting
    * at the first space.
    * 
    * @return a race board with 50 spaces and hare at first space
    */
   
     
   public String [] getRace()
   {
      //Initialize array of type String and length 50
      String [] board = new String[50];
      int index;  //Initialize index iterator 
      
      //Loop through array board
      for(index = 0; index < board.length; index++)
      {
         //At each index, store "_" to represent the race board
         board[index] = "_";
      }
      
      //Place a 'H' to represent hare at the first postion
      board[0] = "H";
      
      return board;
      
   } //end getRace
   
   
   /**
    * This method returns the number of spaces to be moved based on a random 
    * number. This will simulate a Hare's movement according to the following
    * probabilities: 20% chance to move 9 spaces, 30% chance to move 1 space,
    * 10% chance to move back 12 spaces, 20% chance to move back 2 spaces, and 
    * 20% chance to not move.
    * 
    * @param randNum is a generated random number from 1 to 10.
    * @return the number of spaces to be moved.
    * 
    * precondition: randNum is of type integer. 
    * postcondition: the number of spaces to be moved by the Hare is returned.
    * 
    */
   
   public int getMove(int randNum)
   {
      //Initialize move variable
      int move = 0;
      
      //If randNum is less than or equal to 2
      if (randNum <= 2)
      {
         //Set move to 9
         move = 9;
      }
      //If randNum is between 3 and 5, inclusive
      else if (randNum >= 3 & randNum <= 5)
      {
         //Set move to 1
         move = 1;
      }
      //If randNum is equal to 6
      else if (randNum == 6)
      {
         //Set move to -12
         move = -12;
      }
      //If randNum is 7 or 8
      else if (randNum >= 7 & randNum <= 8)
      {
         //Set move to -2
         move = -2;
      }
      else
      {
         //Set move to 0
         move = 0;
      }
      
      return move;
      
   } //end getMove
   
   /**
    * This method prints the type of move made by Hare based on a randNum.
    * 
    * @param randNum is a generated random number between 1 and 10.
    * 
    * precondition: randNum is of type integer.
    * 
    */
   
   public void printMove(int randNum)
   {
      //Initialize move variable using getMove method
      int move = this.getMove(randNum);
      
      //Print type of move based on the following cases
      switch(move)
      {
         case 9: System.out.println("Hare move: Big Hop"); break;
         case 1: System.out.println("Hare move: Small Hop"); break;
         case -12: System.out.println("Hare move: Big Slip"); break;
         case -2: System.out.println("Hare move: Small slip"); break;
         case 0: System.out.println("Hare move: Fall asleep"); break;
      }
      
   } //end printMove
   
   /**
    * This method returns the position of the Hare in a given race board.
    * 
    * @param board is the race board containing Hare
    * @return the position of Hare on the race board
    * 
    * precondition: board is an array of type String.
    * precondition: board contains 'H' for Hare.
    * precondition: index 0 is the first position.
    * postcondition: the index of hare in the board is returned.
    * 
    */
   
   public int getPosition(String [] board)
   {
      //Initialize position and index iterator variable
      int position = 0;
      int index;
      
      //Iterate through the board
      for (index = 0; index < board.length; index++)
      {
         //When the value at current index is 'H'
         if (board[index].equals("H"))
         {
            //Set position to index
            position = index;
         }
      }
      return position;
      
   } //end getPosition

   
   /**
    * This method moves the hare on the race board.
    * 
    * @param board is the race board containing Hare.
    * @param randNum is a generated random number from 1 to 10.
    * 
    * precondition: board is an array of type String.
    * precondition: board contains 'H' for Hare.
    * precondition: randNum is type integer.
    * postcondition: Hare new position is set on board.
    */
   
   public void setNewPosition(String [] board, int randNum)
   {
      //Initialize variables
      int currentPosition = this.getPosition(board);  //store hare current position
      int move = this.getMove(randNum);   //store hare current move
     
      //Calculate new position by adding move to current position
      int newPosition = currentPosition + move;
      
      //Replace current Hare position with empty board space
      board[currentPosition] = "_";
      
      //If new position is less than 0, set Hare position to the first index
      if (newPosition < 0)
      {
         board[0] = "H";
      }
      
      //If new position is greater than or equal to board length
      else if (newPosition >= board.length)
      {
         //Set Hare position to last index of board
         board[board.length - 1] = "H";  
      }
      else
      {
         //Set Hare position to new position
         board[newPosition] = "H";
      }

   } //end setNewPosition
   
} //end Hare
