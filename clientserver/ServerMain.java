package clientserver;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
public static void main(String[] args) {
    try (ServerSocket sc = new ServerSocket(8080)) {
       Socket s=sc.accept();
       OutputStream ot=s.getOutputStream();
       PrintStream ps=new PrintStream(ot);
       ps.print("Hello Client");
       sc.close();
       s.close();
       ps.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    
}