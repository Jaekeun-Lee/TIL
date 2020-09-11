
public class CompactDisc extends Product {
	private String albumTitle;
	private String artist;
	
	public CompactDisc(int productID, String description, String maker, int price, String albumTitle, String artist) {
		super(productID, description, maker, price);
		this.albumTitle = albumTitle;
		this.artist = artist;
	}

	public void setAlbumTitle(String albumTitle) {
		this.albumTitle = albumTitle;
	}

	public String getAlbumTitle() {
		return albumTitle;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getArtist() {
		return artist;
	}
	public void showInfo() {
		super.showInfo();
		System.out.println("举过 力格>>"+albumTitle);
		System.out.println("啊荐>>"+artist);
	}
}
