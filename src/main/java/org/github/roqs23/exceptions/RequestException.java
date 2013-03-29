package org.github.roqs23.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.sun.jersey.api.Responses;

public class RequestException extends WebApplicationException {
	private static Logger logger = Logger.getLogger(RequestException.class);

	public RequestException() {
        super(Response.status(Responses.NOT_FOUND).entity("Request Not Found").type(MediaType.APPLICATION_JSON).build());
    }
	

}