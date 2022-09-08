import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

	public static ArrayList<Producto> productos = new ArrayList<>();
	public static ArrayList<Kit> promociones = new ArrayList<>();
	public static Scanner scanner = new Scanner(System.in);
	public static Empresa empresa = new Empresa(0);

	public static void main(String[] args) {
		Producto p1 = new Producto("Máscara", 10, 1000);
		Producto p2 = new Producto("Capa", 50, 500);
		Producto p3 = new Producto("Accesorio", 20, 1500);
		Producto p4 = new Producto("Set maquillaje", 15, 5000);
		Producto p5 = new Producto("Disfraz", 10, 10000);
		Producto p6 = new Producto("Canasto", 70, 1000);

		productos.add(p1);
		productos.add(p2);
		productos.add(p3);
		productos.add(p4);
		productos.add(p5);
		productos.add(p6);

		Kit kit1 = new Kit(1, "Infantil Básico", 10000, (new ArrayList<>()), 0);
		kit1.getProductos().add(p1);
		kit1.getProductos().add(p2);
		kit1.getProductos().add(p6);

		Kit kit2 = new Kit(2, "Infantil Medio", 12000, (new ArrayList<>()), 0);
		kit2.getProductos().add(p1);
		kit2.getProductos().add(p2);
		kit2.getProductos().add(p3);
		kit2.getProductos().add(p6);

		Kit kit3 = new Kit(3, "Infantil Avanzado", 20000, (new ArrayList<>()), 0);
		kit3.getProductos().add(p4);
		kit3.getProductos().add(p5);
		kit3.getProductos().add(p3);
		kit3.getProductos().add(p6);

		promociones.add(kit1);
		promociones.add(kit2);
		promociones.add(kit3);
		boolean a = true;
		mostrarPromociones();
		/*
		 * while(a) { try { //verificarCantidad(); mostrarPromociones(); } catch
		 * (Exception e) { System.out.println("ENTRADA INVALIDA, REINTENTE...");
		 * a=false; } }
		 */
	}

	public static void mostrarPromociones() {
		System.out.println("");
		System.out.println("PROMOCIONES DISPONIBLES:");
		linea();
		System.out.printf("%20s %50s %20s", "PROMOCIÓN:", "PRODUCTOS", "VALOR");
		System.out.println();
		linea();
		// for (int i = 0; i < Inventario.size(); i++)
		for (Kit promocion : promociones) {

			String aux = "";
			int aux2 = 0;
			for (int i = 0; i < promocion.getProductos().size(); i++) {
				aux += productos.get(i).getNombre();
				if (i < promocion.getProductos().size() - 1)
					aux += ", ";
			}
//        		String aux = promocion.getProductos().stream().map(p -> p.getNombre()).collect(Collectors.joining(", "));

			System.out.format("%20s %50s %20d\n", promocion.getNombre(), aux, promocion.getPrecio());
//            System.out.println();
		}

		selecPromocion();
	}

	public static void mostrarProductos() {
		System.out.println("");
		System.out.println("PRODUCTOS DISPONIBLES:");
		System.out.println("");
		System.out.printf("%20s %20s %20s", "PRODUCTO:", "STOCK", "PRECIO");
		System.out.println();
		linea();
		// for (int i = 0; i < Inventario.size(); i++)

		for (Producto producto : productos) {
			System.out.format("%20s %20s %20d", producto.getNombre(), producto.getCantidad(), producto.getPrecio());
			System.out.println();
		}
	}

	public static void selecPromocion() {
		System.out.println("");
		linea();
		String items = "";
		System.out.println("SELECCIONE UNA PROMOCIÓN:");
		for (int i = 0; i < promociones.size(); i++) {
			items += (i + 1) + ") Para " + promociones.get(i).getNombre() + ", ";
		}
		System.out.println(items);
		String input = scanner.nextLine();
		int cant;
		switch (input) {
		case "1":
			System.out.println("INGRESE CANTIDAD:");
			cant = scanner.nextInt();
			if (productos.get(0).getCantidad() >= cant && productos.get(1).getCantidad() >= cant
					&& productos.get(5).getCantidad() >= cant) {
				linea();
				comprarPromocion(1, cant, promociones.get(0).getNombre());
			} else {
				System.out.println("No hay stock disponible, seleccione otra opción...");
				selecPromocion();
			}
			break;
		case "2":
			System.out.println("INGRESE CANTIDAD:");
			cant = scanner.nextInt();
			if (productos.get(0).getCantidad() >= cant && productos.get(1).getCantidad() >= cant
					&& productos.get(2).getCantidad() >= cant && productos.get(5).getCantidad() >= cant) {
				linea();
				comprarPromocion(2, cant, promociones.get(1).getNombre());
			} else {
				System.out.println("No hay stock disponible, seleccione otra opción...");
				selecPromocion();
			}
			break;
		case "3":
			System.out.println("INGRESE CANTIDAD:");
			cant = scanner.nextInt();
			if (productos.get(3).getCantidad() >= cant && productos.get(4).getCantidad() >= cant
					&& productos.get(2).getCantidad() >= cant && productos.get(5).getCantidad() >= cant) {
				linea();
				comprarPromocion(2, cant, promociones.get(2).getNombre());
			} else {
				System.out.println("No hay stock suficiente, seleccione otra opción...");
				selecPromocion();
			}
			break;
		default:
			System.out.println("ENTRADA INCORRECTA, REINTENTE...");
			selecPromocion();
		}
	}

	public static void selecProductos() {
		System.out.println();
		String items = "";
		System.out.println("SELECCIONE UN PRODUCTO:");
		for (int i = 0; i < productos.size(); i++) {
			items += (i + 1) + ") Para " + productos.get(i).getNombre() + ", ";
		}
		items += " 0) PARA CANCELAR";
		System.out.println(items);
		int input = scanner.nextInt();
		System.out.println("INGRESE CANTIDAD:");
		int cant = scanner.nextInt();
		if (productos.get(input - 1).getCantidad() >= cant) {
			linea();
			comprarProducto(input - 1, cant, productos.get(input - 1).getNombre());
		} else {
			System.out.println("No hay stock suficiente, seleccione otra opción...");
			selecProductos();
		}
	}

	public static void linea() {
		System.out.println("--------------------------------------------------------------------------------------------");
	}

	public static void comprarPromocion(int input, int cant, String nombre) {
		System.out.println("HAS COMPRADO: " + cant + "x " + "PROMOCIÓN " + nombre.toUpperCase());
		empresa.ingresos += promociones.get(input - 1).getPrecio();
		promociones.get(input - 1).setVentas(promociones.get(input - 1).getVentas() + 1);
		linea();
		agregarArticulo(0);
	}

	public static void comprarProducto(int input, int cant, String nombre) {
		System.out.println("HAS ADICIONADO: " + cant + "x " + "PRODUCTO " + nombre.toUpperCase());
		linea();
		agregarArticulo(0);
	}

	public static void verificarExistencia() {
		for (Producto producto : productos) {
			if (producto.getCantidad() <= 0) {
				productos.remove(producto);
			}
		}
	}

	public static void agregarArticulo(int opcion) {
		if (opcion == 0) {
			System.out.println("¿DESEA ADICIONAR UN PRODUCTO?");
		}
		if (opcion == 1) {
			System.out.println("¿DESEA COMPRAR OTRA PROMOCIÓN?");
		}
		System.out.println("1) SI, 2) NO");
		int selec = scanner.nextInt();
		if (selec == 1) {
			System.out.println("");
			if ((opcion == 0)) {
				mostrarProductos();
			}
			if ((opcion == 1)) {
				mostrarPromociones();
			}
		}
		if (selec == 2) {
			if ((opcion == 0)) {
				agregarArticulo(1);
			}
			if ((opcion == 1)) {
				System.out.println("FIN DE LA COMPRA");
				linea();
				mostrarVentas();
			}
		}
	}

	public static void mostrarVentas() {
		linea();
		int total = 0;
		System.out.println("VENTAS DE CADA PROMOCIÓN");
		linea();
		for (int i = 0; i < promociones.size(); i++) {
			System.out.println(promociones.get(i).getNombre() + ": " + promociones.get(i).getVentas());
			total += promociones.get(i).getVentas();
		}
		System.out.println("TOTAL DE PROMOCIÓNES VENDIDAS: " + total);
	}
}
