package edu.ithillel.nio;

import edu.ithillel._constants.InputOutputConstants;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class NioExample {
    public static void main(String[] args) {
        Path path = Paths.get(InputOutputConstants.FILE_FOR_READING_PATH);//analog of File in IO

        try (FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.READ)){
            ByteBuffer readBuffer = ByteBuffer.allocate(10);

            int read = 0;
            StringBuilder stringBuilder = new StringBuilder();
            while (read != -1) {
                readBuffer.flip();
                read = fileChannel.read(readBuffer);

                //CharBuffer charBuffer = readBuffer.asCharBuffer();//UTF16
                //CharBuffer decode = StandardCharsets.UTF_8.decode(readBuffer);

                while (readBuffer.hasRemaining()) {
                    stringBuilder.append((char)readBuffer.get());
                }
                readBuffer.clear();
            }
            System.out.println(stringBuilder);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
