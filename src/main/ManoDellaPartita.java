package main;

import java.util.ArrayList;

public class ManoDellaPartita {

	private ArrayList<Giocata> giocate;

	private Carta briscolaCorrente;

	public ManoDellaPartita(Carta briscolaCorrente) {
		super();
		giocate = new ArrayList<>();
		this.briscolaCorrente = briscolaCorrente;
	}

	public ArrayList<Giocata> getGiocate() {
		return giocate;
	}

	public void gioca(Giocata giocata) {
		giocate.add(giocata);
	}

	public Giocata chiudiMano() {
		// TODO parlare di : interfacce, eccezioni
		Carta prima = null;
		Giocata presa = null;
		int forzaMassima = -1;
		for (Giocata giocata : giocate) {
			// calcolo a forza della giocataa iesima
			int forza = calcolaForza(giocata.getCarta());
			// se è la prima giocata, la salvo perchè il seme è vincente (se non ci sono
			// briscole)
			if (prima == null) {
				prima = giocata.getCarta();
			}
			// se il seme della prima carta è lo stesso della giocata corrente, allora
			// aggiungo 10 alla forza
			if (prima.getSeme().equals(giocata.getCarta().getSeme())) {
				forza += 10;
			}
			// se la giocata corrente ha il seme della briscola allora aggiungo 20 alla
			// forza
			if (giocata.getCarta().getSeme().equals(briscolaCorrente.getSeme())) {
				forza += 20;
			}
			// se la giocata corrente supera la forza massima di questa mano, è quella
			// vincente
			if (forza > forzaMassima) {
				presa = giocata;
				forzaMassima = forza;
			}
		}
		return presa;
	}

	// calcola la forza della carta
	private int calcolaForza(Carta carta) {
		switch (carta.getValore()) {
		case DUE:
			return 0;
		case QUATTRO:
			return 1;
		case CINQUE:
			return 2;
		case SEI:
			return 3;
		case SETTE:
			return 4;
		case FANTE:
			return 5;
		case CAVALLO:
			return 6;
		case RE:
			return 7;
		case TRE:
			return 8;
		case ASSO:
			return 9;
		}
		// TODO parlare di : interfacce, eccezioni
		return -1;
	}

	public int calcolaPunteggioMano() {
		int punteggio = 0;
		for (Giocata giocata : giocate) {
			punteggio += calcolaPunteggioCarta(giocata.getCarta());
		}
		return punteggio;
	}

	private int calcolaPunteggioCarta(Carta carta) {
		switch (carta.getValore()) {
		case DUE:
			return 0;
		case QUATTRO:
			return 0;
		case CINQUE:
			return 0;
		case SEI:
			return 0;
		case SETTE:
			return 0;
		case FANTE:
			return 2;
		case CAVALLO:
			return 3;
		case RE:
			return 4;
		case TRE:
			return 10;
		case ASSO:
			return 11;
		}
		return 0;
	}
}