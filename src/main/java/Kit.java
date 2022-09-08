import java.util.ArrayList;

public class Kit extends Articulo{
    public ArrayList<Producto> productos = new ArrayList<>();
    public int ventas;

    public Kit(String nombre, int precio, ArrayList<Producto> productos, int ventas){
        this.nombre = nombre;
        this.precio = precio;
        this.productos = productos;
        this.ventas = ventas;

    }

    public String getNombre(){
        return this.nombre;
    }

    public ArrayList<Producto> getProductos(){
        return this.productos;
    }

    public int getPrecio(){
        return this.precio;
    }

    public int getVentas(){
        return this.ventas;
    }
}
