package fileTransfer;

import java.net.Socket;

public class FileTCPClient {
    public static final int PORT = 4000;
    public static final String SERVER = "localhost";

    private Socket clientSideSocket;

    public FileTCPClient() {
        System.out.println("File TCP Client ...");
    }

    public void init() throws Exception {
        clientSideSocket = new Socket(SERVER, PORT);

        protocol(clientSideSocket);
        clientSideSocket.close();
    }

    public void protocol(Socket socket) throws Exception {
        Files.sendFile("test.pdf", socket);
        Files.sendFile("scan.pdf", socket);
        Files.receiveFile("Descargas", socket);
    }

    public static void main(String[] args) throws Exception {
        FileTCPClient fc = new FileTCPClient();
        fc.init();
    }
}