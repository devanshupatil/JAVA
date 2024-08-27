import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.io.IOException;

public class UDP_Client {

    public static void main(String[] args) {

        DatagramPacket dpac;
        DatagramSocket dsco;
        byte[] b = new byte[64];

        try {
            // Initialize DatagramSocket only once, outside the loop

            while (true) {
                // Initialize DatagramPacket
                dpac = new DatagramPacket(b, b.length);
                dsco = new DatagramSocket(5000);

                // Receive data into the DatagramPacket
                dsco.receive(dpac);

                String data = new String(dpac.getData());
                System.out.println("We received: " + data);

                // Convert the received data to a string and print it
                String receivedData = new String(dpac.getData(), 0, dpac.getLength());
                System.out.println("Received: " + receivedData);
            }

        } catch (IOException e) {

            System.out.println(e);
        }

    }
}
