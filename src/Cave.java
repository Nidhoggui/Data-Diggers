import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Map;
import java.util.HashMap;
import java.lang.Math;

public class Cave 
{
	private ArrayList<Chamber> chambers = new ArrayList<Chamber>();

	public Cave(ArrayList<Chamber> chambers) {
		super();
		this.chambers = chambers;
	}

	public void addChamber(Chamber chamber) {
		chambers.add(chamber);
	}

	public boolean removeChamber(Chamber chamber) {
		if(chambers.contains(chamber)) {
			chambers.remove(chamber);
			return true;
		} else {
			return false;
		}
	}

	public Chamber searchChamber(Chamber chamber) {
		if(chambers.contains(chamber)) {
			return chamber;
		} else {
			return null;
		}
	}

	public void setChambers(ArrayList<Chamber> chambers) {
		this.chambers = chambers;
	}

	public ArrayList<Chamber> getChambers() {
		return this.chambers;
	}

	public void listChambers() {
		for (Chamber chamber : chambers) {
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

	public boolean connectChambers(Tunnel tunnel) {
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

		//origin.addConnection(tunnel);
		//destiny.addConnection(tunnel);
		connectionsOrigin.add(tunnelToDestiny);
		connectionsDestiny.add(tunnelToOrigin);
		return true;
	}

	public void clearChambersVariables(ArrayList<Chamber> chambers){
		for (Chamber chamber : chambers) {
			chamber.setG(0);
			chamber.setH(0);
			chamber.setF(0);
			chamber.setTunnelNumber(0);
		}
	}

	public int findEscape2(Chamber start){
		start.setF(-1);
		start.setG(999999);
		start.setH(999999);
		ArrayList<Chamber> openSet = new ArrayList<Chamber>();
		ArrayList<Chamber> closedSet = new ArrayList<Chamber>();
		openSet.add(start);
		Chamber neighbor = new Chamber();
		Chamber exit = new Chamber();
		for (Chamber chamber : chambers) {
			if (chamber.isExit() == true) {
				exit = chamber;
			}
		}
		while(!openSet.isEmpty()){
			Chamber current = new Chamber();
			int i = 0;
			for (Chamber chamber : openSet) {
				if(i == 0){
					current = chamber;
					i++;
				}
				if(chamber.getF() < current.getF()){
					current = chamber;
				}
			}
			openSet.remove(current);
			closedSet.add(current);
			for (Tunnel tunnel : current.getConnections()) {
				//System.out.println("rodou");
				if (tunnel.getDestiny() != current) {
					neighbor = tunnel.getDestiny();
				} else {
					neighbor = tunnel.getOrigin();
				}
				if (closedSet.contains(neighbor)){
					continue;
				}
				if (neighbor.isExit()){
					neighbor.setTunnelNumber(current.getG() + Math.abs(neighbor.getDistance() - current.getDistance()));
					return neighbor.getTunnelNumber() - 999999;
				}
				neighbor.setG(Math.abs(neighbor.getDistance() - start.getDistance()));
				neighbor.setH(Math.abs(exit.getDistance() - neighbor.getDistance()));
				neighbor.setF(neighbor.getH() + neighbor.getG());
				int movementCost = current.getG() + Math.abs(neighbor.getDistance() - current.getDistance()) ;
				if (movementCost < neighbor.getG() || !openSet.contains(neighbor)) {
					neighbor.setG(movementCost);
					neighbor.setTunnelNumber(movementCost);
					if (!openSet.contains(neighbor)) {
						openSet.add(neighbor);
					}
				}
			}
		}
		return -1;
	}

	//should not be used
	public int findEscape(Chamber start){
		int tunnelNumberCheck = 0;
		Chamber exit = new Chamber();
		ArrayList<Chamber> openSet = new ArrayList<Chamber>();
		ArrayList<Chamber> closedSet = new ArrayList<Chamber>();
		for (Chamber chamber : chambers) {
			if (chamber.isExit() == true) {
				exit = chamber;
			}
		}
		Chamber current = new Chamber();
		current.setExit(false);
		current.setF(0);
		start.setG(start.getDistance());
		start.setH(Math.abs(exit.getDistance() - start.getDistance()));
		start.setF(start.getH());
		System.out.println(start.getH());
		openSet.add(start);
		while (!openSet.isEmpty()) {
			current.setF(0);
			for (Chamber chamber : openSet) {
				if (current.getF() == 0 || current.getF() > chamber.getF() && !closedSet.contains(chamber)){
					current = chamber;
					//System.out.println("pegou current");
				}
			}
			//System.out.println(current.getDescription());
			//if (current.isExit() == true) {
			//	return tunnelNumber; //retornar numero de tuneis que faltam!!!!
			//}
			openSet.remove(current);
			for (Tunnel tunnel : current.getConnections()){
				if (closedSet.contains(tunnel.getDestiny())) {
					continue;
				}
				//System.out.println(tunnel.getLength());
				int brk = 0;
				Chamber neighbor = tunnel.getDestiny();
				neighbor.setG(Math.abs(neighbor.getDistance() - start.getDistance())); // 20: 15 - 0 = 15  21: 20 + 0 = 20
				if (neighbor.isExit()){
					//System.out.println("achou");
					//System.out.println("currenttunnelnumber = " + current.getTunnelNumber());
					//System.out.println("neightgetG= " + neighbor.getG());
					neighbor.setTunnelNumber(current.getTunnelNumber() + (Math.abs(current.getTunnelNumber() - neighbor.getG())));
					return neighbor.getTunnelNumber();
				}
				neighbor.setH(Math.abs(exit.getDistance() - neighbor.getDistance())); // 20: 15 - 27 = 12  21: 27 - 20 = 7
				neighbor.setF(neighbor.getH() + neighbor.getG()); // 20: 12 + 15 = 27  21: 20 + 7 = 27
				for (Chamber chamber : openSet){
					if (chamber.getF() < neighbor.getF()){
						//System.out.println("open");
						brk = 1;
					}
				}
				for (Chamber chamber : closedSet){
					if (chamber.getF() < neighbor.getF()){
						//System.out.println("closed");
						brk = 1;
					}
				}
				//int test_gScore = current.getG() + Math.abs(neighbor.getDistance() - current.getDistance()); //15
				if (brk > -1) {
					//System.out.println("passou");
					if (tunnelNumberCheck == 0) {
						current.setTunnelNumber((current.getTunnelNumber() + current.getG()));
						tunnelNumberCheck = 1;
					}
					//neighbor.setG(test_gScore);
					//neighbor.setF(test_gScore + Math.abs(exit.getDistance() - neighbor.getDistance()));
					//if (openSet.indexOf(neighbor) == -1) {
					neighbor.setTunnelNumber(current.getTunnelNumber() + (Math.abs(current.getTunnelNumber() - neighbor.getG())));
					openSet.add(neighbor);
					closedSet.add(current);
					//}
				}
			}
		}
		return -1;
	}

	public ArrayList<Chamber> generateRandomCave(int numChambers, ArrayList<String> descriptionText, ArrayList<ChamberContent> contentObject) {
		ArrayList<Chamber> chambers = new ArrayList<>();
	    ArrayList<Tunnel> tunnels = new ArrayList<>();
	    Random random = new Random();

	    // Generate chambers
	    for (int i = 0; i < numChambers; i++) {
	        String description = descriptionText.get(random.nextInt(descriptionText.size()));
			ChamberContent content = null;
			int r = random.nextInt(numChambers) + 1;
			if (r > 5) {
				content = contentObject.get(random.nextInt(contentObject.size()));
			}
	        boolean isExit = (i == numChambers - 1); // Last chamber is the exit
	        Chamber chamber = new Chamber((random.nextInt(100) + 1), description, content, isExit, new ArrayList<>());
	        chambers.add(chamber);
	    }

	    // Generate tunnels
	    for (int i = 0; i < numChambers; i++) {
			/*
	        for (int j = i + 1; j < numChambers; j++) {
	            int length = random.nextInt(100) + 1; // Random tunnel length between 1 and 100
	            Tunnel tunnel = new Tunnel(chambers.get(i), chambers.get(j), length);
	            tunnels.add(tunnel);
	        }
			 */
			for (int j = 0; j < numChambers; j++) {
				int rand = random.nextInt(numChambers) + 1;
				if ((rand == 1 || rand == 2) && i != j) {
					Tunnel tunnel = new Tunnel(chambers.get(i), chambers.get(j), i);
					tunnels.add(tunnel);
				}/* else if (i == 9) {
					if (chambers.get(i).getConnections() == null) {
						Tunnel tunnel = new Tunnel(chambers.get(i), chambers.get(rand), i);
					}
				}*/
			}
		}

		//check if exit is reachable
		/*
		while (findEscape2(chambers.get(0)) != -1){
			int rand0 = random.nextInt(numChambers);
			int rand1 = random.nextInt(numChambers);
			if (rand0 != rand1) {
				Tunnel tunnel = new Tunnel(chambers.get(rand0), chambers.get(rand1), 0);
				tunnels.add(tunnel);
				cave.connect
			}
		}
		 */

	    // Shuffle tunnels
	    Collections.shuffle(tunnels);

	    // Kruskal's algorithm
	    UnionFind<Chamber> uf = new UnionFind<>(chambers);
	    for (Tunnel tunnel : tunnels) {
	        Chamber origin = tunnel.getOrigin();
	        Chamber destiny = tunnel.getDestiny();
	        if (!uf.connected(origin, destiny)) {
	            uf.union(origin, destiny);
	            origin.addConnection(tunnel);
	            destiny.addConnection(new Tunnel(destiny, origin, tunnel.getLength()));
	        }
	    }

		// repeat if exit is unreachable
		//System.out.println("rodou generate cave");
		while (findEscape2(chambers.get(0)) == -1) {
			chambers = generateRandomCave(numChambers, descriptionText, contentObject);
			clearChambersVariables(chambers);
		}

	    return chambers;
	}
}
