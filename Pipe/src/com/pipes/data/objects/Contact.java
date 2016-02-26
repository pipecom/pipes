package com.pipes.data.objects;

public class Contact {

	private final long contactId;
	private final long userId;
	private final long pipeId;

	//TODO change the contact meta data to more than Name
	private String contactMetadata;
	
	private String callingPhone;
	// TODO Not needed can be required from the contacts table
	private String callerPhone;

	public String getContactMetadata() {
		return contactMetadata;
	}
	public void setContactMetadata(String contactMetadata) {
		this.contactMetadata = contactMetadata;
	}
	public String getCallingPhone() {
		return callingPhone;
	}
	public void setCallingPhone(String callingPhone) {
		this.callingPhone = callingPhone;
	}
	public String getCallerPhone() {
		return callerPhone;
	}
	public void setCallerPhone(String callerPhone) {
		this.callerPhone = callerPhone;
	}
	public long getContactId() {
		return contactId;
	}
	public long getUserId() {
		return userId;
	}
	public Contact(long contactId, long userId, long pipeId,
			String contactMetadata, String callingPhone, String callerPhone) {
		super();
		this.contactId = contactId;
		this.userId = userId;
		this.pipeId = pipeId;
		this.contactMetadata = contactMetadata;
		this.callingPhone = callingPhone;
		this.callerPhone = callerPhone;
	}
	
}
