package ar.edu.unlam.interfaz;

import java.util.ArrayList;
import java.util.Scanner;

import ar.edu.unlam.dominio.Bebida;
import ar.edu.unlam.dominio.Cliente;
import ar.edu.unlam.dominio.Mozo;
import ar.edu.unlam.dominio.Pedido;
import ar.edu.unlam.dominio.PlatoPrincipal;
import ar.edu.unlam.dominio.Postre;
import ar.edu.unlam.dominio.Producto;
import ar.edu.unlam.dominio.Restaurante;

public class InterfazRestaurante {

	static Scanner teclado = new Scanner(System.in);
	static ArrayList<Mozo> mozos = new ArrayList<>();
    static ArrayList<Cliente> clientes = new ArrayList<>();
    static ArrayList<Producto> productos = new ArrayList<>();
    static int idMozo = 1;
    static Restaurante restaurante = new Restaurante();
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		
	    
		int opcion;				
		do {
            System.out.println("\n====== MENÚ RESTAURANTE ======");
            System.out.println("1. Agregar Mozo");
            System.out.println("2. Listar Mozos");
            System.out.println("3. Registrar Cliente");
            System.out.println("4. Agregar Pedido a Cliente");
            System.out.println("5. Cobrar Cliente");
            System.out.println("6. Listar Clientes");
            System.out.println("0. Salir");
            System.out.print("Elija una opción: ");
            opcion = teclado.nextInt();
            teclado.nextLine();

           
            switch (opcion) {
                case 1 : agregarMozo();
                break;
                case 9 : asisgnarMesaAMozo();
                break;
                case 2 : listarMozos();
                break;
                case 3 : registrarCliente();
                break;
                case 4 : agregarPedidoCliente();
                break;
                case 5 : cobrarCliente();
                break;
                case 6 : listarClientes();
                break;
                case 0 : System.out.println("Saliendo...");
                break;
                default : System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }
	
	static void asisgnarMesaAMozo() {
		mesa.agregarMesa();
		
		
	}
	

    static void agregarMozo() {
    	
        System.out.print("Ingrese nombre del mozo: ");
        String nombre = teclado.nextLine();
        System.out.println("ingrese el dni del mozo");
        Integer dni = teclado.nextInt();
        System.out.println("Ingrese el turno del mozo");
        String turno = teclado.next();
        mozos.add(new Mozo(nombre, dni, turno)); 
        System.out.println("Mozo agregado correctamente.");
    }

    static void listarMozos() {
        if (mozos.isEmpty()) {
            System.out.println("No hay mozos registrados.");
        } else {
            mozos.forEach(System.out::println);
        }
    }

    static void registrarCliente() {
        System.out.print("Ingrese nombre del cliente: ");
        String nombre = teclado.nextLine();
        System.out.print("Ingrese número de mesa: ");
        int mesa = teclado.nextInt();
        clientes.add(new Cliente(nombre, mesa));
        System.out.println("Cliente registrado correctamente.");
    }

    static void agregarPedidoCliente() {
      
        System.out.print("Ingrese nombre del cliente: ");
        String nombre = teclado.nextLine();

        Cliente cliente = buscarCliente(nombre);

        if (cliente != null) {
            // Pedir datos del pedido
            System.out.print("Ingrese el nombre del plato principal: ");
            String nombrePlato = teclado.nextLine();

            System.out.print("Ingrese el precio del plato principal: ");
            Double precio = teclado.nextDouble();
            teclado.nextLine(); 

            System.out.print("Ingrese el nombre de la bebida: ");
            String nombreBebida = teclado.nextLine();

            System.out.print("Ingrese el precio de la bebida: ");
            Double precioBebida = teclado.nextDouble();
            teclado.nextLine(); 

            System.out.print("Ingrese el nombre del postre: ");
            String nombrePostre = teclado.nextLine();

            System.out.print("Ingrese el precio del postre: ");
            Double precioPostre = teclado.nextDouble();
            teclado.nextLine(); 

            // Crear los objetos Producto
            Producto platoPrincipal = new PlatoPrincipal(nombre, precio);
            Producto bebida = new Bebida(nombreBebida, precioBebida);
            Producto postre = new Postre(nombrePostre, precioPostre);

            // Calcular monto total
            Double montoTotal = precio + precioBebida + precioPostre;

            // Crear el pedido
            Pedido pedido = new Pedido(platoPrincipal, bebida, postre, montoTotal);

            // Asociar el pedido a la mesa del cliente 
            cliente.agregarPedido(pedido);

            System.out.println("✅ Pedido agregado con éxito para " + Cliente.getNombre());
        } else {
            System.out.println("❌ Cliente no encontrado.");
        }
    }

    static void cobrarCliente() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }
        System.out.print("Ingrese nombre del cliente: ");
        String nombre = teclado.nextLine();
        Cliente cliente = buscarCliente(nombre);
        if (cliente != null) {
            System.out.println("Total a pagar: $" + cliente.cuenta);
            clientes.remove(cliente);
            System.out.println("Cliente cobrado y retirado del sistema.");
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    static void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            clientes.forEach(System.out::println);
        }
    }

    static Cliente buscarCliente(String nombre) {
        for (Cliente c : clientes) {
            if (c.nombre.equalsIgnoreCase(nombre)) {
                return c;
            }
        }
        return null;
    }
}
