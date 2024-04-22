
package teatro_moro_s7;

import java.util.ArrayList;
import java.util.Scanner;



public class Teatro_moro_s7 {
static double estudiante=10;
static double  tercera_edad=15;        
static double general=0;
ArrayList<Entradas> listaentradas = new ArrayList<>();


public static void main(String[] args) {
    System.out.println("Bienvenido al teatro moro");
    System.out.println("");
    System.out.println("Estudiante 10% descuento");
    System.out.println("tercera edad 15% desceunto");
    System.out.println("");
    Teatro_moro_s7 teatro = new Teatro_moro_s7();
    teatro.menuopciones();
    }
    
public void menuopciones(){
    Scanner Teclado =new Scanner(System.in);
    int opciones;
    do{
    System.out.println("1- Comprar Entradas");
    System.out.println("2- Resumen de Ventas");
    System.out.println("3- Generar Boleta");
    System.out.println("4- Total de Ingresos");
    System.out.println("5- Salir");
    opciones=Teclado.nextInt();
    Teclado.nextLine();
    switch (opciones){
        case 1:
            comprarentrada(Teclado);
            break;
        case 2:
            mostrarResumen();
            break;
        case 3:
            generarboleta();
            break;
        case 4:
            totalIngresos();
            break;
        case 5:
            System.out.println("Gracias por tu visitar al teatro moro");
            break;
        default:
            System.out.println("Opcion no valida");
            break;
    
    }
    } while (opciones<1||opciones>5);
                                }
public void comprarentrada(Scanner Teclado){
    while(true){
    int edad = 0, vip = 0, plateaalta = 0, palcos = 0, preciobase = 0, total = 0;
        String edades, categoria, pagar, ubicacion = null;
        double descuento = 0;

        System.out.println("    Entradas   -     Tarifas ");
        System.out.println("|  Categorias  |  Valor Entrada  |");
        System.out.println("|     Vip      |     $25.000     |");
        System.out.println("| Platea alta  |     $11.000     |");
        System.out.println("|    Palcos    |     $7.200      |");
        System.out.println("");
        System.out.println("Por favor ingresar su edad:");
        do {
            edad = Teclado.nextInt();
            if (edad < 5 || edad > 100) {
                System.out.println("edad incorrecta");
            }
        } while (edad < 5 || edad > 100);

        if (edad < 18) {
            edades = "Estudiante";
        } else if (edad >= 60) {
            edades = "Tercera Edad";
        } else {
            edades = "General";
        }
        System.out.println("Su edad califica como ! " + edades + " ! ");
        System.out.println("");

        if (edades.equalsIgnoreCase("estudiante")) {
            descuento = estudiante; // Descuento estudiante
        } else if (edades.equalsIgnoreCase("tercera edad")) {
            descuento = tercera_edad; // Descuento tercera edad
        } else {
            descuento = 0;
        }
        System.out.println("");
        System.out.println("Que categoria necesitas?");
        System.out.println("- Vip");
        System.out.println("- Platea alta");
        System.out.println("- Palcos");
        Teclado.nextLine();
        do {
            categoria = Teclado.nextLine().toLowerCase();
            System.out.println("");
            switch (categoria) {
                case "vip":
                    vip = 25000;
                    total = (total + vip);
                    ubicacion = "Vip";
                    preciobase = 25000;
                    break;
                case "platea alta":
                    plateaalta = 11000;
                    total = (total + plateaalta);
                    ubicacion = "Platea alta";
                    preciobase = 11000;
                    break;
                case "palcos":
                    palcos = 7200;
                    total = (total + palcos);
                    ubicacion = "Palcos";
                    preciobase = 7200;
                    break;
                default:
                    System.out.println("Categoria invalida.");
                    break;
            }
        } while (!categoria.equalsIgnoreCase("vip") && !categoria.equalsIgnoreCase("platea alta") && !categoria.equalsIgnoreCase("palcos"));
      
        listaentradas.add(new Entradas(edad, ubicacion, preciobase, descuento, preciobase));
        menuopciones();
        break;
                }
                            }
public void generarboleta(){
    double descuento = 0;
    double montodescuento = 0;
    double preciofinal = 0;
    
    System.out.println("Generando boleta...");
    
    if (!listaentradas.isEmpty()) {
        Entradas ultimaEntrada = listaentradas.get(listaentradas.size() - 1);
        
        System.out.println("------------------------------------");
        System.out.println("            Teatro Moro             ");
        System.out.println("------------------------------------");
        System.out.println("Ubicacion del asiento: " + ultimaEntrada.getubicacion());
        System.out.println("Precio base de la entrada: $" + ultimaEntrada.getpreciobase());
        System.out.println("Descuento aplicado: " + ultimaEntrada.getdescuento() + "%");
        descuento = ultimaEntrada.getdescuento() / 100;
        montodescuento = descuento * ultimaEntrada.getpreciobase();
        preciofinal = ultimaEntrada.getpreciofinal() - montodescuento;
        System.out.println("Precio final a pagar: $" + preciofinal);
        System.out.println("------------------------------------");
        System.out.println("!Gracias por la visita al teatro moro!");
        System.out.println("------------------------------------");
        System.out.println("");
    } else {
        System.out.println("----------------------------------");
        System.out.println("No se ha realizado ninguna compra.");
        System.out.println("----------------------------------");
        System.out.println("");
        
    }
    menuopciones();
    
}
public void totalIngresos() {
    double totalIngresos = 0;
    double descuento=0;
    double montodescuento=0;
    double preciofinal=0;
    
    for (Entradas entrada : listaentradas) {
        descuento = entrada.getdescuento() / 100;
        montodescuento = descuento * entrada.getpreciobase();
        preciofinal = entrada.getpreciofinal() - montodescuento;
        totalIngresos += preciofinal;
    }
    
    System.out.println("Total de ingresos: $" + totalIngresos);
    System.out.println("");
    
    menuopciones();
}

public void mostrarResumen() {
    double montodescuento=0;
    double preciofinal=0;
    
    System.out.println("Resumen de Ventas:");
    System.out.println("----------------------------------");
    if (listaentradas.isEmpty()) {
        System.out.println("No se ha realizado ninguna compra.");
        System.out.println("----------------------------------");
    } else {
    for (Entradas entrada : listaentradas) {
        montodescuento = (entrada.getdescuento() / 100) * entrada.getpreciobase();
        preciofinal = entrada.getpreciobase() - montodescuento;

        System.out.println("Ubicacion: " + entrada.getubicacion());
        System.out.println("Precio base: $" + entrada.getpreciobase());
        System.out.println("Descuento aplicado: " + entrada.getdescuento() + "%");
        System.out.println("Costo final: $" + preciofinal);
        System.out.println("------------------");
        System.out.println("");
    } 
    }
    menuopciones();
}

                                }


