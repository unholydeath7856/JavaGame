
public class Stone {
	public String name;
	public String desc;
	public int id = 1;
	public int meta = -1;
	public boolean knapped = false;
	public boolean sharp;
	
	public Stone(int meta) {
		switch(meta) {
		case 0:
			this.name = "Granite Stone";
			this.desc = "A rock laying in the grass";
			this.meta = meta;
			break;
		default:
			Debug.error(1);
			break;
		}
	}
}
