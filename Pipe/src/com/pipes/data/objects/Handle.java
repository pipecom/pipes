package com.pipes.data.objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Handle {

	private final long handleId;
	private final long userId;
	private String token;
	private String properties;
	private String contactMetadata;

	@SuppressWarnings("unused")
	private Handle() {
		this(-1, -1, null, null, null);
	}

	public Handle(long handleId, long userId, String token, String properties,
			String contactMetadata) {
		super();
		this.handleId = handleId;
		this.userId = userId;
		this.token = token;
		this.properties = properties;
		this.contactMetadata = contactMetadata;
	}

	public String getContactMetadata() {
		return contactMetadata;
	}

	public void setContactMetadata(String contactMetadata) {
		this.contactMetadata = contactMetadata;
	}

	public String getProperties() {
		return properties;
	}

	public void setProperties(String properties) {
		this.properties = properties;
	}

	public long getHandleId() {
		return handleId;
	}

	public long getUserId() {
		return userId;
	}

	public String getToken() {
		return token;
	}

}
