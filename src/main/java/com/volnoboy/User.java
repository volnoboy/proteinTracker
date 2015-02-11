package com.volnoboy;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Reuven on 2/8/15.
 */
public class User {
	private int id;
	private String name;

	private ProteinData proteinData = new ProteinData();

	private Collection<UserHistory> history = new ArrayList<UserHistory>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProteinData getProteinData() {
		return proteinData;
	}

	public void setProteinData(ProteinData proteinData) {
		this.proteinData = proteinData;
	}

	public Collection<UserHistory> getHistory() {
		return history;
	}

	public void setHistory(Collection<UserHistory> history) {
		this.history = history;
	}


}
