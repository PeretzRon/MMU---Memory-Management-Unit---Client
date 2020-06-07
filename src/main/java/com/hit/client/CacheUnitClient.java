package com.hit.client;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class CacheUnitClient {

    public CacheUnitClient() {
    }

    public String send(String request) {
        Socket myServer = null;
        InetAddress address;
        PrintWriter writer = null;
        Scanner scanner = null;
        String input = "";

        try {
            address = InetAddress.getByName("localhost");
            myServer = new Socket(address, 12345);
            writer = new PrintWriter(new OutputStreamWriter(myServer.getOutputStream()));
            scanner = new Scanner(new InputStreamReader(myServer.getInputStream()));
            writer.println(request);
            writer.flush();
            while (scanner.hasNextLine()) {
                input += scanner.nextLine() + "\n\n";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        finally {
            if (writer != null) {
                writer.close();
            }
            if (!myServer.isClosed())
                try {
                    myServer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

        return input;

    }

}
