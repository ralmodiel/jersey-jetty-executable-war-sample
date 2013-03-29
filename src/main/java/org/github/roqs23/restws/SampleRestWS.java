package org.github.roqs23.restws;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import org.apache.log4j.Logger;

/**
 * Sample resource.
 */
@Path("/sample")
public class SampleRestWS {
	private static Logger logger = Logger.getLogger(SampleRestWS.class);
	
	public SampleRestWS() {
	}
	
	/**
	 * Sample REST WS with JSON response
	 * 
	 * @see    SampleObject
	 */
	@GET
	@Path("/hello/there/json")
	@Produces("application/json")
	public SampleObject helloThereJson(
			final @Context UriInfo ui 
			,@Context HttpServletRequest httpReq
			,@Context HttpServletResponse httpResp) {
		logger.info("--------------------");
		logger.info("*** "+ui.getPath());
		logger.info("*** "+ui.getRequestUri().getRawQuery());
		return(new SampleObject(
						ui.getPath(), 
						ui.getRequestUri().getRawQuery(),
						"hello to you too!" ));
	}
	
	/**
	 * Sample REST WS with pathparam and an XML response.
	 * 
	 * @param  anything Sample PathParam.
	 * 
	 * @see    SampleObject
	 */	
	@GET
	@Path("/hello/there/xml/{anything}")
	@Produces("application/xml")
	public SampleObject helloThereXML(
		    @PathParam("anything") String anything
			,final @Context UriInfo ui 
			,@Context HttpServletRequest httpReq
			,@Context HttpServletResponse httpResp) {
		logger.info("--------------------");
		logger.info("*** "+ui.getPath());
		logger.info("*** "+ui.getRequestUri().getRawQuery());
		return(new SampleObject(
						ui.getPath(), 
						ui.getRequestUri().getRawQuery(),
						"echo="+anything));
	}
}
