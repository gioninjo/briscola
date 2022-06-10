package main;

import java.util.ArrayList;
import java.util.Objects;

public class Giocatore {

	private ArrayList<Carta> myCards = new ArrayList<Carta>();
	private String nomeSquadra;
	private String descrizione;
//	private int punteggio;
//	
//	public int getPunteggio() {
//		return punteggio;
//	}
//	
//	public void aumentaPunteggio(int quantita) {
//		this.punteggio += quantita;
//	}
	
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
	public String getNomeSquadra() {
		return nomeSquadra;
	}
	
	public void setSquadra(String squadra) {
		this.nomeSquadra = squadra;
	}
	
	public void takeCards(ArrayList<Carta> mano) {
		myCards.addAll(mano);
	}
	
	public void takeACard(Carta carta) {
		myCards.add(carta);
	}
	
	public void removeACard(int posizione) {
		myCards.remove(posizione);
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
		return "Giocatore " + descrizione;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descrizione, myCards, nomeSquadra);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Giocatore other = (Giocatore) obj;
		return Objects.equals(descrizione, other.descrizione) && Objects.equals(myCards, other.myCards)
				&& Objects.equals(nomeSquadra, other.nomeSquadra);
	}
	
	
}
