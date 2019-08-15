package auxp.ch17.encryption;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import lib.Misc.FileIO;

public class Crypt {

    public static void encrypt(File file, int key) {
        File encrypted = new File(file.getPath() + ".crypt");
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(encrypted))) {
            while (in.available() > 0) {
                int read = in.read();
                read += key;
                out.write(read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void decrypt(File file, int key) {
        String orig = FileIO.getCleanName(file);
        File decrypted =
            new File(
                file.getParent()
                    + "/"
                    + FileIO.getCleanName(orig)
                    + "-[decrypted]."
                    + FileIO.getFileExtension(orig));
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(decrypted))) {
            while (in.available() > 0) {
                int read = in.read();
                read -= key;
                out.write(read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
