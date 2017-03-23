package com.mypackage;

public class Game {
	private Player p1;
	private Player p2;
	public void play() {
		CardDeck cd = new CardDeck();
		cd.shuffle();
		p1 = new Player("X");
		p2 = new Player("Y");
		while (cd.getSize() >= 2) {
			p1.collectCard(cd.deal());
			p2.collectCard(cd.deal());
		}
		p1.useWonPile();
		p2.useWonPile();
		Pile down = new Pile(); 
		for (int t = 1; t <= 100; t++) {
			if (!enoughCards(1)) {
				break;
			}
		Card c1 = p1.playCard();
		Card c2 = p2.playCard();
		if (c1.compareTo(c2) > 0) {
			p1.collectCard(c1);
			p1.collectCard(c2);
		} else if (c1.compareTo(c2) < 0) {
			p2.collectCard(c1);
			p2.collectCard(c2);
		} else {
			down.clear();
			down.addCard(c1);
			down.addCard(c2);
			boolean done = false;
			do {
				int num = c1.getRank();
				if (!enoughCards(num))
					break ;
				for (int m = 1; m <= num; m++) {
					c1 = p1.playCard();
					c2 = p2.playCard();
					down.addCard(c1);
					down.addCard(c2);
				}
				if (c1.compareTo(c2) > 0) {
					p1.collectCards(down);
					done = true;
				} else if (c1.compareTo(c2) < 0) {
					p2.collectCards(down);
					done = true;
				}
			} while (!done);
		} 
	}
	}

	public boolean enoughCards(int n) {
		if (p1.numCards() < n || p2.numCards() < n) {
			return false;
		}
		return true;
	}

	public Player getWinner() {
		if (p1.numCards() > p2.numCards())
			return p1;
		else if (p2.numCards() > p1.numCards())
			return p2;
		else
			return null;
	}

}