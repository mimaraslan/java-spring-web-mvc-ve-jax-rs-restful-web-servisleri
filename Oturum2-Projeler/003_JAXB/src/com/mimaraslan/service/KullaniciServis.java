package com.mimaraslan.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mimaraslan.model.Kullanici;

//    http://localhost:8085/003_JAXB/rest/kullanici
@Path(value="/kullanici")
public class KullaniciServis {

	
//	http://localhost:8085/003_JAXB/rest/kullanici/detay/3
	@GET
	@Path(value="/detay/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Response getKullaniciBilgisi(@PathParam("id") Integer id) {
		
		Kullanici kullanici = new Kullanici(id, "Melek", "Kocabey");
		
		//Kullanici kullanici = new Kullanici();
		//kullanici.setKullaniciId(1);
		//kullanici.setKullaniciAdi("Melek");
		//kullanici.setKullaniciSoyadi("Kocabey");
		
		return Response.status(200).entity(kullanici).build();
	}
	

}
