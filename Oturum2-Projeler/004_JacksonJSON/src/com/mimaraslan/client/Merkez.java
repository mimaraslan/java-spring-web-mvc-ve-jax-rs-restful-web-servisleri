package com.mimaraslan.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.mimaraslan.model.Kullanici;

public class Merkez {

	public static void main(String[] args) {
		long id = 20;
		String adi = "OMER";
		String soyadi ="METIN";
		
		try {   
			
			URL url = new URL("http://localhost:8085/004_JacksonJSON/rest/kullanici/detay/json/"+id+"/"+adi+"/"+soyadi);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "application/json"+";charset=utf-8");
			
			if (connection.getResponseCode() != 200) {
				throw new RuntimeException("GELEN HTTP CODE:" + connection.getResponseCode() );
			}
			
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String sonuc = bufferedReader.readLine();
			System.out.println(sonuc);
			connection.disconnect();
			
			/*
			JAXBContext jaxbContext = JAXBContext.newInstance(Kullanici.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			Kullanici kullanici = (Kullanici) unmarshaller.unmarshal(new StringReader(sonuc));
			
			System.out.println(kullanici.getKullaniciId());
			System.out.println(kullanici.getKullaniciAdi());
			System.out.println(kullanici.getKullaniciSoyadi());
			*/
			
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(sonuc);
			
			
			JSONObject jsonObject = (JSONObject) obj;
			
		     id =  (Long) jsonObject.get("kullaniciId");

			adi = (String) jsonObject.get("kullaniciAdi");
			
			soyadi = (String) jsonObject.get("kullaniciSoyadi");
			
			System.out.println(id);
			System.out.println(adi);
			System.out.println(soyadi);
				    
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			
		}
		
		
	}

}
