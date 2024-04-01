package edu.ithillel.nio.serverDemo;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.*;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

public class NioServer implements Server {
    private ServerSocketChannel serverSocketChannel; //receive connections
    private Selector selector;//manage received connections

    public NioServer(int port) throws IOException {
        this.serverSocketChannel = ServerSocketChannel.open();
        this.serverSocketChannel.bind(new InetSocketAddress(port));
        // if we get another request while processing preveous one - we return null reference
        this.serverSocketChannel.configureBlocking(false);

        this.selector = Selector.open();
        this.serverSocketChannel.register(selector, serverSocketChannel.validOps());

    }

    @Override
    public void start() {
        while (true) {
            processConnections();
        }
    }

    private void processConnections() {
        try {
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            int select = selector.select(); // Selects a set of keys whose corresponding channels are ready for I/O operations
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                if(selectionKey.isAcceptable()) {
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(this.selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
                }
                if(selectionKey.isReadable()){
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(256);

                    socketChannel.read(byteBuffer);
                    byteBuffer.flip();
                    CharBuffer decode = StandardCharsets.UTF_8.decode(byteBuffer);
                    System.out.println(decode);
                }
                if (selectionKey.isWritable()) {
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    InputStream htmlInputStream = getClass().getClassLoader().getResourceAsStream("nio/index.html");
                    Reader inputStreamReader = new InputStreamReader(htmlInputStream);

                    String siteText = readTextFile(inputStreamReader);

                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("HTTP 1.1 200 OK\r\n");
                    stringBuilder.append("Content-Type: text/html\r\n\r\n");
                    stringBuilder.append(siteText);

                    ByteBuffer wrap = ByteBuffer.wrap(stringBuilder.toString().getBytes());
                    socketChannel.write(wrap);

                    socketChannel.close();
                }
                iterator.remove();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
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
