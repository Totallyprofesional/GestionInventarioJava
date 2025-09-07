
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
      
    public void agregarProducto(Producto p) {  
        productos.put(p.getCodigo(), p); 
    } 
     
    public void quitarProducto(String codigo) { 
        Producto eliminado = productos.remove(codigo);
        if (eliminado != null) {
            System.out.println("Producto eliminado: " + eliminado.mostrarProducto());
        } else { 
            System.out.println("El código no existe");
    }
    } 
    
    public Producto buscarProducto(String codigo) {
        return productos.get(codigo);  
    }
    
    public void mostrarLista() {  
    productos.values().stream()
        .sorted((p1, p2) -> Integer.compare(Integer.parseInt(p1.getCodigo()), Integer.parseInt(p2.getCodigo())))
        .forEach(p -> System.out.println(p.mostrarProducto()));
    }
    
} 

 