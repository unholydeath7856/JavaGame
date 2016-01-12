
public class Fruit extends Item {
	int smlFruitCount;
	int medFruitCount;
	int lrgFruitCount;
	int rippenDay;
	int matureDay;
	int startMonth;
	int endMonth;
	public Fruit(String name, String desc, int fruitCountS, int fruitCountM, int fruitCountL, int startMnth, int endMnth, int ripeDay, int matureDay) {
		super(name,desc);
		this.smlFruitCount = fruitCountS;
		this.medFruitCount = fruitCountM;
		this.lrgFruitCount = fruitCountL;
		this.rippenDay = ripeDay;
		this.matureDay = matureDay;
		this.startMonth = startMnth;
		this.endMonth = endMnth;
	}
}
