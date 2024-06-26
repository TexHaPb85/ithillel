package edu.ithillel.io.d_socketIO;

import edu.ithillel.io.a_simpleInputOutput.InputStreamExample;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//telnet localhost 8585
public class SocketExample {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8585)) {
            Socket connection = serverSocket.accept();
            String s = InputStreamExample.readInputStreamByteByByte(connection.getInputStream());
            System.out.println(s);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
