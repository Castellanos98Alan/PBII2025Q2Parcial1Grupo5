package ar.edu.unlam.dominio;

import java.time.LocalDateTime;
import java.util.HashSet;

public class Mozo extends Persona {

	private HashSet<Mesa> mesas;
	private String turno;
	private String dia;
	private LocalDateTime comienzoTurno;
	private LocalDateTime finTurno;

	public Mozo(String nombre, Integer dni, String turno, String dia) {
		super(nombre, dni);
		this.mesas = new HashSet<>();
		this.turno = turno;
		this.setDia(dia);
	}

	public void agregarMesa(Mesa mesa) {
		this.mesas.add(mesa);

	}

	public HashSet<Mesa> getMesas() {
		return mesas;
	}

	@Override
	public String toString() {
		return "Mozo [mesa=" + mesas + ", getDni()=" + getDni();
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public LocalDateTime getComienzoTurno() {
		return comienzoTurno;
	}

	public LocalDateTime getFinTurno() {
		return finTurno;
	}

	public void setComienzoTurno(LocalDateTime comienzoTurno) {
		this.comienzoTurno = comienzoTurno;
	}

	public void setFinTurno(LocalDateTime finTurno) {
		this.finTurno = finTurno;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

}