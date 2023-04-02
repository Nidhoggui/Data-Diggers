import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Map;
import java.util.HashMap;

public class Cave 
{
	private List<Chamber> chambers;
	
	public Cave(List<Chamber> chambers) {
		super();
		this.chambers = chambers;
	}
	
	public void addChamber(Chamber chamber)
	{
		chambers.add(chamber);
	}
	
	public boolean removeChamber(Chamber chamber)
	{
		if(chambers.contains(chamber)) 
		{ 
			chambers.remove(chamber);
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public Chamber searchChamber(Chamber chamber)
	{
		if(chambers.contains(chamber))
		{
			return chamber;
		}
		else 
		{
			return null;
		}
	}
	
	public List<Chamber> getChambers()
	{
		return this.chambers;
	}
	
	public void listChambers() 
	{
	    for (Chamber chamber : chambers) 
	    {
	        System.out.println("Description: " + chamber.getDescription());
	        System.out.println("Content: " + chamber.getContent());
	        System.out.println("Exit Status: " + chamber.isExit());
	        System.out.println("Connections: ");
	        chamber.listConnections();
	        //System.out.println("Connections: " + chamber.listConnections());
	        System.out.println("------------------------------------");
	    }
	}

	/*
	 * conectChambers(): boolean (true se as salas foram conectadas com sucesso, false caso contrário)
	 * disconnectChambers(): boolean (true se as salas foram desconectadas com sucesso, false caso contrário)
	 * calculatePath(): calcularCaminho(): List<Sala> (lista com as salas do caminho mais curto entre duas salas)
	 * */
	
	public boolean connectChambers(Tunnel tunnel)
	{
		Chamber origin = tunnel.getOrigin();
		Chamber destiny = tunnel.getDestiny();
		int length = tunnel.getLength();
		
		// tem que ver se tudo que a gente ta trabalhando ta na caverna
		if(!chambers.contains(origin) || !chambers.contains(destiny)) return false;
		
		List<Tunnel> connectionsOrigin = origin.getConnections();
		List<Tunnel> connectionsDestiny = destiny.getConnections();
		
		Tunnel tunnelToDestiny = new Tunnel(origin, destiny, length);
		Tunnel tunnelToOrigin = new Tunnel(destiny, origin, length);
		
		// verifica se os tuneis nao ja estao conectando a camara de origem e a camara de destino
		if(connectionsOrigin.contains(tunnelToDestiny) || connectionsDestiny.contains(tunnelToOrigin)) return false;
		
		// se contem e eles ja nao estao conectados, posso simplesment3e adicionar a lista de coneccoes que eles fazem
		
		origin.addConnection(tunnel);
		destiny.addConnection(tunnel);
		connectionsOrigin.add(tunnelToDestiny);
		connectionsDestiny.add(tunnelToOrigin);
		return true;
	}
	
	// sera que realmente e necessario uma funcao para desconectar os tuneis?
}
