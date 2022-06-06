package main;

import java.util.List;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	@SuppressWarnings("static-access")
	public static void main(String args[]) {
		
		Mazzo myMazzo =  new Mazzo();
		for(int i = 0; i < myMazzo.myMazzo.size(); i++) {
			myMazzo.myMazzo.get(i).printCarta();
		}
				
		myMazzo.Shuffle();
		
		System.out.println("\n\n\n inizio shuffle \n\n\n");
		
		for(int i = 0; i < myMazzo.myMazzo.size(); i++) {
			myMazzo.myMazzo.get(i).printCarta();
		}

	}
}
