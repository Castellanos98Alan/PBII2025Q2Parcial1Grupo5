package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

public class RestauranteTest {

	Restaurante restaurante;
	Persona mozo1;
	Persona mozo2;
	Mesa mesa1;
	Mesa mesa2;
	Persona cliente1;

	@Before
	public void inicializacion() {
		restaurante = new Restaurante();
		mozo1 = new Mozo("Juan", 40589410, "Mañana", "Lunes");
		mozo2 = new Mozo("Flor", 39989315, "Tarde", "Lunes");
		mesa1 = new Mesa(1);
		mesa2 = new Mesa(2);
		cliente1 = new Cliente("Alexis", 36908347);

	}

	@Test
	public void dadoQueExisteUnRestauranteSeDebenAgregarAlMozoConSuNombreDniYTurnoMañanaOTarde() {
		assertTrue(restaurante.agregarMozo((Mozo) mozo1));
		assertTrue(restaurante.agregarMozo((Mozo) mozo2));
	}

	@Test
	public void dadoQueExisteUnRestauranteSeDebenAgregarSusMesas() {
		assertTrue(restaurante.agregarMesa(mesa1));
		assertTrue(restaurante.agregarMesa(mesa2));
	}

	@Test
	public void dadoQueExisteUnRestauranteSeDebenAgregarLasMesasYMozoAlRestauranteParaAsignarleLaMesaAlMozo2() {
		assertTrue(restaurante.agregarMozo((Mozo) mozo1));
		assertTrue(restaurante.agregarMesa(mesa1));

		assertTrue(restaurante.agregarAsignacion(mozo1.getDni(), mesa1.getNumeroMesa()));

	}

	@Test
	public void dadoQueExisteUnaMesaAsignadaAlMozoNoSePuedaAsignarMesaInexistente() {
		restaurante.agregarMozo((Mozo) mozo1);
		restaurante.agregarMesa(mesa2);// mesa numero 2

		assertFalse(restaurante.agregarAsignacion(mozo1.getDni(), 99)); // no existe mesa 99

	}

	@Test
	public void dadoQueExisteUnRestauranteSeDebeAgregarAlCliente() {
		assertTrue(restaurante.agregarCliente((Cliente) cliente1));
	}

	@Test
	public void dadoQueElRestauranteTieneUnClienteSeCalculaElMontoTotalDeLaConsumicion() {
		assertTrue(restaurante.agregarCliente((Cliente) cliente1));

		String nombrePlato = "Fideos";
		Double precioPlato = 500.0;
		Double precioBaseCubiertos = 100.0;
		Producto platoPrincipal = new PlatoPrincipal(nombrePlato, precioPlato, precioBaseCubiertos);

		String nombrePostre = "Tiramisu"; //
		String adicional = "Cafe"; // cafe - helado
		Double precioPostre = 100.0;
		Producto postre = new Postre(nombrePostre, precioPostre, adicional);

		String nombreBebida = "Coca";
		Double precioBebida = 50.0;
		String tamanio = "grande";// puede ser pequeño o grande
		Producto bebida = new Bebida(nombreBebida, precioBebida, tamanio);

		Double precioFinalEsperadoBebida = 45.0;
		Double precioFinalObtenidoBebida = bebida.calcularPrecioFinal();
		assertEquals(precioFinalEsperadoBebida, precioFinalObtenidoBebida);

		Double precioFinalEsperadoPostre = 120.0;
		Double precioFinalObtenidoPostre = postre.calcularPrecioFinal();
		assertEquals(precioFinalEsperadoPostre, precioFinalObtenidoPostre);

		Double precioFinalEsperadoPlatoPrincipal = 600.0;
		Double precioFinalObtenidoPlatoPrincipal = platoPrincipal.calcularPrecioFinal();
		assertEquals(precioFinalEsperadoPlatoPrincipal, precioFinalObtenidoPlatoPrincipal);

		Double montoTotalEsperado = 765.0;
		Double montoTotalObtenido = bebida.calcularPrecioFinal() + postre.calcularPrecioFinal()
				+ platoPrincipal.calcularPrecioFinal();
		assertEquals(montoTotalEsperado, montoTotalObtenido);
	}

