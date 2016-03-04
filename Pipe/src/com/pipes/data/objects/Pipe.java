package com.pipes.data.objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
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

	@SuppressWarnings("unused")
	private Pipe() {
		this(-1, -1, -1, null);
	}

	public Pipe(long pipeId, long user1, long user2, String properties) {
		super();
		this.pipeId = pipeId;
		this.user1 = user1;
		this.user2 = user2;
		this.properties = properties;
	}
	
}
