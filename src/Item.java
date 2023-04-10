
public class Item
{
	private String name;
	private String description;
	
	public Item(String name, String description)
	{
		this.name = name;
		this.description = description;
	}
	
	public void getDescription()
	{
		System.out.println("Name: " + name);
		System.out.println("Description: " + description);
		System.out.println("------------------------------------------------");
	}
}
