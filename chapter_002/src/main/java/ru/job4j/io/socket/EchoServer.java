package ru.job4j.io.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (true) {
                boolean status = true;
                String strStatus = "";
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    while (!(str = in.readLine()).isEmpty()) {
                        if (str.contains("?msg=")) {
                            strStatus= str.split("=")[1].split(" ")[0];
                            if (strStatus.equals("Exit")) {
                                status = false;
                            }
                        }
                        System.out.println(str);
                    }
                    if (!status) {
                        out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                        break;
                    }
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    out.write(strStatus.getBytes());
                }
            }
        }
    }
}
