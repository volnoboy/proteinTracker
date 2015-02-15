package com.volnoboy;

/**
 * Created by Reuven on 2/15/15.
 */
public class GoalAlert {
	private int Id;
	private String message;

	public GoalAlert(String message) {
		this.message = message;
	}

	public GoalAlert() {

	}

	public int getId() {
		return Id;

	}

	public void setId(int id) {
		Id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
