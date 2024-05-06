package edu.ithillel.io.b_textFileReaderWriter;

import java.io.File;

public class FileBlockerUtil {
    public static void blockFileForWriting(File file) {
        if(file.canWrite()){
            boolean b = file.setWritable(false);
            System.out.println(b ? "File blocked successfully" : "Error trying blocking file");
        }
    }
    public static void unblockFileForWriting(File file) {
        if(!file.canWrite()){
            boolean b = file.setWritable(true);
            System.out.println(b ? "File unblocked successfully" : "Error trying unblocking file");
        }
    }
    public static void blockFileForReading(File file) {
        if(file.canRead()){
            boolean b = file.setReadable(false);
            System.out.println(b ? "File blocked successfully" : "Error trying blocking file");
        }
    }
    public static void unblockFileForReading(File file) {
        if(!file.canRead()){
            boolean b = file.setReadable(true);
            System.out.println(b ? "File unblocked successfully" : "Error trying unblocking file");
        }
    }
}
