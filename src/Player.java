public class Player
{
	private String name;
	private Chamber location;
	private int stamina;
	private int score;

	public Player(String name, Chamber location, int stamina)
	{
		this.name = name;
		this.location = location;
		this.stamina = stamina;
	}

	public void surveyArea()
	{
		stamina -= 20;
		System.out.println(name + " starts surveying the area...");
		System.out.println(location.getDescription());
		System.out.println(location.getContent());
	}

	//completar este método depois de adicionar IDs às chambers
	public void move()
	{
		location.listConnections();
		System.out.println("Where do you want to go?");
	}

	public boolean isAlive()
	{
		if(stamina > 0) return true;
		return false;
	}
}
