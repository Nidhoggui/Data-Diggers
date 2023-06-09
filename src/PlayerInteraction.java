import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

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

		int newStamina = player.getStamina() - 25;
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
		System.out.println("\n You focus to determinate the distance between where you are and where the path leads to. After a while you think the distance is about: " + (Math.abs(player.getLocation().getDistance() - selectedChamber.getDistance()) + random));
	    //System.out.println("Content: " + selectedChamber.getContent());
	    //System.out.println("Number of tunnels: " + selectedChamber.getConnections().size());
	    //System.out.println("Exit: " + selectedChamber.isExit());

	    int newStamina = player.getStamina() - 20;
	    player.setStamina(newStamina);
	}

	public void handleGoToSelectedChamber(Player player, int choice) {
		{
			List<Tunnel> connections = player.getLocation().getConnections();
			Chamber selectedChamber = connections.get(choice).getDestiny();
			int newStamina = player.getStamina() - Math.abs(player.getLocation().getDistance() - selectedChamber.getDistance()); //wrong math
			player.setLocation(selectedChamber);
			System.out.println("\nYou gather courage and passes through the tight path...");
			System.out.println(selectedChamber.getDescription());
			player.setStamina(newStamina);
		}
	}

	public void handlePlayerCheck(Player player, String name, ArrayList<String> stamina)
	{
	    if (player.isAlive())
	    {
			name = name.replace("[NAME]", player.getName());
	        System.out.println("\n" + name + "\n");
			if (player.getStamina() < 100) {
				System.out.println(stamina.get(0));
			} else if (player.getStamina() < 200) {
				System.out.println(stamina.get(1));
			} else if (player.getStamina() < 300) {
				System.out.println(stamina.get(2));
			} else if (player.getStamina() < 400) {
				System.out.println(stamina.get(3));
			} else if (player.getStamina() <= 500) {
				System.out.println(stamina.get(4));
			}
			System.out.print("\nAs you pause to catch your breath, feeling a sense of reassurance as you begin to look at your bag. The items you've gathered along your journey thus far are a testament to your resilience:\n\n");
			player.listItems();
			System.out.print("Score: " + player.getScore());
			//handleCheckCurrentChamber(player);
			int newStamina = player.getStamina() - 10;
			player.setStamina(newStamina);
	    } else System.out.println(player.getName() + " is dead.");
	}
	
	public void handleQuitGame() 
	{
	    Scanner scanner = new Scanner(System.in);
	    System.out.print("Are you sure you want to exit the game?[Y/n]: ");
	    char answer = scanner.next().charAt(0);
	    if (answer == 'Y' || answer == 'y') 
	    {
	        System.out.println("Quitting game...");
	        System.exit(0);
	    }
	}
	public void handleExitFound() {
		Scanner a = new Scanner(System.in);
		System.out.println("\nYou've found the exit and managed to leave the cave. A cave that was never found again.");
		System.out.println("Continue to be made...");
		System.out.println("\nPress \"ENTER\" to continue...");
		a.nextLine();
		System.exit(0);
	}
	public void handleHelp(){
		System.out.println("\n--- List of commands. Write to do the action ---");
		System.out.println("quit game -> quit the game");
	}
	public void handleDeath(){
		Scanner a = new Scanner(System.in);
		System.out.println("Unfortanely you died after passing out in the cold cave.");
		System.out.println("\nPress \"ENTER\" to continue...");
		a.nextLine();
		System.exit(0);
	}

	public void handleConsumeItem(Player player) {
		Scanner scanner = new Scanner(System.in);
		Random rng = new Random();
		int value = rng.nextInt(100);
		ArrayList<Item> items = new ArrayList<>();
		for (Item item : player.getItems()) {
			if (item.isConsumable()) {
				items.add(item);
			}
		}
		if (items.size() == 0) {
			System.out.println("You don't have nothing to consume.");
			return;
		}
		System.out.println("Quer comer? Lhe dou, papai");
		for(int i = 0; i < items.size(); i++) {
			if(items.get(i).isConsumable()) {
				System.out.println((i + 1) + ": " + items.get(i).getName() + " - " + items.get(i).getDescription());
			}
		}
		System.out.println("Selecione o número da comida que queres, amegan");
		int choice = scanner.nextInt();
		choice--;
		if(items.get(choice).isConsumable() && choice <= items.size()) {
			System.out.println("Que delícia, cara");
			items.remove(choice);
			player.setItems(items);
			player.setStamina(player.getStamina() + 100 + value);
		}else {
			System.out.println("Aí zoou");
		}
	}
}
