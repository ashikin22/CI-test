package circularize;

import java.util.List;

public class CircularRequiredShift extends CircularShift {
    protected List<String> requiredWords;

    /**
     * Constructor of CircularShift with required words.
     */
    public CircularRequiredShift(List<String> lines, List<String> requiredWords) {
        super(lines);
        this.requiredWords = requiredWords;
    }

    /**
     * To check if the first word of the line matches any required word.
     */
    public boolean isMatchRequiredWords(String line) {
        if (requiredWords.isEmpty()) {
            return true;
        }
        for (String word : requiredWords) {
            if (line.equalsIgnoreCase(word)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method to do circular shifting of the input lines,
     * with required words.
     */
    public void setShiftedLines() {
        String baseLine;
        int shiftTimes;
        int linesSize = lines.size();

        for (int i = 0; i < linesSize; i++) {
            baseLine = lines.get(i);
            shiftTimes = getShiftTimes(lines.get(i));

            //Take out the first word, and move it to the end.
            for (int j = 0; j <= shiftTimes; j++) {
                String[] lineBuffer = baseLine.split(" ", 2);
                if (isMatchRequiredWords(lineBuffer[0])) {
                    outputLines.add(baseLine);
                }
                if (lineBuffer.length == 2) {
                    baseLine = lineBuffer[1] + " " + lineBuffer[0];
                }
            }
        }

    }
}
