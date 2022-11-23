package upei2910.assignment1.service;

/**
 * Track the statistics for a specific character over a specific season
 * You cannot change the method headers of the getter functions as they are used
 * in the characterstats webpage
 */
public class CharacterStatistics {
    /**
     * public constructor
     * precondition:none
     * postcondition:
     * @param character the character to track statistics for
     * @param season the season to track statistics for
     */
    public CharacterStatistics(String character, int season) {

    }

    /**
     * Return the average words per line for the character and season
     * or zero if no such season or character exists
     * precondition:
     * postcondition:
     * @return double value with average words per line
     */
    public double getAverageWordsPerLine() {
        return 0;
    }

    /**
     * The text of the longest line for this character
     * or empty string if no such season or character exists
     * precondition:
     * postcondition:
     * @return a String containing the character's longest line in this season
     */
    public String getLongWordsLine() {
        return "";
    }

    /**
     * Total lines for this character in this season
     * or zero if no such season or character exists
     * precondition:
     * postcondition:
     * @return the count of the total lines for this character
     */
    public int getTotalLines() {
        return 0;
    }

}
