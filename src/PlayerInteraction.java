import java.util.List;
import java.util.Scanner;

public class PlayerInteraction {
	
	public PlayerInteraction(Player player) {
		super();
		this.player = player;
	}

	Player player = new Player(null, null, 0);
	
	public void handleCheckCurrentChamber(Player player) 
	{
	    Chamber currentChamber = player.getLocation();
	    //System.out.println("Current chamber:");
		if (currentChamber.getContent() != null) {
			System.out.println(currentChamber.getContent().getContentText());
			System.out.println("\nYou've found a: " + currentChamber.getContent().getItem().getName());
			System.out.println(currentChamber.getContent().getItem().getDescription());
		} else {
			System.out.println("\nYou've found nothing new");
		}
	    //System.out.println("Content: " + currentChamber.getContent());
	    //System.out.println("Number of tunnels: " + currentChamber.getConnections().size());
	    //System.out.println("Exit: " + currentChamber.isExit());

		int newStamina = player.getStamina() - 5;
		player.setStamina(newStamina);
		if (currentChamber.getContent() != null) {
			player.setScore(player.getScore() + currentChamber.getContent().getScore());
			player.addItem(currentChamber.getContent().getItem());
			currentChamber.setContent(null);
		}
	}
	
	public void handleCheckSelectedChamber(Player player, int choice, int random)
	{
	    List<Tunnel> connections = player.getLocation().getConnections();
	    Chamber selectedChamber = connections.get(choice).getDestiny();
	    //System.out.println("Selected chamber:");
		System.out.println("\n You focus to determinate the distance between where you are and where the path leads to. After a while you think the distance is about: " + (selectedChamber.getDistance() + random));
	    //System.out.println("Content: " + selectedChamber.getContent());
	    //System.out.println("Number of tunnels: " + selectedChamber.getConnections().size());
	    //System.out.println("Exit: " + selectedChamber.isExit());

	    int newStamina = player.getStamina() - 10;
	    player.setStamina(newStamina);
	}

	public void handleGoToSelectedChamber(Player player, int choice) {
		{
			List<Tunnel> connections = player.getLocation().getConnections();
			Chamber selectedChamber = connections.get(choice).getDestiny();
			player.setLocation(selectedChamber);
			int newStamina = player.getStamina() - selectedChamber.getDistance(); //wrong math
			player.setStamina(newStamina);
		}
	}

	public void handlePlayerCheck(Player player)
	{
	    if (player.isAlive())
	    {
	        System.out.println("\n" + player.getName() + " is alive.");
	        System.out.println("Stamina: " + player.getStamina());
	        System.out.println("Score: " + player.getScore());
	        //handleCheckCurrentChamber(player);
			int newStamina = player.getStamina() - 2;
			player.setStamina(newStamina);
	    } else System.out.println(player.getName() + " is dead.");
	}
	
	public void handleQuitGame() 
	{
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("Are you sure you want to exit the game?[Y/n]");
	    char answer = scanner.nextLine().charAt(0);
	    if (answer == 'Y' || answer == 'y') 
	    {
	        System.out.println("Quitting game...");
	        System.exit(0);
	    }
	}
}
