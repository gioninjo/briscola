package main;

public class Carta {
	public Seme seme;
	public Valore valore;
	
	
	public Seme getSeme() {
		return seme;
	}
	public void setSeme(Seme seme) {
		this.seme = seme;
	}
	public Valore getNome() {
		return valore;
	}
	public void setNome(Valore valore) {
		this.valore = valore;
	}
	public Carta(Valore valore, Seme seme) {
		this.valore = valore;
		this.seme = seme;
	}
	public void printCarta() {
		System.out.println(valore.name() + " di " + seme.name());
	}
}
