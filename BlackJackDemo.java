import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class BlackJackDemo extends JPanel{
    JButton newGame = new JButton();
    JButton rules = new JButton();
    ImageIcon image = new ImageIcon("menuBackGround.jpg");
    JLabel background = new JLabel();


    public BlackJackDemo(){
        background.setBounds(0, 2, image.getIconWidth(), image.getIconHeight());
        background.setIcon(image);

        newGame.setText("PLAY");

        rules.setText("RULES");

        newGame.addActionListener(new newGame());
        /** Set up main panel. **/
        setBackground(Color.WHITE);
        add(background);
        add(newGame);
        add(rules);
    }

    /**

    public void display(){
        JFrame frame = new JFrame();
        frame.setSize(500, 500);
        setBackground(Color.WHITE);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(this);
        frame.setVisible(true);
    }
     */

    class newGame implements ActionListener{
        public void actionPerformed(ActionEvent e){
            BlackJack game = null;
            try {
                game = new BlackJack();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            game.display();
            
        }
    }
}