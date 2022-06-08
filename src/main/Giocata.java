package main;

public class Giocata {
	private Giocatore giocatore;
	private Carta carta;
	
	
	//getters e setters
	public Giocatore getGiocatore() {
		return giocatore;
	}
	public void setGiocatore(Giocatore giocatore) {
		this.giocatore = giocatore;
	}
	public Carta getCarta() {
		return carta;
	}
	public void setCarta(Carta carta) {
		this.carta = carta;
	}
	//costruttore
	public Giocata(Giocatore giocatore, Carta carta) {
		super();
		this.giocatore = giocatore;
		this.carta = carta;
	}
	@Override
	public String toString() {
		return "Giocata di " + giocatore + ":   " + carta;
	}
	
	
}
