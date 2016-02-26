package com.pipe.jersey.sample;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/pipe")
public class PipeResource {
	@GET
	public String getTodoHTML() {
		return "Hello World !! - pipe";
	}
}
