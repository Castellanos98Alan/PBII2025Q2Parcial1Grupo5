package ar.edu.unlam.dominio;

public class Postre extends Producto {

	private String adicional;
	
	public Postre(String nombre, Double precio, String adicional) {
		super(nombre, precio);
		this.adicional = adicional;
	}
	
	public String getAdicional() {
		return adicional;
	}

	@Override
	public Double calcularPrecioFinal() {
		Double precioFinal = 0.0;
		
		
		if(this.adicional.equalsIgnoreCase("cafe")){ // adicional de $20
			precioFinal = super.getPrecio() + 20.0;
			super.setPrecio(precioFinal);
		}else if(this.adicional.equalsIgnoreCase("helado")) { // adicional de $40
			precioFinal = super.getPrecio() + 40.0;
			super.setPrecio(precioFinal);
		}
		return precioFinal;
	}

	@Override
	public String toString() {
		return "Postre [adicional=" + adicional + ", getNombre()=" + getNombre() + "]";
	}
	
	

}
