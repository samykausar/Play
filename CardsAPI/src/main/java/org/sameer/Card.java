
package org.sameer;


public class Card {
	
    public enum Suit { HEARTS, DIAMONDS, SPADES, CLUBS, JOKER }
    public enum Value { TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE }


    private Suit suit;
    private Value value;
    
    public Card(Suit suit, Value value) {
		super();
		this.suit = suit;
		this.value = value;
	}
	public Suit getSuit() {
		return suit;
	}
	public void setSuit(Suit suit) {
		this.suit = suit;
	}
	public Value getValue() {
		return value;
	}
	public void setValue(Value value) {
		this.value = value;
	}

	
}