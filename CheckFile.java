
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.sql.SQLOutput;
import java.util.Scanner;

public class CheckFile {
    public static void main(String[] args)  {

        System.out.println("Write file path");
        //  Read input \Users\Cube\Desktop\kolo.jpg
        Scanner terminalInput = new Scanner(System.in);
        File file = new File(terminalInput.nextLine());

        String extension = "";

        int i = file.toString().lastIndexOf('.');
        if (i > 0) {
            extension = file.toString().substring(i+1);
        }
        else
            System.out.println("Please attach correct file!");

        System.out.println(extension);

        if(extension.equals("jpg") || extension.equals("jpeg")){
            IfJPG ifjpg = new IfJPG(file);
        }

    }


}

