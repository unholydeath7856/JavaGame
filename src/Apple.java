
public class Apple extends Fruit {
	public Apple(String name, String desc, int fruitCountS, int fruitCountM, int fruitCountL, int startMnth, int endMnth, int ripeDay, int matureDay) {
		super(name,desc,fruitCountS, fruitCountM, fruitCountL, startMnth, endMnth, ripeDay, matureDay);
	}
	
	public static Apple createRedApple(Fruit greenApple) {
		if (greenApple.equals(Apple.class)) {
			Apple apple = (Apple)(greenApple);
			return new Apple("Red Apple","A tasty delicious matured apple",9,27,54,7,10, apple.rippenDay, apple.matureDay);
		}
		return null;
	}
	
	public static Apple createGreenApple() {
		int ripeDay = (int)(Math.random() * 18);
		int matureDay = ripeDay + 13;
		return new Apple("Green Apple","A ripe and sour apple",9,27,54,7,10,ripeDay,matureDay);
	}
}
