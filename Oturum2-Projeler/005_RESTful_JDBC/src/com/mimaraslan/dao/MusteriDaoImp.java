package com.mimaraslan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mimaraslan.model.Musteri;


public class MusteriDaoImp implements MusteriDao {

	static Connection baglanti = null;
	static Statement bildirim = null;
	static ResultSet sonuc = null;
	
	@Override
	public Connection veriTabaninaBaglantiKur() {
		
		try {
			
			String url = "jdbc:mysql://localhost:3306/firmaveritabani";
			String kullaniciAdi = "root";
			String parola = "12345678";
			Class.forName("com.mysql.jdbc.Driver");
			
			baglanti = DriverManager.getConnection(url, kullaniciAdi, parola);
			
			if (!baglanti.isClosed()) {
				System.out.println("ACIK");
			} else {
				System.out.println("KAPALI");
			}
			
			
		} catch (Exception exp) {
			exp.printStackTrace();
		}
		

		return baglanti;
	}

	@Override
	public Musteri veriOku(int musteriId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Musteri> veriOku() {
		veriTabaninaBaglantiKur();

		List<Musteri> musteriler = new ArrayList<>(); 
		Musteri musteri = null;
		
		try {
			PreparedStatement preparedStatement = baglanti.prepareStatement("SELECT * FROM firmaveritabani.Musteri");
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				musteri = new Musteri(resultSet.getInt(1), resultSet.getInt(2),resultSet.getString(3), resultSet.getString(4));
				
				System.out.println(musteri);
				musteriler.add(musteri);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		for (int i = 0; i < musteriler.size(); i++) {
			Object obj = musteriler.get(i).getMusteriId()+" "+ musteriler.get(i).getMusteriNo()
					+" "+musteriler.get(i).getMusteriAdi()+" "+musteriler.get(i).getMusteriSoyadi();
			System.out.println(obj);
		}
		
		return musteriler;
	}

	@Override
	public boolean veriEkle(Musteri musteri) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean veriDuzenle(Musteri musteri) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean veriSilme(Musteri musteri) {
		// TODO Auto-generated method stub
		return false;
	}

}
