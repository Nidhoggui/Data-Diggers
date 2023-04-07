import java.util.List;
//import java.util.Map;

public class Chamber 
{
	private int g;
	private int h;
	private int f;
	private int tunnelNumber;
	private int distance;
	private String description;
	private String content;
	private boolean exit;
	private List<Tunnel> connections;
	
	public Chamber() 
	{
		super();
	}
	
	public Chamber(int distance, String description, String content, boolean exit, List<Tunnel> connections)
	{
		super();
		this.distance = distance;
		this.description = description;
		this.content = content;
		this.exit = exit;
		this.connections = connections;
		this.tunnelNumber = 0;
	}

	public int getG() {
		return g;
	}
	public int getH() {
		return h;
	}
	public int getF() {
		return f;
	}
	public void setG(int g) {
		this.g = g;
	}
	public void setH(int h) {
		this.h = h;
	}
	public void setF(int f) {
		this.f = f;
	}

	public int getTunnelNumber() {
		return this.tunnelNumber;
	}
	public void setTunnelNumber(int tunnelNumber) {
		this.tunnelNumber = tunnelNumber;
	}
	public void addTunnelNumber() {
		this.tunnelNumber++;
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

	public List<Tunnel> getConnections() {
		return connections;
	}
	
	//acho que vai precisar como metodo auxiliar na hora de formar uma caverna
	public void setConnections(List<Tunnel> connections) {
		this.connections = connections;
	}

	public void addConnection(Tunnel tunnel)
	{
		connections.add(tunnel);
	}
	
	public void listConnections() 
	{
	    for (Tunnel connection : connections) 
	    {
	        System.out.println("Description: " + connection.getDestiny().getDescription());
	        System.out.println("Content: " + connection.getDestiny().getContent());
	        System.out.println("Length: " + connection.getLength());
	        System.out.println("------------------------------------");
	    }
	}
	
	
	
}


