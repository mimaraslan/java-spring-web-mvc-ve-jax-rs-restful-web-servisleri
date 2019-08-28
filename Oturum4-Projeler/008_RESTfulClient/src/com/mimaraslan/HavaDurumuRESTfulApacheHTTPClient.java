package com.mimaraslan;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class HavaDurumuRESTfulApacheHTTPClient {

	private void getCtoF(double c) {
		
		try {
			/*
			Client client = Client.create();
			WebResource webResource = client.resource("http://localhost:8085/007_RESTfulServer/ctofservice/"+c+"/ver/xml");
			ClientResponse response = webResource.accept("application/xml").get(ClientResponse.class);
			*/
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet httpGetRequest = new HttpGet("http://localhost:8085/007_RESTfulServer/ctofservice/"+c+"/ver/json");
			        httpGetRequest.addHeader("accept","application/json" );
			HttpResponse response = client.execute(httpGetRequest);
			        
			if(response.getStatusLine().getStatusCode() !=200) {  //if(response.getStatus() !=200) 
				throw new RuntimeException("HATA MEYDANA GELDI. GELEN HTTP STATUS CODU :" + response.getStatusLine().getStatusCode());
			}else {
				//System.out.println(response.getEntity(String.class));
				
				BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
				String sonuc;
				
				while((sonuc = br.readLine()) !=null ) {
					System.out.println(sonuc);
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	private void getFtoC(double f) {

		try {
			/*
			Client client = Client.create();
			WebResource webResource = client.resource("http://localhost:8085/007_RESTfulServer/ftocservice/"+f+"/ver/json");
			ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
			*/
			
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet httpGetRequest = new HttpGet("http://localhost:8085/007_RESTfulServer/ftocservice/"+f+"/ver/json");
			        httpGetRequest.addHeader("accept","application/json" );
			HttpResponse response = client.execute(httpGetRequest);
			        
			if(response.getStatusLine().getStatusCode() !=200) {  //if(response.getStatus() !=200) 
				throw new RuntimeException("HATA MEYDANA GELDI. GELEN HTTP STATUS CODU :" + response.getStatusLine().getStatusCode());
			}else {
				//System.out.println(response.getEntity(String.class));
				
				BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
				String sonuc;
				
				while((sonuc = br.readLine()) !=null ) {
					System.out.println(sonuc);
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
public static void main(String[] args) {
		
  	HavaDurumuRESTfulApacheHTTPClient nesne = new HavaDurumuRESTfulApacheHTTPClient();
		
		nesne.getFtoC(92.84);
	
		System.out.println("--------------------\n");
		
		nesne.getCtoF(33.8);
		
	}
	
}
