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
	    System.out.println("\nDescription: " + currentChamber.getDescription());
	    //System.out.println("Content: " + currentChamber.getContent());
	    //System.out.println("Number of tunnels: " + currentChamber.getConnections().size());
	    //System.out.println("Exit: " + currentChamber.isExit());
	}
	
	public void handleCheckSelectedChamber(Player player, int choice)
	{
	    List<Tunnel> connections = player.getLocation().getConnections();
	    Chamber selectedChamber = connections.get(choice).getDestiny();
	    //System.out.println("Selected chamber:");
	    System.out.println("\nDescription: " + selectedChamber.getDescription());
		System.out.println("\nhow far: " + selectedChamber.getDistance());
	    //System.out.println("Content: " + selectedChamber.getContent());
	    //System.out.println("Number of tunnels: " + selectedChamber.getConnections().size());
	    //System.out.println("Exit: " + selectedChamber.isExit());

	    int newStamina = player.getStamina() - 5;
	    player.setStamina(newStamina);
	}

	public void handleGoToSelectedChamber(Player player, int choice) {
		{
			List<Tunnel> connections = player.getLocation().getConnections();
			Chamber selectedChamber = connections.get(choice).getDestiny();
			player.setLocation(selectedChamber);
			int newStamina = player.getStamina() - 20;
			player.setStamina(newStamina);
		}
	}

	public void handlePlayerCheck(Player player)
	{
	    if (player.isAlive())
	    {
	        System.out.println(player.getName() + " is alive.");
	        System.out.println("Stamina: " + player.getStamina());
	        System.out.println("Score: " + player.getScore());
	        handleCheckCurrentChamber(player);
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
