package upei2910.assignment1.service;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * The backend class providing the data processing api service
 *
 * Reminder not to change the method headers for any of the existing methods
 * - but please change the implementation
 * - feel free to add methods as required
 */
@Service
public class NothingService {

    /**
     * public constructor
     * precondition: none:
     * postcondition: TBD
     * be mindful that after creation load data is called separately
     */
    public NothingService() {
        //be mindful that loadData will be explicitly called after the constructor
        //so don't call it here it will be called for you before any other methods
    }

    /**
     * Load the data from a specific fileName
     * (the first line is given for you)
     * This method should only be called once per session
     * precondition: TBD (fill this in)
     * postcondition: TBD (fill this in)
     * @param fileName the full absolute file to open
     * @throws FileNotFoundException in the case the file does not exist
     */
    public void loadData(String fileName) throws FileNotFoundException {

        File file = Helper.openResourceFile(fileName);

        //the above line is left to help you setting the file
        // from which the data will load
        //you'll want to add more to this method below
    }

    /**
     * Process and retrieve the character statistics for a certain season
     * Preconditions: the data is loaded
     * Postconditions:
     * @param character the character to calculate statistics for
     * @param season the season to calculate statistics for or -1 for all seasons
     * @return CharacterStatistics object containing the required data
     */
    public CharacterStatistics getStats(String character, int season) {
        //you may want to replace this
        return new CharacterStatistics(character, season);
    }


    /**
     * Process and retrieve the season statistics for a certain season
     * Preconditions: the data is loaded
     * Postconditions:
     * @param season the season to calculate statistics for or -1 for all seasons
     * @return SeasonStatistics object containing the required data
     */
    public SeasonStatistics getStats(int season, int position) {
        //you may want to replace this
        return new SeasonStatistics(season, position);
    }
}
