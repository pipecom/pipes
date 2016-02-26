package com.pipes.data.objects;

public class User {

	private final long userId;
	// TODO: Extract thses info to a different DS.
	private String name;
	private String phone;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public long getUserId() {
		return userId;
	}

	public User(long userId, String name, String phone) {
		super();
		this.userId = userId;
		this.name = name;
		this.phone = phone;
	}

	
}
