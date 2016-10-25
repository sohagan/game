
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestSetup {

	@Test
	public void testDeckSize() {
		Deck deck = Deck.instance(Deck.Type.CARS, 5);
		assertEquals(deck.getCards().size(), 5);
	}
	
	@Test
	public void testCardAttribute() {
		Deck deck = Deck.instance(Deck.Type.CARS, 5);
		assertEquals(deck.getCards().size(), 5);
	}

}
