import java.util.ArrayList;

public class Store {
	private Player player;
	
	public Store(Player player)
	{
		this.player = player;
	}
	
	public void listItems()
	{
		ArrayList<Item> items = new ArrayList<Item>();
		items = player.getItems();
		for(int i = 0; i < items.size(); i++)
		{
			System.out.println((i + 1) + ": " + items.get(i).getName());
		}
	}
	
	public void sellItem(int index)
	{
		ArrayList<Item> items = new ArrayList<Item>();
		items = player.getItems();
		//player.setScore(player.getScore() + items.get(index).getValue());
		items.remove(index);
		player.setItems(items);
	}
}
