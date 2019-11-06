
import java.io.*;
import java.util.Scanner;

public class CheckFile {
    public static void main(String[] args) throws IOException {

        System.out.println("Write file path");
        /*  Read input
        \Users\Cube\Desktop\kolo.jpg
        \Users\Cube\Desktop\kwadrat.gif
        \Users\Cube\Desktop\trojkat.txt
         */

        Scanner terminalInput = new Scanner(System.in);
        File file;
        file = new File(terminalInput.nextLine());

        String extension = "";

        int i = file.toString().lastIndexOf('.');
        if (i > 0) {
            extension = file.toString().substring(i + 1);
        } else
            System.out.println("Please attach correct file!");

        System.out.print("This should be " + extension.toUpperCase() + " format");
        IsItGoodFile isitgooffile = new IsItGoodFile(file, extension);
    }
}

