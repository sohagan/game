import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class Deck {

	public enum Type {CARS, FOOTBALLERS}

	private List<Card> cards = null;
	
	private Deck() {}
	
	public static Deck instance(Deck.Type type, int size) {

		Deck deck = new Deck();
		if (type == Type.CARS) {
			deck.setCards(buildDeck(size));
			return deck;
		} else {
			throw new UnsupportedOperationException();
		}
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public void shuffle() {
		Collections.shuffle(cards);
	}

	private static List<Card> buildDeck(int size) {
		List<Card> deck = new ArrayList<Card>();
		
		List<String> attribNames = new ArrayList<>();
		attribNames.add("Price");
		attribNames.add("Speed");
		attribNames.add("CC");
		attribNames.add("Cool Value");

		for (int deckSize = 0; deckSize < size; deckSize++) {
			Map <String, Attribute>attributeMap = new HashMap<>();
			attribNames.forEach(item->{
				attributeMap.put(item, new Attribute(item, getRandomAttributeValue(1, 9)));
			});
			deck.add(new Card(attributeMap));
		}
		return deck;
	}

	private static int getRandomAttributeValue(int min, int max) {
		Random ran = new Random();
		return min + ran.nextInt(max - min + 1);		
	}
}
