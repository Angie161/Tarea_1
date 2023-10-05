/**
 * Subclase de Pago, la cual permite realizar la compra a través de una transferencia bancaria.
 *
 * @author Angie Ramírez
 */
public class Transferencia extends Pago {
    /** String para almacenar el nombre del banco al que se asocia la transacción*/
    private String banco;

    /** String para almacenar el número de cuenta del Cliente*/
    private String numCuenta;

    /**
     * Método constructor de la clase Transferencia, que hereda los datos de la clase Pago.
     * @param monto float con la cantidad de dinero a pagar.
     * @param banco String en el que se almacena el nombre del banco.
     * @param numCuenta String donde se guarda el numero de Cuenta.
     */
    public Transferencia(float monto, String banco,String numCuenta){
        super(monto);
        this.banco = banco;
        this.numCuenta = numCuenta;
    }

    /**
     * Override del método toString.
     * @return Una cadena con los datos de la Transferencia otorgados, es decir el banco y número de cuenta.
     */
    @Override
    public String toString(){
        return "Transferencia desde el banco: "+banco+", Numero de Cuenta: "+numCuenta;
    }
}
