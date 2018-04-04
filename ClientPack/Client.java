package ClientPack;

import java.net.Socket;

public class Client {

//    private ProfGui professor;
//    private StudGui student;
    private LoginWindow login;
    private boolean isProfessor;
    private Socket socket;

    private Client() {
        login = new LoginWindow();

//        if(isProfessor) {
//            professor = new ProfGui();
//        }
//        else {
//            student = new StudGui();
//        }

    }

    public static void main(String[] args) {

        Client client  = new Client();

    }
}
