package mainmain;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Sugma ");

        Panel Panel = new Panel();
        window.add(Panel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        Panel.startGameThread();

    }
}