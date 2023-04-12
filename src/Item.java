
public class Item
{
	private String name;
	private String description;
	//private int value;
	private boolean consumable;
	
	public Item(String name, String description, boolean consumable)
	{
		this.name = name;
		this.description = description;
		this.consumable = consumable;
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
	public boolean isConsumable() {
		return consumable;
	}

	public void setConsumable(boolean consumable) {
		this.consumable = consumable;
	}
}
