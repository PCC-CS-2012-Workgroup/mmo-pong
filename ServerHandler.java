// ServerHandler.java
// 2005.06.29.08.40
// Daniel Foerster -- reformatted and shaved down 3 August 2012

import java.net.*;


public class ServerHandler extends Thread {
    ServerSocket ss = null;
    ConnectionListener cl = null;

    ServerHandler(ConnectionListener c) {
        try {
            ss  = new ServerSocket(13428);
            cl = c;
        }
        catch(Exception e) {
            System.out.println("ServerHandler constructor: " + e);
        }
    }
    
    public void run() {
        ConnectionHandler j = null;
        
        try {
            while(true) {
                j = new ConnectionHandler(ss.accept(), cl);
                cl.add_connection(j);
                j.start();
            }
        }
        catch(Exception e) { 
            System.out.print("ConnectionListener " + cl + "//");
            System.out.println("ConnectionHandler " + j);
            System.out.println("ServerHandler run(): " + e);
            e.printStackTrace();
        }
    }
}
