/**
 * Classe permettant de générer des commandes effectuées par un client dans l'appli. Le client doit être inséré en base.
 * @author Le-porcherS
 */
package fr.fms.entities;

import java.util.Date;

public class Orders {

	// J'ai essayé d'appeler cette classe Order, mais mariaDB veut pas...

		public int idOrder;
		public Date orderDate;
		public double amount;
		public int idCustomer;
		
		public Orders(int idOrder, Date orderDate, double amount, int idCustomer) {
			super();
			this.idOrder = idOrder;
			this.orderDate = orderDate;
			this.amount = amount;
			this.idCustomer = idCustomer;
		}

		public Orders(Date orderDate, double amount, int idCustomer) {
			super();
			this.orderDate = orderDate;
			this.amount = amount;
			this.idCustomer = idCustomer;
		}

		@Override
		public String toString() {
			return "Orders [idOrder=" + idOrder + ", orderDate=" + orderDate + ", amount=" + amount + ", idCustomer="
					+ idCustomer + "]";
		}

		public int getIdOrder() {
			return idOrder;
		}

		public void setIdOrder(int idOrder) {
			this.idOrder = idOrder;
		}

		public Date getOrderDate() {
			return orderDate;
		}

		public void setOrderDate(Date orderDate) {
			this.orderDate = orderDate;
		}

		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}

		public int getIdCustomer() {
			return idCustomer;
		}

		public void setIdCustomer(int idCustomer) {
			this.idCustomer = idCustomer;
		}
}
