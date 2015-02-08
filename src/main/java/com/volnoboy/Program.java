package com.volnoboy;

import org.hibernate.Session;

/**
 * Created by Reuven on 2/8/15.
 */
public class Program {

	public static void main(String[] args) {
		System.out.println("Program started");

		Session session  = HibernateUtilities.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(generateUser());
		session.getTransaction().commit();

		session.beginTransaction();
		User loadedUser = (User) session.load(User.class, 1);
        System.out.println("User name is: " + loadedUser.getName() + ", and total is " + loadedUser.getTotal());
		loadedUser.setTotal(loadedUser.getTotal() + 7);
		System.out.println("User name is: " + loadedUser.getName() + ", and total is " + loadedUser.getTotal());
		session.getTransaction().commit();

		session.close();
		HibernateUtilities.getSessionFactory().close();
		System.out.println("Program executed");
	}

	public static User generateUser() {
		User user = new User();
		user.setName("Valera");
		user.setGoal(115);
		user.setTotal(5643);
		return user;
	}
}
