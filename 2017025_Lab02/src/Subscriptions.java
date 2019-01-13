
public class Subscriptions {
	private int price;
	private int songs;
	private int downloads;
	
	public Subscriptions(int price, int songs, int downloads) {

		this.price = price;
		this.songs = songs;
		this.downloads = downloads;
	}
	
	
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getSongs() {
		return songs;
	}
	public void setSongs(int songs) {
		this.songs = songs;
	}
	public int getDownloads() {
		return downloads;
	}
	public void setDownloads(int downloads) {
		this.downloads = downloads;
	}
	
	
	
}
