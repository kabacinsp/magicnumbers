package logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;

public class IfGIF implements CheckIf {

    private byte[] fileContent;
    private int whichTime;
    private File passFile;
    private int lenGIF;
    private String gifFile;

    IfGIF(File file, int o) throws IOException {
        whichTime = o;
        passFile = file;
        try {
            fileContent = Files.readAllBytes(file.toPath());
        } catch (FileNotFoundException exc) {
            System.out.println("File not was founded");
        } catch (InvalidPathException | IOException eip) {
            System.out.println("IO error");
        }

        gifFile = new String(fileContent, "UTF-8");
        lenGIF = gifFile.length();
        checkIfFileIsMatched();
    }


    @Override
    public void checkIfFileIsMatched() {
        if (lenGIF > 6 && (gifFile.substring(0, 6).equals("GIF89a") || gifFile.substring(0, 6).equals("GIF87a"))) {
            if (whichTime == 0) {
                System.out.println(" and so it is");
            } else
                System.out.println(", but the file format is GIF");
        } else {
            ++whichTime;
            try {
                IsItGoodFile isitgoodfile = new IsItGoodFile(whichTime, passFile);
            } catch (IOException e) {
                System.out.println("File passing problem");
            }
        }
    }
}
