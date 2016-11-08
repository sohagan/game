
public class Computer extends Player {

	private Intelligence intelligence = null;

	public Computer(final String name) {
		super(name, Player.Type.COMPUTER);
	}

	public Computer(final String name, Intelligence intelligence) {
		super(name, Player.Type.COMPUTER);
		this.intelligence = intelligence;
	}

	public Attribute play(Card card) {
		return intelligence.select(card);
	}
	
	public Intelligence getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(Intelligence intelligence) {
		this.intelligence = intelligence;
	}

	@Override
	public Attribute chooseAttribute(Card card) {
		return intelligence.select(card);
	}

}
