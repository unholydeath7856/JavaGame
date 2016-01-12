import java.util.Scanner;

public class Player {
	public Point playerPos;
	public int health = 100;
	public int thirst = 100;
	public int hunger = 100;
	public int stamina = 100;
	public Inventory inventory = new Inventory();
	
	public Player(Point playerpos) {
		this.playerPos = playerpos;
	}
	
	public enum State {
		STATE_INTREE,
		STATE_ONGROUND,
		STATE_MOVING,
		STATE_STANDING,
		STATE_SITTING
	}
	State state = State.STATE_ONGROUND;
	
	public void seeInv() {
		System.out.println("Your inventory Contains:");
		for (int i = 0; i < inventory.inventory.size(); i++) {
			Item item = inventory.inventory.get(i);
			System.out.println(item.name);
		}
	}
	
	public void pickUpItem(Tile currentTile) {
		boolean parsable = true;
		int itemNum;
		int userItemPicked = -1;
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("There are these objects lying near you:");
		
		for (int i = 0; i < currentTile.items.size(); i++) {
			itemNum = i+1;
			Item item = currentTile.items.get(i);
			System.out.println(itemNum + ": " + item.name);
			System.out.println("Which Item Do you want to pick up");
		}
		
		String input = scanner.nextLine();
	
		try {
			userItemPicked = Integer.parseInt(input);
		} catch(NumberFormatException e) { 
			parsable = false;
		}
		
		
		if (parsable) {
			inventory.inventory.add(currentTile.items.get(userItemPicked - 1));
			currentTile.items.remove(userItemPicked - 1);
		}
		
	}
	
	public void dropItem(Tile currentTile) {
		boolean parsable = true;
		int itemNum;
		int userItemPicked = -1;
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Inventory contains:");
		
		for (int i = 0; i < inventory.inventory.size(); i++) {
			itemNum = i+1;
			Item item = inventory.inventory.get(i);
			System.out.println(itemNum + ": " + item.name);
			System.out.println("Which item do you wnat to drop");
		}
		
		String input = scanner.nextLine();
		
		try {
			userItemPicked = Integer.parseInt(input);
		} catch(NumberFormatException e) { 
			parsable = false;
		}
		
		if (parsable) {
			currentTile.items.add(inventory.inventory.get(userItemPicked - 1));
			inventory.inventory.remove(userItemPicked - 1);
		}
	}
	
	public Tile move(Tile currentTile, GameTimeTasks gameTime, Player player, World world) {
		Scanner scanner = new Scanner(System.in);
		boolean moving = true;
		while (moving) {
			currentTile = world.chunkMap[player.playerPos.y/Chunk.HEIGHT][player.playerPos.x/Chunk.WIDTH].tiles[player.playerPos.y % Chunk.HEIGHT][player.playerPos.x % Chunk.WIDTH];
			System.out.println("You are currently moving and Coords are X: " + player.playerPos.x + " Y: " + player.playerPos.y);
			if (currentTile.tree != null) {
				System.out.println("has tree DropTime: " + currentTile.tree.timeToDrop + " Mature Day: " + currentTile.tree.fruit.matureDay + " Rippen Day: " + currentTile.tree.fruit.rippenDay);
			}
			player.state = State.STATE_MOVING;
			System.out.println("Where do you want to go (WASD)");
			String input = scanner.nextLine();
			switch (input) {
			case "w":
				if (player.playerPos.y < World.HEIGHT && player.state == State.STATE_MOVING) {
					player.playerPos.y++;
					player.state = State.STATE_STANDING;
				}
				break;
			case "d":
				if (player.playerPos.x < World.WIDTH && player.state== State.STATE_MOVING) {
					player.playerPos.x++;
					player.state= State.STATE_STANDING;
					
				}
				break;
			case "s":
				if (player.playerPos.y > 0 && player.state == State.STATE_MOVING) {
					player.playerPos.y--;
					player.state = State.STATE_STANDING;
					
				}
				break;
			case "a":
				if (player.playerPos.x > 0 && player.state == State.STATE_MOVING) {
					player.playerPos.x--;
					player.state = State.STATE_STANDING;
					
				}
				break;
			case "c":
				player.state = State.STATE_INTREE;
				if (player.state == State.STATE_INTREE) {
					boolean inTree = true;
					System.out.println("What would you like to do in the tree");
					while(inTree) {
						input = scanner.nextLine();
						switch (input) {
						case "d":
							System.out.println("You climb down the " + currentTile.tree.name);
							player.state = State.STATE_ONGROUND;
							inTree = false;
							break;
						case "p":
							currentTile.tree.pick(currentTile.tree, gameTime, player);
							break;
						default:
							break;
						}
					}
				}
				break;
			default:
				System.out.println("Not a valid movement");
				moving = false;
				return currentTile;
			}
			
		}
		return currentTile;
	}
	
	public void actions(Player player, Tile currentTile) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("What action would you like to do");
		String input = scanner.nextLine();
		switch (input) {
		case "p":
			player.pickUpItem(currentTile);
			break;
		case "d":
			player.dropItem(currentTile);
			break;
		case "e":
			player.eat(player);
			break;
		case "s":
			player.toggleStanding(player);
		default:
			break;
		}
	}
	
	public void toggleStanding(Player player) {
		if (player.state == State.STATE_SITTING) {
			player.state = State.STATE_STANDING;
			System.out.println("You are now Standing");
		} else {
			System.out.println("You are now Sitting");
			player.state = State.STATE_SITTING;
		}
	}
	
	public void eat(Player player) {
		if (player.state == State.STATE_STANDING || player.state == State.STATE_SITTING) {
			
		}
	}
}
