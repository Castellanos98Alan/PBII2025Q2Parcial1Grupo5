package ar.edu.unlam.dominio;

import java.util.ArrayList;

public class Pedido {

	private static Integer contadorId = 0;
	private Integer id;
	private ArrayList<PlatoPrincipal> platosPrincipales;
	private ArrayList<Bebida> bebidas;
	private ArrayList<Postre> postres;
	private Double montoTotal;

	public Pedido() {
		this.id = ++contadorId;

		platosPrincipales = new ArrayList<>();
		bebidas = new ArrayList<>();
		postres = new ArrayList<>();

		this.montoTotal = 0.0;
	}

	public void agregarPlatoPrincipal(PlatoPrincipal plato){
		this.platosPrincipales.add(plato);
	};
	public void agregarBebida(Bebida bebida){
		this.bebidas.add(bebida);
	};
	public void agregarPostre(Postre postre){
		this.postres.add(postre);
	};
	
	public Double  calcularMontoTotal() {
		
		Double monto = 0.0;
		for (Bebida bebida : bebidas) {
			monto += bebida.getPrecio();
		}
		for (PlatoPrincipal platoPrincipal : platosPrincipales) {
			monto += platoPrincipal.getPrecio();
		}
		for (Postre postre : postres) {
			monto += postre.getPrecio();
		}
		
		this.montoTotal = monto;
		return this.montoTotal;
	}
	
	
	
	public Integer getIdPedido() {
		return id;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", platosPrincipales=" + platosPrincipales + ", bebidas=" + bebidas + ", postres="
				+ postres + ", montoTotal=" + montoTotal + "]";
	}
	
	

}
