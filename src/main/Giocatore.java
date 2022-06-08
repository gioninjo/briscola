package main;

import java.util.ArrayList;

public class Giocatore {

	private ArrayList<Carta> myCards = new ArrayList<Carta>();
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
	public ArrayList<Carta> getMyCards() {
		return myCards;
	}
	public int getPunteggio() {
		return punteggio;
	}
	
	public int getSquadra() {
		return squadra;
	}
	
	public void setSquadra(int squadra) {
		this.squadra = squadra;
	}
	
	public void aumentaPunteggio(int p) {
		this.punteggio += p;
	}
	
	public void takeCards(ArrayList<Carta> mano) {
		myCards.addAll(mano);
	}
	
	public void takeACard(Carta carta) {
		myCards.add(carta);
	}
	
	public Carta playACard(int posizione) {
		return myCards.remove(posizione);
	}
	
	public void printCards() {
		int count = 0;
		for(Carta carta : myCards) {
			 System.out.println(count + ".  " + carta);
			 count++;
		}
	}
	
	@Override
	public String toString() {
		return "Giocatore [descrizione=" + descrizione + "]";
	}
	
}
