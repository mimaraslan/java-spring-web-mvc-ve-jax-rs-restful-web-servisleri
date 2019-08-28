package com.mimaraslan;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
 

// http://localhost:8085/002_RESTfulRESTEasy/rest/kullanici
@Path(value="/kullanici")
public class Merkez {


	// http://localhost:8085/002_RESTfulRESTEasy/rest/kullanici/karisla1	
	@GET
	@Path(value="karisla1")
	@Produces(MediaType.TEXT_PLAIN)
	public String metot1() {
		return "Selamlar RESTful";
	}
	
	// http://localhost:8085/002_RESTfulRESTEasy/rest/kullanici/karisla2	
	@GET
	@Path(value="karisla2")
	@Produces(MediaType.TEXT_PLAIN)
	public Response metot2() {
		return  Response.status(200).entity("Selamlar RESTful").build();	
	}
	
	
	// http://localhost:8085/002_RESTfulRESTEasy/rest/kullanici/selamla/Melek	
	@GET
	@Path(value="selamla/{gelenBilgi}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response metot3(@PathParam("gelenBilgi")  String adi)  {
		return  Response.status(200).entity("Selamlar "+ adi).build();	
	}	
	

	// http://localhost:8085/002_RESTfulRESTEasy/rest/kullanici/selamla/Burak/Umut	
	@GET
	@Path(value="selamla/{gelenBilgi1}/{gelenBilgi2}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response metot4(@PathParam("gelenBilgi1")  String adi,  @PathParam("gelenBilgi2")  String soyadi)  {
		return  Response.status(200).entity("Selamlar "+ adi + " " + soyadi).build();	
		}
	
	
	// http://localhost:8085/002_RESTfulRESTEasy/rest/kullanici/selamla-html/BURAK
	@GET
	@Path(value="selamla-html/{gelenBilgi1}")
	@Produces("text/html")
	public Response metot5(@PathParam("gelenBilgi1")  String adi)  {
		return  Response.status(200).entity("<font size=66>"+ adi + "</font>").build();	
	}	
		 

	// http://localhost:8085/002_RESTfulRESTEasy/rest/kullanici/selamla7/ğüİşö/çÖıĞÜ
	@GET
	@Path(value="selamla7/{adi}/{soyadi}")
	@Produces("text/html"+";charset=utf-8")
	public Response metot7(@PathParam("adi")  String adi, @PathParam("soyadi") String soyadi)  {
		return  Response.status(200).entity("<font size=66>"+ adi + " " + soyadi + "</font>").build();	
	}	
		
	
	// http://localhost:8085/002_RESTfulRESTEasy/rest/kullanici/selamla-xml/Ali	
	@GET
	@Path(value="selamla-xml/{gelenBilgi}")
	@Produces(MediaType.TEXT_XML)
	public Response metot8(@PathParam("gelenBilgi")  String adi)  {
		String sonuc = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> <personel>Merhaba " +  adi +" </personel>";
		
		return  Response.status(200).entity(sonuc).build();	
	}	
	
}










