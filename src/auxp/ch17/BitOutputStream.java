package auxp.ch17;

import lib.Math.NumberConverter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BitOutputStream extends FileOutputStream {
    private StringBuilder nextByte;

    public BitOutputStream(File file) throws FileNotFoundException {
        super(file);
        nextByte = new StringBuilder();
    }

    public void writeBit(char bit) throws IOException {
        if (bit == '0' || bit == '1') nextByte.append(bit);
        if (nextByte.length() == 8) {
            writeBit();
        }
    }

    private void writeBit() throws IOException {
        write(NumberConverter.binToDec(nextByte.toString()));
        nextByte.setLength(0);
    }

    public void writeBit(char... bits) throws IOException {
        for (char bit : bits) {
            writeBit(bit);
        }
    }

    public void writeBit(String bit) throws IOException {
        writeBit(bit.toCharArray());
    }

    @Override
    public void close() throws IOException {
        if (nextByte.length() > 0) {
            for (int i = nextByte.length(); i <= 8; i++) {
                nextByte.append(0);
            }
            writeBit();
        }
        super.close();
    }
}
