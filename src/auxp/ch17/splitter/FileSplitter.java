package auxp.ch17.splitter;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import lib.Misc.FileIO;

public class FileSplitter {

    /**
     * Recursive Byte string formatter ex: 10000 = 10.000
     *
     * @param bytes string containing digits to be formated
     * @return x.xxx.xxx.xxx style string
     */
    private static String byteSizeFormatter(String bytes) {
        StringBuilder sb = new StringBuilder();
        if (bytes.length() < 4) {
            sb.insert(0, bytes);
        } else {
            sb.insert(0, "." + bytes.substring(bytes.length() - 3));
            sb.insert(0, byteSizeFormatter(bytes.substring(0, bytes.length() - 3)));
        }
        return sb.toString();
    }

    public static String byteSizeFormatter(long bytes) {
        return byteSizeFormatter(bytes + "");
    }

    public static void splitByPieces(File file, int pieces) {
        long bytes = (file.length() / pieces) + (file.length() % pieces == 0 ? 0 : 1);
        splitBySize(file, bytes);
    }

    public static void splitBySize(File file, long bytes) {
        int pieces = (int) (file.length() / bytes);
        int digits = (pieces + "").length();
        int count = 0;
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(file))) {
            while (in.available() > 0) {
                long size = in.available() >= bytes ? bytes : in.available();
                byte[] split = new byte[(int) size]; // TODO fix casting
                in.read(split);

                File piece =
                    new File(
                        file.getAbsolutePath() + "." + String.format("%0" + digits + "d", count++));

                try (FileOutputStream out = new FileOutputStream(piece)) {
                    out.write(split);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void join(ArrayList<File> files, String newName) {
        File jointFile = new File(files.get(0).getParent() + "/" + newName);

        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(jointFile))) {
            for (File file : files) {
                try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(file))) {
                    while (in.available() != 0) {
                        out.write(in.read());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void join(ArrayList<File> files) {
        String originalName = FileIO.getCleanName(files.get(0));
        String originalExt = FileIO.getFileExtension(originalName);
        String newName = FileIO.getCleanName(originalName) + "-[joint]." + originalExt;
        join(files, newName);
    }

    public static void join(File file0) {
        join(getSplitFiles(file0));
    }

    public static ArrayList<File> getSplitFiles(File file0) {
        ArrayList<File> splitFiles = new ArrayList<>();
        int extensionSize = FileIO.getFileExtension(file0).length();

        String baseName = FileIO.getCleanName(file0);

        int count = 0;
        File actual;
        while (true) {
            actual =
                new File(
                    file0.getParent()
                        + "/"
                        + baseName
                        + "."
                        + String.format("%0" + extensionSize + "d", count++));
            // System.out.println(actual.getAbsolutePath() + actual.exists());
            if (!actual.exists()) {
                break;
            } else {
                splitFiles.add(actual);
            }
        }

        return splitFiles;
    }
}
