import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        Client client = new Client();

        for(int i  =0;i<100;i++){
            try {
                Thread thread = new Thread(client.getRunnable());
                thread.start();
            } catch (IOException e) {
               
            }
        }

    }

public  Runnable getRunnable() throws IOException {
       return new Runnable(){
        @Override
        public void run() {
           int port = 8080;
            try {
            InetAddress address =InetAddress.getByName("localhost");
            Socket socket = new Socket(address,port);
            try {
            PrintWriter toSocket = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader fromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            toSocket.print("Hello from client "+ socket.getLocalSocketAddress());
            String line = fromSocket.readLine();
            System.out.println("Response from Server"+line);
            } catch (Exception e) {
                System.out.println("io excepton happen");
            }
           } catch (IOException e) {
            System.out.println("io excepton happen");
           }
        }

       };
    }
}
