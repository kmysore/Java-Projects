package calendar;

/**
 * This program is intended to print out a calendar of a single month or single
 * year based on the user's preferences. 
 * 
 * @author Karthik Mysore
 */

import java.util.Scanner;

public class Calendar {

   /**
    * This main method prints either a month calendar or year calendar based on
    * the user input.
    * 
    */
   public static void main(String[] args) 
   {
      // Initialize variables
      int month;  // store user input for month number
      int year;   // store user input for year
      int userChoice;   // store user choice for either Month or Year calendar
      
      // Create new Calendar
      Calendar myCal = new Calendar();
      
      // Create new Scanner for user input
      Scanner input = new Scanner(System.in);
      
      // Allow user to choose between month and year calendar
      System.out.print("Please enter 1 (Month Calendar) or 2 (Year Calendar): ");
      userChoice = input.nextInt();
      
      // If userChoice is 1, print Month Calendar
      if (userChoice == 1)
      {
         // Read user input for month and year 
         System.out.print("Please enter the month (1-12): ");
         month = input.nextInt();  
         System.out.print("Please enter the year: ");
         year = input.nextInt();
         System.out.println();
         
         // Print month calendar
         myCal.printMonthCalendar(month, year);
      }
      
      // If userChoice is 2, print Year Calendar
      else if (userChoice == 2)
      {
         // Read user input for year
         System.out.print("Please enter the year: ");
         year = input.nextInt();
         System.out.println();
         
         // Print year calendar
         myCal.printYearCalendar(year);
      }
      
      // End program if incorrect choice is entered
      else
      {
         System.out.println("Incorrect choice entered. End program!");
      }
 
   } // end main()
   
   /**
    * This method prints a Year Calendar for a given year, including the month
    * headers and month bodies.
    * 
    * @param y is the year
    * 
    * precondition: y is integer type.
    * postcondition: Prints a 12 month calendar for a given year.
    * 
    */
   
   private void printYearCalendar( int y )
   {
      int month;   // Initalize month iterator variable
      
      // Loop through months
      for (month = 1; month <= 12; month++)
      {
         // Print month calendar for given year
         printMonthCalendar(month, y);
      }
 
   } // end printYearCalendar
   
   /**
    * This method prints the month calendar for a given month and year, including
    * the month header and month body.
    * 
    * @param m is the month number
    * @param y is the year
    * 
    * precondition: m and y are integer types.
    * precondition: m is a month number between 1 and 12, inclusive.
    * postcondition: Print the month header and month body.
    * 
    */
   
   private void printMonthCalendar( int m, int y)
   {
      // Print the month header
      printMonthHeader(m, y);
      
      // Print the month body
      printMonthBody(m, y);
      System.out.println();
      
   } // end printMonthCalendar
   
   /**
    * This method prints out a header that includes the month name and year, 
    * followed by the days of the week.
    * 
    * @param m is the month number
    * @param y is the year
    * 
    * precondition: m and y are integer types.
    * precondition: m is between 1 and 12, inclusive.
    * 
    */
   
   private void printMonthHeader( int m, int y)
   {
      // Print out month name and year
      System.out.println("         " + getMonthName(m) + " " + y);
      System.out.println("-----------------------------");
      
      // Print out days of the week
      System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
      
   } // end printMonthHeader
   
   /**
    * This method prints out the individual dates for a given month and year,
    * making sure to assign the dates to the correct day of the week.
    * 
    * @param m is the month number
    * @param y is the year
    * 
    * precondition: m and y are integer types.
    * precondition: m is between 1 and 12, inclusive.
    * postcondition: The month body is printed for a given month a year.
    * 
    */
   
   private void printMonthBody( int m, int y)
   {
      // Initialize variables
      int numDays = getNumDaysInMonth(m, y); // numDays stores # of days
      int day;   // initialize day iterator variable
      int date; // intialize date iterator variable
      
      // startDay stores the start day of the month for a given year.
      // Set the day argument in getStartDay to 1 for the first day.
      // For day argument in getStartDay (1=Monday, ..., 7=Sunday)
      int startDay = getStartDay(m, y, 1);
      
      // Check to see which day startDay is and adjust spacing accordingly
      if (startDay == 7)   // No spaces if startDay is 7 or Sunday
      {
         System.out.print("");
      }
      else
      {
         // Determine # of spaces before startDay
         // Loop through days before startDay and end loop before startDay
         for (day = 0; day < startDay; day++) 
         {
            // Print in 4 space increments up to the startDay
            System.out.print("    ");
         }
      }
      
      // Print the date according to its assigned day. Loop through numDays.
      // Loop ends when the last date is printed
      for (date = 1; date <= numDays; date++)   
      {
         // When date is single digit, use three spaces
         if (date < 10)
         {
            // Print spaces and date
            System.out.print("   " + date);
         }
         // When date is double digit, use two spaces
         else
         {
            // Print spaces and date
            System.out.print("  " + date);
         }
         
         // When date is a Saturday and not the last date in month, start new line.
         // When (date + startDay) is divisible by 7, date is a Saturday.
         if ((date + startDay) % 7 == 0 & date != numDays)
         {
            System.out.println();
         }
      
      }
      
      // Print new line for aesthetics
      System.out.println();
     
   } // end printMonthBody
   
