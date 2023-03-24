package fr.fms.authenticate;

import fr.fms.dao.CustomerDao;
import fr.fms.dao.Dao;
import fr.fms.dao.DaoFactory;
import fr.fms.dao.UsersDao;
import fr.fms.entities.Customer;
import fr.fms.entities.Users;

public class Authenticate {

	private Dao<Customer> customerDao = DaoFactory.getCustomerDao();
	private Dao<Users> userDao = DaoFactory.getUserDao();

	/**
	 * méthode qui vérifie si login et pwd correspond à un utilisateur en base
	 * @param log
	 * @param pwd
	 * @return id de l'utilisateur, 0 si non trouvé
	 */
	public int existUser(String log, String pwd) {
		Users user = ((UsersDao)userDao).findUserByCredentials(log,pwd);
		if(user != null )	return user.getIdUser();
		return 0;
	}
	
	/**
	 * méthode qui vérifie si login correspond à un utilisateur en base
	 * @param log
	 * @return id de l'utilisateur, 0 si non trouvé
	 */
	public int existUser(String log) {
		Users user = ((UsersDao)userDao).findUserByLogin(log);
		if(user != null )	return user.getIdUser();
		return 0;
	}

	/**
	 * méthode qui renvoi un client correspondant à un email (unique en base)
	 * @param email 
	 * @return client
	 */
	public Customer existCustomerByEmail(String email) {
		return ((CustomerDao)customerDao).findCustomerByEmail(email);
	}

	public void addUser(String email, String password) {
		userDao.create(new Users(email, password));		
	}

	public boolean addCustomer(Customer customer) {
		return customerDao.create(customer);		
	}
}
