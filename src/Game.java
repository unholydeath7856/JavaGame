
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Game {
	public World world;
	public Player player;
	public Timer gameTime;
	public GameTimeTasks gameTimeTasks;
	public Game()
	{
		this.player = new Player(new Point(0,0));
		this.world = new World();
		this.world.chunkMap[0][0].tiles[0][0].items.add(Stone.CreateGraniteStone());
		this.gameTime = new Timer();
		this.gameTimeTasks = new GameTimeTasks(this);
		gameTime.schedule(this.gameTimeTasks,0, 1000);
	}
		
	public void Run()
	{
		// User interactivity loop!
		boolean running = true;
		while (running) {
			Scanner scanner = new Scanner(System.in);
			Tile currentTile = world.chunkMap[player.playerPos.y/Chunk.HEIGHT][player.playerPos.x/Chunk.WIDTH].tiles[player.playerPos.y % Chunk.HEIGHT][player.playerPos.x % Chunk.WIDTH];
			System.out.println("Tile Name: " + currentTile.name + " Tile Desc: " + currentTile.desc);
			System.out.println("X: " + player.playerPos.x + " Y: " + player.playerPos.y);
			System.out.println("Year: " + gameTimeTasks.year + " Month: " + gameTimeTasks.displayMonth + " Day: " + gameTimeTasks.displayDay);
			if (currentTile.tree != null) {
				System.out.println("has tree DropTime: " + currentTile.tree.timeToDrop + " Mature Day: " + currentTile.tree.matureDay + " Rippen Day: " + currentTile.tree.rippenDay);
				
			}
			String input = scanner.nextLine();
			
			switch (input) {
			case "m":
				player.move(currentTile, gameTimeTasks);
				break;
			case "o":
				player.seeInv();
				break;
			case "p":
				player.pickUpItem(currentTile);
				break;
			case "r":
				player.dropItem(currentTile);
				break;
			default :
				break;
			}
		}
	}
	
	public void onTime(int gameTime) {
		for (int chunkX = 0; chunkX < World.WIDTH; chunkX++) {
			for (int chunkY = 0; chunkY < World.HEIGHT; chunkY++) {
				for (int tileX = 0; tileX < Chunk.WIDTH; tileX++) {
					for (int tileY = 0; tileY < Chunk.HEIGHT; tileY++) {
						Tile tile = world.chunkMap[chunkY][chunkX].tiles[tileY][tileX];
						if (tile.tree != null) {
							if (gameTimeTasks.displayMonth >= 7 && gameTimeTasks.displayMonth <= 10 && gameTimeTasks.displayDay >= tile.tree.rippenDay && tile.tree.fruitCount != 0 ) {
								tile.tree.timeToDrop -= 60;
								if (tile.tree.timeToDrop < 0) {
									if (gameTimeTasks.displayDay >= tile.tree.matureDay) {
										tile.tree.fruit = Apple.createRedApple();
									}
									tile.tree.timeToDrop = 5000;
									tile.tree.fruitCount--;
									tile.items.add(tile.tree.fruit);
								}
							}
							if (tile.tree.size != 1) {
								if (gameTimeTasks.year % 4 == 0 && gameTimeTasks.year != 8) {
									tile.tree.size++;
									tile.tree.fruitCountUpdate(tile.tree);
								}
							} else if (tile.tree.size != 2) {
								if (gameTimeTasks.year % 8 == 0) {
									tile.tree.size+=2;
									tile.tree.fruitCountUpdate(tile.tree);
								}
							}
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		game.Run();
	}
}
