package ro.wine.rest.freebase;

import java.io.IOException;

import com.google.gson.*;

import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.net.URLEncoder;

public class Test {
	
	public static void searchTest(String query, String key, String params) throws IOException
	{        
	       String query_envelope = "{\"query\":" + query + "}";
	       String service_url = "https://www.googleapis.com/freebase/v1/search";      

	       String url = service_url    + "?query=" + URLEncoder.encode(query, "UTF-8")
	                                    + params 
	                                    + "&key=" + key;     

	       HttpClient httpclient = new DefaultHttpClient();   
	       HttpResponse response = httpclient.execute(new HttpGet(url));  

	       JsonParser parser = new JsonParser();
	       JsonObject json_data = 
	       (JsonObject)parser.parse(EntityUtils.toString(response.getEntity()));
	       JsonArray results = (JsonArray)json_data.get("result");            

	       if(results != null)
	       {
	           for (Object planet : results) 
	           {
	              System.out.println(((JsonObject)planet).get("name"));
	           }
	       }        
	}

}
