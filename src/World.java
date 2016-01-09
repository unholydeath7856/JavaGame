import java.util.ArrayList;

public class World {
	private static int chunkID = 0;
	private static ArrayList<Chunk> chunkMap = new ArrayList<Chunk>();
	private static int[] spawnCords = new int[] {0,0};
	private static int[][] worldChunkBounds = new int [][] {
		{0,0},
		{1000,1000}
	};
	private static int[][] worldCordBounds = new int[][] {
		{0,0},
		{1600,1600}
	};
	final static int chunkSize = 16;
	
	public static void generateSpawn() {
		boolean adjusting = true;
		spawnCords[0] = (int)(Math.random() * ((1000 - 100) + 1));
		spawnCords[1] = (int)(Math.random() * ((1000 - 100) + 1));
		while (adjusting) {
			if (spawnCords[0] % chunkSize != 0) {
				spawnCords[0]++;
			}
			if (spawnCords[1] % chunkSize != 0) {
				spawnCords[1]++;
			}
			if (spawnCords[0] % chunkSize == 0 && spawnCords[1] % chunkSize == 0) {
				adjusting = false;
			}
		}
	}
	
	public static void generateSpawnChunks(int[] chunkCords) {
		
		for (int x = 0; x < worldChunkBounds[1][0]; x ++) {
			for (int y = 0; y < worldChunkBounds[1][1]; y++) {
				chunkID++;
				Chunk chunk = new Chunk(chunkCords, 6, chunkID);
				chunkMap.add(chunk);
			}
		}
		System.out.println();
		
	}
	
	
}
