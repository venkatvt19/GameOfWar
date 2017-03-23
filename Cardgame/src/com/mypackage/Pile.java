package com.mypackage;

public class Pile {
	private Card[] pile;
	private int front, end;

	public Pile() {
		this.pile = new Card[52];
		this.front = 0;
		this.end = 0;
	}

	public int getSize() {
		return this.end - this.front;
	}

	public void clear() {
		this.front = 0;
		this.end = 0;
	}

	public void addCard(Card c) {
		pile[end] = c;
		end++;
	}

	public void addCards(Pile p) {
		while (p.getSize() > 0) {
			addCard(p.nextCard());
		}
	}

	public Card nextCard() {
		if (front == end)
			return null; 
		Card c = pile[front];
		front++;
		return c;
	}
}
