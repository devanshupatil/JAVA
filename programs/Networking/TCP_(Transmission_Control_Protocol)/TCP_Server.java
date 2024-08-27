import java.net.*;
import java.util.Scanner;
import java.io.*;
//import java.util.*;

/**
 * Server
 */
public class TCP_Server {

    public static void main(String[] args) {

        try {

            ServerSocket ss = new ServerSocket(5000);
            System.out.println("Wetting for client!" + ss.getLocalPort());

            Socket server = ss.accept(); //
            System.out.println("Server is connected to send");

            // Send data from server to client
            Scanner sc = new Scanner(System.in);
            PrintWriter pw = new PrintWriter(server.getOutputStream());

            while (true) {

                System.out.print("Enter data: ");
                String data = sc.nextLine();

                pw.println(data);
                pw.flush();

            }

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}