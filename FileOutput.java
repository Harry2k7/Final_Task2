import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileOutput {

    public static void writeToFile(String filename, String content) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))) {
            bw.write(content);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
