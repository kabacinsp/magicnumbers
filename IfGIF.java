import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.List;

public class IfGIF {

    public IfGIF(File file) throws IOException {
        byte[] fileContent = new byte[0];
        try {
            fileContent = Files.readAllBytes(file.toPath());
        } catch (
                FileNotFoundException exc) {
            System.out.println("File not was founded");
        } catch (
                IOException e) {
            System.out.println("IO error");
        }

        String gifFile = new String(fileContent, "UTF-8");
        int lenGIF = gifFile.length();

        if (gifFile.substring(0, 6).equals("GIF89a") || gifFile.substring(0, 6).equals("GIF87a")) {
            System.out.println("This is GIF file");
        } else {
            System.out.println("This is not GIF file, please attach correct file!");
        }
    }

}
