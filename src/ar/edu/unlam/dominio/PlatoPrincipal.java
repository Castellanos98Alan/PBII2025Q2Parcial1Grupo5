package ar.edu.unlam.dominio;

public class PlatoPrincipal extends Producto {

	private Double precioBaseCubiertos;

	//
	public PlatoPrincipal(String nombre, Double precio) {
		super(nombre, precio);

	}

	public Double getPrecioBaseCubiertos() {
		return precioBaseCubiertos;
	}

	@Override
	public Double calcularPrecioFinal() {
		Double precioFinal = getPrecio();

		super.setPrecio(precioFinal);

		return precioFinal;
	}

	@Override
	public String toString() {
		return "PlatoPrincipal [getNombre()=" + getNombre() + "]";
	}

}