package main;

public class Giocata {
	private Giocatore giocatore;
	private Carta carta;
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
	public Giocata(Giocatore giocatore, Carta carta) {
		super();
		this.giocatore = giocatore;
		this.carta = carta;
	}
	
}
