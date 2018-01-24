package main.java.nl.hu.v2tosad.model;

import java.sql.Date;

public class Klant {
	private int id;
	private String naam;
	private String geslacht;
	private String voorletters;
	private String titel;
	private Date geboorteDatum;
	
	public Klant(int id, String naam, String geslacht, String voorletters, String titel, Date geboorteDatum) {
		this.id = id;
		this.naam = naam;
		this.geslacht = geslacht;
		this.voorletters = voorletters;
		this.titel = titel;
		this.geboorteDatum = geboorteDatum;
	}

	public Date getGeboorteDatum() {
		return geboorteDatum;
	}

	public void setGeboorteDatum(Date geboorteDatum) {
		this.geboorteDatum = geboorteDatum;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getGeslacht() {
		return geslacht;
	}

	public void setGeslacht(String geslacht) {
		this.geslacht = geslacht;
	}

	public String getVoorletters() {
		return voorletters;
	}

	public void setVoorletters(String voorletters) {
		this.voorletters = voorletters;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

}
