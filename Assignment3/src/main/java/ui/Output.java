package ui;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Output {
    protected List<String> lines;

    /**
     * Constructor of ui.Output,
     * Store the input lines.
     */
    public Output(List<String> lines) {
        this.lines = lines;
    }

    /**
     * Show and store the KWIC program result.
     */
    public void getOutputLines() throws IOException {
        Path outputPath = Paths.get("output.txt");
        File outputFile = new File(String.valueOf(outputPath));

        //Create the output folder under project root directory,
        //if it doesn't exist.
        if (!outputFile.exists()) {
            outputFile.createNewFile();
        }

        System.out.println("********************************\n" +
                "The search result is:\n" +
                "********************************");

        //Display the result and write to output file at same time.
        FileWriter writeLine = new FileWriter(String.valueOf(outputPath));
        for (String line : lines) {
            System.out.println(line);
            writeLine.write(line);
            writeLine.write("\n");
        }
        writeLine.close();

        System.out.println("********************************\n" +
                "Result is saved in output.txt\n" +
                "********************************");
    }
}
