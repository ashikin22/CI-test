package ui;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Input {
    protected Path inputPath;
    protected String inputFileName;

    /**
     * Constructor for input.Input class,
     * obtain the arguments and convert to file path.
     */
    public Input(String inputFileName) {
        this.inputFileName = inputFileName;
        inputPath = Paths.get(this.inputFileName);
        checkFileExist();
    }

    /**
     * To check if the provided file exist.
     */
    protected void checkFileExist() {
        if (!Files.isRegularFile(inputPath)) {
            System.out.println("********************************\n" +
                    inputFileName + " does not exist.\n" +
                    "********************************");
            System.exit(0);
        }
    }

    /**
     * Return the lines obtained from the input file.
     */
    public List<String> getInputLines() throws IOException {
        return Files.readAllLines(inputPath);
    }

}
