package race;

/**
 * This class represents a Tortoise that can participate in a race against the 
 * hare.
 * 
 * @author Karthik Mysore
 * 
 */
public class Tortoise 
{
   /**
    * This method returns a race board with 50 spaces and the tortoise starting
    * at the first space.
    * 
    * @return a race board with 50 spaces and tortoise at first space
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
      
      //Place a 'T' to represent tortoise at the first postion
      board[0] = "T";
      
      return board;
      
   } //end getRace
   
   
   /**
    * This method returns the number of spaces to be moved based on a random 
    * number. This will simulate a Tortoise's movement according to the following
    * probabilities: 50% chance to move 3 spaces, 30% chance to move 1 space, and
    * 20% chance to move back 6 spaces.
    * 
    * @param randNum is a generated random number from 1 to 10.
    * @return the number of spaces to be moved.
    * 
    * precondition: randNum is of type integer. 
    * postcondition: the number of spaces to be moved by the Tortoise is returned.
    * 
    */
   
   public int getMove(int randNum)
   {
      //Initialize move variable
      int move = 0;

      //If randNum is between 1 and 5, inclusive
      if (randNum >= 1 & randNum <=5)
      {
         //Set move to 3
         move = 3;
      }
      //If randNum is between 6 and 8, inclusive
      else if (randNum >= 6 & randNum <= 8)
      {
         //Set move to 1
         move = 1;
      }
      //Else if randNum is greater than 8
      else
      {
         //Set move to -6
         move = -6;
      }
      
      return move;
      
   } //end getMove
   
   
   /**
    * This method prints the type of move made by Tortoise based on a randNum.
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
      
      //Print the type of move
      switch(move)
      {
         case 3: System.out.println("Tortoise move: Fast Plod"); break;
         case 1: System.out.println("Tortoise move: Slow plod"); break;
         case -6: System.out.println("Tortoise move: Slip"); break;
      }
      
   } //end printMove
   
   /**
    * This method returns the index of the Tortoise in a given race board.
    * 
    * @param board is the race board containing Tortoise
    * @return the position of Tortoise on the race board
    * 
    * precondition: board is an array of type String.
    * precondition: board contains 'T' for Tortoise.
    * precondition: index 0 is the first position.
    * postcondition: the index of tortoise in the board is returned.
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
         //When the value at current index is 'T'
         if (board[index].equals("T"))
         {
            //Set position to index
            position = index;
         }
      }
      return position;
      
   } //end getPosition
   
   /**
    * This method moves the tortoise on the race board.
    * 
    * @param board is the race board containing Tortoise.
    * @param randNum is a generated random number from 1 to 10.
    * 
    * precondition: board is an array of type String.
    * precondition: board contains 'T' for Tortoise.
    * precondition: randNum is type integer.
    * postcondition: Tortoise new position is set on board.
    */
   
   public void setNewPosition(String [] board, int randNum)
   {
      //Initialize variables
      int currentPosition = this.getPosition(board);  //store tortoise current position
      int move = this.getMove(randNum);   //store Tortoise current move
     
      //Calculate new position by adding move to current position
      int newPosition = currentPosition + move;
      
      //Replace current Tortoise position with empty board space
      board[currentPosition] = "_";
      
      //If new position is less than 0, set Tortoise position to the first index
      if (newPosition < 0)
      {
         board[0] = "T";
      }
      
      //If new position is greater than or equal to board length
      else if (newPosition >= board.length)
      {
         //Set Tortoise position to last index of board
         board[board.length - 1] = "T";  
      }
      else
      {
         //Set Tortoise position to new position
         board[newPosition] = "T";
      }
       
      
   } //end setNewPosition
   
   
} //end Tortoise
