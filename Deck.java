import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javax.imageio.ImageIO;

/**
 * Deck class that represents a deck of playing cards. 
 * An ArrayList will be use to represent the deck of 
 * object cards. ArrayList is used due to its methods.
 */
public class Deck { 
 //Initialize variables
 private ArrayList<Card> deck; //ArrayList of object cards
 
 /**
  * Construct a deck of cards and set values for each card.
  * @throws IOException - for BufferedImage
  */
 public Deck() throws IOException{
  deck = new ArrayList<Card>();
  //BufferedImage method subImage will be used to divide allCards image to 52 images
  BufferedImage allCards = ImageIO.read(new File("allcards.png"));
  BufferedImage tempCardImage; //temporary storage for image to assign to each card 
  
  //Image dimensions is 1027 x 615 pixels
  final int height = 123; // 615/4 = 123 height of each card
  final int width = 79; //1027/13 = 79 width of each card
  
  /**
   * Use two for loops to assign rank, suit, value, and images for all card objects
   * inside ArrayList deck.
   */
    for (int i = 0; i < 4; i++){
   //Go through each enum and get String description to assign it to suit value
      String suit = Suit.values()[i].getSuitText();
      for (int j = 0; j < 13; j++){
    //Enumerate through rank enum and get String description
       String rank = Rank.values()[j].getRankText();
       //Enumerate through rank enum and get int value of card
       int rankValue = Rank.values()[j].getCardValue();
       
       //go through allCards image via subImage method and assign to tempCardImage
       tempCardImage = allCards.getSubimage(
         j * width, //starting x-coordinate for subimage/crop
      i * height, //starting y-coordinate for subimage/crop
      width,  //width of image
      height); //height of image
       //create a temp card object that will be stored in deck ArrayList
       Card tempCard = new Card(rank, suit, rankValue, tempCardImage);
       deck.add(tempCard); //add tempCard images to deck
      }
     }
 }
 /**
  * Shuffle the deck through Collections.shuffle method.
  */
 public void shuffle(){
  Collections.shuffle(deck);//method i found online that shuffles a list
 }
 /**
  * Test to make sure that each card has correct
  * suit, rank, and value.
  */
 public void displayDeck(){
  //print out each card since each card has a toString() method
  for (int i = 0; i < deck.size(); i++){
   System.out.println(deck.get(i).toString());
  }
 }
 
 /**
  * Deal cards by removing from the top of the deck.
  * Subtracting 1 from size of deck.
  */
 public Card deal(){
  this.shuffle();
  return deck.remove(0);
 }
 
 /**
  * Return the size of the deck.
  */
 public int deckSize(){
  return deck.size();
 }
 public static void main(String[] args) throws IOException{
  Deck d = new Deck();
  d.shuffle();
  d.displayDeck();
 }
}
