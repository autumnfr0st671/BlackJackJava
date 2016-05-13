import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class Menu extends JPanel{
    JButton newGame = new JButton();
    JButton exit = new JButton();

    ImageIcon image = new ImageIcon("menuBackGround.jpg");
    JLabel background = new JLabel();


    public Menu(){
        background.setBounds(0, 2, image.getIconWidth(), image.getIconHeight());
        background.setIcon(image);

        /** NewGame button that launches the game. **/
        newGame.setText("NEW GAME");
        newGame.addActionListener(new newGame());

        /** Exit Button. **/
        exit.setText("EXIT");
        exit.addActionListener(new exit());


        /** Set up main panel. **/
        setBackground(Color.WHITE);
        add(background);
        add(newGame);
        add(exit);
    }

    /** Launches blackJack game. **/
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

    /** Exit via System.exit(0). **/
    class exit implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    class mainMenu implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            removeAll();
            updateUI();

            background.setBounds(0, 2, image.getIconWidth(), image.getIconHeight());
            background.setIcon(image);

            /** NewGame button that launches the game. **/
            newGame.setText("NEW GAME");
            newGame.addActionListener(new newGame());

            /** Exit Button. **/
            exit.setText("EXIT");
            exit.addActionListener(new exit());


            /** Set up main panel. **/
            setBackground(Color.WHITE);
            add(background);
            add(newGame);
            add(exit);
            updateUI();
        }
    }
}