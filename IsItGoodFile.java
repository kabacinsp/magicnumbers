import java.io.File;
import java.io.IOException;

public class IsItGoodFile {

    String whatExtension;
    File otherFile;

    public IsItGoodFile(File file, String extension) throws IOException {
        whatExtension = extension;
        otherFile = file;
        if (extension.equals("jpg") || extension.equals("jpeg")) {
            IfJPG ifjpg = new IfJPG(file);
        } else if (extension.equals("gif")) {
            IfGIF ifgif = new IfGIF(file);
        } else if (extension.equals("txt")) {
            IfTXT iftxt = new IfTXT(file);
        } else
            System.out.println("Extension not supported, please contact support");
    }

    boolean gif;
    boolean jpg;
    boolean txt;
    int i = 0;

    public IsItGoodFile(String format, boolean check, File otherFile) throws IOException {
        if (format.equals("gif")) {
            gif = check;
            i++;
        } else if (format.equals("jpg")) {
            jpg = check;
            i++;
        } else if (format.equals("txt")) {
            txt = check;
            i++;
        }

        switch (i) {
            case 1:
                IfGIF ifgif = new IfGIF(otherFile);
                break;
            case 2:
                IfJPG ifjpg = new IfJPG(otherFile);
                break;
            case 3:
                IfTXT iftxt = new IfTXT(otherFile);
                break;
            case 4:
                System.out.println("The file extension was not recognized");
                break;
        }
    }
}
