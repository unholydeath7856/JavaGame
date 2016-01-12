
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
		String menuName = "the [Root]";
		while (running) {
			Scanner scanner = new Scanner(System.in);
			Tile currentTile = world.chunkMap[player.playerPos.y/Chunk.HEIGHT][player.playerPos.x/Chunk.WIDTH].tiles[player.playerPos.y % Chunk.HEIGHT][player.playerPos.x % Chunk.WIDTH];
			Game.textUpdate(currentTile, player, gameTimeTasks, menuName);
			String input = scanner.nextLine();

			switch (input) {
			case "w":
				world.menu(player,currentTile,gameTimeTasks, world);
				break;
			case "m":
				Game.menu(player,currentTile,gameTimeTasks);
				break;
			default:
				System.out.println("Help func");
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
							if (gameTimeTasks.displayMonth >= tile.tree.fruit.startMonth && gameTimeTasks.displayMonth <= tile.tree.fruit.endMonth && gameTimeTasks.displayDay >= tile.tree.fruit.rippenDay && tile.tree.fruitCount != 0 ) {
								tile.tree.timeToDrop -= 60;
								if (tile.tree.timeToDrop < 0) {
									if (gameTimeTasks.displayDay >= tile.tree.fruit.matureDay) {
										tile.tree.fruit = Apple.createRedApple(tile.tree.fruit);
									}
									tile.tree.timeToDrop = (int)(Math.random() * (10000-5000));
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
							} else {
								tile.tree.fruit = Apple.createGreenApple();
							}
						}
					}
				}
			}
		}
	}
	
	public static void menu(Player player, Tile currentTile, GameTimeTasks gameTimeTasks) {
		Scanner scanner = new Scanner(System.in);
		boolean inMainMenu = true;
		String menuName = "the [Main Menu]";
		while (inMainMenu) {
			Game.textUpdate(currentTile, player, gameTimeTasks, menuName);
			String input = scanner.nextLine();
			switch(input) {
			case "c":
				System.out.println("Character options");
				break;
			case "i":
				player.seeInv();
				Inventory.menu(player,currentTile,gameTimeTasks);
				break;
			default:
				inMainMenu = false;
				break;
			}
		}
		
	}
	
	public static void textUpdate(Tile currentTile, Player player, GameTimeTasks gameTimeTasks, String menuName) {
		System.out.println("You ar currently in " + menuName);
		System.out.println("Tile Name: " + currentTile.name + " Tile Desc: " + currentTile.desc);
		System.out.println("X: " + player.playerPos.x + " Y: " + player.playerPos.y);
		System.out.println("Year: " + gameTimeTasks.year + " Month: " + gameTimeTasks.displayMonth + " Day: " + gameTimeTasks.displayDay);
		if (currentTile.tree != null) {
			System.out.println("has tree DropTime: " + currentTile.tree.timeToDrop + " Mature Day: " + currentTile.tree.fruit.matureDay + " Rippen Day: " + currentTile.tree.fruit.rippenDay);

		}
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		game.Run();
	}
}
