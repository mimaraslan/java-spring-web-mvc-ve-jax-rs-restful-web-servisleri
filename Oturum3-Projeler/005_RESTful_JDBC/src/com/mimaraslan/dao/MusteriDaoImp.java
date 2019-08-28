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
	public Musteri veriOku(int musteriId) {
		veriTabaninaBaglantiKur();

		Musteri musteri = null;
		
		try {
			PreparedStatement preparedStatement = baglanti.prepareStatement("SELECT * FROM Musteri WHERE musteriId=?");
			preparedStatement.setInt(1, musteriId);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				musteri = new Musteri(resultSet.getInt(1), resultSet.getInt(2),resultSet.getString(3), resultSet.getString(4));
				
				System.out.println(musteri);
			}
			
		} catch (Exception hata) {
			System.out.println("HATA: "+ hata);
		}

		
		return musteri;
		
	}

	
	
	@Override
	public boolean veriEkle(Musteri musteri) {
		veriTabaninaBaglantiKur();
		
		
		boolean eklemeDurumu = false;
		String sonuc = "";
		
		try {
			String sorgu = "INSERT INTO musteri (musteriNo, musteriAdi, musteriSoyadi) VALUES (?, ?, ?)";
			
			PreparedStatement preparedStatement = baglanti.prepareStatement(sorgu);
			
			preparedStatement.setInt(1, musteri.getMusteriNo());
			preparedStatement.setString(2, musteri.getMusteriAdi());
			preparedStatement.setString(3, musteri.getMusteriSoyadi());
			
			eklemeDurumu = preparedStatement.execute();
			
			if(eklemeDurumu == false) {
				sonuc = "Ekleme Basarili";
			}else {
				sonuc = "Ekleme Basarisiz";
			}
			
			
			
			
		} catch(Exception e) {
			System.out.println("HATA: "+e);

		}
		System.out.println(sonuc);
		
		return eklemeDurumu;
	}
	
	

	@Override
	public boolean veriDuzenle(Musteri musteri, int musteriId) {
		veriTabaninaBaglantiKur();
		
		
		boolean duzenlemeDurumu = false;
		String sonuc = "";
		
		try {
			String sorgu = "UPDATE musteri"
					+ " SET musteriNo=?, "
					+ " musteriAdi=?, "
					+ " musteriSoyadi=? "
					+ " WHERE musteriId=? ";
			
			
			PreparedStatement preparedStatement = baglanti.prepareStatement(sorgu);
			
			preparedStatement.setInt(1, musteri.getMusteriNo());
			preparedStatement.setString(2, musteri.getMusteriAdi());
			preparedStatement.setString(3, musteri.getMusteriSoyadi());
			preparedStatement.setInt(4, musteri.getMusteriId());

			
			int sorguSonucu = preparedStatement.executeUpdate();
			
			if(sorguSonucu == 1) {
				sonuc = "Duzenleme Basarili";
				duzenlemeDurumu = true;
			}else {
				sonuc = "Duzenleme Basarisiz";
				duzenlemeDurumu = false;
			}
		
		} catch(Exception e) {
			System.out.println("HATA: "+e);

		}
		System.out.println(sonuc);
		
		return duzenlemeDurumu;
	}
	

	@Override
	public boolean veriSilme(int musteriId) {
		veriTabaninaBaglantiKur();
		

		boolean silmeDurumu = false;
		String sonuc = "";
		
		try {
			String sorgu = "DELETE FROM musteri WHERE musteriId=?";
			
			
			PreparedStatement preparedStatement = baglanti.prepareStatement(sorgu);
			
			preparedStatement.setInt(1, musteriId);

			
			silmeDurumu = preparedStatement.execute();
			
			if(silmeDurumu == false) {
				sonuc = "Silme Basarili";	
			}else {
				sonuc = "Silme Basarisiz";
			}
		
		} catch(Exception e) {
			System.out.println("HATA: "+e);

		}
		System.out.println(sonuc);
		
		return silmeDurumu;
	}

	
}
