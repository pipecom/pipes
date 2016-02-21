package com.pipe.jersey.sample;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/handle")
public class HandleResource {
	@GET
	public String getTodoHTML() {
		return "Hello World !! - Jersey 2";
	}
}
