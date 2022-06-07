package main;


public class Main {
	public static void main(String args[]) {
		
		Mazzo myMazzo =  new Mazzo();
		
		myMazzo.printMazzo();
		
		System.out.println("\n\n\n prova a mostrare la briscola \n\n\n");
		
		Carta briscola = myMazzo.pushACard();
		
		System.out.println(briscola);
		
		System.out.println("\n\n\n\n");
		
		myMazzo.printMazzo();
		
		System.out.println("\n\n\n inizio shuffle \n\n\n");
		
		myMazzo.shuffle();
		
		myMazzo.printMazzo();
		
		Carta briscola2 = myMazzo.pushACard();
		
		
		System.out.println("\n\n\n ecco la briscola" + briscola2);
		
		System.out.println("\n\n\n\n");
		
		myMazzo.printMazzo();
		
		
		Carta myCarta = myMazzo.takeACard();
		
		System.out.println("\n\n\n questa è la carta pescata:   " + myCarta + "\n\n");
		
		myMazzo.printMazzo();
	}
}
