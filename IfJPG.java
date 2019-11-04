import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

public class IfJPG {

    public IfJPG(File file) {
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

        String jpgFile = bytesToHex(fileContent);
        int lenIPG = jpgFile.length();

        if(jpgFile.substring(0,4).equals("ffd8") && jpgFile.substring(lenIPG-4,lenIPG).equals("ffd9")){
            System.out.println("This is JPEG file");
        }else{
            System.out.println("This is not JPEG file, please attach correct file!");
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
