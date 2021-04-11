package database;

import java.util.LinkedList;
import java.util.List;

public class LinesDataBase {
    protected List<LineSection> lineSectionList;
    protected int numberOfSections;

    /**
     * Constructor of LinesDataBase,
     * Initialize the Section list.
     */
    public LinesDataBase() {
        lineSectionList = new LinkedList<>();
        numberOfSections = 0;
    }

    /**
     * Function to add new section into the list,
     * and record how many sections.
     */
    public void addSection(List<String> sectionLines, String parentFilePath) {
        lineSectionList.add(new LineSection(sectionLines, parentFilePath));
        numberOfSections++;
    }

    /**
     * Function to return the Strings from the section,
     * based on the section index provided.
     */
    public List<String> getSectionLines(int sectionIndex) {
        return lineSectionList.get(sectionIndex).getLines();
    }

    /**
     * Function to return the parent file name from the section,
     * based on the section index provided.
     */
    public String getSectionFileName(int sectionIndex) {
        return lineSectionList.get(sectionIndex).getFileName();
    }

    /**
     * Function to return number of the sections contained.
     */
    public int getNumberOfSections() {
        return numberOfSections;
    }
}
