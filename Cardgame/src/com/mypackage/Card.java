package com.mypackage;

public class Card implements Comparable<Card> {

	private int rank;
	private int suit;

	public Card(int r, int s) {
		rank = r;
		suit = s;
	}

	public int getRank() {
		return rank;
	}

	public int getSuit() {
		return suit;
	}

	public int compareTo(Card card) {
		Card cardToBeCompared = (Card) card;
		int rankOfCard = this.getRank();
		int rankOfOtherCard = cardToBeCompared.getRank();
		if (rankOfCard == 1) {
			rankOfCard = 14; 
		}
		if (rankOfOtherCard == 1) {
			rankOfOtherCard = 14;
		}
		return rankOfCard - rankOfOtherCard;
	}

	public boolean equals(Object ob) {
		if (ob instanceof Card) {
			Card other = (Card) ob;
			return rank == other.rank && suit == other.suit;
		} else {
			return false;
		}
	}
}
