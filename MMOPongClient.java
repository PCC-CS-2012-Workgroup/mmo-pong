import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;


class MMOPongClient extends Frame 
        implements ConnectionListener, WindowListener, KeyListener {
    
    static String title = "MMO Pong v1.0";
    ConnectionHandler remote = null;
    
    public static void main(String[] args) {
        String host;
        
        System.out.println("==== " + title + " ====");
        
        try {
            host = args[0];
        }
        catch (ArrayIndexOutOfBoundsException e) {
            Scanner scan = new Scanner(System.in);
            System.out.print(
                    "Enter the name of the server you wish to connect to: ");
            host = scan.nextLine();
        }
        
        MMOPongClient p = new MMOPongClient(host);
    }
    
    MMOPongClient(String host) {
        super(title);
        try {
            Socket remote_socket = new Socket(host, 13428);
            remote = new ConnectionHandler(remote_socket, this);
            remote.start();   // Don't forget to start your Thread!!
        }
        catch(UnknownHostException e) {
            System.out.println("Could not find host " + host + 
                    ".");
        }
        catch(IOException e) {
            System.out.println("Could not connect to host " + host + 
                    ".");
        }
    }
    
    public void add_connection(ConnectionHandler ch) {}
    
    public void use_data(String s, String address) {
        // Parse data and update screen
    }
    
    public void windowActivated(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}
    public void windowOpened(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    
    public void windowClosing(WindowEvent e) {
        this.dispose();
    }
    
    public void windowClosed(WindowEvent e) {
        System.exit(1);
    }
    
    public void keyPressed(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
    
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        
        // Could use switch-case here, but this works well enough
        // There are left-handed controls (ef) and right-handed controls (ih)
        if (c == 'e' || c == 'i') {
            // up
            remote.send_message("u");
        }
        if (c == 'f' || c == 'h') {
            // down
            remote.send_message("d");
        }
    }
}
