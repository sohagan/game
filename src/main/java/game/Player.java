

public class Player {

	public enum Type {
		HUMAN, COMPUTER
	}
	
	private String name = null;
	private Type type = null;
	private Deck deck = null;
	
	public Player(final String name, Type type) {
		this.name = name;
		this.type = type;
	}

	public Player(final String name, Type type, Deck deck) {
		this.name = name;
		this.type = type;
		this.deck = deck;
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public String getName() {
		return name;
	}

	public Type getType() {
		return type;
	}
}
