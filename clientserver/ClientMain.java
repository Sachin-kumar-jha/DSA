package clientserver;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

public class ClientMain {
    public static void main(String[] args) {
        try {
            Socket s= new Socket("localhost",8080);
            InputStream inStream= s.getInputStream();
            BufferedReader bf=new BufferedReader(new InputStreamReader(inStream));
            System.out.println(bf.readLine());
            s.close();
            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
