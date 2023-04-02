
public class Tunnel 
{
	private Chamber origin;
	private Chamber destiny;
	private int length;
	
	public Tunnel(Chamber origin, Chamber destiny, int length) 
	{
		super();
		this.origin = origin;
		this.destiny = destiny;
		this.length = length;
	}

	public Chamber getOrigin() {
		return origin;
	}

	public void setOrigin(Chamber origin) {
		this.origin = origin;
	}

	public Chamber getDestiny() {
		return destiny;
	}

	public void setDestiny(Chamber destiny) {
		this.destiny = destiny;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
}
