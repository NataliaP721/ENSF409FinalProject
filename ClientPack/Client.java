package ClientPack;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Client implements ActionListener {

//    private ProfGui professor;
//    private StudGui student;
    private LoginWindow login;
    private boolean isProfessor;

    private Client() {
        login = new LoginWindow();
        String userName = login.getUser();
        char[] pass = login.getPass();
        if(isProfessor) {
            professor = new ProfGui();
        }
        else {
            student = new StudGui();
        }

    }

    private void actionPerformed(ActionEvent e) {

        if()
    }

    public static void main(String[] args) {

        Client client  = new Client();

    }
}
