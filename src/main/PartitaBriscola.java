package main;

import java.util.ArrayList;
import java.util.Scanner;

public class PartitaBriscola {
	Scanner tastiera = new Scanner(System.in);
	private ArrayList<Giocatore> giocatori;
	private ArrayList<Integer> punteggiSquadre;
	private int nsquadre = 0;

	public void SelezioneGiocatori() {

		int n = 0;

		do {
			System.out.println("Selezionare il numero di giocatori:");
			n = Integer.parseInt(tastiera.nextLine());
		} while (n > 8 && n < 1); 
		for (int i = 0; i < n; i++) {
			giocatori.add(new Giocatore());
		}
	}

	public void SelezioneSquadre() {
		System.out.println("\nSelezionare il numero di squadre:");

	}
}
