package ui;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SearchInput {
    protected List<String> keyWordRecords;
    protected String keyWord;
    protected boolean exit;

    public SearchInput() {
        keyWordRecords = new LinkedList<>();
        keyWord = null;
        exit = false;
        welcomeMessage();
    }

    protected void welcomeMessage(){
        System.out.println("********************************\n" +
                "**         Welcome to         **\n" +
                "** Key Word in Context System **\n" +
                "********************************");
    }

    protected void searchMessage() {
        System.out.println("********************************\n" +
                "Key in the search key word.\n" +
                "Key in q to exit.\n" +
                "********************************");
        if (!keyWordRecords.isEmpty()) {
            for (String record : keyWordRecords) {
                System.out.println(record);
            }
        }
    }

    /**
     * Function to let user input search key word,
     * and detect if the user input q for exit.
     */
    public void getUserInput() {
        searchMessage();
        Scanner input = new Scanner(System.in);
        keyWord = input.nextLine();
        if (keyWord.equals("q")) {
            exit = true;
        }
        keyWordRecords.add(keyWord);
    }

    public List<String> getKeyWordRecords() {
        return keyWordRecords;
    }

    public boolean isExit() {
        return exit;
    }
}
