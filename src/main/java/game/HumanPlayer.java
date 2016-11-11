import java.util.Scanner;

public class HumanPlayer extends Player {

	public HumanPlayer(final String name) {
		super(name, Player.Type.HUMAN);
	}

	public Attribute chooseAttribute(Card card) {
		System.out.println(super.getName() + " your card is : ");
		card.showAttributes();
		System.out.println("Choose the attribute you want to play with : ");
		Scanner scan2 = new Scanner(System.in);
		String chosenAttributeName = scan2.nextLine();
		Attribute currentAttribute = null;

		boolean validInput = false;
		while (!validInput) {
			try {
				currentAttribute = card.getNameAttribute(chosenAttributeName);
				if (currentAttribute == null) {
					System.out
							.println("Attribute you entered unknown. Please re-enter");
					chosenAttributeName = scan2.nextLine();
				} else {
					validInput = true;
				}
			} catch (Exception e) {
				System.out
						.println("Attribute you entered unknown. Please re-enter");
				chosenAttributeName = scan2.nextLine();
			}
		}
		return currentAttribute;
	}
}
