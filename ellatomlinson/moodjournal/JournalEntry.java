package ellatomlinson.moodjournal;

public class JournalEntry {

    private final int moodRating;
    private final String[] emotions;
    private final String journal;

    public JournalEntry(int moodRating, String[] emotions, String journal) {
        this.moodRating = moodRating;
        this.emotions = emotions;
        this.journal = journal;
    }

    public String toString(){
        // Create output string and add mood rating
        String outputString = "Mood: " + moodRating + "\n" +
                              "Emotions: ";

        // Add each emotion to output string
        for (String item : emotions){
            outputString += item;
            outputString += " ";
        }
        outputString += "\nJournal Entry: ";

        // Add journal entry to outputString
        outputString += journal + "\n";

        // Add separator for when many entries are printed
        outputString += "=================================================================================================================================";

        // Return outputString
        return outputString;
    }

    // For writing csv type files in saveToFile
    public String fileType(){
        // Create outputString and add mood and journal
        String outputString = this.getMoodRating() + "," + this.getJournal() + ",";
        // Add each emotion to output string
        for (String item : emotions){
            outputString += item;
            outputString += ",";
        }

        // return output string
        return outputString;
    }

    public int getMoodRating() {return moodRating;}
    public String getJournal() {return journal;}
}
