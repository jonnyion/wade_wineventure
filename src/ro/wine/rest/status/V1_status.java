package ro.wine.rest.status;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/v1")
public class V1_status {

	public static final String VERSION = "00.01.00";
	@GET
	@Produces(MediaType.TEXT_HTML)
	public Response  returnTitle()
	{
		return Response.ok("This is the root of the api").build();
	}
	
	@GET
	@Path("/version")
	@Produces(MediaType.TEXT_HTML)
	public Response  returnVersion()
	{
		return Response.ok("Current version is:" + VERSION ).build();
	}
	
	@GET
	@Path("/status")
	@Produces(MediaType.TEXT_HTML)
	public Response  returnStatus()
	{
		return Response.ok("Rest api is up!").build();
	}
	
	
}
