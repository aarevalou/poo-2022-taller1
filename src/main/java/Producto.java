public class Producto extends Articulo{

    public int cantidad;

    public Producto(String nombre, int cantidad, int precio){
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;

    }

    public String getNombre(){
        return this.nombre;
    }

    public int getCantidad(){
        return this.cantidad;
    }

    public int getPrecio(){
        return this.precio;
    }
}
