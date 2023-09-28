import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase que permite efectuar el pago de la Orden de compra a través de 3 subclases llamadas Efectivo, Tarjeta y Transferencia.
 *
 * @author Angie Ramírez
 * @version version 2, 28 de Septiembre del 2023
 */
public class Pago {

    /** float para almacenar la cantidad de dinero con el que se quiere pagar. */
    private float monto;

    /** Date que guarda la fecha en la que se realiza el pago. */
    private Date fecha;

    /**
     * Constructor de la clase Pago.
     * @param monto float con la cantidad de dinero a pagar.
     */
    public Pago(float monto){
        fecha=new Date();
        this.monto=monto;
    }

    /**
     * Override del método toString. Devuelve la información del pago.
     * @return Una cadena que contiene el monto del pago y la fecha de emisión
     */
    @Override
    public String toString(){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return "Monto ingresado para el pago: "+monto+", fecha: "+formato.format(fecha);
    }

    /**
     * Devuelve el monto almacenado en la variable privada.
     * @return el monto almacenado.
     */
    public float GetMonto(){
        return monto;
    }
}