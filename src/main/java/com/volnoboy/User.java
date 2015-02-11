package com.volnoboy;

/**
 * Created by Reuven on 2/8/15.
 */
public class User {
	private int id;
	private String name;

	public ProteinData getProteinData() {
		return proteinData;
	}

	public void setProteinData(ProteinData proteinData) {
		this.proteinData = proteinData;
	}

	private ProteinData proteinData = new ProteinData();

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


}
