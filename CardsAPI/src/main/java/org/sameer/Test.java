package org.sameer;

import java.util.Collections;

public class Test {
	public static void main(String[] args) {
	Deck deck = new Deck();
	for(Card card : deck.getCards()){
		System.out.println(card.getValue()+" of "+card.getSuit());
	}
	deck.shuffle();
	for(Card card : deck.getCards()){
		System.out.println(card.getValue()+" of "+card.getSuit());
	}
	Collections.sort(deck.getCards(), new DefaultCardComparator());
	for(Card card : deck.getCards()){
		System.out.println(card.getValue()+" of "+card.getSuit());
	}
	}
}