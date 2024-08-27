package Networking.ClipBoard_Sync;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

        String previousText = ""; // Track the previously copied text

        try {

            ServerSocket ss = new ServerSocket(5000);
            System.out.println("Wetting for client!");

            Socket server = ss.accept(); //
            System.out.println("Server is connected to send");

            // Send data from server to client
            PrintWriter pw = new PrintWriter(server.getOutputStream());

            while (true) {

                try {
                    // Get the clipboard contents as a Transferable object
                    Transferable contents = clipboard.getContents(null);

                    // Check if the clipboard contains text data
                    if (contents != null && contents.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                        // Retrieve the data from the clipboard as a String
                        String currentText = (String) contents.getTransferData(DataFlavor.stringFlavor);

                        // Check if the text has changed
                        if (!currentText.equals(previousText)) {

                            pw.println(currentText);
                            pw.flush();
                            System.out.println("Clipboard updated: " + currentText);
                            previousText = currentText; // Update the previously copied text
                        }
                    }

                    // Sleep for a short period before checking again
                    Thread.sleep(1000); // Check every 1 second

                } catch (UnsupportedFlavorException | IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}
