package com.mimaraslan;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

// http://localhost:8085/007_RESTfulServer/ctofservice
@Path(value="/ctofservice")
public class CtoFService {
	
	
	
	// http://localhost:8085/007_RESTfulServer/ctofservice
	@GET
	@Produces("application/xml")
	public String cevirCtoF() {
		Double fahrenheit;
		Double celsius = 20.5;
	
		fahrenheit = ((celsius * 9) / 5) + 32;	
		
		String sonuc = "C to F Sonucu : \n" +  fahrenheit;

		return "<ctofservice>\n" + 
				"	<celsius>"+ celsius +"</celsius>\n" + 
				"	<fahrenheit>"+ sonuc +"</fahrenheit>\n" + 
				"</ctofservice>";
	}
	
	
	
	
	// http://localhost:8085/007_RESTfulServer/ctofservice/20.5/ver/xml
	@GET
	@Path("{celsius}/ver/xml")
	@Produces("application/xml")
	public String cevirCtoFDetay2(@PathParam("celsius") Double celsius) {
		
		Double fahrenheit = ((celsius * 9) / 5) + 32;	
	
		return "<ctofservice>\n" + 
				"	<celsius>"+ celsius +"</celsius>\n" + 
				"	<fahrenheit>"+ fahrenheit +"</fahrenheit>\n" + 
				"</ctofservice>";
	}
	
	
	
	
	// http://localhost:8085/007_RESTfulServer/ctofservice/20.5/ver/json
	@GET
	@Path("{celsius}/ver/json")
	@Produces("application/json")
	public Response cevirCtoFDetay3(@PathParam("celsius") Double celsius) {
		 
		JSONObject jsonObject = new JSONObject();
		
		Double fahrenheit = ((celsius * 9) / 5) + 32;	
	
		jsonObject.put("F Value", fahrenheit);
		jsonObject.put("C Value", celsius);
		
		
		return  Response.status(200).entity(jsonObject.toString()).build();
	}
		

}
