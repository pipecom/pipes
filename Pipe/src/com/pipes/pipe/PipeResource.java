package com.pipes.pipe;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/pipe")
public class PipeResource {
	@GET
	public String getPipe() {
		return "Pipe has been created";
	}
}
