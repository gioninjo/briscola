package main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ManoDellaPartita {

	private ArrayList<Giocata> giocate;
	Scanner tastiera = new Scanner(System.in);
	private Carta briscolaCorrente;

	//getter scanner
	public Scanner getTastiera() {
		return tastiera;
	}
	
	public ManoDellaPartita(Carta briscolaCorrente) {
		super();
		giocate = new ArrayList<>();
		this.briscolaCorrente = briscolaCorrente;
	}

	public ArrayList<Giocata> getGiocate() {
		return giocate;
	}
	
	public void faiUnaGiocata(Giocatore giocatore) {
		System.out.println(giocatore.getDescrizione() + " e' il tuo turno(hai " + giocatore.getMyCards().size() + " carte in mano:");
		//espongo le carte possibili
		giocatore.printCards();
		System.out.println("--------------------------------------------------");
		int scelta = -1;
		boolean firstTry = true;
		boolean catched = false;
//		//sono obbligato a scegliere tra le 3 opzioni
//		while (scelta < 0 || scelta > giocatore.getMyCards().size() - 1) {
//			System.out.println("Seleziona una carta da giocare:" );
//			scelta = tastiera.nextInt();
//		}
		do {
			//int buffer = 0;
			if (!firstTry && !catched) {
				System.out.println("Per favore inserire un numero di carta valido!");
			}
			System.out.println("Selezionare una carta da giocare:");
			try {
				scelta = tastiera.nextInt();
				catched = false;
			} catch (InputMismatchException e) {
				System.out.println("il valore deve essere un numero");
				catched = true;
			}
			//n = buffer;
			//pulisci scanner
			tastiera.nextLine();
			firstTry = false;
		} while (scelta < 0 || scelta > giocatore.getMyCards().size() - 1);
		
		
		//prendo la scelta e vado ad aggiungere una nuova giocata nell'array delle giocate
		giocate.add(new Giocata(giocatore, giocatore.getMyCards().get(scelta)));
		giocatore.removeACard(scelta);
	}
	
	
	//dopo che sono state raccolte tutte le giocate si calcola il vincitore della mano
	public Giocatore chiudiMano() throws ValoreInvalidoException {
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
	private int calcolaForza(Carta carta) throws ValoreInvalidoException {
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
		default:
			throw new ValoreInvalidoException("il valore della carta non è gestito");
		}
	}

	public int calcolaPunteggioMano() throws ValoreInvalidoException {
		int punteggio = 0;
		for (Giocata giocata : giocate) {
			punteggio += calcolaPunteggioCarta(giocata.getCarta());
		}
		return punteggio;
	}

	private int calcolaPunteggioCarta(Carta carta) throws ValoreInvalidoException {
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
			throw new ValoreInvalidoException("il valore della carta non è gestito");
		}

	}

	@Override
	public String toString() {
		String mano = "giocate della mano: \n\n";
		for(Giocata giocata : giocate) {
			mano += giocata + "\n";
		}
		System.out.println();
		return mano;
	}
	
}