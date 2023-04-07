
public class Item
{
	private String name;
	private int score;
	private String description;
	
	public Item(String name, int score, String description)
	{
		this.name = name;
		this.score = score;
		this.description = description;
	}
	
	public void getDescription()
	{
		System.out.println("Description: " + description);
		System.out.println("Value: " + score);
		System.out.println("------------------------------------------------");
	}
}
