
package cl.duoc.gestioninventariojava.models;

import cl.duoc.gestioninventariojava.models.Producto;
import java.util.HashMap;
  
public class Inventario { 
    private HashMap<String, Producto> productos;
    
    public Inventario() {
        productos = new HashMap<>(); 
    }   
 
    public HashMap<String, Producto> getProductos() {
        return productos;  
    }
     
    public void listaProductos() { 
        agregarProducto(new Producto("1", "Manzanas", 1500));
        agregarProducto(new Producto("2", "Pan", 800));
        agregarProducto(new Producto("3", "Leche", 1200));
        agregarProducto(new Producto("4", "Huevos", 2500));
        agregarProducto(new Producto("5", "Queso", 3000));
        agregarProducto(new Producto("6", "Arroz", 1000));
        agregarProducto(new Producto("7", "Pasta", 1300));
        agregarProducto(new Producto("8", "Tomates", 2000));
        agregarProducto(new Producto("9", "Aceite", 4500));
        agregarProducto(new Producto("10", "Azúcar", 1800));
    }
      
    public void agregarProducto(Producto producto) {  
        productos.put(producto.getCodigo(), producto);
        System.out.println("Producto agregado: " + producto.getNombre());
    }
     
    public void quitarProducto(String codigo) {
        if (productos.containsKey(codigo)) {
            productos.remove(codigo);
            System.out.println("Producto eliminado: " + codigo); 
        } else {
        System.out.println("No se encontró código: " + codigo);
        }
    } 
    
    public Producto buscarProducto(String codigo) {
        return productos.get(codigo); 
    }
    
    public void mostrarLista() {
        for (Producto p : productos.values()) {
            System.out.println(p.mostrarProducto());
        }
    }
} 
 