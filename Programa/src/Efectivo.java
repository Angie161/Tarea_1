/**
 * Subclase de Pago, la cual permite realizar la compra con dinero en efectivo.
 *
 * @author Angie Ramírez
 * @version 2, 28 de Septiembre del 2023
 */
class Efectivo extends Pago {
    /**
     * Método constructor de la clase Efectivo, que hereda los datos de la clase Pago.
     * @param monto float con la cantidad de dinero a pagar.
     */
    public Efectivo(float monto){
        super(monto);
    }

    /**
     * Calcula el cambio a entregar al realizar el pago.
     * @param ordenboleta Es un OrdenBoleta con el que accedemos al precio que se debe pagar.
     * @return una variable float con el dinero sobrante.
     */
    public float calDevolucion(OrdenBoleta ordenboleta){
        if(ordenboleta.calcPrecio()<GetMonto()){
            return ordenboleta.calcPrecio()-GetMonto();
        }
        else{
            return 0;
        }
    }

    /**
     * Override del método toString.
     * @return Una cadena con la identificación de esta clase.
     */
    @Override
    public String toString(){
        return "Esto es efectivo";
    }
}
