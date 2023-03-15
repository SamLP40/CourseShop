package fr.fms.entities;

public class Cart {


	public int idCart;
	public int totalCourses;
	public int idOrder;
	
	public Cart(int idCart, int totalCourses, int idOrder) {
		super();
		this.idCart = idCart;
		this.totalCourses = totalCourses;
		this.idOrder = idOrder;
	}

	@Override
	public String toString() {
		return "Cart [idCart=" + idCart + ", totalCourses=" + totalCourses + ", idOrder=" + idOrder + "]";
	}

	public int getIdCart() {
		return idCart;
	}

	public void setIdCart(int idCart) {
		this.idCart = idCart;
	}

	public int getTotalCourses() {
		return totalCourses;
	}

	public void setTotalCourses(int totalCourses) {
		this.totalCourses = totalCourses;
	}

	public int getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}
}
