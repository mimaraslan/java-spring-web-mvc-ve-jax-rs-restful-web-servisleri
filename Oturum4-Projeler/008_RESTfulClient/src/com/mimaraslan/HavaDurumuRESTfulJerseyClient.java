package com.mimaraslan;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class HavaDurumuRESTfulJerseyClient {

	private void getCtoF(double c) {
		
		try {
			Client client = Client.create();
			WebResource webResource = client.resource("http://localhost:8085/007_RESTfulServer/ctofservice/"+c+"/ver/xml");
			ClientResponse response = webResource.accept("application/xml").get(ClientResponse.class);
			
			if(response.getStatus() !=200) {
				throw new RuntimeException("HATA MEYDANA GELDI. GELEN HTTP STATUS CODU :" + response.getStatus());
			}else {
				System.out.println(response.getEntity(String.class));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	private void getFtoC(double f) {

		try {
			Client client = Client.create();
			WebResource webResource = client.resource("http://localhost:8085/007_RESTfulServer/ftocservice/"+f+"/ver/json");
			ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
			
			if(response.getStatus() !=200) {
				throw new RuntimeException("HATA MEYDANA GELDI. GELEN HTTP STATUS CODU :" + response.getStatus());
			}else {
				System.out.println(response.getEntity(String.class));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
public static void main(String[] args) {
		
		HavaDurumuRESTfulJerseyClient nesne = new HavaDurumuRESTfulJerseyClient();
		
		nesne.getFtoC(92.84);
	
		System.out.println("--------------------\n");
		
		nesne.getCtoF(33.8);
		
	}
	
}
