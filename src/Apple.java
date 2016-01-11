
public class Apple extends Item {
	
	public Apple(String name, String desc) {
		super(name,desc);
	}
	
	public static Apple createRedApple() {
		return new Apple("Red Apple","A tasty delicious matured apple");
	}
	
	public static Apple createGreenApple() {
		return new Apple("Green Apple","A ripe and sour apple");
	}
}
