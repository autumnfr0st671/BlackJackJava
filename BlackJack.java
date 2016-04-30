import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.System.*;


/**
 * Created by SilentWolf on 4/23/16.
 */
public class BlackJack extends JPanel {

    /** Initialize different Panels. **/
    JPanel titlePanel = new JPanel();
    JPanel playerPanel = new JPanel();
    JPanel winLosePanel = new JPanel();
    JPanel dealerPanel = new JPanel();
    JPanel buttonPanel = new JPanel();

    /** Title Panel components. **/
    JLabel titleLabel = new JLabel("Welcome to BlackJack!");

    /** Button Panel components. **/
    JButton dealButton = new JButton();
    JButton hitButton = new JButton();
    JButton standButton = new JButton();

    /** Win Lose Panel components. **/
    JLabel winLose = new JLabel();

    /** Initialize Deck and boolean for game. **/
    Deck deck = new Deck();
    boolean endGame = true;

    /** Player components. **/
    ArrayList<Card> playerHand = new ArrayList<Card>();
    ArrayList<JLabel> playerLabel = new ArrayList<JLabel>();
    JLabel playerScore = new JLabel();
    int pScore = 0;

    /** Betting components. **/
    //Player betting components
    JLabel playerMoney = new JLabel();
    JPanel playerBetPanel = new JPanel();
    int pMoney = 500;
    int[] moneyArr = {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000};
    JComboBox moneyBox = new JComboBox();
    int playerBet = 0;
    JButton betButton = new JButton();



    //Dealer betting components.
    JPanel dealerBetPanel = new JPanel();
    JLabel dealerMoney = new JLabel();
    int dMoney = 1000;

    boolean haveMoney = true;

    /** Dealer components. **/
    ArrayList<Card> dealerHand = new ArrayList<Card>();
    ArrayList<JLabel> dealerLabel = new ArrayList<JLabel>();
    JLabel dealerScore = new JLabel();
    JLabel backCard;

    int dScore = 0;

    public BlackJack() throws IOException {
        /****************************************************/
        /** Title Panel **/
        /****************************************************/
        titleLabel.setFont(new Font("Garamond", Font.PLAIN, 40));
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);
        titlePanel.setBackground(new Color(53, 56, 64));

        /****************************************************/
        /** Button Panel **/
        /****************************************************/
        dealButton.setText("  DEAL");
        dealButton.addActionListener(new dealButton());
        buttonPanel.add(dealButton);
        dealButton.setEnabled(false);

        hitButton.setText("  HIT");
        hitButton.addActionListener(new hitButton());
        buttonPanel.add(hitButton);
        hitButton.setEnabled(false);

        standButton.setText("  STAND");
        standButton.addActionListener(new standButton());
        buttonPanel.add(standButton);
        standButton.setEnabled(false);

        buttonPanel.setSize(new Dimension(this.getWidth(), 40));
        buttonPanel.setBackground(new Color(53, 56, 64));

        /***************************************************/
        /** Betting components **/
        /***************************************************/
        //Player components.
        /** Add choices to combobox via for loop. **/
        for (int i =0; i < moneyArr.length; i++){
            moneyBox.addItem(moneyArr[i]);
        }

