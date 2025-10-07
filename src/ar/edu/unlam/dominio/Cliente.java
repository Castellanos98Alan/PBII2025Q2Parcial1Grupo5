package ar.edu.unlam.dominio;

public class Cliente extends Persona {

	private Pedido pedido;

	public Cliente(String nombre, Integer dni) {
		super(nombre, dni);
	}

	public Pedido realizarPedido(Pedido pedido) {
		this.pedido = pedido;
		return this.pedido;
	}

	@Override
	public String toString() {
		return "Cliente [pedido=" + pedido + ", getDni()=" + getDni() + "]";
	}

	


}
