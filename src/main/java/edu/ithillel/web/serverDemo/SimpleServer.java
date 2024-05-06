package edu.ithillel.web.serverDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer implements Server {
    private ServerSocket serverSocket;

    public SimpleServer(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
    }

    @Override
    public void start() {
        int i = 0;
        while (true) {
            System.out.println("iteration " + i++);
            try(Socket connection =this.serverSocket.accept();
                OutputStream outputStream = connection.getOutputStream();
                PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream));
                InputStream htmlInputStream = getClass().getClassLoader().getResourceAsStream("nio/index.html");
                Reader inputStreamReader = new InputStreamReader(htmlInputStream)) {

//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }

                String siteText = readTextFile(inputStreamReader);

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("HTTP 1.1 200 OK\r\n");
                stringBuilder.append("Content-Type: text/html\r\n\r\n");
                stringBuilder.append(siteText);

                writer.println(stringBuilder.toString());
                writer.flush();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String readTextFile(Reader fileReader) {
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        return bufferedReader
                .lines()
                .reduce((resLine, currentLine) -> resLine + currentLine + "\n")
                .orElse("");
    }
}
