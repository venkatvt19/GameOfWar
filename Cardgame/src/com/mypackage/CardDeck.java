package com.mypackage;

public class CardDeck {
	private Card[] deck;
	private int numCards;

	public CardDeck() {
		this.deck = new Card[52];
		fill();
	}

	void shuffle() {
		for (int next = 0; next < numCards - 1; next++) {
			int r = myRandom(next, numCards - 1);
			Card temp = deck[next];
			deck[next] = deck[r];
			deck[r] = temp;
		}
	}

	public Card deal() {
		if (numCards == 0)
			return null;
		numCards--;
		return deck[numCards];
	}

	public int getSize() {
		return numCards;
	}

	private void fill() {
		int index = 0;
		for (int r = 1; r <= 13; r++)
			for (int s = 1; s <= 4; s++) {
				deck[index] = new Card(r, s);
				index++;
			}
		numCards = 52;
	}

	private static int myRandom(int low, int high) {
		return (int) ((high + 1 - low) * Math.random() + low);
	}
}
