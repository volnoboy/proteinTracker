package com.volnoboy;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * Created by Reuven on 2/8/15.
 */
public class Program {

	public static void main(String[] args) {
		System.out.println("Program started");

		PopulateSampleData();

		Session session  = HibernateUtilities.getSessionFactory().openSession();
		session.enableFilter("nameFilter").setParameter("name", "J%");

		session.beginTransaction();

		Query filterQuery = session.createQuery("from User");
		List<User> filteredUsers = filterQuery.list();
		for (User user : filteredUsers) {
			System.out.println(user.getName());
		}

		Criteria criteria = session.createCriteria(User.class);
		List<User> users = criteria.list();
		for (User user : users) {
			System.out.println(user.getName());
		}

		Query sqlQuery = session.createSQLQuery("SELECT * FROM protein_tracker.Users").addEntity(User.class);
		List<User> sqlUsers = sqlQuery.list();
		for (User user : sqlUsers) {
			System.out.println(user.getName());
		}

		Query query = session.createQuery("update ProteinData pd set pd.goal = 0");
		query.executeUpdate();

		User u = (User) session.load(User.class, 1);
		System.out.println(u.getName());

		session.getTransaction().commit();
		session.close();
		HibernateUtilities.getSessionFactory().close();

		System.out.println("Program executed");
	}

	private static void PopulateSampleData() {
		Session session = HibernateUtilities.getSessionFactory().openSession();
		session.beginTransaction();

		User joe = CreateUser("Joe", 500, 50, "Good job", "You made it!");
		session.save(joe);

		User bob = CreateUser("Bob", 300, 20, "Taco time!");
		session.save(bob);

		User amy = CreateUser("Amy", 250, 200, "Yes!!!");
		session.save(amy);
		session.getTransaction().commit();
		session.close();
	}

	private static User CreateUser(String name, int goal, int total, String ... alerts){
		User user = new User();
		user.setName(name);
		user.getProteinData().setGoal(goal);
		user.addHistory(new UserHistory(new Date(), "Set goal to " + goal));
		user.getProteinData().setTotal(total);
		user.addHistory(new UserHistory(new Date(), "Set total to " + total));
		for(String alert : alerts) {
			user.getGoalAlerts().add(new GoalAlert(alert));
		}

		return user;
	}
}
