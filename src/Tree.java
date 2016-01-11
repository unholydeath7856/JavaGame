
public class Tree {
	public String name;
	public String desc;
	public int timeToDrop;
	public boolean hasFruit;
	public Item fruit;
	public int fruitCount;
	public int rippenDay;
	public int matureDay;
	public int size;
	
	public static Tree generateSmallAppleTree() {
		return new Tree("Small Apple Tree", "A small apple tree sways in the wind", true, Apple.createGreenApple(),0);
	}
	
	public Tree(String name, String desc, boolean hasFruit, Item fruit, int size) {
		//Fruit Tree
		this.name = name;
		this.desc = desc;
		this.hasFruit = true;
		this.size = size;
		
		if (hasFruit) {
			this.timeToDrop = (int)(Math.random() * (10000-5000));
			this.fruit = fruit;
			
			switch (fruit.name) {
			
			case "Green Apple":
				this.rippenDay = (int)(Math.random() * (18-1));
				this.matureDay = rippenDay + 13;
				switch (size) {
				case 0:
					this.fruitCount = (int)(Math.random() * 9);
					break;
				case 1:
					this.fruitCount = (int)(Math.random() * (27 - 13));
					break;
				case 2:
					this.fruitCount = (int)(Math.random() * (54-29));
					break;
				default:
					this.fruitCount = (int)(Math.random() * 9);
					break;
				}
			} 
		}
	}
	
	public Tree(String name, String desc) {
		//general tree
		this.name = name;
		this.desc = desc;
	}
	
	public void pick(Tree tree, GameTimeTasks gameTime) {
		if (hasFruit && fruitCount != 0 && gameTime.displayDay >= tree.rippenDay) {
			Inventory.inventory.add(tree.fruit);
			System.out.println("Apple picked");
			System.out.println(fruitCount + " Apples remain in this tree.");
			fruitCount--;
		} else if (hasFruit == false) {
			System.out.println("There are no fruits in this tree");
		} else if (fruitCount == 0) {
			System.out.println("You have picked all the fruit from this tree");
		} else if (gameTime.displayDay < tree.rippenDay) {
			System.out.println("Fruit has not bloomed yet");
		}
	}
	
	public void fruitCountUpdate(Tree tree) {
		switch (tree.fruit.name) {
		case "Green Apple":
			switch (tree.size) {
			case 1:
				tree.fruitCount = (int)(Math.random() * 27);
				break;
			case 2:
				tree.fruitCount = (int)(Math.random() * 54);
				break;
			default:
				tree.fruitCount = (int)(Math.random() * 9);
				break;
			}
		case "Red Apple":
			switch (tree.size) {
			case 1:
				tree.fruitCount = (int)(Math.random() * (27));
				break;
			case 2:
				tree.fruitCount = (int)(Math.random() * (54));
				break;
			default:
				tree.fruitCount = (int)(Math.random() * 9);
				break;
			}
		} 
	}
}
