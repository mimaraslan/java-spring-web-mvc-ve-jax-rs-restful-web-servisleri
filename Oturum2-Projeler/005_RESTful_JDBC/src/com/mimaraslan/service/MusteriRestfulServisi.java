package com.mimaraslan.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mimaraslan.dao.MusteriDaoImp;
import com.mimaraslan.model.Musteri;

//   http://localhost:8085/005_RESTful_JDBC/rest/musteri

@Path("/musteri")
public class MusteriRestfulServisi {
	
	
	
//  http://localhost:8085/005_RESTful_JDBC/rest/musteri/herkes

	@GET
	@Path("/herkes")
	@Produces (MediaType.APPLICATION_XML) //, MediaType.APPLICATION_JSON
	public List<Musteri> musteriler() {	
		MusteriDaoImp nesne = new MusteriDaoImp();
		return nesne.veriOku();
	}

}
