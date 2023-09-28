public class Tarjeta extends Pago {
    String tipo;
    String numTransacción;
    public Tarjeta(float monto,OrdenCompra Boleta, String tipo, String numTransacción){
        super(monto, Boleta);
        this.tipo=tipo;
        this.numTransacción=numTransacción;
    }

    @Override
    public String toString(){
        return "Tipo de Tarjeta: "+tipo+", numero de Transacción: "+numTransacción;
    }
}


