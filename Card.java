import java.awt.image.BufferedImage;

/**
 * Card class that represents one of the 52 cards on a deck.
 * Each cards will have a rank, suit, value, and image.
 */

public class Card {
 //Instantiate variables
 private String rank; //rank of card
 private String suit; //suit of card
 private int value; //value of card
 private BufferedImage card; //image for card
 
 /**
  * Construct a card with a specific rank, suit, value, and image.
  * @param rank - rank of card
  * @param suit - suit of card
  * @param value - value of card
  * @param card - image of card
  */
 public Card(String rank, String suit, int value, BufferedImage card){
  this.rank = rank;
  this.suit = suit;
  this.value = value;
  this.card = card;
 }
 
 /**
  * Get the value of specific card.
  * @return - integer value
  */
 public int getValue(){
  return value;
 }
 
 /**
  * Get the image of specific card.
  * @return - BufferedImage card
  */
 public BufferedImage getCardImage(){
  return card;
 }
 
 public String getRank(){
  return rank; 
 }
 
 /**
  * Print out rank, suit, and value of card.
  */
 public String toString(){
  return rank + " of " + suit + " is " + value;
 }
}
