import java.util.ArrayList;

public class Inventory {
	public static ArrayList<Item> inventory = new ArrayList<Item>();
	
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
}
