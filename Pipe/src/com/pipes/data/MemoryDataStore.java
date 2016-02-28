package com.pipes.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import com.pipes.data.objects.Contact;
import com.pipes.data.objects.Handle;
import com.pipes.data.objects.Pipe;
import com.pipes.data.objects.User;

public class MemoryDataStore implements IDataStore {

	private final AtomicInteger tokenGen = new AtomicInteger(1);

	private final AtomicInteger handleIdGen = new AtomicInteger(1);
	private final Map<Long, Handle> handles = new HashMap<Long, Handle>();

	private final AtomicInteger pipeIdGen = new AtomicInteger(1);
	private final Map<Long, Pipe> pipes = new HashMap<Long, Pipe>();

	private final AtomicInteger userIdGen = new AtomicInteger(1);
	private final Map<Long, User> users = new HashMap<Long, User>();

	private final AtomicInteger contactIdGen = new AtomicInteger(1);
	private final Map<Long, Contact> contacts = new HashMap<Long, Contact>();

	private MemoryDataStore() {
		User alice = new User(userIdGen.getAndIncrement(), "Alice", "XXX");
		User bob = new User(userIdGen.getAndIncrement(), "Bob", "YYY");
		User trudy = new User(userIdGen.getAndIncrement(), "Trudy", "ZZZ");
		users.put(alice.getUserId(), alice);
		users.put(bob.getUserId(), bob);
		users.put(trudy.getUserId(), trudy);
	}

	private static MemoryDataStore sMemoryDataStore = new MemoryDataStore();

	public static IDataStore getDataStore() {
		return sMemoryDataStore;
	}

	@Override
	public List<Contact> getContactsForId(long userId) {
		List<Contact> contactList = new ArrayList<Contact>();
		for (Contact contact : contacts.values()) {
			if (contact.getUserId() == userId) {
				contactList.add(contact);
			}
		}
		return contactList;
	}

	@Override
	public Handle createHandle(long userId, String contactMetaData, String properties) {
		String token = "T" + tokenGen.getAndIncrement();
		Handle handle = new Handle(handleIdGen.getAndIncrement(), userId, token, properties, contactMetaData);
		handles.put(handle.getHandleId(), handle);
		return handle;
	}

	@Override
	public Pipe createPipe(long userId, String contactMetaData, String token, String properties) {
		Handle neededHandle = null;
		for (Handle handle : handles.values()) {
			if (token.equals(handle.getToken())) {
				neededHandle = handle;
				break;
			}
		}
		if (neededHandle == null) {
			return null;
		}

		// resolve properties
		String newProperties = getStrictProperties(neededHandle.getProperties(), properties);

		// create pipe
		Pipe pipe = new Pipe(pipeIdGen.getAndIncrement(), userId, neededHandle.getUserId(), newProperties);
		pipes.put(pipe.getPipeId(), pipe);

		// create and add contacts;
		Random r = new Random(System.currentTimeMillis());
		String ph1 = "" + r.nextInt();
		String ph2 = "" + r.nextInt();
		Contact c1 = new Contact(contactIdGen.getAndIncrement(), userId, pipe.getPipeId(), contactMetaData, ph1, ph2);
		Contact c2 = new Contact(contactIdGen.getAndIncrement(), neededHandle.getUserId(), pipe.getPipeId(),
				neededHandle.getContactMetadata(), ph2, ph1);

		contacts.put(c1.getContactId(), c1);
		contacts.put(c2.getContactId(), c2);

		return pipe;
	}

	private String getStrictProperties(String p1, String p2) {
		// TODO for now return p1
		return p1;
	}
}
