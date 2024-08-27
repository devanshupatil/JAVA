package Desplay;

import javax.swing.*;
import java.awt.*;

public class LargeTextGUI {
    public static void main(String[] args) {
        System.out.println("█▀█ █ █▀▀   ▀█▀ █▀▀ ▀▄▀ ▀█▀");
        System.out.println("█▀▀ █ █▄█   ░█░ ██▄ █░█ ░█░");

        JFrame frame = new JFrame("Large Text");
        JLabel label = new JLabel("Devanshu");
        label.setFont(new Font("Arial", Font.BOLD, 48));
        frame.add(label);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}