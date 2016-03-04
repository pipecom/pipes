package com.pipes.pipe;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.pipes.data.MemoryDataStore;
import com.pipes.data.objects.Handle;
import com.pipes.data.objects.Pipe;

@Path("/pipe")
public class PipeResource {
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createPipe(Handle handle) {
		Pipe pipeCreated = MemoryDataStore.getDataStore().createPipe(handle.getUserId(),
								handle.getContactMetadata(),
								handle.getToken(), handle.getProperties());
		
		return Response.status(201).entity(pipeCreated).build();
	}
}
