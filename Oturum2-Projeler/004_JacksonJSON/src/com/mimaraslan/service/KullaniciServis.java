package com.mimaraslan.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mimaraslan.model.Kullanici;

//    http://localhost:8085/004_JacksonJSON/rest/kullanici
@Path(value="/kullanici")
public class KullaniciServis {

	
//	http://localhost:8085/004_JacksonJSON/rest/kullanici/detay/xml/1
	@GET
	@Path(value="/detay/xml/{id}")
	@Produces(MediaType.APPLICATION_XML)
//	@Produces("application/xml"+";charset=utf=8")
	public Response getKullaniciBilgisi1(@PathParam("id") Integer id) {
		
		Kullanici kullanici = new Kullanici(id, "Melek", "Kocabey");
		
		//Kullanici kullanici = new Kullanici();
		//kullanici.setKullaniciId(1);
		//kullanici.setKullaniciAdi("Melek");
		//kullanici.setKullaniciSoyadi("Kocabey");
		
		return Response.status(200).entity(kullanici).build();
	}
	
	
	
//	http://localhost:8085/004_JacksonJSON/rest/kullanici/detay/xml/1/ÖMER/METİN
	@GET
	@Path(value="/detay/xml/{id}/{adi}/{soyadi}")
	//@Produces(MediaType.APPLICATION_XML)
		@Produces("application/xml"+";charset=utf-8")
	public Response getKullaniciBilgisi2(
			@PathParam("id") Integer id,
			@PathParam("adi") String adi,
			@PathParam("soyadi") String soyadi
			) {
		
		Kullanici kullanici = new Kullanici(id, adi, soyadi);
		
		//Kullanici kullanici = new Kullanici();
		//kullanici.setKullaniciId(1);
		//kullanici.setKullaniciAdi("Melek");
		//kullanici.setKullaniciSoyadi("Kocabey");
		
		return Response.status(200).entity(kullanici).build();
	}	
		
	
	
	
	
	
//	http://localhost:8085/004_JacksonJSON/rest/kullanici/detay/json/1
	@GET
	@Path(value="/detay/json/{id}")
	//@Produces(MediaType.APPLICATION_JSON)
		@Produces("application/json"+";charset=utf-8")
	public Response getKullaniciBilgisi3(@PathParam("id") Integer id) {
		
		Kullanici kullanici = new Kullanici(id, "Melek", "Kocabey");
		
		//Kullanici kullanici = new Kullanici();
		//kullanici.setKullaniciId(1);
		//kullanici.setKullaniciAdi("Melek");
		//kullanici.setKullaniciSoyadi("Kocabey");
		
		return Response.status(200).entity(kullanici).build();
	}	
	
	
	
//	http://localhost:8085/004_JacksonJSON/rest/kullanici/detay/json/1/Ali/Burak
	@GET
	@Path(value="/detay/json/{id}/{adi}/{soyadi}")
	//@Produces(MediaType.APPLICATION_JSON)
		@Produces("application/json"+";charset=utf-8")
	public Response getKullaniciBilgisi4(
			@PathParam("id") Integer id,
			@PathParam("adi") String adi,
			@PathParam("soyadi") String soyadi
			) {
		
		Kullanici kullanici = new Kullanici(id, adi, soyadi);
		
		//Kullanici kullanici = new Kullanici();
		//kullanici.setKullaniciId(1);
		//kullanici.setKullaniciAdi("Melek");
		//kullanici.setKullaniciSoyadi("Kocabey");
		
		return Response.status(200).entity(kullanici).build();
	}	
		

}
