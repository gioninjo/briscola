package main;

public class CartaDaBriscola extends Carta {
	private int potenza;
	private int punteggio = 0;

	// costruisce una carta da briscola
	public CartaDaBriscola(Valore valore, Seme seme, Carta briscola) {
		super(valore, seme);
		// assegno valore in base alla potenza delle carte
		// briscole da 20 a 29
		// altre da 0 a 9
		switch (valore) {
		case ASSO:
			potenza = 9;
			punteggio = 11;
			break;
		case TRE:
			potenza = 8;
			punteggio = 10;
			break;
		case RE:
			potenza = 7;
			punteggio = 4;
			break;
		case CAVALLO:
			potenza = 6;
			punteggio = 3;
			break;
		case FANTE:
			potenza = 5;
			punteggio = 2;
			break;
		case SETTE:
			potenza = 4;
		case SEI:
			potenza = 3;
			break;
		case CINQUE:
			potenza = 2;
			break;
		case QUATTRO:
			potenza = 1;
			break;
		case DUE:
			potenza = 0;
			break;
		}

	}

	public int getPotenza() {
		return potenza;
	}

	public int getPunteggio() {
		return punteggio;
	}

}
