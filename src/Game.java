
public class Game {
	
	private static void initialize() {
		ItemLib.itemDB.add(Stick.class);
		ItemLib.itemDB.add(Stone.class);
	}
	
	private static Object instantiateItem(int index, int meta) {
		Object item = ItemLib.itemDB.get(index);
		if (item.equals(Stick.class)) {
			return instantiateStick(meta);
		}
		else if (item.equals(Stone.class)) {
			return instantiateStone(meta);
		}
		else {
			return null;
		}
	}
	
	private static Stick instantiateStick(int meta) {
		Stick stick = new Stick(meta);
		return stick;
	}
	
	private static Stone instantiateStone(int meta) {
		Stone stone = new Stone(meta);
		return stone;
	}
	
	public static void main(String[] args) {
		initialize();
		instantiateItem(1,0);
		
	}

}
