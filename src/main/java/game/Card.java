import java.util.Collection;
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
		Attribute attArray[] = attributes.values().toArray(new Attribute[0]);
		return attArray[index];
	}
	
	public Attribute getNameAttribute(String attributeName) {
		return  attributes.get(attributeName.toLowerCase());
	}
	
	public int getNumberOfAttributes() {
		return attributes.keySet().size();
	}

	public void showAttributes() {
		for(Map.Entry entry : attributes.entrySet()){
			System.out.println(entry);
		        //System.out.println(entry.getKey() + "=[" + entry.getValue() + "]");
		}
	}
	@Override
	public String toString() {
		return "Card [ attributes = " + attributes + " ]";
	}
}