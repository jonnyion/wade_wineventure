package ro.wine.rest.freebase;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import ro.wine.rest.common.Constants;

public class Freebase {
	  public JSONArray wines( String condition )throws Exception{
	      HttpTransport httpTransport = new NetHttpTransport();
	      HttpRequestFactory requestFactory = httpTransport.createRequestFactory();
	      JSONParser parser = new JSONParser();
	      String query = Constants.QUERY_START+Constants.BASIC_FIELDS+condition+Constants.TYPE_WINE + Constants.QUESRY_END;
	      GenericUrl url = new GenericUrl("https://www.googleapis.com/freebase/v1/mqlread");
	      url.put("query", query);
	      url.put("key", Constants.FREEBASE_KEY);
	      HttpRequest request = requestFactory.buildGetRequest(url);
	      HttpResponse httpResponse = request.execute();
	      JSONObject response = (JSONObject)parser.parse(httpResponse.parseAsString());
	      JSONArray results = (JSONArray)response.get("result");
	      return results;
	}
	  
	  public JSONArray vineyard( String condition )throws Exception{
	      HttpTransport httpTransport = new NetHttpTransport();
	      HttpRequestFactory requestFactory = httpTransport.createRequestFactory();
	      JSONParser parser = new JSONParser();
	      String query = Constants.QUERY_START+Constants.BASIC_FIELDS+condition+Constants.TYPE_WINE + Constants.QUESRY_END;
	      GenericUrl url = new GenericUrl("https://www.googleapis.com/freebase/v1/mqlread");
	      url.put("query", query);
	      url.put("key", Constants.FREEBASE_KEY);
	      HttpRequest request = requestFactory.buildGetRequest(url);
	      HttpResponse httpResponse = request.execute();
	      JSONObject response = (JSONObject)parser.parse(httpResponse.parseAsString());
	      JSONArray results = (JSONArray)response.get("result");
	      return results;
	}
}
