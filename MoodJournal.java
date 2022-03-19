import java.util.Objects;
import java.util.Scanner;

public class MoodJournal {

    public static void printMenu(){
        System.out.println("""
                =================================================================================================================================================================================
                Hello! Welcome to your daily mood journal! Let's reflect on how you feel today, please select which option
                you would like to use by typing the digit 1-5 in the terminal, or x to exit:
                
                Manage entries:
                    1) Add a new journal entry
                    2) View all journal entries for a specific month
                    3) View all journal entries
                                
                Entry statistics:
                    4) View top three most logged emotions
                    5) View average mood rating
                    
                x) Exit mood journal
                =================================================================================================================================================================================
                """);
    }

    public static void main(String[] args) {
        // Print menu for user
        printMenu();

        // Get selection from user
        Scanner userIn = new Scanner(System.in);
        String userSelection = userIn.nextLine();

        while (!(userSelection.equals("x"))) {

            if (userSelection.equals("1")){

            }
            else if (userSelection.equals("2")){

            }
            else if (userSelection.equals("3")){

            }
            else if (userSelection.equals("4")){

            }
            else if (userSelection.equals("5")){

            }
            // Print menu for user
            printMenu();
            // Get new input selection from user
            userSelection = userIn.nextLine();
        }

        // Once user has requested exit, print goodbye message
        System.out.println("Thank-you for taking some time for yourself today, see you soon!");
    }
}
