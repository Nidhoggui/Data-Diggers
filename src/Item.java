
public class Item
{
	private String name;
	private String description;
	//private int value;
	
	public Item(String name, String description)
	{
		this.name = name;
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	/*
	 * public int getValue() {
	 * 		return value;
	 * }
	 * 
	 * public void setValue(int value) {
	 * 		this.value = value;
	 * }
	 */
}
