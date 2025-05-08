package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket server = new ServerSocket(10000);
        Socket connection = server.accept();
        InputStream is = connection.getInputStream();
        String result = readAll(is);
        System.out.println(result);
    }
    private static String readAll(InputStream is) throws IOException, InterruptedException {
        Thread.sleep(1000L);
        byte[] buffer = new byte[1025 * 10];
        int len = 0;
        while (is.available() > 0){
            int read = is.read(buffer, len, is.available());
            len += read;
            Thread.sleep(1000L);
        }
        return new String(buffer,0,len);
    }
}