   /**
    * This method converts the month number to month name and returns the month
    * name.
    * 
    * @param m is the month number.
    * @return the month name.
    * 
    * precondition: m is of type integer and should be between 1 and 12, inclusive.
    * postcondition: The month name as type String is returned. 
    * 
    */
   
   private String getMonthName( int m )
   {
      // Initialize month as empty string
      String monthName = "";
      
      // Convert month number to month name
      switch(m)
      {
         case 1: monthName = "January"; break;
         case 2: monthName = "February"; break;
         case 3: monthName = "March"; break;
         case 4: monthName = "April"; break;
         case 5: monthName = "May"; break;
         case 6: monthName = "June"; break;
         case 7: monthName = "July"; break;
         case 8: monthName = "August"; break;
         case 9: monthName = "September"; break;
         case 10: monthName = "October"; break;
         case 11: monthName = "November"; break;
         case 12: monthName = "December"; break;
      } // end switch (m)
      
      return monthName;
      
   } // end getMonthName
   
 /** 
  * The method getStartDay() implements Zeller's Algorithm for determining the
  * day of the week the first day of a month is. The method adjusts Zeller's
  * numbering scheme for day of week ( 0=Saturday, ..., 6=Friday ) to conform to
  * a day of week number that corresponds to ISO conventions (i.e., 1=Monday,
  * ..., 7=Sunday)
  *
  * Pre-Conditions: The month value, m, is 1-12 The day value, d, is 1-31, or
  * 1-28, 1-29 for February The year value, y, is the full year (e.g., 2012)
  *
  * Post-Conditions: A value of 1-7 is returned, representing the first day of
  * the month 1 = Monday, ..., 7 = Sunday
  * 
  * This code was provided by John's Hopkins University for the class
  * EN.605.201.83.SU19 under Prof. Doug Ferguson
  * 
  */
 
   private int getStartDay(int month, int year, int day)
   {

      if (month < 3) // Adjust month number & year to fit Zeller's numbering system
      {
         month += 12;
         year -= 1;
      }

      int centuryYear = year % 100;    // Calculate year within century
      int centuryTerm = year / 100;    // Calculate century term
      int firstDayinMonth = 0;         // Day number of first day in month 'm'

      firstDayinMonth = (day + (13 * (month + 1) / 5) + centuryYear + (centuryYear / 4) + (centuryTerm / 4) + (5 * centuryTerm)) % 7;

      // Convert Zeller's value to ISO value (1 = Mon, ... , 7 = Sun )
      int dayNum = ((firstDayinMonth + 5) % 7) + 1;

      return dayNum;
      
   } // end getStartDay
   
   /**
    * This method returns a boolean True if the year is a Leap Year or False if
    * not. In the Gregorian calendar, there are two criteria that are used to
    * identify Leap Years:
    * 1. The year can be evenly divided by 4.
    * 2. If the year is divisible by 100, it is a Leap Year if and only if the 
    * year is also divisible by 400.
    * 
    * @param y is the year
    * @return True if y is a Leap Year or False if the y is not a Leap Year
    * 
    * precondition: y is an integer type
    * postcondition: Return a boolean true or false depending if y is a Leap Year.
    * 
    */

   private boolean isLeapYear( int y )
   {
      // Determine if y is a Leap Year based on the criteria
      if (y % 400 == 0 || (y % 4 == 0 && y % 100 != 0))
      {
         return true;
      }
      else
      {
         return false;
      }
   } // end isLeapYear
   
   /**
    * This method returns the number of days in a given month and year.
    * 
    * @param m is the month number
    * @param y is the year
    * @return the number of days in a given month and year, which accounts for 
    * leap years
    * 
    * precondition: m and y are integer types
    * precondition: m is between 1 and 12, inclusive
    * postcondition: The number of days in a month is returned
    * 
    */

   private int getNumDaysInMonth( int m, int y )
   {
      // Initialize variables
      int numDays;   // numDays will store the # of days in the month
      boolean leapYear = isLeapYear(y);   // leapYear will check if y is a Leap Year
      
      // Determine # of days in month
      if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12)
      {
         numDays = 31;
      }
      // When m is 2, check whether y is a Leap Year and set numDays accordingly
      else if (m == 2)
      {
         if (leapYear)
         {
            numDays = 29;
         }
         else
         {
            numDays = 28;
         }
      }
      else
      {
         numDays = 30;
      }
      
      return numDays;
   } // end getNumDaysInMonth
   
   
} // end Calendar
