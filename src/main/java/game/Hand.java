import java.util.List;

public class Hand {
	private List<Card> cards = null;

	public Hand() {
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	/**
	 * return card from deck. The card stays in the deck
	 * 
	 * @param index
	 * @return
	 */
	public Card getCard(int index) {
		return cards.get(index);
	}

	/**
	 * remove a card from the deck and pass it back
	 * to the caller.
	 * 
	 * @param index
	 * @return
	 */
	public Card removeCard(int index) {
		Card card = cards.get(index);
		cards.remove(0);
		return card;
	}

	/**
	 * swap the top card of our deck to the 
	 * bottom of the deck. 
	 */
	public void swapToBottom() {
		cards.add(cards.remove(0));
	}
	
	public void addToBottom(Card card) {
		cards.add(card);
	}
	
}
