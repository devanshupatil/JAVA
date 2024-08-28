
package Networking.ClipBoard_Sync;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {

        try {

            Socket client;
            try {

                client = new Socket("localhost", 5000);
                System.out.println("Client is connected to read");

                // Read data from server
                BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));

                while (true) {

                    String data = br.readLine();

                    System.out.println("Data from server: " + data);

                }

            } catch (Exception e) {

                System.out.println(e);
            }

        } catch (Exception e) {

            System.out.println(e);
        }

    }

}