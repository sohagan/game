import java.util.Random;


public class RandomIntelligence implements Intelligence {

	@Override
	public Attribute select(Card card) {
		return card.getAttribute(getRandomIndex(card));
	}
	
	private int getRandomIndex(Card card) {
		int min = 0;
		int max = card.getNumberOfAttributes();
		Random ran = new Random();
		return min + ran.nextInt(max - min + 1);		
	}
}
