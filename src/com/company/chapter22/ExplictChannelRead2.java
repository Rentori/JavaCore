package chapter22;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ExplictChannelRead2 {
    static final String pathName = "/home/viktor/java-projects/JavaCore/src/chapter22/test.txt";

    public static void main(String[] args) {
        int count;

        try (SeekableByteChannel fChan = Files.newByteChannel(Paths.get(pathName))) {
            ByteBuffer mBuf = ByteBuffer.allocate(128);

            do {
                count = fChan.read(mBuf);

                if (count != -1) {
                    mBuf.rewind();
                    for (int i = 0; i < count; i++) {
                        System.out.print((char)mBuf.get());
                    }
                }
            } while (count != -1);
            System.out.println();

        } catch (InvalidPathException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
