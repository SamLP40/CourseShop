package fr.fms.dao;

import fr.fms.entities.Cart;
import fr.fms.entities.Category;
import fr.fms.entities.Courses;
import fr.fms.entities.Customer;
import fr.fms.entities.Orders;
import fr.fms.entities.Users;

public class DaoFactory {

	public static Dao<Courses> getArticleDao() {
		return new CoursesDao();		
	}
	
	public static Dao<Users> getUserDao() {
		return new UsersDao();
	}
	
 	public static Dao<Category> getCategoryDao() {
 		return new CategoryDao();
 	}
 	
 	public static Dao<Orders> getOrderDao() {
 		return new OrdersDao();
 	}
 	
 	public static Dao<Cart> getOrderItemDao() {
 		return new CartDao();
 	}
 	
 	public static Dao<Customer> getCustomerDao() {
 		return new CustomerDao();
 	}
}
