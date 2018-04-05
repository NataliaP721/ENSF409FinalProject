package ClientPack;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.io.IOException;
import SharedDataObjects.*;

public class Client {

//    private ProfGui professor;
//    private StudGui student;
    private LoginWindow login;
    private boolean isProfessor;
    private Socket socket;
    private ObjectInputStream socketIn;
    private ObjectOutputStream socketOut;

    private Client(String host, int port) {

        try {
            socket = new Socket(host, port);
            socketIn = new ObjectInputStream(socket.getInputStream());
            socketOut = new ObjectOutputStream(socket.getOutputStream());
        }
        catch(IOException e) {
            System.err.println("IO ERROR");
        }

        login = new LoginWindow(socketIn, socketOut);
    }

    private void communicateServer() {

        User user = null;
        while(true) {
            try {
                user = (User) socketIn.readObject();
            }
            catch(ClassNotFoundException e) {
                System.err.println("error");
            }
            catch(IOException e) {
                System.err.println("IO Error");
            }
            if (user.getUserType == 'P') {
                ProfessorGUI prof = new ProfessorGUI(socketIn, socketOut);
                break;
            } else if (user.getUserType == 'S') {
                break;
            } else {
                login.getWarning().setText("Incorrect username or password");
            }
        }

        login.getWarning().setText("");
        login.setVisible(false);

        Object obj;
        while(true) {
            try {
                obj = socketIn.readObject();
                if(obj instanceof String) {
                    if(obj.equals("QUIT")) {
                        break;
                    }
                }
            }
            catch(ClassNotFoundException e) {
                System.err.println("error");
            }
            catch(IOException e) {
                System.err.println("IO Error");
            }
        }
    }

    public static void main(String[] args) {

        Client client  = new Client("localhost", 8099);
        client.communicateServer();
    }
}
