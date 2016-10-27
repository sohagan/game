import java.util.List;


public class Hand {
	private List<Card> cards = null;

	public Hand() {}
	
	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	
	public Card getCard(int index) {
		return cards.get(index);
	}
}
