package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Mazzo {
	public static ArrayList<Carta> myMazzo = new ArrayList<Carta>();
	
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

	public void setMyMazzo(ArrayList<Carta> mazzo) {
		this.myMazzo = mazzo;
	}
	
	public void Shuffle() {
		Collections.shuffle(myMazzo);
	}
}