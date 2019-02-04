package no.hvl.dat110.messaging;

import java.io.IOException;
import java.net.Socket;

public class MessagingClient {

    private String server;
    private int port;
    private Connection connection;

    public MessagingClient(String server, int port) {
        this.server = server;
        this.port = port;
    }

    // connect to messaging server
    public Connection connect() {

        Socket clientSocket;
        this.connection = null;

        // TODO
        // create TCP socket for client and connection

        try {
            clientSocket = new Socket(server, port);
            this.connection = new Connection(clientSocket);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return this.connection;
    }

    public void disconnect(){
        this.connection.close();
        this.connection = null;
    }
}