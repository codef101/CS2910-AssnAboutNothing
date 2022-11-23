package upei2910.assignment1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import upei2910.assignment1.service.CharacterStatistics;
import upei2910.assignment1.service.NothingService;
import upei2910.assignment1.service.SeasonStatistics;

import javax.annotation.PostConstruct;
import java.io.FileNotFoundException;

/**
 * Class to sit between the frontend html files and the
 * data processing backend
 */
@Controller
public class NothingController {

    @Autowired
    NothingService nothingService;

    boolean error = false;

    /**
     * Load the data
     */
    @PostConstruct
    public void init() {
        try {
            nothingService.loadData("seinfeld.csv");
        }catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Generate the index page
     * @return the name of the index html file
     */
    @GetMapping("/")
    public String index() {

        return "index";
    }

    /**
     * Create the character stats webpage
     * preconditions: the data is loaded
     * postconditions: the data is loaded and processed
     * @param character the character to form stats on
     * @param season the season or -1 for all
     * @param model the model to pass information to the webpage
     * @return the html file to open
     */
    @GetMapping("/characterstats")
    public String getCharacterStats(@RequestParam(name="character", required=false, defaultValue="JERRY") String character, @RequestParam(name="season", required=false, defaultValue="-1") String season, Model model) {
        model.addAttribute("character", character);

        int intSeason = Integer.parseInt(season);
        if(intSeason == -1)
            season = "all";

        CharacterStatistics stats = nothingService.getStats(character, intSeason);

        model.addAttribute("season", season);
        model.addAttribute("lineCount", stats.getTotalLines());
        model.addAttribute("averageLine", stats.getAverageWordsPerLine());
        model.addAttribute("longLine", stats.getLongWordsLine());

        return "characterstats";
    }

    /**
     * Create the seasonstats webpage
     * @param season the season to formulate stats for or -1 for all
     * @param position the position'th largest number of lines and words
     * @param model the model to pass information through to the frontend
     * @return the name of the html file
     */
    @GetMapping("/seasonstats")
    public String getSeasonStats(@RequestParam(name="season", required=false, defaultValue="-1") String season, @RequestParam(name="position", required=false, defaultValue="1") String position, Model model) {


        int intSeason = Integer.parseInt(season);
        if(intSeason == -1)
            season = "all";

        int intPosition = Integer.parseInt(position);

        model.addAttribute("position", position);

        model.addAttribute("season", season);

        SeasonStatistics stats = nothingService.getStats(intSeason, intPosition);

        model.addAttribute("season", season);
        model.addAttribute("mostLines", stats.characterWithXthMostLines());
        model.addAttribute("mostWords", stats.characterWithXthMostWords());
        model.addAttribute("avgLines", stats.averageLines());
        model.addAttribute("uniques", stats.uniqueCharacterCount());

        return "seasonstats";
    }

}