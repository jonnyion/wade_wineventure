package ro.wine.rest.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ro.wine.rest.common.Constants;
import ro.wine.rest.freebase.Freebase;

@Path("/v1/vineyard")
public class VineyardController {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSearch(@QueryParam("name") String name) throws Exception {
		String returnString = null;
		try {
			if (name == null) {

			}
			Freebase freebase = new Freebase();
			String search = String.format(Constants.QUERY_SEARCH, name);
			returnString = freebase.wines(search).toString();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500)
					.entity("Server was not able to process your request")
					.build();
		}

		return Response.ok(returnString).build();
	}

}
