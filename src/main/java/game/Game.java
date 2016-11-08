import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Game {

	/**
	 * updated
	 */
	public static String newline = System.getProperty("line.separator");
	private static String EXIT = "exit";

	public enum Type {
		CARS
	};

	private Type type = null;

	private Scanner scan = new Scanner(System.in);

	public Game(Game.Type type) {
		if (type != Game.Type.CARS) {
			throw new IllegalArgumentException("Unsupported Game Type");
		}
	}

	public void run() {

		for (;;) {

			List<Player> players = setupPlayers();

			dealDeck(players);

			Player current = players.get(0);
			
			showIntroMessage(players);

			while (!isWinner(current, players)) {

				System.out.println("Current Player is [" + current.getName() + "]");
				Card card = current.getHand().getCard(0);

				Attribute attribute = current.chooseAttribute(card);
		
				showCard(current, players);
				
				System.out.println(current.getName() + "'s selected attribute is " + attribute);
				current = playHand(current, players, attribute);
				System.out.println(current.getName() + " won that round");
				
				winningHand(current, players);
			}
			
			System.out.println("Game over. Winner = " + current.getName());
			System.out.println("Options : X (Exit), G (Play Again)");
			System.out.print("Enter Command : ");
			String text = scan.nextLine();
			System.out.println(text);

			if (text.toLowerCase().equals(Game.EXIT)
					|| text.toLowerCase().equals("x")) {
				System.out.println("Thanks for Playing The GAME");
				System.exit(0);
				// ? -convert string text to attribute - casting
			}
		}

	}

	private void showCard(Player current, List<Player> players) {
		Iterator<Player> playerIterator = players.iterator();
		while (playerIterator.hasNext()) {
			Player player = playerIterator.next();
			if (!player.equals(current)) {
				if (player.getType().equals(Player.Type.HUMAN)) {
					System.out.println(player.getName().toUpperCase() + " please show your card by hitting enter key");
					String text = scan.nextLine();
					System.out.println(player.getName().toUpperCase() + " Your attributes are " + player.getHand().getCard(0));
				} else {
					System.out.println("[COMPUTER PLAYER = " + player.getName().toUpperCase() + "] card attributes are " + player.getHand().getCard(0));
				}
			}
		}
	}
	
	private void showIntroMessage(List<Player> players) {
		System.out.println("We are ready to play The Game.");
		Iterator<Player> playerIterator = players.iterator();
		while (playerIterator.hasNext()) {
			Player player = playerIterator.next();
			System.out.println("Player Name [" + player.getName() + "] Number of Cards [" + player.getHand().getCards().size() + "]");
		}
	}
	
	private boolean isWinner(Player winner, List<Player> players) {
		Iterator<Player> playerIterator = players.iterator();
		while (playerIterator.hasNext()) {
			Player player = playerIterator.next();
			if (!player.equals(winner)) {
				if (player.getHand().getCards().size() > 0) {
					return false;
				}
			}
		}
		return true;
	}

	private void winningHand(Player winner, List<Player> players) {
		Iterator<Player> playerIterator = players.iterator();
		while (playerIterator.hasNext()) {
			Player player = playerIterator.next();
			if (!player.equals(winner)) {
				Card loosingCard = player.getHand().removeCard(0);
				winner.receiveCard(loosingCard);
			} else {
				winner.getHand().swapToBottom();
			}
		}
	}

	private void dealDeck(List<Player> players) {
		System.out.println("Enter the number of cards you want to play with :");
		int cardNo = scan.nextInt();
		int deckCardNo = cardNo * players.size();

		Deck deck = Deck.instance(Deck.Type.CARS, deckCardNo);

		deck.shuffle();

		Iterator<Player> playerIterator = players.iterator();
		while (playerIterator.hasNext()) {
			Player player = playerIterator.next();
			Hand hand = deck.getHand(cardNo);
			player.setHand(hand);
		}
	}

	private Player playHand(Player currentWinner, List<Player> players,
			Attribute attribute) {
		Iterator<Player> playerIterator = players.iterator();
		while (playerIterator.hasNext()) {
			Player opponent = playerIterator.next();

			if (!opponent.equals(currentWinner)) {
				Card card = opponent.getHand().getCard(0);

				System.out.println(card.toString());
				Attribute opponentsAttribute = card.getNameAttribute(attribute
						.getName());

				// compare to current highest
				// check requirements regarding what happens if attribute
				// values are the same ?
				// i.e. who is the winner.

				if (attribute.getValue() < opponentsAttribute.getValue()) {
					attribute = opponentsAttribute;
					currentWinner = opponent;
				}

			}
		}
		return currentWinner;
	}

	private List<Player> setupPlayers() {
		List<Player> players = new ArrayList<Player>();

		HumanPlayer human = setupHuman();

		players.add(human);

		System.out.println("Hi " + human.getName()
				+ " what type of computer would you like to play against");

		Computer computer = setupComputer();
		System.out.println(human.getName()
				+ " you will be playing a computer called "
				+ computer.getName());

		players.add(computer);

		return players;
	}

	private Computer setupComputer() {

		String type = null;
		do {
			System.out.print("Enter P (Predictable) or R (Random) : ");
			type = scan.nextLine().toLowerCase();
		} while (!type.equals(Intelligence.PREDICTABLE)
				&& !type.equals(Intelligence.RANDOM));

		String computerName = "HAL";
		System.out.println("Thanks you want to play : " + type);

		Computer computer = new Computer("HAL");
		if (type.equals(Intelligence.PREDICTABLE)) {
			computer.setIntelligence(new PredictableIntelligence());
		} else if (type.equals(Intelligence.RANDOM)) {
			computer.setIntelligence(new RandomIntelligence());
		} else {
			throw new RuntimeException("Unexpected Error");
		}
		return computer;
	}

	private HumanPlayer setupHuman() {
		System.out.print("Welcome to The Game. Please enter your name : ");
		String name = scan.nextLine();

		HumanPlayer human = new HumanPlayer(name);
		return human;
	}
};
