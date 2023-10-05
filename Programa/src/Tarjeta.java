/**
 * Subclase de Pago, la cual permite realizar la compra a través de una transferencia mediante una Tarjeta.
 *
 * @author Angie Ramírez
 */
public class Tarjeta extends Pago {
    /** String para almacenar el tipo de Tarjeta*/
    private String tipo;
    /** String para almacenar el número de la Transacción*/
    private String numTransaccion;

    /**
     * Método constructor de la clase Tarjeta, que hereda los datos de la clase Pago.
     * @param monto float con la cantidad de dinero a pagar.
     * @param tipo String para inicializar la variable tipo
     * @param numTransaccion String para inicializar la variable numTransacción
     */
    public Tarjeta(float monto, String tipo, String numTransaccion){
        super(monto);
        this.tipo=tipo;
        this.numTransaccion=numTransaccion;
    }

    /**
     * Override del método toString.
     * @return Una cadena con los datos de la Tarjeta otorgados.
     */
    @Override
    public String toString(){
        return "Tipo de Tarjeta: "+tipo+", numero de Transacción: "+numTransaccion;
    }
}


