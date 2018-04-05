import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.*;

/**
 * The purpose of this class is to create
 * @version 1.0
 * @since April 5, 2018
 */

public class Server {
    /**
     * The socket of the server
     */
    private ServerSocket serverSocket;

    /**
     * The thread pool for the server
     */
    private ExecutorService pool;

    private DatabaseHelper database;
    private EmailHelper emailService;
    private FileHelper fileManager;

    /**
     * Constructs a Server Object with specified port value.
     * @throws IOException
     */
    public Server() {
        try {
            serverSocket = new ServerSocket(8099);
            pool = Executors.newCachedThreadPool();

        } catch (IOException e) {
            System.out.println("Create the new socket error");
        }
    }

    /**
     * Looks for new clients to be added and constantly listens to what the client does.
     * Creates xPlayer and oPlayer, a Referee and a Game and starts theGame
     * @throws Exception
     */
    public void communicateWithClient () {
        try {
            // Constantly listening to what client does and looking for new clients to be added
            while(true) {
                Worker worker = new Worker(database, emailService, fileManager, serverSocket.accept());

                System.out.println("Connected to new Client");

                pool.execute(worker);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            pool.shutdown(); // Close pool is something disconnects
        }

    }

    /**
     * @param args a string array for input parameters passed to main
     */
    public static void main(String[] args){
        Server myserver = new Server();
        System.out.println("Server is running...");
        myserver.communicateWithClient();
    }
}