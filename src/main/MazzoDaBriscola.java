package main;

import java.util.ArrayList;
import java.util.Collections;
//mazzo da briscola viene creato dopo 
//che la partita ha già mostrato la briscola
//ricrea un mazzo fatto di carte da briscola
//non eredita da mazzo perchè creerebbe un array di 40 carte norma
public class MazzoDaBriscola implements IMazzo{
	private ArrayList<CartaDaBriscola> myMazzo;

	public MazzoDaBriscola(ArrayList<Carta> myMazzo, Carta briscola) {
		super();
		
		for(Carta c : myMazzo) {
			myMazzo.add(new CartaDaBriscola(c.getValore(), c.getSeme(), briscola));
		}
	}
	
	//mescola il mazzzo
	public void shuffle() {
		Collections.shuffle(myMazzo);
	}
	
	//prende la prima carta, la ritorna e la rimuove
	public CartaDaBriscola takeACard() {
		return myMazzo.remove(0);
	}
	
	
	
	//prende una carta in cima, la mostra e la mette i n  fondo
	public CartaDaBriscola pushACard() {
		CartaDaBriscola cardShown = myMazzo.remove(0);
		myMazzo.add(cardShown);
		return cardShown;
	}
	
	public void printMazzo() {
		for(Carta c : myMazzo) {
			System.out.println(c);
		}
	}
	
	public ArrayList<CartaDaBriscola> dammiPrimeTreCarte(){
		ArrayList<CartaDaBriscola> cards = new ArrayList<CartaDaBriscola>();
		for(int i = 0; i < 3; i++) {
			cards.add(myMazzo.remove(0));
		}
		return cards;
	}
}
