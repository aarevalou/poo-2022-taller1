import java.util.ArrayList;

public class Kit extends Articulo {

	private int codigo;
	private ArrayList<Producto> productos = new ArrayList<>();
	private int ventas;

	public Kit(int codigo, String nombre, int precio, ArrayList<Producto> productos, int ventas) {
		super(nombre, precio);
		this.codigo = codigo;
//        this.nombre = nombre;
//        this.precio = precio;
		this.productos = productos;
		this.ventas = ventas;

	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	public int getVentas() {
		return ventas;
	}

	public void setVentas(int ventas) {
		this.ventas = ventas;
	}
}
