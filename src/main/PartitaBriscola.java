package main;

import java.util.ArrayList;
import java.util.Scanner;

public class PartitaBriscola {
	Scanner tastiera = new Scanner(System.in);
	private ArrayList<Giocatore> giocatori;
	private ArrayList<Squadra> squadre;
	private Mazzo myMazzo;
	// tracciamento mani
	ArrayList<ManoDellaPartita> storicoMani;

	// costruttore
	public PartitaBriscola() {
		giocatori = new ArrayList<Giocatore>();
		myMazzo = new Mazzo();
		squadre = new ArrayList<Squadra>();
		storicoMani = new ArrayList<ManoDellaPartita>();
	}

	// in base al numero di giocatori vengono scartate carte deboli dal mazzo
	// ordinato
	public void scartaCarteDeboli() {
		if (giocatori.size() == 7) {
			myMazzo.myMazzo.remove(1);
			myMazzo.myMazzo.remove(3);
			myMazzo.myMazzo.remove(11);
			myMazzo.myMazzo.remove(21);
			myMazzo.myMazzo.remove(31);
		} else if (giocatori.size() == 6) {
			myMazzo.myMazzo.remove(1);
			myMazzo.myMazzo.remove(11);
			myMazzo.myMazzo.remove(21);
			myMazzo.myMazzo.remove(31);
		} else if (giocatori.size() == 3) {
			myMazzo.myMazzo.remove(1);
		}
	}

	// imposto che si può giocare in massimo 8 giocatori e minimo 2
	public void selezioneGiocatori() {
		boolean firstTry = true;
		int n = 0;

		do {
			if (!firstTry) {
				System.out.println("Per favore inserire un numero di giocatori valido (minimo 2)");
			}
			System.out.println("Selezionare il numero di giocatori:");
			n = tastiera.nextInt();
			firstTry = false;
		} while (n > 8 || n < 2);

		for (int i = 1; i < n + 1; i++) {
			System.out.println("Giocatore " + i + " seleziona un username: ");
			String descrizione = tastiera.next();
			giocatori.add(new Giocatore(descrizione));
			System.out.println("---------------------------------------------------------------------");

		}
	}

	// la selezione delle squadre
	public void selezioneSquadre() {
//		int nsquadre = 0;
//		boolean firstTry = true;
//		do {
//			if (!firstTry) {
//				System.out.println("Per favore inserire un numero di squadre valido (minimo 2)");
//			}
//			System.out.println("Selezionare il numero di squadre:");
//			nsquadre = Integer.parseInt(tastiera.next());
//			firstTry = false;
//		} while (nsquadre > 8 || nsquadre < 2);
//		System.out.println("---------------------------------------------------------------------");
//		for (Giocatore giocatore : giocatori) {
//			System.out.println("entrato");
//			int scelta = 0;
//			// sono obbligato a scegliere tra le 3squadre
//			while (scelta < 1 || scelta > nsquadre) {
//				System.out.println(giocatore + " seleziona la squadra a cui appartieni: ");
//				scelta = tastiera.nextInt();
//
//			}
//			giocatore.setSquadra(scelta);
//		}

		// selezione della squadra
		String jolly;
		for (Giocatore giocatore : giocatori) {
			System.out.println(giocatore + " seleziona la squadra a cui appartieni: ");
			jolly = tastiera.nextLine();
			giocatore.setSquadra(jolly);
			Squadra buffer = new Squadra(jolly);
			//se la squadra non è ancora registrata allora la aggiungo alla lista
			if(!squadre.contains(buffer)) {
				squadre.add(buffer);
			}
		}
		//mostro le squadre
		mostraSquadrePunteggi();
	}

