import java.util.List;

public abstract class Player {

	public enum Type {
		HUMAN, COMPUTER
	}

	private String name = null;
	private Type type = null;
	private Hand hand = null;
	private Card card = null;
	private Object deck;

	public Player(final String name, Type type) {
		this.name = name;
		this.type = type;
	}

	public Player(final String name, Type type, Hand hand) {
		this.name = name;
		this.type = type;
		this.deck = deck;
	}

	public abstract Attribute chooseAttribute(Card card);
	
	public Card showCard() {
		return hand.getCard(0);
	}

	public Card giveCard() {
		return hand.getCard(0);
	}

	public void receiveCard(Card card) {
		hand.addToBottom(card);
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

	public String getName() {
		return name;
	}

	public Type getType() {
		return type;
	}
}
