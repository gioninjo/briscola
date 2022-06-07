package main;

import java.util.ArrayList;

public class Giocatore {

	private ArrayList<ICarta> myCards;
	private int punteggio = 0;
	private int squadra;
	private String descrizione;

	public Giocatore(String descrizione) {
		super();
		this.descrizione = descrizione;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public ArrayList<ICarta> getMyCards() {
		return myCards;
	}
	public void setMyCards(ArrayList<ICarta> myCards) {
		this.myCards = myCards;
	}
	public int getPunteggio() {
		return punteggio;
	}
	public void setPunteggio(int punteggio) {
		this.punteggio = punteggio;
	}
	public int getSquadra() {
		return squadra;
	}
	public void setSquadra(int squadra) {
		this.squadra = squadra;
	}
	
}
