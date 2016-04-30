import javax.swing.*;

/**
 * Created by SilentWolf on 4/28/16.
 */
public class blackJackGame {
    public static void main(String[] args){
        BlackJackDemo game = new BlackJackDemo();
        JFrame frame = new JFrame();

        frame.setSize(500, 500);
        frame.add(game);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
