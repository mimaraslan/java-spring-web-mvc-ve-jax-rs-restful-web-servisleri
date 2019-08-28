package com.mimaraslan.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder= {"musteriId","musteriNo","musteriAdi","musteriSoyadi"} )
@XmlRootElement(name="musteri")
public class Musteri implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/*
	<musteri>
		<musteriId>1</musteriId>
		<musteriNo>1000</musteriNo>
		<musteriAdi>Melek</musteriAdi>
		<musteriSoyadi>Kocabey</musteriSoyadi>	
	</musteri>
	*/
	private int musteriId;
	private int musteriNo;
	private String musteriAdi;
	private String musteriSoyadi;
	
	
	public Musteri() {
		// TODO buraya kod gir
	}

	public Musteri(int musteriId, int musteriNo, String musteriAdi, String musteriSoyadi) {
		this.musteriId = musteriId;
		this.musteriNo = musteriNo;
		this.musteriAdi = musteriAdi;
		this.musteriSoyadi = musteriSoyadi;
	}

	
	public int getMusteriId() {
		return musteriId;
	}

	public void setMusteriId(int musteriId) {
		this.musteriId = musteriId;
	}

	
	public int getMusteriNo() {
		return musteriNo;
	}

	public void setMusteriNo(int musteriNo) {
		this.musteriNo = musteriNo;
	}

	public String getMusteriAdi() {
		return musteriAdi;
	}

	public void setMusteriAdi(String musteriAdi) {
		this.musteriAdi = musteriAdi;
	}

	public String getMusteriSoyadi() {
		return musteriSoyadi;
	}

	public void setMusteriSoyadi(String musteriSoyadi) {
		this.musteriSoyadi = musteriSoyadi;
	}

	@Override
	public String toString() {
		return "Musteri [musteriId=" + musteriId + ", musteriNo=" + musteriNo + ", musteriAdi=" + musteriAdi
				+ ", musteriSoyadi=" + musteriSoyadi + "]";
	}
	
	
}
