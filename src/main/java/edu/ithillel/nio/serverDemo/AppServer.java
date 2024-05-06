package edu.ithillel.nio.serverDemo;

import java.io.IOException;

public class AppServer {
    public static void main(String[] args) {
        try {
//            SimpleServer simpleServer = new SimpleServer(8181);
//            simpleServer.start();

            Server nioServer = new NioServer(8181);
            nioServer.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
