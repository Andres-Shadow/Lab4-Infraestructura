package fileTransfer;

import java.net.ServerSocket;
import java.net.Socket;

public class FileTCPServer {
    public static final int PORT = 4000;
    private ServerSocket listener;
    private Socket serverSideSocket;

    public FileTCPServer() {
        System.out.println("File TCP Server ...");
    }

    private void init() throws Exception {
        listener = new ServerSocket(PORT);

        while(true) {
            serverSideSocket = listener.accept();

            protocol(serverSideSocket);
        }
    }
    public void protocol(Socket socket) throws Exception {
        Files.receiveFile("Descargas", socket);
        Files.receiveFile("Juan", socket);
        Files.sendFile("02 Diplomas.pdf", socket);
    }
    public static void main(String[] args) throws Exception {
        FileTCPServer os = new FileTCPServer();
        os.init();
    }
}