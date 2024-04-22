
package teatro_moro_s7;


    public class Entradas {
    private String ubicacion;
    private int preciobase;
    private double descuento;
    private int edad;
    private int preciofinal;

 public Entradas (int edad, String ubicacion, int preciobase, double descuento, int preciofinal){
        this.edad = edad;
        this.ubicacion = ubicacion;
        this.preciobase = preciobase;
        this.descuento = descuento;
        this.preciofinal = preciofinal;
}    
public int getEdad() {
        return edad;
    }

    public String getubicacion() {
        return ubicacion;
    }

    public int getpreciobase() {
        return preciobase;
    }

    public double getdescuento() {
        return descuento;
    }

    public int getpreciofinal() {
        return preciofinal;
    }
@Override
    public String toString() {
        return "Entrada{" +
                "edad=" + edad +
                ", ubicacion='" + ubicacion + '\'' +
                ", precioBase=" + preciobase+
                ", descuento=" + descuento +
                ", precioFinal=" + preciofinal +
                '}';
                            }
}

