package br.com.senior.model.dto;

public class ItemDTO {

	private String description;
	private Double value;
	private Character type;

	public ItemDTO() {
	}

	public ItemDTO(String description, Double value, Character type) {
		this.description = description;
		this.value = value;
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Character getType() {
		return type;
	}

	public void setType(Character type) {
		this.type = type;
	}

}
