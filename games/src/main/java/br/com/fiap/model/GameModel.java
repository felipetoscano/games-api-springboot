package br.com.fiap.model;

public class GameModel {
	
	private long id;
	private String image;
	private String name;
	private String category;
	private float price;
	private String description;
	private String urlBuy;
	
	public GameModel(String image, String name, String category, float price, String description, String urlBuy) {
		super();
		this.image = image;
		this.name = name;
		this.category = category;
		this.price = price;
		this.description = description;
		this.urlBuy = urlBuy;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getImage() {
		return image;
	}
	public String getName() {
		return name;
	}
	public String getCategory() {
		return category;
	}
	public float getPrice() {
		return price;
	}
	public String getDescription() {
		return description;
	}
	public String getUrlBuy() {
		return urlBuy;
	}
	
	
}
