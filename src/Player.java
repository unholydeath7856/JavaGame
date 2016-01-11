import java.util.Scanner;

public class Player {
	Point playerPos;
	int health = 100;
	int thirst = 100;
	int hunger = 100;
	int stamina = 100;
	
	public Player(Point playerpos) {
		this.playerPos = playerpos;
	}
	
	public enum State {
		STATE_INTREE,
		STATE_ONGROUND,
		STATE_MOVING,
		STATE_STANDING
	}
	State state = State.STATE_ONGROUND;
	
	public void seeInv() {
		System.out.println("Your inventory Contains:");
		for (int i = 0; i < Inventory.inventory.size(); i++) {
			Item item = Inventory.inventory.get(i);
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
			Inventory.inventory.add(currentTile.items.get(userItemPicked - 1));
			currentTile.items.remove(userItemPicked - 1);
		}
		
	}
	
	public void dropItem(Tile currentTile) {
		boolean parsable = true;
		int itemNum;
		int userItemPicked = -1;
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Inventory contains:");
		
		for (int i = 0; i < Inventory.inventory.size(); i++) {
			itemNum = i+1;
			Item item = Inventory.inventory.get(i);
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
			currentTile.items.add(Inventory.inventory.get(userItemPicked - 1));
			Inventory.inventory.remove(userItemPicked - 1);
		}
	}
	
	public void move(Tile currentTile, GameTimeTasks gameTime) {
		Scanner scanner = new Scanner(System.in);
		state = State.STATE_MOVING;
		System.out.println("Where do you want to go (WASD");
		String input = scanner.nextLine();
		switch (input) {
		case "w":
			if (playerPos.y < World.HEIGHT && state == State.STATE_MOVING) {
				playerPos.y++;
				state = State.STATE_STANDING;
			}
			break;
		case "d":
			if (playerPos.x < World.WIDTH && state == State.STATE_MOVING) {
				playerPos.x++;
				state = State.STATE_STANDING;
				
			}
			break;
		case "s":
			if (playerPos.y > 0 && state == State.STATE_MOVING) {
				playerPos.y--;
				state = State.STATE_STANDING;
				
			}
			break;
		case "a":
			if (playerPos.x > 0 && state == State.STATE_MOVING) {
				playerPos.x--;
				state = State.STATE_STANDING;
				
			}
			break;
		case "c":
			state = State.STATE_INTREE;
			if (state == State.STATE_INTREE) {
				boolean inTree = true;
				System.out.println("What would you like to do in the tree");
				while(inTree) {
					input = scanner.nextLine();
					switch (input) {
					case "d":
						state = State.STATE_ONGROUND;
						inTree = false;
						break;
					case "p":
						currentTile.tree.pick(currentTile.tree, gameTime);
						break;
					default:
						break;
					}
				}
			}
			break;
		default:
			System.out.println("Not a valid movement");
			break;
		}
	}
}
