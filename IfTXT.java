import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class IfTXT {

    /*
    Due to the lack of magic numbers in the txt files,
    https://stackoverflow.com/questions/23672780/magic-number-for-plain-text-file
    I decided to use the MIME check
    https://developer.mozilla.org/en-US/docs/Web/HTTP/Basics_of_HTTP/MIME_types
     */
    public IfTXT(File file) throws IOException {
        String fileContent = "new byte[0]";
        try {
            fileContent = Files.probeContentType(file.toPath());
        } catch (
                FileNotFoundException exc) {
            System.out.println("File not was founded");
        } catch (
                IOException e) {
            System.out.println("IO error");
        }

        if (fileContent.equals("text/plain") || fileContent.equals("text/csv") || fileContent.equals("text/html")) {
            System.out.println("This is TXT file");
        } else {
            System.out.println("This is not TXT file, please attach correct file!");
        }
    }
}