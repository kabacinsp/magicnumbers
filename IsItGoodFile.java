import java.io.File;
import java.io.IOException;

public class IsItGoodFile {

    String whatExtension;
    File otherFile;

    public IsItGoodFile(File file, String extension) throws IOException {
        whatExtension = extension;
        otherFile = file;
        if (extension.equals("jpg") || extension.equals("jpeg")) {
            IfJPG ifjpg = new IfJPG(file, 0);
        } else if (extension.equals("gif")) {
            IfGIF ifgif = new IfGIF(file, 0);
        } else if (extension.equals("txt")) {
            IfTXT iftxt = new IfTXT(file, 0);
        } else
            System.out.println("Extension not supported, please contact support");
    }


    public IsItGoodFile(int o, File otherFile) throws IOException {
        if (o == 1) {
            IfGIF ifgif = new IfGIF(otherFile, o);
        } else if (o == 2) {
            IfJPG ifjpg = new IfJPG(otherFile, o);
        } else if (o == 3) {
            IfTXT iftxt = new IfTXT(otherFile, o);
        } else
            System.out.println(", but the file extension was not recognized");
    }
}
