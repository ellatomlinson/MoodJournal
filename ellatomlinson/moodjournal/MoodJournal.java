package ellatomlinson.moodjournal;
import java.util.HashMap;
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

    public static void newEntry( HashMap<String, JournalEntry> moodEntries){
        Scanner entry = new Scanner(System.in);

        // Get journal input from user
        System.out.println("How would you rate your mood today on a scale from 1 to 10?");
        int moodRating = Integer.parseInt(entry.nextLine());

        System.out.println("What emotions were prevalent for you today? E.g excited, nervous, angry etc. Enter emotions" +
                "as comma separated values.");
        String allEmotions = entry.nextLine();
        // Separate input into an array by commas, strip trailing whitespace
        String[] emotionsUnstripped = allEmotions.split(",");
        String[] emotions = new String[emotionsUnstripped.length];
        for (int i = 0; i < emotionsUnstripped.length; i++) {
            String currentItem = emotionsUnstripped[i];
            emotions[i] = currentItem.strip();
        }

        System.out.println("Write a journal entry about how your day went, you can write anything you would like, it doesn't" +
                "have to be good, this journal is for you!");
        String journal = entry.nextLine();

        // Get date
        System.out.println("Great job! Finally, enter the current date in the format YYYY/MM/DD.");
        String date = entry.nextLine();

        // Create new journal entry using information
        JournalEntry newEntry = new JournalEntry(moodRating, emotions, journal);

        // Add entry to mood journal entries hashmap with the date as the key and entry as value
        moodEntries.put(date, newEntry);
    }

    public static void main(String[] args) {
        // Create hashmap for all mood journal entries
        HashMap<String, JournalEntry> moodEntries = new HashMap<>();

        // Print menu for user
        printMenu();

        // Get selection from user
        Scanner userIn = new Scanner(System.in);
        String userSelection = userIn.nextLine();

        while (!(userSelection.equals("x"))) {

            if (userSelection.equals("1")){
                // call newEntry function
                newEntry(moodEntries);
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
        userIn.close();
    }
}
