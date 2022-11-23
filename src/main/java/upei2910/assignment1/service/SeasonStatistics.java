package upei2910.assignment1.service;

/**
 * All of the required data for the seasonstats webpage
 */
public class SeasonStatistics {

    /**
     * public constructor
     * @param season the season to calculate stats for
     * @param position the X'th values to calculate
     */
    public SeasonStatistics (int season, int position) {
    }

    /**
     * Which character had the position'th most words in this season
     * if there are less than X unique characters return an empty string
     * precondition:
     * postcondition:
     * @return the name of the character having the X'th most words where X is position
     */
    public String characterWithXthMostWords() {
        return "";
    }

    /**
     * Which character had the X'th most lines this season
     * * if there are less than X unique characters return an empty string
     * precondition:
     * postcondition:
     * @return the name of the character having the X'th most lines where X is position
     */
    public String characterWithXthMostLines() {
        return "";
    }

    /**
     * The average number of lines for a character in the show in this season
     * precondition:
     * postcondition:
     * @return the average number of lines
     */
    public double averageLines() {
        return 0;
    }

    /**
     * How many unique characters had a line in this season
     * precondition:
     * postcondition:
     * @return the count of unique characters
     */
    public int uniqueCharacterCount() {
        return 0;
    }
}
