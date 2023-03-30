import java.util.List;

public class Chamber 
{	
	private int distance;
	private String description;
	private String content;
	private boolean exit;
	private List<Chamber> connections;
	
	public Chamber() 
	{
		super();
	}
	
	public Chamber(int distance, String description, String content, boolean exit, List<Chamber> connections)
	{
		super();
		this.distance = distance;
		this.description = description;
		this.content = content;
		this.exit = exit;
		this.connections = connections;
	}



	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isExit() {
		return exit;
	}

	public void setExit(boolean exit) {
		this.exit = exit;
	}

	public List<Chamber> getConnections() {
		return connections;
	}
	
	//acho que vai precisar como metodo auxiliar na hora de formar uma caverna
	public void setConnections(List<Chamber> connections) {
		this.connections = connections;
	}

	public void addConnection(Chamber chamber)
	{
		connections.add(chamber);
	}
	
	public void listChambers() 
	{
	    for (Chamber connection : connections) {
	        System.out.println("Description: " + connection.getDescription());
	        System.out.println("Content: " + connection.getContent());
	        System.out.println("------------------------------------");
	    }
	}
	
}


