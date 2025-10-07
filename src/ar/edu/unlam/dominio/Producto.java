package ar.edu.unlam.dominio;

public abstract class Producto implements ICalcularPrecioFinal {

	private String nombre;
	private Double precio;
	
	public Producto(String nombre, Double precio) {
		this.nombre = nombre;
		this.precio = precio;
	}

	public Double getPrecio() {
		return precio;
	}

	
	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}
	
}
