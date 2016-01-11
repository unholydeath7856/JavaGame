import java.util.ArrayList;

public class Tile
{
	public Tree tree;
	public String name;
	public String desc; 
	public ArrayList<Item> items = new ArrayList<Item>();
	
	public static Tile generateTile() {
		int tileID = (int)(Math.random() * 4);
		switch (tileID) {
		case 0:
			return new Tile("Grass","A small patch of grass");
		case 1: 
			return new Tile("Dirt","A barren patch of soil");
		case 2:
			return new Tile("Stone","A cool slab of stone resting under the sun's rays");
		default:
			return new Tile("Grass","A small patch of grass");
		}
	}
	
	public Tile(String name, String desc)
	{
		this.tree = null;
		this.desc = desc;
		this.name = name;
	}
}
