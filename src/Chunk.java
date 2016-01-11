public class Chunk {
	final static public int WIDTH = 16;
	final static public int HEIGHT = 16;
	private int treeCount;
	public Tile[][] tiles = new Tile[HEIGHT][WIDTH];
	
	private Point chunkCords;
	
	public Chunk(Point coords, int tree) {
		this.chunkCords = coords;
		this.treeCount = tree;
		
		for (int i = 0; i < HEIGHT; i++)
		{
			for (int j = 0; j < WIDTH; j++)
			{
				this.tiles[i][j] = Tile.generateTile();
			}
		}
		
		this.spawnTrees(this.treeCount);
	}
	
	private void spawnTrees(int trees) {
		for (int i = 0; i < trees; i++)
		{
			int cordX = (int)(Math.random() * WIDTH);
			int cordY = (int)(Math.random() * HEIGHT);
			
			tiles[cordY][cordX].tree = Tree.generateSmallAppleTree();
		}
	}	
}
