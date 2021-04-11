package alphabetize;

import java.util.Collections;
import java.util.List;

public class AlphabeticShift {
    protected List<String> lines;

    /**
     * Constructor of alphabetize.AlphabeticShift,
     * Store the input lines, and do soring in alphabetic order.
     */
    public AlphabeticShift(List<String> lines) {
        this.lines = lines;
        setAlphabetizedLines(this.lines);
    }

    /**
     * Return the lines after Alphabetizing.
     */
    public List<String> getAlphabetizedLines() {
        return lines;
    }

    /**
     * Sort the lines in alphabetic order, ignoring case sensitive.
     */
    public void setAlphabetizedLines(List<String> lines) {
        Collections.sort(lines, String.CASE_INSENSITIVE_ORDER);
    }
}
