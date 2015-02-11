package com.volnoboy;

import java.util.Date;

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
        System.out.println("User name is: " + loadedUser.getName() + ", and total is " + loadedUser.getProteinData().getTotal());
		for (UserHistory history : loadedUser.getHistory()) {
			System.out.println(history.getEntryTime().toString() + " " + history.getEntry());
		}

		loadedUser.getProteinData().setTotal(loadedUser.getProteinData().getTotal() + 7);
		loadedUser.getHistory().add(new UserHistory(new Date(), "Added 50 protein"));
		System.out.println("User name is: " + loadedUser.getName() + ", and total is " + loadedUser.getProteinData().getTotal());
		session.getTransaction().commit();

		session.close();
		HibernateUtilities.getSessionFactory().close();
		System.out.println("Program executed");
	}

	public static User generateUser() {
		User user = new User();
		user.setName("Valera");
		user.getHistory().add(new UserHistory(new Date(), "Set name to Valera"));
		user.getProteinData().setGoal(115);
		user.getProteinData().setTotal(5643);
		user.getHistory().add(new UserHistory(new Date(), "Set the goal to 250"));
		return user;
	}
}
