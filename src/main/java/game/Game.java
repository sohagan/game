import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

	public static String newline = System.getProperty("line.separator");
	private static String EXIT = "exit";
	
	public static void run() {
		
	    Scanner scan = new Scanner(System.in);
		System.out.print("Welcome to The Game. Please enter your name : ");
	    String name = scan.nextLine();
	    System.out.println("Hi " + name + " what type of computer would you like to play against");
	   
	    String type = null;
	    do {
	    	System.out.print("Enter P (Predictable) or R (Random) : ");
	    	type = scan.nextLine().toLowerCase();
	    } while (!type.equals(Intelligence.PREDICTABLE) && !type.equals(Intelligence.RANDOM));
	 
	    String computerName = "HAL";
		System.out.println("Thanks you want to play : " + type);
		System.out.println("This is V1 of our game so our attributes are about Cars only.");
		System.out.println("Sorry if you don't like Cars. We are working on V2 which will have other topics !.");
	   
		System.out.println(name + " you will be playing a computer called " + computerName);
	   
		List<Player> players = new ArrayList<Player>();
		
		HumanPlayer human = new HumanPlayer(name);
		
		Computer computer = new Computer("HAL");
		if (type.equals(Intelligence.PREDICTABLE)) {
			computer.setIntelligence(new PredictableIntelligence());
		} else if (type.equals(Intelligence.RANDOM)) {
			computer.setIntelligence(new RandomIntelligence());
		} else {
			throw new RuntimeException("Unexpected Error");
		}
	
		Deck deck = Deck.instance(Deck.Type.CARS, 10);
		
		deck.shuffle();
	
		Hand hand = deck.getHand(5);
		
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
}
