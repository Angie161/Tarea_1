/**
 * Subclase de Pago, la cual permite realizar la compra a través de una transferencia mediante una Tarjeta.
 *
 * @author Angie Ramírez
 * @version 2, 28 de Septiembre del 2023
 */
public class Tarjeta extends Pago {
    /** String para almacenar el tipo de Tarjeta*/
    private String tipo;
    /** String para almacenar el número de la Transacción*/
    private String numTransacción;

    /**
     * Método constructor de la clase Tarjeta, que hereda los datos de la clase Pago.
     * @param monto float con la cantidad de dinero a pagar.
     * @param tipo String para inicializar la variable tipo
     * @param numTransacción String para inicializar la variable numTransacción
     */
    public Tarjeta(float monto, String tipo, String numTransacción){
        super(monto);
        this.tipo=tipo;
        this.numTransacción=numTransacción;
    }

    /**
     * Override del método toString.
     * @return Una cadena con los datos de la Tarjeta otorgados.
     */
    @Override
    public String toString(){
        return "Tipo de Tarjeta: "+tipo+", numero de Transacción: "+numTransacción;
    }
}


