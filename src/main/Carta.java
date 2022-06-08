package main;

public class Carta {
	private Seme seme;
	private Valore valore;
	
	
	public Seme getSeme() {
		return seme;
	}
	
	public Valore getValore() {
		return valore;
	}
	public Carta(Valore valore, Seme seme) {
		this.valore = valore;
		this.seme = seme;
	}
	@Override
	public String toString() {
		return valore + " di " + seme;
	}
	
}
