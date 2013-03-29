package org.github.roqs23.exceptions;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.log4j.Logger;

import com.sun.jersey.api.NotFoundException;

@Provider
public class NotFoundExceptionMapper implements
		ExceptionMapper<NotFoundException> {
	private static Logger logger = Logger.getLogger(NotFoundExceptionMapper.class);

	private static String defaultError = "Not Found.";
	

	@Override
	public Response toResponse(NotFoundException e) {
		//logger.fatal(e.getMessage(), e);
		return Response.status(Response.Status.BAD_REQUEST)
				.entity(defaultError).type(MediaType.APPLICATION_JSON).build();
	}
}
