import java.net.ServerSocket;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Server {
    public static CopyOnWriteArrayList<ClientHandler> clientHandlers = new CopyOnWriteArrayList<>();
    
    private ServerSocket serverSocket;

    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void startServer() {
        try {
            while (!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected!");
                ClientHandler clientHandler = new ClientHandler(socket);
                Thread thread = new Thread(clientHandler);
                thread.start();
            }
        } catch (IOException e) {
            closeServerSocket();
        }
    }

    public void closeServerSocket() {
        try {
            if (serverSocket != null) serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void logMessage(String message) {
        try (FileWriter fw = new FileWriter("chat_log.txt", true)) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            fw.write("[" + timestamp + "] " + message + "\n");
        } catch (IOException e) {
            System.err.println("Log failed");
        }
    }

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            Server server = new Server(serverSocket);
            System.out.println("Server started on port 1234");
            server.startServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
