import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

public class UDP_Server {
    public static void main(String[] args) {

        DatagramPacket dpac;
        DatagramSocket dsco;
        System.out.println("Server is up");

        try {
            // Initialize DatagramSocket
            dsco = new DatagramSocket();

            while (true) {

                System.out.println("Sending......");
                Thread.sleep(1000);
                String time = new Date().toString();
                byte[] b = time.getBytes();

                // Create and send the packet
                dpac = new DatagramPacket(b, b.length, InetAddress.getByName("LocalHost"), 5000);
                dsco.send(dpac);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
