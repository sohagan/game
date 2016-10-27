import java.util.List;
import java.util.Map;

public class Card {

	private Map <String, Attribute> attributes = null;
	
	public Card(Map<String, Attribute> attributes) {
		this.attributes = attributes;
	}

	@Override
	public String toString() {
		return "Card [attributes=" + attributes + "]";
	}
}
