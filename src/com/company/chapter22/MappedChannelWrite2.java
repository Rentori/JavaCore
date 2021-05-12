package chapter22;

import java.io.File;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class MappedChannelWrite2 {
    static final String pathName = "/home/viktor/java-projects/JavaCore/src/chapter22/test.txt";

    public static void main(String[] args) {
        try (FileChannel fCHan = (FileChannel) Files.newByteChannel(Paths.get(pathName),
                StandardOpenOption.WRITE,
                StandardOpenOption.READ,
                StandardOpenOption.CREATE)) {
            MappedByteBuffer mBuf = fCHan.map(FileChannel.MapMode.READ_WRITE, 0 , 26);

            for (int i = 0; i < 26; i++) {
                mBuf.put((byte) ('A' + i));
            }

        } catch (InvalidPathException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
