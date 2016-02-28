package com.pipes.pipe;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.pipes.data.MemoryDataStore;
import com.pipes.data.objects.Handle;

@Path("/handle")
public class HandleResource {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createHandle(Handle handle) {
		System.out.println("Inside createHandle");
		Handle handleCreated = MemoryDataStore.getDataStore().createHandle(handle.getUserId(),
				handle.getContactMetadata(), handle.getProperties());
		return Response.status(201).entity(handleCreated).build();
	}
}
