package database;

import java.nio.file.Paths;
import java.util.List;

public class LineSection {
    protected List<String> lines;
    protected String fileName;

    /**
     * Constructor of the Section class,
     * Store the Strings and parent file name.
     */
    public LineSection(List<String> lines, String filePath) {
        this.lines = lines;
        this.fileName = Paths.get(filePath).getFileName().toString();
    }

    /**
     * Function to return the Strings list.
     */
    public List<String> getLines() {
        return lines;
    }

    /**
     * Function to return the parent file name.
     */
    public String getFileName() {
        return fileName;
    }
}
