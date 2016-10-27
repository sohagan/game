public class Main {

	public static void main(String args[]) {
		System.out.println("Game is running");
		Game game = new Game(Game.Type.CARS);
		game.run();
	}
}
