// ConnectionListener.java
// 2005.06.29.08.28
// Daniel Foerster -- reworked 3 August 2012

public interface ConnectionListener {
    public void use_data(String data, String sender_name);
    public void add_connection(ConnectionHandler ch);
}
