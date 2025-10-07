package ar.edu.unlam.dominio;

public class AsignacionMesaMozo {

	public Mozo mozo;
	public Mesa mesa;
	public String turno;

	public AsignacionMesaMozo(Mozo mozo, Mesa mesa, String turno) {
		this.mozo = mozo;
		this.mesa = mesa;
		this.turno = turno;
	}

}