        playerMoney.setForeground(Color.WHITE);
        playerMoney.setFont(new Font("Garamond", Font.TRUETYPE_FONT, 18));
        playerMoney.setText("Your Money: " + pMoney);//Display player money
        playerMoney.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(0, 153, 153),
                2), BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        /** Set up bet button. **/
        betButton.setText("  Bet");
        betButton.addActionListener(new betButton());
        playerBetPanel.add(betButton);
        playerBetPanel.add(playerMoney);
        playerBetPanel.add(moneyBox);
        playerBetPanel.setPreferredSize(new Dimension(20, 5));
        playerBetPanel.setBackground(new Color(53, 56, 64));


        //Dealer components.
        dealerMoney.setFont(new Font("Garamond", Font.TRUETYPE_FONT, 18));
        dealerMoney.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(0, 153, 153),
                2), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        dealerMoney.setForeground(Color.WHITE);
        dealerBetPanel.setBackground(new Color(53, 56, 64));
        dealerMoney.setText("Dealer Money: " + dMoney); //Display dealer money
        dealerBetPanel.add(dealerMoney);
        dealerPanel.add(dealerBetPanel);


        /****************************************************/
        /** Player Panel **/
        /****************************************************/
        playerScore.setText("Player Score: " + pScore);
        playerScore.setForeground(new Color(0, 153, 153));
        playerScore.setFont(new Font("Arial", Font.PLAIN, 17));
        playerPanel.add(playerScore, BorderLayout.PAGE_END);
        playerPanel.setBackground(new Color(53, 56, 64));

        /****************************************************/
        /** Dealer Panel **/
        /****************************************************/
        backCard = new JLabel(new ImageIcon("backCard.png"));
        dealerScore.setForeground(new Color(0, 153, 153));
        dealerScore.setFont(new Font("Arial",Font.PLAIN, 17));
        dealerPanel.setBackground(new Color(53, 56, 64));
        dealerPanel.add(dealerScore, BorderLayout.PAGE_END);


        /****************************************************/
        /** Win/Lose Box **/
        /****************************************************/
        winLose.setFont(new Font("Garamond", Font.PLAIN, 50));
        winLose.setForeground(new Color(0, 153, 153));
        winLosePanel.setBackground(new Color(53, 56, 64));
        winLosePanel.add(winLose);


        /****************************************************/
        /** Add components to main Panel. **/
        /****************************************************/
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(titlePanel);
        add(playerBetPanel);
        add(playerPanel);
        add(winLosePanel);
        add(buttonPanel);
        add(dealerPanel);


    }//end of constructor class

    public void display(){
        /*********************************************************/
        /** JFrame class to display JFrame and add mainPanel. **/
        /*********************************************************/
        JFrame myFrame = new JFrame();
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setContentPane(this);
        myFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        myFrame.setVisible(true);
    }//end of display class

    /** Resets the game. **/
    public void newGame(){
        pScore = 0; //Set playerScore back to 0
        /** Clear the playerPanel by removing  all cards(JLabels) in it. **/
        for (int i = 0; i < playerHand.size(); i++){
            playerPanel.remove(playerLabel.get(i));
        }
        //Display the score 0.
        playerScore.setText("Player Score: " + pScore);
        /** Use ArrayList method clear() to remove all elements inside
         * ArrayList. (playerHand and playerLabel)
         */
        playerHand.clear();
        playerLabel.clear();
        //Update the Panel
        playerPanel.updateUI();

        //Set the winLose label to blank.
        winLose.setText("");

        dScore = 0; //Set dealerScore to 0
        /** Clear dealerPanel by removing  all cards(JLabels) in it. **/
        for (int j = 0; j < dealerHand.size(); j++){
            dealerPanel.remove(dealerLabel.get(j));
        }
        dealerPanel.remove(backCard); //Remove the backCard if it exists
        //Display blank for score.
        dealerScore.setText("");
        /** Use ArrayList method clear() to remove all elements inside
         * ArrayList. (dealerHand and dealerLabel)
         */
        try {
            deck = new Deck();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        dealerHand.clear();
        dealerLabel.clear();
        //update the panel
        dealerPanel.updateUI();
        //Set endGame and haveMoney boolean to true to be able to use JButtons again.
        endGame = true;
        dealButton.setEnabled(false);
        hitButton.setEnabled(false);
        standButton.setEnabled(false);
    }//end of newGame() method

    public void gameOver(boolean e){
        if (!e){
            this.removeAll();
            this.updateUI();

            /** Exit Button **/
            JButton exitButton = new JButton("EXIT");
            JButton newGameButton = new JButton("NEW GAME");
            JPanel exitPanel = new JPanel();
            exitPanel.add(newGameButton);
            exitPanel.add(exitButton);
            exitPanel.setBackground(new Color(53, 56, 64));

            newGameButton.addActionListener(new newGameButton());
            exitButton.addActionListener(new exitButton());


            this.add(winLosePanel, BorderLayout.CENTER);
            this.add(exitPanel);
            winLose.setText("Game Over!");
            winLose.setFont(new Font("Garamonod", Font.BOLD, 120));
            this.updateUI();
            }
        }





    /*********************************************************/
    /** Button functions and code for each **/
    /*********************************************************/
    class dealButton implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            hitButton.setEnabled(true);
            standButton.setEnabled(true);
            if (endGame == false){
                betButton.setEnabled(true);
                newGame();
            }
            if (playerHand.size() == 0 && playerBet > 0 && pMoney >= 0) {
                for (int i = 0; i < 2; i++) {
                    playerHand.add(deck.deal());
                    dealerHand.add(deck.deal());
                    /** Check for Ace **/
                    if (playerHand.get(i).getRank().equals("Ace") && pScore + 10 <= 21){
                        pScore += 10;
                    }


                    if (dealerHand.get(i).getRank().equals("Ace") && dScore + 10 <= 21) {
                        dScore += 10;
                    }
                    playerLabel.add(new JLabel(new ImageIcon(playerHand.get(i).getCardImage())));
                    dealerLabel.add(new JLabel(new ImageIcon(dealerHand.get(i).getCardImage())));
                    pScore += playerHand.get(i).getValue();
                    dScore += dealerHand.get(i).getValue();
                }
                if (playerHand.get(0).getRank().equals("Ace") && playerHand.get(1).getRank().equals("Ace")){
                    pScore = 12;
                }
                if (dealerHand.get(0).getRank().equals("Ace") && dealerHand.get(1).getRank().equals("Ace")){
                    dScore = 12;
                }

                playerPanel.add(playerLabel.get(0));
                playerPanel.add(playerLabel.get(1));
                dealerPanel.add(dealerLabel.get(0));
                dealerPanel.add(backCard);
                playerScore.setText("Player Score: " + pScore);

                if (pScore == 21) {
                    playerBet *= 2.5;
                    dMoney -= playerBet;
                    pMoney += playerBet;
                    winLose.setText(" Winner! Winner! Chicken Dinner! You won $" + playerBet);
                    playerMoney.setText("Player Money: " + pMoney);
                    playerBet = 0;
                    endGame = false;
                } else if (dScore == 21) {
                    dealerPanel.remove(backCard);
                    dealerPanel.add(dealerLabel.get(1));
                    dealerScore.setText("Dealer Score: " + dScore);
                    dealerPanel.updateUI();
                    dMoney += playerBet;
                    dealerMoney.setText("Dealer Money: " + dMoney);
                    winLose.setText("BlackJack! Dealer Wins!");
                    playerBet = 0;
                    endGame = false;
                }
                if (deck.deckSize() == 0){
                    try {
                        deck = new Deck();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
                playerPanel.updateUI();
                dealerPanel.updateUI();
            }

        }
    }

    class hitButton implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if (playerHand.size() > 0 && endGame == true) {
                boolean ace = false;
                playerHand.add(deck.deal());
                playerLabel.add(new JLabel(new ImageIcon(playerHand.get(playerHand.size() - 1).getCardImage())));
                playerPanel.add(playerLabel.get(playerLabel.size() - 1));
                pScore = 0;
                for (int i = 0; i < playerHand.size(); i++){
                    int value = playerHand.get(i).getValue();
                    if (value == 1){
                        ace = true;
                    }
                    pScore += value;
                }

                if (ace == true && pScore + 10 <= 21){
                    pScore += 10;
                }
                else if (pScore > 21) {

                    dealerPanel.remove(backCard);
                    dealerPanel.add(dealerLabel.get(1));
                    dealerScore.setText("Dealer Score: " + dScore);
                    dMoney += playerBet;
                    winLose.setText("You Lose $" + playerBet + "! Dealer Wins!");
                    dealerMoney.setText("Dealer Money: " + dMoney);
                    endGame = false;
                    playerBet = 0;
                }

                playerScore.setText("Player Score: " + pScore);

                if (deck.deckSize() == 0) {
                    try {
                        deck = new Deck();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }//end of hitButton
    }

    class standButton implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if (playerHand.size() > 0 && endGame == true) {
                dealerPanel.remove(backCard);
                dealerPanel.add(dealerLabel.get(1));
                boolean dealerTurn = true;
                while (dealerTurn && endGame) {
                    if (dScore < 17) {
                        dealerHand.add(deck.deal());
                        dealerLabel.add(new JLabel(new ImageIcon(dealerHand.get(dealerHand.size() - 1).getCardImage())));
                        dealerPanel.add(dealerLabel.get(dealerLabel.size() - 1));
                        dScore += dealerHand.get(dealerHand.size() - 1).getValue();
                    } else if (dScore >= 17) {
                        dealerTurn = false;
                    }
                    if (deck.deckSize() == 0) {
                        try {
                            deck = new Deck();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
                dealerScore.setText("Dealer Score: " + dScore);
                while (endGame) {
                    if (dScore > 21) {
                        dMoney -= playerBet;
                        pMoney += playerBet * 2;
                        playerMoney.setText("Player Money: " + pMoney);
                        dealerMoney.setText("Dealer Money: " + dMoney);

                        winLose.setText("Dealer Busts! You Win $" + playerBet);
                        endGame = false;
                        playerBet = 0;
                    } else if (dScore > pScore || pScore < dScore) {
                        dMoney += playerBet;
                        playerMoney.setText("Player Money: " + pMoney);
                        dealerMoney.setText("Dealer Money: " + dMoney);

                        winLose.setText("Dealer Wins! You Lose $" + playerBet + "!");
                        endGame = false;
                        playerBet = 0;
                    } else if (dScore == pScore) {
                        pMoney += playerBet;
                        playerMoney.setText("Player Money: " + pMoney);
                        dealerMoney.setText("Dealer Money: " + dMoney);

                        winLose.setText("Draw!");
                        endGame = false;
                        playerBet = 0;

                    } else if (pScore > dScore || dScore < pScore) {
                        dMoney -= playerBet;
                        pMoney += playerBet * 2;
                        playerMoney.setText("Player Money: " + pMoney);
                        dealerMoney.setText("Dealer Money: " + dMoney);

                        winLose.setText("You won $" + playerBet + "!");
                        endGame = false;
                        playerBet = 0;

                    }
                }
            }
        }//end of standButton ActionListener class
    }

    class betButton implements ActionListener{
        public void actionPerformed(ActionEvent e){

            playerBet =  (Integer) moneyBox.getSelectedItem();
            if (playerBet > pMoney){
                playerMoney.setText("Insufficient Funds!");
                if (playerBet == 100 || pMoney == 0){
                    haveMoney = false;
                }
            }
            else if (playerBet > dMoney || (playerBet * 1.5) > dMoney){
                playerMoney.setText("Dealer has insufficient funds!");
                if (playerBet == 100){
                    haveMoney = false;
                }
            }
            else {
                dealButton.setEnabled(true);
                pMoney -= playerBet;
                betButton.setEnabled(false);
                playerMoney.setText("Player Money: " + pMoney + "   Player Bet: " + playerBet);
            }
            gameOver(haveMoney);




        }//end of betButton ActionListener class
    }

    class exitButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }//end of exitButton ActionListener class
    }

    class newGameButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            removeAll();
            dMoney = 10000;
            pMoney = 10000;
            haveMoney = true;
            endGame = true;
            add(titlePanel);
            add(playerBetPanel);
            add(playerPanel);
            add(winLosePanel);
            winLose.setText("NEW GAME");
            winLose.setFont(new Font("Garamond", Font.PLAIN, 50));
            playerMoney.setText("Player Money: " + pMoney);
            dealerMoney.setText("Dealer Money: " + dMoney);
            add(buttonPanel);
            add(dealerPanel);
            updateUI();
        }
    }
}