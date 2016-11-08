import java.util.List;
import java.util.Map;

public class Card {

	private Map <String, Attribute> attributes = null;
	
	public Card(Map<String, Attribute> attributes) {
		this.attributes = attributes;
	}

	public Attribute getFirstAttribute() {
		return attributes.entrySet().iterator().next().getValue();
	}
	
	public Attribute getAttribute(int index) {
		Attribute attArray[] = (Attribute[])attributes.values().toArray();
		return attArray[index];
	}
	
	public Attribute getNameAttribute(String attributeName) {
		return  attributes.get(attributeName);
	}
	
	public int getNumberOfAttributes() {
		return attributes.keySet().size();
	}
	
	@Override
	public String toString() {
		return "Card [ attributes = " + attributes + " ]";
	}
}