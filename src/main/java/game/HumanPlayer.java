import java.util.Scanner;


public class HumanPlayer extends Player {

	public HumanPlayer(final String name) {
		super(name, Player.Type.HUMAN);
	}
	
	public Attribute chooseAttribute(Card card) {
		System.out.println(super.getName() + " your card is : " + card.toString());
		System.out.println("Choose the attribute you want to play with : ");
		Scanner scan2 = new Scanner(System.in);
		String chosenAttributeName = scan2.nextLine();
		Attribute currentAttribute = card
				.getNameAttribute(chosenAttributeName);
		return currentAttribute;
	}
}
