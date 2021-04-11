package circularize;

import java.util.LinkedList;
import java.util.List;

public class CircularShift {
    protected List<String> lines;
    protected List<String> outputLines;

    /**
     * Constructor of circularize.CircularShift,
     * Store the input lines, and do circular shift.
     */
    public CircularShift(List<String> lines) {
        this.lines = lines;
        outputLines = new LinkedList<>();
    }

    /**
     * Calculate how many are needed to do the shifting,
     * based on how many spaces are there in the line.
     */
    protected int getShiftTimes(String line) {
        int result = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == ' ') result++;
        }

        return result;
    }

    /**
     * Return the lines after circular shift.
     */
    public List<String> getShiftedLines() {
        return outputLines;
    }

    /**
     * Method to do circular shifting of the input lines.
     */
    public void setShiftedLines() {
        String baseLine = "";
        int shiftTimes = 0;
        int linesSize = lines.size();

        for (int i = 0; i < linesSize; i++) {
            baseLine = lines.get(i);
            shiftTimes = getShiftTimes(lines.get(i));

            //Take out the first word, and move it to the end.
            for (int j = 0; j <= shiftTimes; j++) {
                String[] lineBuffer = baseLine.split(" ", 2);
                outputLines.add(baseLine);
                if (lineBuffer.length == 2) {
                    baseLine = lineBuffer[1] + " " + lineBuffer[0];
                }
            }
        }

    }

}
