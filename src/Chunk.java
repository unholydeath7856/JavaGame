
public class Chunk {
	private int id;
	private int treeCount;
	private int[][] corners = new int[][] 
	{
		{0,0},
		{0,0}
	};
	private int[] chunkCords = new int[] {0,0};
	
	private void spawnTrees(int trees) {
		int cordX = corners[0][0] + (int)(Math.random() * (corners[1][0] - corners[0][0]) + 1);
		int cordY = corners[0][1] + (int)(Math.random() * (corners[1][1] - corners[0][1]) + 1);
	}
	
	public Chunk(int[] cords, int tree, int id) {
		this.chunkCords = cords;
		this.corners[0][0] = cords[0] * 16;
		this.corners[0][1] = cords[1] * 16;
		this.corners[1][0] = corners[0][0] + 16;
		this.corners[1][1] = corners[0][1] + 16;
		this.treeCount = tree;
		this.spawnTrees(this.treeCount);
	}
	
}
