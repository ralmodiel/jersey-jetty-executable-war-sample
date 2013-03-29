package org.github.roqs23.exceptions;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.log4j.Logger;

@Provider
public class RuntimeExceptionMapper implements ExceptionMapper<RuntimeException> {
private static Logger logger = Logger.getLogger(RuntimeExceptionMapper.class);

private static String defaultError = "Server Error.";

@Override
public Response toResponse(RuntimeException e) {
	logger.fatal(e.getMessage(), e);
    return Response.status(400).entity(defaultError).type(MediaType.APPLICATION_JSON).build();
    }
}