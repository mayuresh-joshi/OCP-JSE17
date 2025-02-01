package org.mj.from17to21.JEP408_simplewebserver;

import com.sun.net.httpserver.SimpleFileServer;

import java.net.InetSocketAddress;
import java.nio.file.Path;

public class Example {

    public static void main(String[] args) {
        startFileServer();
        System.out.println("Go to -> http://localhost:8080/");
    }

    private static void startFileServer() {
        var server = SimpleFileServer.createFileServer(new InetSocketAddress(8080),
                Path.of("H:\\Intellij Projects\\OCP-JSE17\\src\\main\\java\\org\\mj\\from17to21\\JEP408_simplewebserver"),
                SimpleFileServer.OutputLevel.VERBOSE);
        server.start();
    }
}
