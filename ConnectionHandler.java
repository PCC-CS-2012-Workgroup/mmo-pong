// ConnectionHandler.java
// 2005.06.29.08.11
// Daniel Foerster -- reformatted 3 August 2012

import java.io.*;
import java.net.*;


public class ConnectionHandler extends Thread {
    Socket socket = null;
    BufferedReader readsocket = null;
    PrintStream writesocket = null;
    ConnectionListener client = null;

    ConnectionHandler(Socket s, ConnectionListener c) {
        client = c;
        socket = s;
        try {
            readsocket = new BufferedReader(
                    new InputStreamReader(s.getInputStream()));
            writesocket = new PrintStream(s.getOutputStream());
        }
        catch(Exception e) {
            System.out.println("ConnectionHandler constructor() " + e);
        }
    }

    public void run() {
        try {
            while(socket.isConnected()) {
                if(readsocket.ready()) {
                    client.use_data(readsocket.readLine(), 
                            socket.getInetAddress().toString());
                }
            }

        } 
        catch(Exception e) {
            System.out.println("ConnectionHandler run(): " + e);
        }
    }

    public void sendmessage(String s) {
        writesocket.println(s);
    }
}
