package fr.fms;

import java.util.Scanner;
import java.util.function.Predicate;

import fr.fms.dao.CoursesDao;
import fr.fms.dao.CustomerDao;
import fr.fms.dao.Dao;
import fr.fms.dao.DaoFactory;
import fr.fms.dao.UsersDao;
import fr.fms.entities.Courses;
import fr.fms.entities.Users;
/**
 * Programme exécutable qui permet de tester l'application CourseShop.
 * @author Le-porcherS
 *
 */
public class TestCourse extends Thread {

	/**
	 * Méthode qui permet de lancer l'application CourseShop.
	 * @param name
	 */
	public TestCourse(String name) {
	    super(name);
	  }
	  public void run(){
		  try {
			Thread.sleep(1000);
		 } catch (InterruptedException e) {
			e.printStackTrace();
		 }
		 System.out.println(this.getName() + " : " + new CoursesDao().read(1));
		 System.out.println(this.getName() + " : " + new UsersDao().read(1));
		 System.out.println(this.getName() + " : " + new CustomerDao().read(1));
	  }      
	
	  /**
	   * Programme principal servant à tester CourseShop.
	   * 
	   * @param args
	   */
	public static void main(String[] args) {	
		testThreads();
//		new UsersDao().create(new User("toto", "123"));
//		testDaoFactory();
//		testUsersCourses();		
//		testUsersDao();		
//		testCoursesDao();
//		ArticleDao articleDao = new ArticleDao();
//		articleDao.createPrepared(new Article("S9","Samsung",250));		
	}

	private static void testThreads() {
		TestCourse t1 = new TestCourse(" 1-");
		TestCourse t2 = new TestCourse(" 2-");
		TestCourse t3 = new TestCourse(" 3-");
		TestCourse t4 = new TestCourse(" 4-");
		TestCourse t5 = new TestCourse(" 5-");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
	private static void testUserCourse() {
		Scanner scan = new Scanner(System.in);
		UsersDao userDao = new UsersDao();		
		System.out.println("saisissez votre identifiant :");
		String login = scan.nextLine();
		System.out.println("saisissez votre password :");
		String pwd = scan.nextLine();		
		//méthode 1 pas très performante
//		for(User user : userDao.readAll()) {
//			if(login.equalsIgnoreCase(user.getLogin()) && pwd.equalsIgnoreCase(user.getPwd())) {
//				for(Article article : new ArticleDao().readAll()) {
//					System.out.println(article);
//				}
//			}	
//		}	
		
		//méthode 2
		Users user = userDao.findUserByCredentials(login, pwd);
		if(user != null) {
			for(Courses course : new CoursesDao().readAll()) {
				System.out.println(course);
			}
		}
		else System.out.println("accès refusé !");
			
		scan.close();
		//userDao.create(new User("mohamed","123"));
	}

	//afficher tous les utilisateurs en base
	private static void testUserDao() {
		UsersDao userDao = new UsersDao();
		
		for(Users user : userDao.readAll())
			System.out.println(user);
	}
	//----------------test les méthodes Crud du composant d'accès aux données : CourseDao
	private static void testArticleDao() {
		CoursesDao coursesDao = new CoursesDao();
		
		//Afficher tous les articles
		for(Courses course : coursesDao.readAll()) {
			System.out.println(course);
		}	
		System.out.println();
		//Afficher un article à partir de son id
		Courses course = coursesDao.read(5);
		System.out.println(course);
		
		//Mise à jour de l'article
		course.setDescription("");
		coursesDao.update(course);
		
		//Supprimer un article
		if(course != null)		
			coursesDao.delete(course);
		
		//Insertion de l'article en base
		if(course != null)		
			coursesDao.create(course);
		
		System.out.println();
		//Afficher tous les articles
		for(Courses art : coursesDao.readAll()) {
			System.out.println(art);
		}			
	}
	
	//test notre fabrique à objet ou composant d'accès
	private static void testDaoFactory() {
		Dao<Users> userDao = DaoFactory.getUserDao();
			
		Predicate<Courses> artPredicate = a -> a.getIdCourse() >= 5 && (a.getPrice() > 50 && a.getPrice() < 100); 
		DaoFactory.getArticleDao().readAll()
					.stream()
					.filter(artPredicate)
					.forEach(System.out::println);
			
		System.out.println("---------------------------------------------");
		
		userDao.readAll().forEach(user -> System.out.println(user));
	}
}
