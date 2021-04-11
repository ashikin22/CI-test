import alphabetize.AlphabeticShift;
import circularize.CircularRequiredShift;
import circularize.CircularShift;
import database.LinesDataBase;
import ui.Input;
import ui.SearchInput;
import ui.Output;
import database.SearchDataBase;

import java.io.IOException;

public class kwicsearch {

    /**
     * Master control method to control the program.
     */
    public static void run(String[] arguments) throws IOException {
        long totalTime = 0;
        long startTime = System.currentTimeMillis();
        Input programInput = new Input(arguments[0]);
        LinesDataBase helpManual = new LinesDataBase();
        SearchInput userInput = new SearchInput();
        SearchDataBase searchDataBase = new SearchDataBase();

        //Initializing the program from the file path in the argument
        for (String sectionFilePath : programInput.getInputLines()) {
            Input sectionInput = new Input(sectionFilePath);
            helpManual.addSection(sectionInput.getInputLines(), sectionFilePath);
        }

        long loadTime = System.currentTimeMillis();
        System.out.println("Load time is " + (loadTime - startTime) + "ms.");
        totalTime += (loadTime - startTime);

        while (true) {
            //Get user search input.
            userInput.getUserInput();
            if (userInput.isExit()) {
                break;
            }

            long searchStartTime = System.currentTimeMillis();

            //Control units to get the Search data from database.
            //Search the keyword from each section and consolidate the results.
            for (int index = 0; index < helpManual.getNumberOfSections(); index++) {
                CircularShift shifter = new CircularRequiredShift(helpManual.getSectionLines(index), userInput.getKeyWordRecords());
                shifter.setShiftedLines();
                if (!shifter.getShiftedLines().isEmpty()) {
                    AlphabeticShift alphabetizer = new AlphabeticShift(shifter.getShiftedLines());
                    searchDataBase.addResult(helpManual.getSectionFileName(index));
                    searchDataBase.addResult(alphabetizer.getAlphabetizedLines());
                }
            }
            //Provide user search output.
            Output out = new Output(searchDataBase.getResult());
            out.getOutputLines();
            searchDataBase.reset();

            long searchEndTime = System.currentTimeMillis();
            System.out.println("Search time is " + (searchEndTime - searchStartTime) + "ms.");
            totalTime += (searchEndTime - searchStartTime);
        }

        System.out.println("Total response time is: " + totalTime + "ms.");
    }

    public static void main(String[] args) throws IOException {
        String[] input = {"input.txt"} ;
        run(input);
    }
}
