package ar.edu.unlam.dominio;

import java.util.HashSet;

public class Restaurante {

	public HashSet<Mozo> mozos;
	public HashSet<Mesa> mesas;
	public HashSet<Cliente> clientes;
	public HashSet<Pedido> pedidos;

	public Restaurante() {
		mozos = new HashSet<Mozo>();
		mesas = new HashSet<>();
		clientes = new HashSet<>();
		pedidos = new HashSet<>();
	}

	public Boolean agregarMozo(Mozo mozo) {
		return this.mozos.add(mozo);
	}

	public Boolean agregarMesa(Mesa mesa) {
		return this.mesas.add(mesa);
	}

	public Boolean agregarCliente(Cliente cliente) {
		return this.clientes.add(cliente);
	}

	public Boolean agregarPedido(Pedido pedido) {
		return this.pedidos.add(pedido);
	}

	public Boolean asignarMesaAMozo(Integer dniMozo, Integer numeroMesa) {

		Boolean fueAsignada = false;

		Mozo mozoEncontrado = buscarMozoPorDni(dniMozo);
		Mesa mesaEncontrada = buscarMesaPorId(numeroMesa);

		if (mozoEncontrado != null && mesaEncontrada != null) {
			mozoEncontrado.agregarMesa(mesaEncontrada);
			fueAsignada = true;
		}

		return fueAsignada;
	}

	private Mesa buscarMesaPorId(Integer mesaID) {

		Mesa mesaEncontrada = null;
		for (Mesa mesa : mesas) {
			if (mesa.getNumeroMesa().equals(mesaID)) {
				mesaEncontrada = mesa;
			}
		}
		return mesaEncontrada;
	}

	private Mozo buscarMozoPorDni(Integer mozoDni) {

		Mozo mozoEncontrado = null;
		for (Mozo mozo : mozos) {
			if (mozo.getDni().equals(mozoDni)) {
				mozoEncontrado = mozo;
			}
		}
		return mozoEncontrado;
	}


	public Boolean asignarPedidoAMesa(Integer pedidoId, Integer mesaId) {
		Boolean fueAsignado = false;

		Mesa mesaEncontrada = buscarMesaPorId(mesaId);
		Pedido pedidoEncontrado = buscarPedidoPorId(pedidoId);

		if (mesaEncontrada != null && pedidoEncontrado != null) {
			mesaEncontrada.asignarPedido(pedidoEncontrado);
			fueAsignado = true;
		}
		return fueAsignado;
	}

	private Pedido buscarPedidoPorId(Integer pedidoId) {

		Pedido pedidoEncontrado = null;

		for (Pedido pedidoFor : pedidos) {
			if (pedidoFor.getIdPedido().equals(pedidoId)) {
				pedidoEncontrado = pedidoFor;
			}
		}
		return pedidoEncontrado;
	}

	public Boolean cambiarTurnoMozos(Mozo mozo, Mozo mozoNuevo) {
		Boolean seCambio = false;
		if (mozo.getFinTurno().equals(mozoNuevo.getComienzoTurno())) {
			seCambio = true;
		}
		return seCambio;
	}
}
