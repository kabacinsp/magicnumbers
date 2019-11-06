import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;

public class IfJPG {

    public IfJPG(File file, int o) throws IOException {
        byte[] fileContent = new byte[0];
        try {
            fileContent = Files.readAllBytes(file.toPath());
        } catch (FileNotFoundException exc) {
            System.out.println("File not was founded");
        } catch (InvalidPathException | IOException eip) {
            System.out.println("IO error");
        }

        String jpgFile = bytesToHex(fileContent);
        int lenJPG = jpgFile.length();

        if (lenJPG > 4 && (jpgFile.substring(0, 4).equals("ffd8") && jpgFile.substring(lenJPG - 4, lenJPG).equals("ffd9"))) {
            if (o == 0) {
                System.out.println(" and so it is");
            } else
                System.out.println(", but the file format is JPG");
        } else {
            o++;
            IsItGoodFile isitgoodfile = new IsItGoodFile(o , file);
        }
    }

    //Converting bytes to hex
    private static String bytesToHex(byte[] hashInBytes) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < hashInBytes.length; i++) {
            sb.append(Integer.toString((hashInBytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
}
