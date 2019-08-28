package com.mimaraslan.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mimaraslan.dao.MusteriDaoImp;
import com.mimaraslan.model.Musteri;

//   http://localhost:8085/005_RESTful_JDBC/rest/musteri
@Path("/musteri")
public class MusteriRestfulServisi {
	
	
//  http://localhost:8085/005_RESTful_JDBC/rest/musteri/herkes
	@GET
	@Path("/herkes")
	@Produces ({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML   +";charset=utf-8" }) 
	public List<Musteri> musterileriGetir() {	
		MusteriDaoImp nesne = new MusteriDaoImp();
		return nesne.veriOku();
	}
	
	
	
	
	
//  http://localhost:8085/005_RESTful_JDBC/rest/musteri/1
	@GET
	@Path("/{musteriId}")
	@Produces ({ MediaType.APPLICATION_XML  +";charset=utf-8" }) //, MediaType.APPLICATION_JSON
	public Musteri musteriGetirById(@PathParam("musteriId") int musteriId) {	
		MusteriDaoImp nesne = new MusteriDaoImp();
		return nesne.veriOku(musteriId);
	}
		
	
	
	
//  http://localhost:8085/005_RESTful_JDBC/rest/musteri
	@POST
	@Path("/")
	@Consumes ({ MediaType.APPLICATION_XML  +";charset=utf-8" }) //, MediaType.APPLICATION_JSON
	public Response musteriEkle(Musteri musteri) {	
		MusteriDaoImp nesne = new MusteriDaoImp();
		boolean eklemeDurumu = nesne.veriEkle(musteri);
		
		if(eklemeDurumu == false)
			return Response.status(201).build();
		else
			return Response.status(200).build();
			
	}
			
	

	
//  http://localhost:8085/005_RESTful_JDBC/rest/musteri/7
	@PUT
	@Path("/{musteriId}")
	@Produces ({ MediaType.APPLICATION_XML  +";charset=utf-8" }) //, MediaType.APPLICATION_JSON
	@Consumes ({ MediaType.APPLICATION_JSON  +";charset=utf-8" }) //, MediaType.APPLICATION_XML
	public Musteri musteriDuzenle(Musteri musteri, @PathParam("musteriId") int musteriId) {	
		MusteriDaoImp nesne = new MusteriDaoImp();
		boolean duzenlemeDurumu = nesne.veriDuzenle( musteri,  musteriId);
		
		if(duzenlemeDurumu == true)
			return musteri;
		else
		   return null;
	
	}	
	
	
	
//  http://localhost:8085/005_RESTful_JDBC/rest/musteri/7
	@DELETE
	@Path("/{musteriId}")
	public Response musteriSilById(@PathParam("musteriId") int musteriId) {	
		MusteriDaoImp nesne = new MusteriDaoImp();
		
		boolean silmeDurumu = nesne.veriSilme(musteriId);
		
		if(silmeDurumu == false)
			return Response.status(200).build();
		else
			return Response.status(204).build();
	}
			
	

}
