package com.pipes.pipe;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/handle")
public class HandleResource {
	@GET
	public String getHandle() {
		return "Handle has been created";
	}
}