	@Test
	public void dadoQueElRestauranteTieneUnClienteEsteUltimoRealizaSuPedido() {
		assertTrue(restaurante.agregarCliente((Cliente) cliente1));

		String nombrePlato = "Fideos";
		Double precioPlato = 500.0;
		Double precioBaseCubiertos = 100.0;
		Producto platoPrincipal = new PlatoPrincipal(nombrePlato, precioPlato, precioBaseCubiertos);

		String nombrePostre = "Tiramisu";
		String adicional = "Cafe"; // cafe - helado
		Double precioPostre = 100.0;
		Producto postre = new Postre(nombrePostre, precioPostre, adicional);

		String nombreBebida = "Coca";
		Double precioBebida = 50.0;
		String tamanio = "grande";// puede ser pequeño o grande
		Producto bebida = new Bebida(nombreBebida, precioBebida, tamanio);

		Double montoTotal = bebida.calcularPrecioFinal() + postre.calcularPrecioFinal()
				+ platoPrincipal.calcularPrecioFinal();

		Pedido pedido = new Pedido(platoPrincipal, bebida, postre, montoTotal);
		assertTrue(restaurante.agregarPedido(((Cliente) cliente1).realizarPedido(pedido)));

	}

	@Test
	public void dadoQueElRestauranteTieneUnClienteEsteUltimoRealizaSuPedidoYSeAsignaAUnMozo() {
		assertTrue(restaurante.agregarCliente((Cliente) cliente1));

		assertTrue(restaurante.agregarMozo((Mozo) mozo1));

		assertTrue(restaurante.agregarMesa(mesa1));

		// asignar mesa a mozo
		assertTrue(restaurante.agregarAsignacion(mozo1.getDni(), mesa1.getNumeroMesa()));

		// pedido
		String nombrePlato = "Fideos";
		Double precioPlato = 500.0;
		Double precioBaseCubiertos = 100.0;
		Producto platoPrincipal = new PlatoPrincipal(nombrePlato, precioPlato, precioBaseCubiertos);

		String nombrePostre = "Tiramisu";
		String adicional = "Cafe"; // cafe - helado
		Double precioPostre = 100.0;
		Producto postre = new Postre(nombrePostre, precioPostre, adicional);

		String nombreBebida = "Coca";
		Double precioBebida = 50.0;
		String tamanio = "grande";// puede ser pequeño o grande
		Producto bebida = new Bebida(nombreBebida, precioBebida, tamanio);

		Double montoTotal = bebida.calcularPrecioFinal() + postre.calcularPrecioFinal()
				+ platoPrincipal.calcularPrecioFinal();

		Pedido pedido = new Pedido(platoPrincipal, bebida, postre, montoTotal);
		assertTrue(restaurante.agregarPedido(((Cliente) cliente1).realizarPedido(pedido)));

		// asignar pedido a mesa
		assertTrue(restaurante.asignarPedidoAMesa(pedido.getIdPedido(), mesa1.getNumeroMesa()));
	}

	@Test
	public void dadoQueExisteUnRestauranteSeRegistraQueEmpiezaElCambioDeTurnosEntreMozos() {
		assertTrue(restaurante.agregarMozo((Mozo) mozo1));
		assertTrue(restaurante.agregarMozo((Mozo) mozo2));

		// Asignar horario de Fin de turno del mozo1, y Comienzo del turno de mozo2
		// MOZO 1 --> 11HS - 17HS
		LocalDateTime finTurnoMozo1 = LocalDateTime.of(2025, 10, 3, 17, 0, 0);

		// MOZO 2 --> 17HS - 23HS
		LocalDateTime comienzoTurnoMozo2 = LocalDateTime.of(2025, 10, 3, 17, 0, 0);

		((Mozo) mozo1).setFinTurno(finTurnoMozo1);
		((Mozo) mozo2).setComienzoTurno(comienzoTurnoMozo2);

		Boolean seRegistroCambio = restaurante.cambiarTurnoMozos(((Mozo) mozo1), ((Mozo) mozo2));

		assertTrue(seRegistroCambio);
	}
}
