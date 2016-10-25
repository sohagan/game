
public class Computer extends Player {

	private Intelligence intelligence = null;
	
	public Computer(final String name) {
		super(name, Player.Type.COMPUTER);
	}

	public Attribute play(Card card) {
		return intelligence.select(card);
	}
}
