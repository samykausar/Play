package org.sameer;

import java.util.Comparator;

public class DefaultCardComparator implements Comparator<Card> {

	public int compare(Card c1, Card c2) {
		if (c1.getSuit() == c2.getSuit()){
			return c1.getValue().compareTo(c2.getValue());
		} else
			try {
				throw new InvalidCardComparisonException();
			} catch (InvalidCardComparisonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return 0;
	}

}
