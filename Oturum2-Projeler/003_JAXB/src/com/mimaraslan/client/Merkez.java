package com.mimaraslan.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import com.mimaraslan.model.Kullanici;

public class Merkez {

	public static void main(String[] args) {
		int idDegeri = 20;
		
		try {
			
			URL url = new URL("http://localhost:8085/003_JAXB/rest/kullanici/detay/"+idDegeri);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "application/xml");
			
			if (connection.getResponseCode() != 200) {
				throw new RuntimeException("GELEN HTTP CODE:" + connection.getResponseCode() );
			}
			
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String sonuc = bufferedReader.readLine();
			System.out.println(sonuc);
			connection.disconnect();
			
			JAXBContext jaxbContext = JAXBContext.newInstance(Kullanici.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			Kullanici kullanici = (Kullanici) unmarshaller.unmarshal(new StringReader(sonuc));
			
			System.out.println(kullanici.getKullaniciId());
			System.out.println(kullanici.getKullaniciAdi());
			System.out.println(kullanici.getKullaniciSoyadi());
			
			
		
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			
		}
		
		
	}

}
