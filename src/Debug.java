
public class Debug {
	public static void error(int errorType) {
		switch (errorType) {
		case 0:
			System.out.println("Item is not added to Inventory.getItemType()");
			break;
		default:
			System.out.println("Error type does not exist");
		}
		
		if (errorType == 0) {
			
		}
		
	}
}
