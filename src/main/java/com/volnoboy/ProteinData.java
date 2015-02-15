package com.volnoboy;

/**
 * @author Volodymyr Volnoboy (vvolnoboy@luxoft.com)
 * @since 2/11/15 11:33 AM
 */
public class ProteinData {

	private int Id;
	private User user;
	private int total;
	private int goal;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getGoal() {
		return goal;
	}

	public void setGoal(int goal) {
		this.goal = goal;
	}
}
