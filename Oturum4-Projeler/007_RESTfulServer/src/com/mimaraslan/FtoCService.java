package com.mimaraslan;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

// http://localhost:8085/007_RESTfulServer/ftocservice
@Path(value="/ftocservice")
public class FtoCService {
	
	
	
	// http://localhost:8085/007_RESTfulServer/ftocservice
	@GET
	@Produces("application/xml")
	public String cevirFtoC() {
		
		Double fahrenheit = 20.5;
		Double celsius = (fahrenheit - 32) * 5 / 9;

		return "<ftocservice>\n" + 
				"	<celsius>"+ celsius +"</celsius>\n" + 
				"	<fahrenheit>"+ fahrenheit +"</fahrenheit>\n" + 
				"</ftocservice>";
	}
	
	
	
	// http://localhost:8085/007_RESTfulServer/ftocservice/20.5/ver/json
	@GET
	@Path("{fahrenheit}/ver/json")
	@Produces("application/json")
	public Response cevirFtoC2(@PathParam("fahrenheit") Double fahrenheit) {
		JSONObject jsonObject = new JSONObject();

		Double celsius = (fahrenheit - 32) * 5 / 9;
		
		jsonObject.put("F", fahrenheit);
		jsonObject.put("C", celsius);
		
		return  Response.status(200).entity(jsonObject.toString()).build();
	}
	
	
	
	// http://localhost:8085/007_RESTfulServer/ftocservice/20.5/ver/xml
	@GET
	@Path("{fahrenheit}/ver/xml")
	@Produces("application/xml")
	public String cevirCtoFDetay2(@PathParam("fahrenheit") Double fahrenheit) {
		
		Double celsius = (fahrenheit - 32) * 5 / 9;	
	
		return "<ftocservice>\n" + 
				"	<celsius>"+ celsius +"</celsius>\n" + 
				"	<fahrenheit>"+ fahrenheit +"</fahrenheit>\n" + 
				"</ftocservice>";
	}
	

		

}
