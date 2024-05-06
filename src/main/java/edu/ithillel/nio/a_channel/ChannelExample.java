package edu.ithillel.nio.a_channel;

import edu.ithillel._constants.InputOutputConstants;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ChannelExample {
    public static void main(String args[]) throws IOException {
        readFileByteByByte();
    }

    private static void readFileByteByByte() throws IOException {
        Path path = Paths.get(InputOutputConstants.FILE_FOR_READING_PATH);
        FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.READ);
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (fileChannel.read(byteBuffer) > 0) {
            // flip the buffer to prepare for get operation
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                System.out.print((char) byteBuffer.get());
            }
            // clear the buffer ready for next sequence of read
            byteBuffer.clear();
        }
    }
}
