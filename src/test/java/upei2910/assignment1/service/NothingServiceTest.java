package upei2910.assignment1.service;


import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Testcases associated with the nothing service
class NothingServiceTest {

    //character stats tests

    @Test
    void basicLinesAllSeasonsTest(){

        NothingService ns = new NothingService();
        try {
            ns.loadData("sample.csv");
        }catch(IOException e) {
            e.printStackTrace();
        }
        CharacterStatistics stats = ns.getStats("ANDREW", -1);
        int lines = stats.getTotalLines();
        assertEquals(3, lines, "expecting 3 lines for ANDREW in sample.csv" );
    }
    @Test
    void basicLinesSingleSeasonsTest(){

        NothingService ns = new NothingService();
        try {
            ns.loadData("sample.csv");
        }catch(IOException e) {
            e.printStackTrace();
        }
        CharacterStatistics stats = ns.getStats("ANDREW", 2);
        int lines = stats.getTotalLines();
        assertEquals(1, lines, "expecting 1 lines for ANDREW in season 2 of sample.csv" );
    }

    @Test
    void longWordsSingleSeasonTest(){

        NothingService ns = new NothingService();
        try {
            ns.loadData("sample.csv");
        }catch(IOException e) {
            e.printStackTrace();
        }
        CharacterStatistics stats = ns.getStats("ANDREW", 1);
        String words = stats.getLongWordsLine();
        assertEquals("Well I might not go that far.", words, "expecting specific long line" );
    }

    @Test
    void longWordsAllSeasonTest(){

        NothingService ns = new NothingService();
        try {
            ns.loadData("sample.csv");
        }catch(IOException e) {
            e.printStackTrace();
        }
        CharacterStatistics stats = ns.getStats("CHRIS", -1);
        String words = stats.getLongWordsLine();
        assertEquals("Yeah you are right perl for the win.", words, "expecting specific long line" );
    }

    @Test
    void avgWordsSingleSeasonTest(){

        NothingService ns = new NothingService();
        try {
            ns.loadData("sample.csv");
        }catch(IOException e) {
            e.printStackTrace();
        }
        CharacterStatistics stats = ns.getStats("ANDREW", 2);
        double avg = stats.getAverageWordsPerLine();
        assertEquals(7, avg, 0.0001, "expecting specific avg words / line" );
    }

    @Test
    void avgWordsAllSeasonTest(){

        NothingService ns = new NothingService();
        try {
            ns.loadData("sample.csv");
        }catch(IOException e) {
            e.printStackTrace();
        }
        CharacterStatistics stats = ns.getStats("ANDREW", -1);
        double avg = stats.getAverageWordsPerLine();
        assertEquals(6, avg, 0.0001, "expecting specific average " );
    }

    @Test
    void avgWordsDecimalAllSeasonTest(){

        NothingService ns = new NothingService();
        try {
            ns.loadData("sample.csv");
        }catch(IOException e) {
            e.printStackTrace();
        }
        CharacterStatistics stats = ns.getStats("CHRIS", -1);
        double avg = stats.getAverageWordsPerLine();
        assertEquals(5.75, avg, 0.0001, "expecting specific value for average" );
    }

    @Test
    void seasonHasNoLinesTest(){

        NothingService ns = new NothingService();
        try {
            ns.loadData("sample.csv");
        }catch(IOException e) {
            e.printStackTrace();
        }
        CharacterStatistics stats = ns.getStats("ANDREW", 3);
        double avg = stats.getAverageWordsPerLine();
        int lines = stats.getTotalLines();
        String longLine = stats.getLongWordsLine();
        assertEquals(0, avg, 0.0001, "expecting specific average");
        assertEquals(0, lines, "expecting zero lines");
        assertEquals("", longLine, "expecting empty string long line");
    }

    @Test
    void seasonHasNoCharacterTest() {
        NothingService ns = new NothingService();
        try {
            ns.loadData("sample.csv");
        }catch(IOException e) {
            e.printStackTrace();
        }
        CharacterStatistics stats = ns.getStats("AN", 1);
        double avg = stats.getAverageWordsPerLine();
        int lines = stats.getTotalLines();
        String longLine = stats.getLongWordsLine();
        assertEquals(0, avg, 0.0001, "expecting specific average 0.0");
        assertEquals(0, lines, "expecting zero lines");
        assertEquals("", longLine, "expecting empty string long line");
    }

    // season stats tests
    @Test
    void season3AvgTest() {
        NothingService ns = new NothingService();
        try {
            ns.loadData("sample.csv");
        }catch(IOException e) {
            e.printStackTrace();
        }
        SeasonStatistics stats = ns.getStats(3,1);
        double avg = stats.averageLines();
        assertEquals(1, avg, 0.0001, "expecting specific average");
    }

