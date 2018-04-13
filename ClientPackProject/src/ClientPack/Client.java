package ClientPack;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.io.IOException;
import SharedDataObjects.*;

/**
 * @author  Natalia Pavlovic
 * @version 2.0
 * @since April 11, 2018
 */

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
                System.err.println("Object error");
            }
            catch(IOException e) {
                System.err.println("IO Error");
            }
            if(user == null) {
                login.getWarning().setText("Incorrect username or password");
            }
            else if (user.getUserType() == 'P') {
                System.out.println(user.getUserType());
                ProfessorGUI prof = new ProfessorGUI(socketIn, socketOut, user);
                break;
            }
            else if (user.getUserType() == 'S') {
                System.out.println(user.getUserType());
                StudentGUI student = new StudentGUI(socketIn, socketOut, user);
                break;
            }
        }

        login.getWarning().setText("");
        login.setVisible(false);
    }

    public static void main(String[] args) {

        Client client  = new Client("localhost", 8099);
        client.communicateServer();
    }
}
