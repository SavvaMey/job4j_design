package ru.job4j.io.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.io.UsageLog4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    private static final Logger LOG = LoggerFactory
            .getLogger(UsageLog4j.class.getName());

    public static void main(String[] args)  {
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
                            strStatus = str.split("=")[1].split(" ")[0];
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
        } catch (IOException e) {
            LOG.error("Exception in log example", e);
        }
    }
}
