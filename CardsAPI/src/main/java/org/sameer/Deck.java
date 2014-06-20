package org.sameer;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	
	private ArrayList<Card> cards;
	private boolean havingJokers = false;
	private int numberOfJokers = 2;
	private int numberOfDecks = 1;

	public Deck(){
		this(false,1);
	}
	public Deck(boolean havingJokers){
		this(havingJokers,1);		
	}
	public Deck(int numberOfDeck){
		this(false,numberOfDeck);		
	}
	public Deck(boolean havingJokers, int numberOfDeck){
		this(havingJokers,2,numberOfDeck);		
	}
	public Deck(boolean havingJokers, int numberOfJokers, int numberOfDecks){
		this.setHavingJokers(havingJokers);
		this.setNumberOfJokers(numberOfJokers);
		this.setNumberOfDecks(numberOfDecks);
		cards = new ArrayList<Card>();
		for(int i=1; i<=numberOfDecks; i++)
		for(Card.Suit suit : Card.Suit.values()){
			if(suit!=Card.Suit.JOKER)
			{
				for(Card.Value value : Card.Value.values()){
					cards.add(new Card(suit, value));
				}
			}
			if(havingJokers){
				for(int j=1; j<=numberOfJokers; j++)
				cards.add(new Card(Card.Suit.JOKER, null));
			}
		}
	}
	public ArrayList<Card> getCards() {
		return cards;
	}
	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}

	public boolean isHavingJokers() {
		return havingJokers;
	}
	public void setHavingJokers(boolean havingJokers) {
		this.havingJokers = havingJokers;
	}
	public int getNumberOfJokers() {
		return numberOfJokers;
	}
	public void setNumberOfJokers(int numberOfJokers) {
		this.numberOfJokers = numberOfJokers;
	}
	public int getNumberOfDecks() {
		return numberOfDecks;
	}
	public void setNumberOfDecks(int numberOfDecks) {
		this.numberOfDecks = numberOfDecks;
	}
	public void shuffle(){
		Collections.shuffle(this.getCards());
	}
}