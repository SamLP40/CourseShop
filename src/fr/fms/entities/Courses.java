package fr.fms.entities;

public class Courses {

	public int idCourse;
	public String name;
	public int duration;
	public String description;
	public String category;
	public String type;
	public double price;
	public int quantity = 1; // Compteur de formations achetées.
	
	public Courses(int idCourse, String name, int duration, String description, String category, String type, double price) {

		this.idCourse = idCourse;
		this.name = name;
		this.duration = duration;
		this.description = description;
		this.category = category;
		this.type = type;
		this.price = price;
	}

	public Courses(String name, int duration, String description, String category, String type, double price) {
		this.name = name;
		this.duration = duration;
		this.description = description;
		this.category = category;
		this.type = type;
		this.price = price;
	}

	
	public Courses(int idCourse, String name, int duration, String description, String category, String type,
			double price, int quantity) {

		this.idCourse = idCourse;
		this.name = name;
		this.duration = duration;
		this.description = description;
		this.category = category;
		this.type = type;
		this.price = price;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Courses [idCourse=" + idCourse + ", name=" + name + ", duration=" + duration +  ", description=" + description + ", category="
				+ category + ", type=" + type + ", price=" + price + "]";
	}

	public int getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(int idCourse) {
		this.idCourse = idCourse;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getDuration() {
		return duration;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public static int centerString(String columnIdcourse) {
		// TODO Auto-generated method stub
		return 0;
	}
}
