package ellatomlinson.moodjournal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class MoodJournal {

    public static void printMenu(){
        System.out.println("""
                =================================================================================================================================================================================
                Hello! Welcome to your daily mood journal! Let's reflect on how you feel today, please select which option
                you would like to use by typing the digit 1-6 in the terminal, or x to exit:
                
                Manage entries:
                    1) Add a new journal entry
                    2) View all journal entries for a specific month
                    3) View all journal entries
                                
                Entry statistics:
                    4) View top three most logged emotions
                    5) View average mood rating
                    6) View average mood rating for a specific month
                    
                x) Exit mood journal
                =================================================================================================================================================================================
                """);
    }

    public static void newEntry( HashMap<String, JournalEntry> moodEntries, ArrayList<String> emotionMasterlist){
        Scanner entry = new Scanner(System.in);

        // Get journal input from user
        System.out.println("How would you rate your mood today on a scale from 1 to 10?");
        int moodRating = Integer.parseInt(entry.nextLine());

        System.out.println("What emotions were prevalent for you today? E.g excited, nervous, angry etc. Enter emotions " +
                "as comma separated values.");
        String allEmotions = entry.nextLine();
        // Separate input into an array by commas, strip trailing whitespace
        String[] emotionsUnstripped = allEmotions.split(",");
        String[] emotions = new String[emotionsUnstripped.length];
        for (int i = 0; i < emotionsUnstripped.length; i++) {
            String currentItem = emotionsUnstripped[i];
            emotions[i] = currentItem.strip();
            // Also add emotion to the emotionMasterlist
            emotionMasterlist.add(currentItem.strip());
        }

        System.out.println("Write a journal entry about how your day went, you can write anything you would like, it doesn't " +
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

    public static void viewMonth(HashMap<String, JournalEntry> moodEntries){
        // get desired month from user
        Scanner getDate = new Scanner(System.in);
        System.out.println("Please enter the month you would like to view entries for (1-12): ");
        int month = Integer.parseInt(getDate.nextLine());

        System.out.println("The journal entries you made for this month are: ");
        // Loop through all entries
        for (String key : moodEntries.keySet()){
            // Check if month matches desired month
            int currentMonth = Integer.parseInt(key.substring(5,7));
            if (currentMonth == month){
                // If months match, get the entry and print it
                System.out.println("Date: " + key + "\n" + moodEntries.get(key));
            }
        }
    }

    public static void viewAll(HashMap<String, JournalEntry> moodEntries){
        // Loop through all objects in moodEntries and print date and entry
        for (String key : moodEntries.keySet()){
            System.out.println("Date: " + key + "\n" + moodEntries.get(key));
        }
    }

    public static void emotionStats(ArrayList<String> emotionMasterlist){
        // Create array for top three emotions
        String[] topThree = new String[3];

        // Initiate variable for top amount of occurences at 0
        int max = 0;

        // Loop through items in emotionsMasterlist
        for (int i = 0; i < emotionMasterlist.size(); i++){
            // Get occurrence of each item
            int occurrences = Collections.frequency(emotionMasterlist, emotionMasterlist.get(i));
            // If occurences is greater than max, set occurrences as max
            if (occurrences > max){
                max = occurrences;
            }
        }

        // Loop through items in emotionsMasterlist again and find the emotion thats occurrences matches the max, add
        // it to the topThree arraylist
        for (int i = 0; i < emotionMasterlist.size(); i++){
            // Get occurrence of each item
            int occurrences = Collections.frequency(emotionMasterlist, emotionMasterlist.get(i));

            if (occurrences == max){
                topThree[0] = emotionMasterlist.get(i);
            }
        }

        // Remove max item from list and repeat process
        ArrayList<String> sublist = new ArrayList<>();
        for (String currentItem : emotionMasterlist) {
            if (!(currentItem.equals(topThree[0]))) {
                sublist.add(currentItem);
            }
        }

        // restart max counter
        max = 0;

        // Loop through items in sublist
        for (int i = 0; i < sublist.size(); i++){
            // Get occurrence of each item
            int occurrences = Collections.frequency(sublist, sublist.get(i));
            // If occurences is greater than max, set occurrences as max
            if (occurrences > max){
                max = occurrences;
            }
        }

        // Loop through items in sublist again and find the emotion thats occurrences matches the max, add
        // it to the topThree arraylist
        for (int i = 0; i < sublist.size(); i++){
            // Get occurrence of each item
            int occurrences = Collections.frequency(sublist, sublist.get(i));

            if (occurrences == max){
                topThree[1] = sublist.get(i);
            }
        }

        sublist.removeIf(currentItem -> currentItem.equals(topThree[1]));

        // restart max counter
        max = 0;

        // Loop through items in sublist
        for (int i = 0; i < sublist.size(); i++){
            // Get occurrence of each item
            int occurrences = Collections.frequency(sublist, sublist.get(i));
            // If occurences is greater than max, set occurrences as max
            if (occurrences > max){
                max = occurrences;
            }
        }

        // Loop through items in sublist again and find the emotion thats occurrences matches the max, add
        // it to the topThree arraylist
        for (int i = 0; i < sublist.size(); i++){
            // Get occurrence of each item
            int occurrences = Collections.frequency(sublist, sublist.get(i));

            if (occurrences == max){
                topThree[2] = sublist.get(i);
            }
        }

        // Print out results
        System.out.println("The top three emotions you've recorded the most are:" + topThree[0] + "\n" + topThree[1] +
                "\n" + topThree[2]);
    }

    public static void avgMood(HashMap<String, JournalEntry> moodEntries){
        float moodSum = 0;

        // Loop through all moodEntries
        for (String key : moodEntries.keySet()){
            JournalEntry currentEntry = moodEntries.get(key);

            // add mood from current entry to sum
            moodSum += currentEntry.getMoodRating();
        }

        // divide moodSum by amount of entries for average
        float avg = moodSum/moodEntries.size();

        // Print results
        System.out.println("Your average mood rating for all time is " + avg);
    }

    public static void main(String[] args) {
        // Create hashmap for all mood journal entries
        HashMap<String, JournalEntry> moodEntries = new HashMap<>();

        // Create masterlist for all emotions ever logged
        ArrayList<String> emotionMasterlist = new ArrayList<String>();

        // Print menu for user
        printMenu();

        // Get selection from user
        Scanner userIn = new Scanner(System.in);
        String userSelection = userIn.nextLine();

        while (!(userSelection.equals("x"))) {

            if (userSelection.equals("1")){
                // call newEntry function
                newEntry(moodEntries, emotionMasterlist);
            }
            else if (userSelection.equals("2")){
                // call viewMonth function
                viewMonth(moodEntries);

            }
            else if (userSelection.equals("3")){
                // call viewAll function
                viewAll(moodEntries);

            }
            else if (userSelection.equals("4")){
                // call emotionStats function
                emotionStats(emotionMasterlist);

            }
            else if (userSelection.equals("5")){
                // call avgMood function
                avgMood(moodEntries);
            }
            else if (userSelection.equals("6")){

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
