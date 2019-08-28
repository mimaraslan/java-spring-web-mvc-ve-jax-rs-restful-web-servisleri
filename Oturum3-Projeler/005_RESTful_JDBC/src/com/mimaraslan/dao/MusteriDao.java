package com.mimaraslan.dao;

import java.sql.Connection;
import java.util.List;

import com.mimaraslan.model.Musteri;

public interface MusteriDao {

	public Connection veriTabaninaBaglantiKur();
	public Musteri veriOku(int musteriId);
	public List<Musteri> veriOku();
	public boolean veriEkle(Musteri musteri);
	public boolean veriDuzenle(Musteri musteri, int musteriId);
	public boolean veriSilme(int musteriId);

}
