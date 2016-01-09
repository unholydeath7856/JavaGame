
public class Debug {
	public static void error(int errorType) {
		switch (errorType) {
		case 0:
			System.out.println("Item has not been added to itemDB or you are calling out of bounds");
			break;
		case 1:
			System.out.println("Meta that you are calling does not exist");
			break;	
		default:
			System.out.println("Error type does not exist");
		}
		
		if (errorType == 0) {
			
		}
		
	}
}
