
/**
 * 
 * @author Lo
 *
 */

public class Attribute implements Comparable<Attribute> {

	private String name = null;
	private int value = 0;
	

	public Attribute(final String name, final int value) {
		if (value < 0 || value > 9) {
			throw new IllegalArgumentException("value should be between 0 and 9 inclusive");
		}
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public int getValue() {
		return value;
	}
	
	@Override
	public int compareTo(Attribute attribute) {
		if (this.value == attribute.value) {
			return 0;
		} else {
			return this.value > attribute.value ? 1 : -1;
		}
	}

	@Override
	public String toString() {
		return "Attribute [name=" + name + ", value=" + value + "]";
	}
}