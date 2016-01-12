import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {
	public ArrayList<Item> inventory = new ArrayList<Item>();
	
	public Inventory() {
		
	}
	
	public static String getItemType(Object item) {
		if (item.equals(Stick.class)) {
			return "Stick";
		}
		if (item.equals(Stone.class)) {
			return "Stone";
		} else {
			Debug.error(0);
			return null;
		}
	}
	
	public static void menu(Player player, Tile currentTile, GameTimeTasks gameTimeTasks) {
		Scanner scanner = new Scanner(System.in);
		String menuName = " your [Inventory]";
		Game.textUpdate(currentTile, player, gameTimeTasks, menuName);
		String input = scanner.nextLine();
		switch(input) {
		case "b":
			Game.menu(player,currentTile,gameTimeTasks);
			break;
		case "m":
			System.out.println("Inventory management");
			break;
		default:
			System.out.println("Help func");
		}
	}
}
