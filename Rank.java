/**
 * This documents the ranks of cards.
 * Each enum has String description and an integer to represent
 * card value. We use 10 for face cards because the deck will
 * be used for the game BlackJack or 21.
 */


public enum Rank {
 ACE("Ace", 1), DEUCE("2", 2), THREE("3", 3), FOUR("4", 4),
 FIVE("5", 5), SIX("6", 6), SEVEN("7", 7), EIGHT("8", 8),
 NINE("9", 9), TEN("10", 10), JACK("Jack", 10), QUEEN("Queen", 10),
 KING("King", 10);
 
 //initiate String rankText and integer cardValue as final
 private final String rankText;
 private final int cardValue;
 
 /**
  * Constructor. Set values for rankText and cardValue.
  * @param rankText - description of card
  * @param cardValue - value of card
  */
 private Rank(String rankText, int cardValue){
  this.rankText = rankText;
  this.cardValue = cardValue;
 }
 
 /**
  * Returns description of card.
  * @return
  */
 public String getRankText(){
  return rankText;
 }
 
 /**
  * Returns the value of card.
  * @return
  */
 public int getCardValue(){
  return cardValue;
 }
}
