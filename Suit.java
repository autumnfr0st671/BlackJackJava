/**
 * This documents suits of cards: Clubs, Diamond, Hearts, Spades.
 * Each enum has a String for representation.
 */
public enum Suit {
 CLUBS("Clubs"), DIAMONDS("Diamonds"), HEARTS("Hearts"), SPADES("Spades");
 
 private final String suitText; //String used for each suit.
 
 
 /**
  * Constructor. Enum constructors have to be private.
  * @param suitText - description for suit of card
  */
 private Suit(String suitText){
  this.suitText = suitText;
 }
 
 /**
  * Returns description of suit.
  * @return
  */
 public String getSuitText(){
  return suitText;
 }
}
