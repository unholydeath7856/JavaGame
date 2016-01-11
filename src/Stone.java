
public class Stone extends Item {
	public int id = 1;
	public boolean knapped = false;
	public boolean sharp;
	
	public static Stone CreateGraniteStone()
	{
		return new Stone("Granite Stone", "A rock laying in the grass");
	}
	
	public Stone(String name, String desc) {
		super(name,desc);
	}
}
