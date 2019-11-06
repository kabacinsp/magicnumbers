import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;

public class IfTXT {

    /*
    Due to the lack of magic numbers in the txt files,
    https://stackoverflow.com/questions/23672780/magic-number-for-plain-text-file
    I decided to use the MIME check
    https://developer.mozilla.org/en-US/docs/Web/HTTP/Basics_of_HTTP/MIME_types
     */
    public IfTXT(File file, int o) throws IOException {
        String fileContent = "new byte[0]";
        try {
            fileContent = Files.probeContentType(file.toPath());
        } catch (
                FileNotFoundException exc) {
            System.out.println("File not was founded");
        } catch (InvalidPathException | IOException eip) {
            System.out.println("IO error");
        }

        if (fileContent.equals("text/plain") || fileContent.equals("text/csv") || fileContent.equals("text/html")) {
            if (o == 0) {
                System.out.println(" and so it is");
            } else
                System.out.println(", but the file format is TXT");
        } else {
            o++;
            IsItGoodFile isitgoodfile = new IsItGoodFile(o , file);
        }
    }
}