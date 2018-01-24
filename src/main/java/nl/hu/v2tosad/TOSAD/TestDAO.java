package main.java.nl.hu.v2tosad.TOSAD;

import main.java.nl.hu.v2tosad.model.Klant;

import java.sql.*;
import java.util.ArrayList;

public class TestDAO extends BaseDAO{

	public ArrayList<Klant> selectKlanten() {
		ArrayList<Klant> klanten = new ArrayList<Klant>();
		try (Connection conn = super.getConnection()) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from vbmg_klanten");
			
			while (rs.next()) {
				int id = rs.getInt("ID");
				String naam = rs.getString("NAAM");
				String geslacht = rs.getString("GESLACHT");
				String voorletters = rs.getString("VOORLETTERS");
				String titel = rs.getString("TITEL");
				Date geboorteDatum = rs.getDate("GEBOORTEDATUM");
				
				Klant k = new Klant(id, naam, geslacht, voorletters, titel, geboorteDatum);
				klanten.add(k);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return klanten;
	}
	public void createKlant(String name) {
		try (Connection conn = super.getConnection()) {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("INSERT INTO VBMG_KLANTEN (ID, NAAM, GESLACHT, VOORLETTERS, TITEL, GEBOORTEDATUM) values(250, '" + name +
					"', 'M', 'TT', 'KONGING', '05-05-1945')");
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
	public void deleteKlant(int ID) {
		try (Connection conn = super.getConnection()) {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("DELETE FROM VBMG_KLANTEN WHERE ID = " + ID);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

}
