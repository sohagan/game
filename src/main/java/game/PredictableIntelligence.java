
public class PredictableIntelligence implements Intelligence {

	@Override
	public Attribute select(Card card) {
		return card.getFirstAttribute();
	}

}
