package database;

import java.util.LinkedList;
import java.util.List;

public class SearchDataBase {
    protected List<String> result;

    /**
     * Constructor of the SearchDataBase class,
     * initialize the result list.
     */
    public SearchDataBase() {
        result = new LinkedList<>();
    }

    /**
     * Function to add search List result to the result list.
     */
    public void addResult(List<String> lines) {
        result.addAll(lines);
    }

    /**
     * Function to add search String result to the result list.
     */
    public void addResult(String line) {
        result.add(line);
    }

    public List<String> getResult() {
        return result;
    }

    public void reset() {
        result.clear();
    }
}
