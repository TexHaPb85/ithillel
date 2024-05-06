package edu.ithillel.web;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) {
        try (Socket socket = new Socket("www.google.com", 80)) {
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            String request = "GET\n" +
                "Host: google.com\n" +
                "Content-Type: text/html\\r\\n\\r\\n";
            System.out.println(request);
            outputStream.write(request.getBytes());

            int c;
            while ((c = inputStream.read()) != -1) {
                System.out.print((char) c);
            }
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
