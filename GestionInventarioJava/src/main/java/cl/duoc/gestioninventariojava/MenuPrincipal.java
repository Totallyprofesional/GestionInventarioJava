
package cl.duoc.gestioninventariojava;

import cl.duoc.gestioninventariojava.models.Inventario;
import cl.duoc.gestioninventariojava.models.Inventario;
import cl.duoc.gestioninventariojava.models.Producto;
import java.util.Scanner;

public class MenuPrincipal {
    private Scanner sc = new Scanner(System.in);
    private Inventario i = new Inventario();

    public void Menu() { 
        i.listaProductos();
        int opcion = 0; 
         
        do {      
            System.out.println("Bienvenido al menu de inventario");
            System.out.println("");          
            System.out.println("1) Mostrar inventario");            
            System.out.println("2) Agregar productos");  
            System.out.println("3) Quitar productos");  
            System.out.println("4) Actualizar informacion de productos"); 
            System.out.println("5) Busqueda de productos");
            System.out.println("6) Generar informe de productos");
            System.out.println("7) Salir");
            
            opcion = sc.nextInt();
            sc.nextLine(); 
                   
                switch (opcion) {
                    case 1: 
                        mostrarInventario();
                        break;
                    case 2:
                        agregarProductos(sc);
                        break; 
                    case 3:
                        quitarProductos(sc);
                        break; 
                    case 4:
                        actualizarInfo(sc);
                        break;
                    case 5:
                        busquedaProductos(sc);
                        break;
                    case 6:
                        generarInforme();
                        break;  
                    case 7:
                        System.out.println("Fin del programa");
                        break;
                    default:
                        System.out.println("Por favor ingrese una opción");
                        break;    
                }                            
        } while (opcion != 7);        
    }   
     
    private void mostrarInventario(){  
        System.out.println("");
        System.out.println("Lista de Productos"); 
        i.mostrarLista(); 
        System.out.println(""); 
    } 
     
    private void agregarProductos(Scanner sc){  
        i.mostrarLista();     
        
        String codigo;
        while (true) { 
            System.out.println("Ingrese código");
            codigo = sc.nextLine().trim();  
            if (!codigo.matches("\\d+")) {  
                System.out.println("Código inválido. Debe contener solo números.");
                continue;
            }
            
            if (i.getProductos().containsKey(codigo)) { 
                System.out.println("Codigo ya existe."); 
                continue;
            }
            break;
        }
                
            System.out.println("Ingrese nombre producto");
            String nombre = sc.nextLine().trim(); 
            
        double precio;
        while (true) {
            System.out.println("Ingrese precio:");
            String input = sc.nextLine().trim();
            try {
                precio = Double.parseDouble(input);
                if (precio < 0) {
                    System.out.println("El precio no puede ser negativo.");
                    continue;
                }
                break; 
            } catch (NumberFormatException e) {
            System.out.println("Precio inválido. Debe ser un número decimal.");
            }
        }
       
        Producto p = new Producto(codigo, nombre, precio);
        i.agregarProducto(p);
    }
        
      
      
    private void quitarProductos(Scanner sc){
        i.mostrarLista(); 
        System.out.println("Ingrese código del producto a quitar");
        String codigo = sc.nextLine().trim(); 
 
        i.quitarProducto(codigo); 
    }
    
    private void actualizarInfo(Scanner sc){ 
        i.mostrarLista(); 
        System.out.println("Ingrese código del producto a editar:");
        String codigo = sc.nextLine();
 
        Producto p = i.getProductos().get(codigo);
   
        if (p != null) { 
            System.out.println("Ingrese nuevo nombre:");
            String nuevoNombre = sc.nextLine();
            if (!nuevoNombre.isEmpty()) {
                p.setNombre(nuevoNombre);
            }
 
            System.out.println("Ingrese nuevo precio:");
            String precioInput = sc.nextLine();
             
            if (!precioInput.isEmpty()) { 
                try { 
                    double nuevoPrecio = Double.parseDouble(precioInput);
                    p.setPrecio(nuevoPrecio);
                } catch (NumberFormatException e) {
                    System.out.println("Precio inválido.");
                } 
            }  

            System.out.println("Producto actualizado: " + p.mostrarProducto());

        } else {
            System.out.println("Código no existe.");
        }  
    }  
     
    private void busquedaProductos(Scanner sc){ 
        System.out.println("Ingrese código del producto");
        String codigo = sc.nextLine();  
        Producto p = i.buscarProducto(codigo);
        
        if (i.getProductos().containsKey(codigo)) {  
        System.out.println(p.mostrarProducto());
        } else{
        System.out.println("Codigo no existe.");
        } 
    } 
    
    private void generarInforme(){
        System.out.println("");
        System.out.println("Informe de inventario");  
        i.mostrarLista();
        System.out.println("");
    }
    
}
 

   

