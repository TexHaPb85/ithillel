package edu.ithillel.nio.d_permissions;

import edu.ithillel._constants.InputOutputConstants;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilePermissionNIO {
    public static void main(String args[]) throws URISyntaxException, IOException {
        URL resource = FilePermissionNIO.class.getClassLoader().getResource("nio/index.html");
        Path file = Paths.get(resource.toURI());

        boolean isRegularFile = Files.isRegularFile(file);
        boolean isHidden = Files.isHidden(file);
        boolean isReadable = Files.isReadable(file);
        boolean isExecutable = Files.isExecutable(file);
        boolean isSymbolicLink = Files.isSymbolicLink(file);

        Path directory = Paths.get(InputOutputConstants.FILE_FOR_UTF);
        boolean isDirectory = Files.isDirectory(directory);
        boolean isWritable = Files.isWritable(directory);

    }

}