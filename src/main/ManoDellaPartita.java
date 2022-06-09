package main;

import java.util.ArrayList;
import java.util.Scanner;

public class ManoDellaPartita {

	private ArrayList<Giocata> giocate;
	Scanner tastiera = new Scanner(System.in);
	private Carta briscolaCorrente;

	public ManoDellaPartita(Carta briscolaCorrente) {
		super();
		giocate = new ArrayList<>();
		this.briscolaCorrente = briscolaCorrente;
	}

	public ArrayList<Giocata> getGiocate() {
		return giocate;
	}
	
	public void faiUnaGiocata(Giocatore giocatore) {
		System.out.println(giocatore.getDescrizione() + "e' il tuo turno(hai " + giocatore.getMyCards().size() + " carte in mano:");
		//espongo le carte possibili
		giocatore.printCards();
		System.out.println("--------------------------------------------------");
		int scelta = -1;
		//sono obbligato a scegliere tra le 3 opzioni
		while (scelta < 0 || scelta > giocatore.getMyCards().size() - 1) {
			System.out.println("Seleziona una carta da giocare:" );
			scelta = tastiera.nextInt();
		}
		
		//prendo la scelta e vado ad aggiungere una nuova giocata nell'array delle giocate
		giocate.add(new Giocata(giocatore, giocatore.getMyCards().get(scelta)));
		giocatore.removeACard(scelta);
	}
	
	
	//dopo che sono state raccolte tutte le giocate si calcola il vincitore della mano
	public Giocatore chiudiMano() {
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
		System.out.println("\n\nMano vinta da " + presa.getGiocatore());
		return presa.getGiocatore();
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
		default:
			return 0;
		}

	}
}