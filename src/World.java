public class World {
	public static final int HEIGHT = 100;
	public static final int WIDTH = 100;
	public Chunk[][] chunkMap = new Chunk[HEIGHT][WIDTH];  

	public World()
	{
		for (int y = 0; y < HEIGHT; y++)
		{
			for (int x = 0; x < WIDTH; x++)
			{
				Point p = new Point(x, y);
				chunkMap[y][x] = new Chunk(p, 32);
			}
		}
	}
}
