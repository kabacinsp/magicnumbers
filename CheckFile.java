
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;

public class CheckFile {
    public static void main(String[] args)  {

        //  Read input \Users\Cube\Desktop\kolo.jpg
        Scanner terminalInput = new Scanner(System.in);
        File file = new File(terminalInput.nextLine());

        //  Write
        byte[] fileContent = new byte[0];
        try {
            fileContent = Files.readAllBytes(file.toPath());
        } catch (FileNotFoundException exc) {
            System.out.println("File not was founded");
        } catch (IOException e) {
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

