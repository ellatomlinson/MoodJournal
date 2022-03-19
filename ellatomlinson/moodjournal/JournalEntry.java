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
        String outputString = "Mood: %d\n" +
                              "Emotions: ", moodRating;

        // Add each emotion to output string
        for (String item : emotions){
            outputString += item;
            outputString += " ";
        }
        outputString += "\nJournal Entry: \n --------------------------------------------------------------------------------\n";

        // Add journal entry to outputString
        outputString += journal;

        // Add separator for when many entries are printed
        outputString += "=================================================================================================================================";

        // Return outputString
        return outputString;
    }

    public int getMoodRating() {return moodRating;}
    public String[] getEmotions() {return emotions;}
    public String getJournal() {return journal;}
}