    @Test
    void season2AvgTest() {
        NothingService ns = new NothingService();
        try {
            ns.loadData("sample.csv");
        }catch(IOException e) {
            e.printStackTrace();
        }
        SeasonStatistics stats = ns.getStats(2,1);
        double avg = stats.averageLines();
        assertEquals(2.0, avg, 0.0001, "expecting specific average");
    }

    @Test
    void seasonX1MostTest() {
        NothingService ns = new NothingService();
        try {
            ns.loadData("sample.csv");
        }catch(IOException e) {
            e.printStackTrace();
        }
        SeasonStatistics stats = ns.getStats(2,1);
        String name = stats.characterWithXthMostLines();
        assertEquals("STUDENT", name, "expecting specific name");
    }

    @Test
    void seasonX2MostTest() {
        NothingService ns = new NothingService();
        try {
            ns.loadData("sample.csv");
        }catch(IOException e) {
            e.printStackTrace();
        }
        SeasonStatistics stats = ns.getStats(2,2);
        String name = stats.characterWithXthMostLines();
        assertEquals("CHRIS", name, "expecting specific name");
    }

    @Test
    void seasonX1MostWordsTest() {
        NothingService ns = new NothingService();
        try {
            ns.loadData("sample.csv");
        }catch(IOException e) {
            e.printStackTrace();
        }
        SeasonStatistics stats = ns.getStats(2,1);
        String name = stats.characterWithXthMostWords();
        assertEquals("STUDENT", name, "expecting specific name");
    }

    @Test
    void seasonX3MostWordsTest() {
        NothingService ns = new NothingService();
        try {
            ns.loadData("sample.csv");
        }catch(IOException e) {
            e.printStackTrace();
        }
        SeasonStatistics stats = ns.getStats(2,3);
        String name = stats.characterWithXthMostWords();
        assertEquals("ANDREW", name, "expecting specific name");
    }

    @Test
    void seasonX2MostWordsTest() {
        NothingService ns = new NothingService();
        try {
            ns.loadData("sample.csv");
        }catch(IOException e) {
            e.printStackTrace();
        }
        SeasonStatistics stats = ns.getStats(2,2);
        String name = stats.characterWithXthMostWords();
        assertEquals("CHRIS", name, "expecting specific name");
    }


    @Test
    void seasonUnique1Test() {
        NothingService ns = new NothingService();
        try {
            ns.loadData("sample.csv");
        }catch(IOException e) {
            e.printStackTrace();
        }
        SeasonStatistics stats = ns.getStats(1,1);
        int count = stats.uniqueCharacterCount();
        assertEquals(2, count, "expecting specific count");
    }

    @Test
    void seasonUniqueAllTest() {
        NothingService ns = new NothingService();
        try {
            ns.loadData("sample.csv");
        }catch(IOException e) {
            e.printStackTrace();
        }
        SeasonStatistics stats = ns.getStats(-1,1);
        int count = stats.uniqueCharacterCount();
        assertEquals(3, count, "expecting specific count");
    }

    @Test
    void seasonUniqueInvalidPositionAllTest() {
        NothingService ns = new NothingService();
        try {
            ns.loadData("sample.csv");
        }catch(IOException e) {
            e.printStackTrace();
        }
        SeasonStatistics stats = ns.getStats(-1,29);
        int count = stats.uniqueCharacterCount();
        assertEquals(3, count, "expecting specific count");
    }

    @Test
    void seasonUniqueInvalidSeasonAllTest() {
        NothingService ns = new NothingService();
        try {
            ns.loadData("sample.csv");
        }catch(IOException e) {
            e.printStackTrace();
        }
        SeasonStatistics stats = ns.getStats(5,29);
        int count = stats.uniqueCharacterCount();
        assertEquals(0, count, "expecting specific count");
    }

    @Test
    void xthLinesInvalidXTest() {
        NothingService ns = new NothingService();
        try {
            ns.loadData("sample.csv");
        }catch(IOException e) {
            e.printStackTrace();
        }
        SeasonStatistics stats = ns.getStats(1,3);
        String name = stats.characterWithXthMostLines();
        assertEquals("", name, "expecting specific count");
    }

    @Test
    void xthLinesInvalidSeasonTest() {
        NothingService ns = new NothingService();
        try {
            ns.loadData("sample.csv");
        }catch(IOException e) {
            e.printStackTrace();
        }
        SeasonStatistics stats = ns.getStats(0,1);
        String name = stats.characterWithXthMostLines();
        assertEquals("", name, "expecting specific count");
    }

    @Test
    void uniqueLargeTest() {
        NothingService ns = new NothingService();
        try {
            ns.loadData("seinfeld.csv");
        }catch(IOException e) {
            e.printStackTrace();
        }
        SeasonStatistics stats = ns.getStats(-1,1);
        int count = stats.uniqueCharacterCount();
        assertEquals(1639, count, "expecting specific count");
    }
}