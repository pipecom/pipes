package com.pipes.data;

import java.util.List;

import com.pipes.data.objects.Contact;
import com.pipes.data.objects.Handle;
import com.pipes.data.objects.Pipe;

public interface IDataStore {
	/**
	 * get the list for contacts for a user id
	 * @param userId
	 * @return
	 */
	public List<Contact> getContactsForId(long userId);


	/**
	 * creates an handle
	 * @param userId
	 * @param properties
	 * @return
	 */
	public Handle createHandle(long userId, String contactMetaData, String properties);

	/**
	 * creates the pipe.
	 * @param userId
	 * @param token
	 * @param properties
	 * @return
	 */
	public Pipe createPipe(long userId, String contactMetaData, String token, String properties);
}
