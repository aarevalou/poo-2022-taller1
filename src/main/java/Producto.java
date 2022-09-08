public class Producto extends Articulo {

    private int cantidad;

    public Producto(String nombre, int cantidad, int precio){
    	super(nombre, precio);
//        this.nombre = nombre;
        this.cantidad = cantidad;
//        this.precio = precio;

    }


    public int getCantidad(){
        return this.cantidad;
    }
    
    public void setCantidad(int cantidad) {
    	this.cantidad = cantidad;
    }
}
