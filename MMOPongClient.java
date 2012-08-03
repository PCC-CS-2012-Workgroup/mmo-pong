import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;


class MMOPongClient extends Frame 
        implements ConnectionListener, WindowListener, KeyListener {
    
    public static void main(String[] args) {
        String host;
        
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
        // Build client here
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
        
        if (c == 'e' || c == 'i') {
            // Send 'move up' signal
        }
        if (c == 'f' || c == 'h') {
            // Send 'move down' signal
        }
    }
}
