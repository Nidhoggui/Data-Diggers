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
