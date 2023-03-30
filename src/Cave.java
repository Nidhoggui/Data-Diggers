import java.util.ArrayList;
import java.util.List;

public class Cave 
{
	private ArrayList<Chamber> chambers;

	public Cave(ArrayList<Chamber> chambers) {
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
	    for (Chamber chamber : chambers) {
	        System.out.println("Description: " + chamber.getDescription());
	        System.out.println("Content: " + chamber.getContent());
	        System.out.println("Exit Status: " + chamber.isExit());
	        System.out.println("Connections: " + chamber.getConnections());
	        System.out.println("------------------------------------");
	    }
	}

	/*
	 * conectChambers(): boolean (true se as salas foram conectadas com sucesso, false caso contrário)
	 * disconnectChambers(): boolean (true se as salas foram desconectadas com sucesso, false caso contrário)
	 * calculatePath(): calcularCaminho(): List<Sala> (lista com as salas do caminho mais curto entre duas salas)
	 * */
}
