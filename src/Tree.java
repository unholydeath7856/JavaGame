
public class Tree {
	public String name;
	public String desc;
	public int timeToDrop;
	public boolean hasFruit;
	public Fruit fruit;
	public int fruitCount;
	public int size;
	
	public static Tree generateSmallAppleTree() {
		return new Tree("Small Apple Tree", "A small apple tree sways in the wind", true, Apple.createGreenApple(),0);
	}
	
	public Tree(String name, String desc, boolean hasFruit, Fruit fruit, int size) {
		//Fruit Tree
		this.name = name;
		this.desc = desc;
		this.hasFruit = true;
		this.size = size;
		
		if (hasFruit) {
			this.timeToDrop = (int)(Math.random() * (10000-5000));
			this.fruit = fruit;
			fruitCountUpdate(this);
			
		}
	}
	
	public Tree(String name, String desc) {
		//general tree
		this.name = name;
		this.desc = desc;
	}
	
	public void pick(Tree tree, GameTimeTasks gameTime, Player player) {
		if (hasFruit && fruitCount != 0 && gameTime.displayDay >= tree.fruit.rippenDay) {
			player.inventory.inventory.add(tree.fruit);
			System.out.println("Apple picked");
			System.out.println(fruitCount + " Apples remain in this tree.");
			fruitCount--;
		} else if (hasFruit == false) {
			System.out.println("There are no fruits in this tree");
		} else if (fruitCount == 0) {
			System.out.println("You have picked all the fruit from this tree");
		} else if (gameTime.displayDay < tree.fruit.rippenDay) {
			System.out.println("Fruit has not bloomed yet");
		}
	}
	
	public void fruitCountUpdate(Tree tree) {
		switch(tree.size) {
		case 0:
			tree.fruitCount = (int)(Math.random() * tree.fruit.smlFruitCount + 1);
			break;
		case 1:
			tree.fruitCount = (int)(Math.random() * tree.fruit.medFruitCount + 1); 
			break;
		case 2:
			tree.fruitCount = (int)(Math.random() * tree.fruit.lrgFruitCount + 1);
		}
	}
}
