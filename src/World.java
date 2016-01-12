import java.util.Scanner;

public class World {
	public static final int HEIGHT = 100;
	public static final int WIDTH = 100;
	public Chunk[][] chunkMap = new Chunk[HEIGHT][WIDTH];  

	public World()
	{
		for (int y = 0; y < HEIGHT; y++)
		{
			for (int x = 0; x < WIDTH; x++)
			{
				Point p = new Point(x, y);
				chunkMap[y][x] = new Chunk(p, 32);
			}
		}
	}
	
	public void menu(Player player, Tile currentTile, GameTimeTasks gameTime, World world) {
		boolean inWorld = true;
		String menuName = "the [World]";
		Scanner scanner = new Scanner(System.in);
		while (inWorld) {
			Game.textUpdate(currentTile, player, gameTime, menuName);
			String input = scanner.nextLine();
			switch (input) {
			case "m":
				currentTile = player.move(currentTile, gameTime, player, world);
				break;
			case "a":
				player.actions(player, currentTile);
				break;
			case "b":
				Game.menu(player,currentTile,gameTime);
				inWorld = false;
				break;
			default:
				System.out.println("Help func");
				break;
			}	
		}
	}
}
