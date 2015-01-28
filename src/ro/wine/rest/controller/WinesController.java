package ro.wine.rest.controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ro.wine.rest.freebase.Freebase;
import ro.wine.rest.common.*;

import com.google.gson.*;

@Path("/v1/wines")
public class WinesController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getWinesByFilter(
			@QueryParam("name") String name,
			@QueryParam("id") String id, 
			@QueryParam("vintage") String vintage,
			@QueryParam("color") String color,
			@QueryParam("percentage_alcohol") String alcohol,
			@QueryParam("fruit_source") String fsource,
			@QueryParam("country") String country,
			@QueryParam("region") String region,
			@QueryParam("subregion") String subregion,
			@QueryParam("wine_type") String winetype,
			@QueryParam("wine_producer") String wine_producer,
			@QueryParam("vineyard") String vineyard
			) throws Exception {
		String returnString = null;
		try {
			StringBuilder sb = new StringBuilder();
			if (name == null && id == null && vintage == null && color == null
					&& alcohol == null && fsource == null && country == null
					&& region == null && subregion == null && winetype == null) {
				return Response
						.status(400)
						.entity("Error: please specify at lest oane filter for this search")
						.build();
			}

			if (name != null) {
				sb.append(String.format(Constants.QUERY_WINE_NAME, name));
			}

			if (id != null) {
				sb.append(String.format(Constants.QUERY_WINE_ID, id));
			}

			if (vintage != null) {
				sb.append(String.format(Constants.QUERY_WINE_VINTAGE, vintage));
			}

			if (color != null) {
				sb.append(String.format(Constants.QUERY_WINE_COLOR, color));
			}

			if (alcohol != null) {
				sb.append(String.format(Constants.QUERY_WINE_ALCOHOL, alcohol));
			}

			if (fsource != null) {
				sb.append(String.format(Constants.QUERY_WINE_FRUIT_S, fsource));
			}

			if (country != null) {
				sb.append(String.format(Constants.QUERY_WINE_COUNTRY, country));
			}

			if (region != null) {
				sb.append(String.format(Constants.QUERY_WINE_REGION, region));
			}

			if (subregion != null) {
				sb.append(String.format(Constants.QUERY_WINE_SUBREGION,
						subregion));
			}

			if (winetype != null) {
				sb.append(String.format(Constants.QUERY_WINE_TYPE, winetype));
			}

			Freebase freebase = new Freebase();
			returnString = freebase.wines(sb.toString()).toString();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500)
					.entity("Server was not able to process your request")
					.build();
		}

		return Response.ok(returnString).build();
	}

	@POST
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED,
			MediaType.APPLICATION_JSON })
	@Produces(MediaType.APPLICATION_JSON)
	public Response getWinesByFilter(String incomingData) throws Exception {

		String returnString = null;
		try {
			JsonObject filter = (JsonObject) new JsonParser()
					.parse(incomingData);
			if (filter == null) {
				return Response
						.status(400)
						.entity("Error: please specify at lest oane filter for this search")
						.build();
			}

			StringBuilder sb = new StringBuilder();
			String select = "";
			sb.append(getFilter(Constants.FLD_NAME,Constants.QUERY_WINE_NAME,filter));
			sb.append(getFilter(Constants.FLD_VINTAGE,Constants.QUERY_WINE_VINTAGE,filter));
			sb.append(getFilter(Constants.FLD_COUNTRY,Constants.QUERY_WINE_COUNTRY,filter));
			sb.append(getFilter(Constants.FLD_ALCOHOL,Constants.QUERY_WINE_ALCOHOL,filter));
			sb.append(getFilter(Constants.FLD_REGION,Constants.QUERY_WINE_REGION,filter));
			sb.append(getFilter(Constants.FLD_COLOR,Constants.QUERY_WINE_COLOR,filter));
			sb.append(getFilter(Constants.FLD_PRODUCER,Constants.QUERY_WINE_PRODUCER,filter));
			sb.append(getFilter(Constants.FLD_WINE_TYPE,Constants.QUERY_WINE_TYPE,filter));
			sb.append(getFilter(Constants.FLD_VINEYARD,Constants.QUERY_WINE_VINEYARD,filter));
			sb.append(getFilter(Constants.FLD_FRUIT_S,Constants.QUERY_WINE_FRUIT_S,filter));
			sb.append(getFilter(Constants.FLD_ID,Constants.QUERY_WINE_ID,filter));

			Freebase freebase = new Freebase();
			returnString = freebase.wines(sb.toString()).toString();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500)
					.entity("Server was not able to process your request")
					.build();
		}

		return Response.ok(returnString).build();
	}

	@GET
	@Path("/search")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSearch(@QueryParam("key") String key) throws Exception {
		String returnString = null;
		try {
			if (key == null) {
				return Response.status(400)
						.entity("Error: please specify key for this search")
						.build();
			}
			Freebase freebase = new Freebase();
			String search = String.format(Constants.QUERY_SEARCH, key);
			returnString = freebase.wines(search).toString();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500)
					.entity("Server was not able to process your request")
					.build();
		}

		return Response.status(200).entity(returnString).build();
	}

	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getWineById(@PathParam("id") String id) throws Exception {

		String returnString = null;
		try {
			if (id == null) {
				return Response.status(400)
						.entity("Error: please specify id for this search")
						.build();
			}
			Freebase freebase = new Freebase();
			String search = String.format(Constants.QUERY_WINE_ID, id);
			returnString = freebase.wines(search).toString();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500)
					.entity("Server was not able to process your request")
					.build();
		}

		return Response.ok(returnString).build();
	}
	
	public String getFilter(String field, String query, JsonObject filter )
	{
		String select = "";
		if ( filter.get(field) !=null)
		{
			select= filter.get(field).getAsString();
		}
		if (select != null && !select.isEmpty()) {
			return String.format(query, select);
		}
		return "";
	}

}
