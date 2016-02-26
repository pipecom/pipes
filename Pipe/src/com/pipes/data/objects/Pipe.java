package com.pipes.data.objects;

public class Pipe {

	private final long pipeId;
	
	//TODO Combine the users into one data structure.
	private final long user1;
	private final long user2;
	
	private String properties;

	public String getProperties() {
		return properties;
	}

	public void setProperties(String properties) {
		this.properties = properties;
	}

	public long getPipeId() {
		return pipeId;
	}

	public long getUser1() {
		return user1;
	}

	public long getUser2() {
		return user2;
	}

	public Pipe(long pipeId, long user1, long user2, String properties) {
		super();
		this.pipeId = pipeId;
		this.user1 = user1;
		this.user2 = user2;
		this.properties = properties;
	}
	
}
