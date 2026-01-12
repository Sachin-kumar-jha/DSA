import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.function.Consumer;

public class Server {
    
    public Consumer<Socket>getConsumer(){
        return (clientsocket)->{
            try {
                PrintWriter toClient = new PrintWriter(clientsocket.getOutputStream());
                toClient.print("Hello from the server in your thread");
                toClient.close();
                clientsocket.close();
            } catch (IOException e) {
              System.out.println("something went wrong");
            }
        };
    }
    public static void main(String[] args) {
        int port = 8080;
        Server server = new Server();
       try {
        ServerSocket socket = new ServerSocket(port);
        socket.setSoTimeout(10000);
        while(true){
            try {
                System.out.println("Server is listening on port: "+port);
                Socket acceptSocket = socket.accept();

               Thread thread = new Thread(()->server.getConsumer().accept(acceptSocket));
               thread.start();

                // PrintWriter toClient = new PrintWriter(acceptSocket.getOutputStream());
                // BufferedReader fromClient = new BufferedReader(new InputStreamReader(acceptSocket.getInputStream()));

                // toClient.print("Hello from the server");
                // String line =fromClient.readLine();
                // System.out.println(line);

                // toClient.close();
                // fromClient.close();
                // acceptSocket.close();

            } catch (SocketTimeoutException e) {
               System.out.println("Time out Happen");
            }
        }
       } catch (IOException e) {
        
       }
    }
}
