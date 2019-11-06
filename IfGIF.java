
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;

public class IfGIF {

    public IfGIF(File file) throws IOException {
        byte[] fileContent = new byte[0];
        try {
            fileContent = Files.readAllBytes(file.toPath());
        } catch (FileNotFoundException exc) {
            System.out.println("File not was founded");
        } catch (InvalidPathException | IOException eip) {
            System.out.println("IO error");
        }

        String gifFile = new String(fileContent, "UTF-8");
        int lenGIF = gifFile.length();

        if (lenGIF > 6 && (gifFile.substring(0, 6).equals("GIF89a") || gifFile.substring(0, 6).equals("GIF87a"))) {
            System.out.println(" but the file format is GIF");
        } else {
            IsItGoodFile isitgoodfile = new IsItGoodFile("txt", false, file);
        }
    }

}
