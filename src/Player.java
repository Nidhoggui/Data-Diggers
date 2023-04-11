import java.util.ArrayList;

public class Player
{
	private String name;
	private Chamber location;
	private int stamina;
	private int score;
	private ArrayList<Item> items = new ArrayList<Item>();

	public Player(String name, Chamber location, int stamina)
	{
		this.name = name;
		this.location = location;
		this.stamina = stamina;
		this.score = 0;
	}

	public void surveyArea()
	{
		stamina -= 20;
		System.out.println(name + " starts surveying the area...");
		System.out.println(location.getDescription());
		System.out.println(location.getContent());
	}

	public boolean containCrystal(Item crystal){
		if(items != null) {
			if (items.contains(crystal)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public void listItems(){
		for ( Item item : items){
			System.out.println("A " + item.getName() + ":");
			System.out.println(item.getDescription() + "\n");
		}
	}

	public void addItem(Item item) {
		items.add(item);
	}

	public boolean isAlive()
	{
		if(stamina > 0) return true;
		return false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Chamber getLocation() {
		return location;
	}
	
	//alterar
	public ArrayList<Item> getItems() {
		return items;
	}
	
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	public void setLocation(Chamber location) {
		this.location = location;
	}

	public int getStamina() {
		return stamina;
	}

	public void setStamina(int stamina) {
		this.stamina = stamina;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	
}
