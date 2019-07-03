package hibernate.hibernate_maven_inheritance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		try {
			
			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
					.addAnnotatedClass(Car.class).addAnnotatedClass(Manual.class).buildSessionFactory();
			
			Session session = factory.openSession();
			
			session.getTransaction().begin();
//			Automatic a = new Automatic();
			Manual a = new Manual();
			Car c =  new Car();
			a.setCarColor("black");
			a.setMakeYear("2019");
			// when we create car object then dont set type..it will set as null
			a.setIsAutomatic("true");
			session.save(a);
			session.getTransaction().commit();
			
			
			session.getTransaction().begin();

			c.setCarColor("gray");
			c.setMakeYear("2018");
			
			session.save(c);
			session.getTransaction().commit();
			System.out.println("done...");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
