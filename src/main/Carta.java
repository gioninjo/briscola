package main;

import java.util.Objects;

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

	@Override
	public int hashCode() {
		return Objects.hash(seme, valore);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carta other = (Carta) obj;
		return seme == other.seme && valore == other.valore;
	}
	
	
}
