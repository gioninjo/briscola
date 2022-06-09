package main;

import java.util.ArrayList;
import java.util.Collections;


public class Mazzo {
	public ArrayList<Carta> myMazzo = new ArrayList<Carta>();
	
	//costruttore
	public Mazzo() {		
		for(Seme seme : Seme.values()) {
			for(Valore valore: Valore.values()) {
				myMazzo.add(new Carta(valore, seme));
			}
		}
	}

	public ArrayList<Carta> getMyMazzo() {
		return myMazzo;
	}
	
	//mescola il mazzzo
	public void shuffle() {
		Collections.shuffle(myMazzo);
	}
	
	//prende la prima carta, la ritorna e la rimuove
	public Carta takeACard() {
		return myMazzo.remove(0);
	}
	
	
	
	//prende una carta in cima, la mostra e la mette i n  fondo
	public Carta pushACard() {
		Carta cardShown = myMazzo.remove(0);
		myMazzo.add(cardShown);
		return cardShown;
	}
	
	public void printMazzo() {
		for(Carta c : myMazzo) {
			System.out.println(c);
		}
	}
	
	//
	public ArrayList<Carta> dammiPrimeTreCarte(){
		ArrayList<Carta> cards = new ArrayList<Carta>();
		for(int i = 0; i < 3; i++) {
			cards.add(myMazzo.remove(0));
		}
		return cards;
	}
	
	public boolean isEmpty() {
		if(myMazzo.size() == 0) {
			return true;
		}
		return false;
	}
}