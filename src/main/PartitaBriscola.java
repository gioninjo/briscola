package main;

import java.util.ArrayList;
import java.util.Scanner;

public class PartitaBriscola {
	Scanner tastiera = new Scanner(System.in);
	private ArrayList<Giocatore> giocatori;
	//private int[] punteggiSquadre;
	private Mazzo myMazzo;

	// costruttore
	public PartitaBriscola() {
		giocatori = new ArrayList<Giocatore>();
		myMazzo = new Mazzo();
	}
	
	
	//in base al numero di giocatori vengono scartate carte deboli dal mazzo ordinato
	public void scartaCarteDeboli() {
		if (giocatori.size() == 7) {
			myMazzo.myMazzo.remove(1);
			myMazzo.myMazzo.remove(3);
			myMazzo.myMazzo.remove(11);
			myMazzo.myMazzo.remove(21);
			myMazzo.myMazzo.remove(31);
		}
		else if (giocatori.size() == 6) {
			myMazzo.myMazzo.remove(1);
			myMazzo.myMazzo.remove(11);
			myMazzo.myMazzo.remove(21);
			myMazzo.myMazzo.remove(31);
		}
		else if (giocatori.size() == 3) {
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
			System.out.println("Giocatore " + i + "seleziona un username: ");
			String descrizione = tastiera.next();
			giocatori.add(new Giocatore(descrizione));
			System.out.println("---------------------------------------------------------------------");

		}
	}
	
	//la selezione delle squadre
	public void selezioneSquadre() {
		int nsquadre = 0;
		boolean firstTry = true;
		do {
			if (!firstTry) {
				System.out.println("Per favore inserire un numero di squadre valido (minimo 2)");
			}
			System.out.println("Selezionare il numero di squadre:");
			nsquadre = Integer.parseInt(tastiera.next());
			firstTry = false;
		} while (nsquadre > 8 || nsquadre < 2);
		System.out.println("---------------------------------------------------------------------");
		for (Giocatore giocatore : giocatori) {
			System.out.println("entrato");
			int scelta = 0;
			// sono obbligato a scegliere tra le 3squadre
			while (scelta < 1 || scelta > nsquadre) {
				System.out.println(giocatore + " seleziona la squadra a cui appartieni: ");
				scelta = tastiera.nextInt();

			}
			giocatore.setSquadra(scelta);
		}
	}
	
	
	//grosso metodo che rappresenta una mano
	private void faiUnaMano(Carta briscolaCorrente) {
		ManoDellaPartita myMano = new ManoDellaPartita(briscolaCorrente);
		for (Giocatore giocatore : giocatori) {
			myMano.faiUnaGiocata(giocatore);
			System.out.println("uscito dalla giocata");
		}
		System.out.println("uscito dal loop");
		Giocatore vincente = myMano.chiudiMano();
		int punteggioMano = myMano.calcolaPunteggioMano();
		
		//ora ho sia il punteggio sia il giocatore che ha vinto la mano
		//aggiungo il punteggio al giocatore
		vincente.aumentaPunteggio(punteggioMano);
		
		//cerco in che posizione dell'arraylist si trova il vincente
		int posizione = -1;
		for(Giocatore giocatore : giocatori) {
			if (giocatore.equals(vincente)) {
				posizione = giocatori.indexOf(giocatore);
			}
		}
		
		//ora se ho trovato la posizione posso shiftare l'array di giocatori
		//in modo che il vincente sia nella prima posizione
		if(posizione != -1) {
			shiftGiocatori(posizione);
		}
		
		//infine i giocatori pescano una carta ognuno
		prendeteUnaCarta();
	}
	
	//il giocatore che si trova nella posizione in input viene spostato in prima posizione
	//senza però icambiare l'ordine di gioco
	private void shiftGiocatori(int posizione) {
		for(int i = 0; i < posizione; i++) {
			Giocatore jolly = giocatori.remove(0);
			giocatori.add(jolly);
		}
	}
	
	//metodo che itera sul metodo faiUnaMano
	//ti fa giocare tutte le mani possibili
	public void giocaTutteLeMani(Carta briscola) {
		int nMani = 40 / giocatori.size();
		for(int i = 0; i < nMani; i++) {
			faiUnaMano(briscola);
		}
	}
	
	//fai pescare una carta ad ogni giocatore
	public void prendeteUnaCarta() {
		for(Giocatore giocatore : giocatori) {
			giocatore.takeACard(myMazzo.takeACard());
		}
	}
	
	//distribuisce 3 carte a ciascun giocatore
	public void distribuzioneMani() {
		for(Giocatore giocatore : giocatori) {
			giocatore.takeCards(myMazzo.dammiPrimeTreCarte());
		}
	}
	
	public void chiudiPartita() {
		//calcoli il punteggio di ogni squadra e stabilisci il vincitore
		
		//creo un arraylist dei punteggi delle squadre
		ArrayList<Integer> punteggiSquadre = new ArrayList<Integer>();
		for(Giocatore giocatore : giocatori) {
			
		}
	}

	public static void main(String args[]) {
		PartitaBriscola myPartita = new PartitaBriscola();
		myPartita.selezioneGiocatori();
		myPartita.selezioneSquadre();
		//guardo se ci sono carte da scartare
		//TODO: spostare il metodo scartaCarteDeboli nella classe PartitaBriscola
		myPartita.scartaCarteDeboli();
		//myPartita.myMazzo.printMazzo();
		//mescolo il mazzo
		myPartita.myMazzo.shuffle();
		//estraggo la briscola
		Carta briscola = myPartita.myMazzo.pushACard();
		System.out.println("La briscola è: " + briscola);
		//distribuisco 3 carte ad ogni giocatore
		myPartita.distribuzioneMani();
		//ora gioco tutte le mani
		myPartita.giocaTutteLeMani(briscola);
		
	}
}
