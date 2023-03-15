package fr.fms.business;


import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;

import fr.fms.dao.CoursesDao;
import fr.fms.dao.CategoryDao;
import fr.fms.dao.CustomerDao;
import fr.fms.dao.Dao;
import fr.fms.dao.DaoFactory;
import fr.fms.entities.Courses;
import fr.fms.entities.Category;
import fr.fms.entities.Customer;
import fr.fms.entities.Orders;
import fr.fms.entities.Cart;
import fr.fms.entities.Users;

public class IBusinessImpl implements IBusiness {	
	private HashMap<Integer,Courses> cart;
	private Dao<Courses> coursesDao = DaoFactory.getArticleDao();
	private Dao<Users> userDao = DaoFactory.getUserDao();
	private Dao<Category> categoryDao = DaoFactory.getCategoryDao();
	private Dao<Orders> orderDao = DaoFactory.getOrderDao();
	private Dao<Cart> orderItemDao = DaoFactory.getOrderItemDao();
	private Dao<Customer> customerDao = DaoFactory.getCustomerDao();
	
	public IBusinessImpl() {
		this.cart = new HashMap<Integer,Courses>();
	}

	@Override
	public void addToCart(Cart courses) {
		Courses art = cart.get(courses.getIdCart());
		if(art.getTotalCourses != null) {
			art.setTotalCourses(art.getTotalCourses() + 1);
		}
		else cart.put(article.getId(), article);
	}

	@Override
	public void rmFromCart(int id) {
		Courses course = cart.get(id);
		if(course != null) {
			if(course.getQuantity() == 1)	cart.remove(id);
			else course.setQuantity(course.getQuantity() - 1);
		}				
	}

	@Override
	public ArrayList<Courses> getCart() {
		return new ArrayList<Courses> (cart.values());
	}

	@Override
	public int order(int idCustomer) {	
		if(customerDao.read(idCustomer) != null) {
			double total = getTotal(); 
			Orders order = new Orders(total, new Date(), idCustomer);
			if(orderDao.create(order)) {	
				for(Courses article : cart.values()) {	
					cartDao.create(new Cart(0, article.getId(), article.getQuantity(), article.getPrice(), order.getIdOrder()));
				}
				return order.getIdOrder();
			}
		}
		return 0;
	}

	@Override
	public ArrayList<Courses> readArticles() {
		return coursesDao.readAll();
	}
	
	@Override
	public ArrayList<Category> readCategories() {
		return categoryDao.readAll();
	}

	@Override
	public Courses readOneArticle(int id) {
		return coursesDao.read(id);
	}

	@Override
	public ArrayList<Courses> readArticlesByCatId(int id) {
		return ((CoursesDao) coursesDao).readAllByCat(id);
	}

	/**
	 * renvoi le total de la commande en cours
	 * @return total
	 */
	public double getTotal() {
		double [] total = {0};
		cart.values().forEach((a) -> total[0] += a.getPrice() * a.getQuantity()); 	
		return total[0];
	}

	public boolean isCartEmpty() {
		return cart.isEmpty();
	}
	
	public void clearCart() {
		cart.clear();		
	}

	public Category readOneCategory(int id) {
		return categoryDao.read(id);
	}
}

