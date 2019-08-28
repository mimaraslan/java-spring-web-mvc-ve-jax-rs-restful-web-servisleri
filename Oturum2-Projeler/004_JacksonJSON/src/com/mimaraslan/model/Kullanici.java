package com.mimaraslan.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name="kullanici")
public class Kullanici implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@XmlElement(name="kullaniciId")
	int kullaniciId;
	
	@XmlElement(name="kullaniciAdi")
	String kullaniciAdi;
	
	@XmlElement(name="kullaniciSoyadi")
	String kullaniciSoyadi;
	
	/*
	<kullanici>
		<kullaniciId>1</kullaniciId>
		<kullaniciAdi>Melek</kullaniciAdi>
		<kullaniciSoyadi>Kocabey</kullaniciSoyadi>	
	</kullanici>
	
	
	
	{
		"kullanici":{
			"kullaniciId":"1",
			"kullaniciAdi":"Melek",
			"kullaniciSoyadi":"Kocabey"
		}	
	}
	
	*/
	//-------------------------------------------	
	public Kullanici() {
	}

	public Kullanici(int kullaniciId, String kullaniciAdi, String kullaniciSoyadi) {
		this.kullaniciId = kullaniciId;
		this.kullaniciAdi = kullaniciAdi;
		this.kullaniciSoyadi = kullaniciSoyadi;
	}

	//-------------------------------------------
	public int getKullaniciId() {
		return kullaniciId;
	}

	public void setKullaniciId(int kullaniciId) {
		this.kullaniciId = kullaniciId;
	}

	public String getKullaniciAdi() {
		return kullaniciAdi;
	}

	public void setKullaniciAdi(String kullaniciAdi) {
		this.kullaniciAdi = kullaniciAdi;
	}

	public String getKullaniciSoyadi() {
		return kullaniciSoyadi;
	}

	public void setKullaniciSoyadi(String kullaniciSoyadi) {
		this.kullaniciSoyadi = kullaniciSoyadi;
	}
	
}
