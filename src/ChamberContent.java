public class ChamberContent {

	private String contentText;
	private int score;
	private Item item;

	public ChamberContent(String contentText, int score, Item item){
		this.contentText = contentText;
		this.score = score;
		this.item = item;
	}

	public String getContentText() {
		return contentText;
	}

	public int getScore() {
		return score;
	}

	public Item getItem() {
		return item;
	}

	public void setContentText(String contentText) {
		this.contentText = contentText;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setItem(Item item) {
		this.item = item;
	}
}
