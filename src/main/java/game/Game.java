import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

	public static String newline = System.getProperty("line.separator");
	private static String EXIT = "exit";

	public enum Type {CARS};

	private Type type = null;
	
	private Scanner scan = new Scanner(System.in);

	public Game(Game.Type type) {
		if (type != Game.Type.CARS) {
			throw new IllegalArgumentException("Unsupport Game Type");
		}
	}
	
	public void run() {
		
		List<Player> players = setupPlayers();
	
		Deck deck = Deck.instance(Deck.Type.CARS, 10);
		
		deck.shuffle();
	
		Hand hand = deck.getHand(5);
	
		Card card = hand.getCard(0);
		System.out.println(card.toString());
		
		for(;;) {
			System.out.print("Enter Command : ");
		    String text= scan.nextLine();
		    System.out.println(text);
		    
		    if (text.toLowerCase().equals(Game.EXIT)) {
		    	System.out.println("Thanks for Playing The GAME");
		    	System.exit(0);
		    }
		}
	}


	private List<Player> setupPlayers() {
		List<Player> players = new ArrayList<Player>();

		HumanPlayer human = setupHuman();

		players.add(human);

		System.out.println("Hi " + human.getName() + " what type of computer would you like to play against");
	   
		Computer computer = setupComputer();
		System.out.println(human.getName() + " you will be playing a computer called " + computer.getName());

		players.add(computer);
		
		return players;
	}

	private Computer setupComputer() {
		
	    String type = null;
	    do {
	    	System.out.print("Enter P (Predictable) or R (Random) : ");
	    	type = scan.nextLine().toLowerCase();
	    } while (!type.equals(Intelligence.PREDICTABLE) && !type.equals(Intelligence.RANDOM));
	 
	    String computerName = "HAL";
		System.out.println("Thanks you want to play : " + type);
		System.out.println("This is V1 of our game so our attributes are about Cars only.");
		System.out.println("Sorry if you don't like Cars. We are working on V2 which will have other topics !.");
	
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
}
