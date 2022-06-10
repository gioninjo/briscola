package main;

import java.util.Objects;

public class Squadra {
	private String nome;
	private int punteggio;
	
	// costruttore
	public Squadra(String squadra) {
		this.nome = squadra;
		this.punteggio = 0;
		
	}
	
	public Squadra() {
		this.punteggio = 0;
	}
	
	//getters and setters
	public String getNome() {
		return nome;
	}
	public void setSquadra(String squadra) {
		this.nome = squadra;
	}
	public int getPunteggio() {
		return punteggio;
	}
	public void addPunteggio(int punteggio) {
		this.punteggio += punteggio;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Squadra other = (Squadra) obj;
		return Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "La squadra " + nome + " ha un punteggio di " + punteggio;
	}
	
	
}
