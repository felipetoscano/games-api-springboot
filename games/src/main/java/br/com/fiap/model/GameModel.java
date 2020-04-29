package br.com.fiap.model;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

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
	
	@Size(min = 2, max = 256, message = "Url deve ter no mínimo 2 e no máximo 256 caracteres")
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	@Size(min = 2, max = 40, message = "Nome deve ter no mínimo 2 e no máximo 40 caracteres")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Size(min = 2, max = 40, message = "Categoria deve ter no mínimo 2 e no máximo 40 caracteres")
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	@DecimalMin(value = "0.1", message = "O preço deve ter um valor minimo de 0.0")
	public float getPrice() {
		return price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	@Size(min = 2, max = 256, message = "Descrição deve ter no mínimo 2 e no máximo 256 caracteres")
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Size(min = 2, max = 256, message = "Url deve ter no mínimo 2 e no máximo 256 caracteres")
	public String getUrlBuy() {
		return urlBuy;
	}
	
	public void setUrlBuy(String urlBuy) {
		this.urlBuy = urlBuy;
	}
	
}
