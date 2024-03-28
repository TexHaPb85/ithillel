package edu.ithillel.io;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketExample {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8585)) {
            Socket connection = serverSocket.accept();
            String s = InputStreamExample.readInputStream(connection.getInputStream());
            System.out.println(s);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