	// grosso metodo che rappresenta una mano
	private void faiUnaMano(Carta briscolaCorrente) {
		ManoDellaPartita myMano = new ManoDellaPartita(briscolaCorrente);
		for (Giocatore giocatore : giocatori) {
			myMano.faiUnaGiocata(giocatore);
		}
		Giocatore vincente = myMano.chiudiMano();
		int punteggioMano = myMano.calcolaPunteggioMano();

		// ora ho sia il punteggio sia il giocatore che ha vinto la mano
		// troviamo quindi la squadra del giocatore eaggiungiamo il punteggio
		for (Squadra squadra : squadre) {
			if (squadra.getNome().equals(vincente.getNomeSquadra())) {
				squadra.addPunteggio(punteggioMano);
			}
		}

		// assegno alle

		// cerco in che posizione dell'arraylist si trova il vincente
		int posizione = -1;
		for (Giocatore giocatore : giocatori) {
			if (giocatore.equals(vincente)) {
				posizione = giocatori.indexOf(giocatore);
			}
		}

		// ora se ho trovato la posizione posso shiftare l'array di giocatori
		// in modo che il vincente sia nella prima posizione
		if (posizione != -1) {
			shiftGiocatori(posizione);
		}

		// ise il mazzo non è finito, i giocatori pescano una carta ognuno
		if (!myMazzo.isEmpty()) {
			prendeteUnaCarta();
		}

		// infine aggiungo la mano allo storico mani
		storicoMani.add(myMano);
		
		mostraSquadrePunteggi();
	}

	// il giocatore che si trova nella posizione in input viene spostato in prima
	// posizione
	// senza però icambiare l'ordine di gioco
	private void shiftGiocatori(int posizione) {
		for (int i = 0; i < posizione; i++) {
			Giocatore jolly = giocatori.remove(0);
			giocatori.add(jolly);
		}
	}

	// metodo che itera sul metodo faiUnaMano
	// ti fa giocare tutte le mani possibili
	public void giocaTutteLeMani(Carta briscola) {
		int nMani = 40 / giocatori.size();
		for (int i = 0; i < nMani; i++) {
			faiUnaMano(briscola);
		}
	}

	// fai pescare una carta ad ogni giocatore
	public void prendeteUnaCarta() {
		for (Giocatore giocatore : giocatori) {
			giocatore.takeACard(myMazzo.takeACard());
		}
	}

	// distribuisce 3 carte a ciascun giocatore
	public void distribuzioneMani() {
		for (Giocatore giocatore : giocatori) {
			giocatore.takeCards(myMazzo.dammiPrimeTreCarte());
		}
	}

	public void calcolaSquadraVincente() {

		// trovo la squadra vincente
		int puntiMassimi = 0;
		String vincente = " ";
		for (Squadra squadra : squadre) {
			if (squadra.getPunteggio() > puntiMassimi) {
				puntiMassimi = squadra.getPunteggio();
				vincente = squadra.getNome();
				System.out.println(squadra + "\n");
			}
		}
		System.out.println("------------------------------------");
		// faccio sapere ai giocatori delpla squadra che hanno vinto
		for (Giocatore giocatore : giocatori) {
			if (vincente.equals(giocatore.getNomeSquadra())) {
				System.out.println(giocatore + "la tua squadra ha vinto la partita!!");
			}
		}
	}
	
	private void mostraSquadrePunteggi() {
		System.out.println("\n\nElenco squadre completo");
		for(Squadra squadra : squadre) {
			System.out.println(squadra);
		}
		System.out.println("\n\n\n");
	}

	public static void main(String args[]) {
		PartitaBriscola myPartita = new PartitaBriscola();
		myPartita.selezioneGiocatori();
		myPartita.selezioneSquadre();
		// guardo se ci sono carte da scartare
		myPartita.scartaCarteDeboli();
		// myPartita.myMazzo.printMazzo();
		// mescolo il mazzo
		myPartita.myMazzo.shuffle();
		// estraggo la briscola
		Carta briscola = myPartita.myMazzo.pushACard();
		System.out.println("La briscola è: " + briscola);
		// distribuisco 3 carte ad ogni giocatore
		myPartita.distribuzioneMani();
		// ora gioco tutte le mani
		myPartita.giocaTutteLeMani(briscola);
		//Calcolo la squadra vincente e la mostro in output
		myPartita.calcolaSquadraVincente();

	}
}
