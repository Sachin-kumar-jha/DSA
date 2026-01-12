
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class Server {

    public void run() throws IOException{
        int port = 8080;
         ServerSocket socket = new ServerSocket(port);
         socket.setSoTimeout(10000);
        try{
            while(true){
                System.out.println("server is listening on port"+" "+port);
                Socket acceptConnection = socket.accept();
                System.out.println("Connection accepted from client"+acceptConnection.getRemoteSocketAddress());
                PrintWriter toClient = new PrintWriter(acceptConnection.getOutputStream());
                BufferedReader fromClient = new BufferedReader( new InputStreamReader(acceptConnection.getInputStream()));
                toClient.print("Hello from the server");
                toClient.close();
                fromClient.close();
                acceptConnection.close();
            }
        } catch (SocketTimeoutException e) {
            System.out.println("No connection here");
        }
    }
    public static void main(String[] args) {
        Server server =new Server();

        try {
            server.run();
        } catch (Exception e) {
          e.printStackTrace();
        }
    }
    
}