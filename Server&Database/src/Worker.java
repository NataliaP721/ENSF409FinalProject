import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import SharedDataObjects.*;

public class Worker implements Runnable {
    private DatabaseHelper databaseHelper;
    private EmailHelper emailHelper;
    private FileHelper fileHelper;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private Socket socket;

    public Worker (DatabaseHelper database, EmailHelper emailService, FileHelper fileManager, Socket socket) {
        this.databaseHelper = database;
        this.emailHelper = emailService;
        this.fileHelper = fileManager;
        this.socket = socket;
    }

    /**
     * {@InheritDoc}
     */
    @Override
    public void run() {

    }

    public void closeConnection() {
        try {
            socket.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
