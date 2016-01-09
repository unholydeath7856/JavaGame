
public class Stick {
	public String name = "";
	public String desc = "";
	public int id = 0;
	public int meta = -1;
	
	public Stick(int meta) {
		switch(meta) {
		case 0:
			this.name = "Oak Stick";
			this.desc = "A twig from a mighty oak";
			this.meta = meta;
			break;
		default:
			Debug.error(1);
			break;
		}
	}
}
