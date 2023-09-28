public class Tarjeta extends Pago {
    String tipo;
    String numTransacción;
    public Tarjeta(float monto, String tipo, String numTransacción){
        super(monto);
        this.tipo=tipo;
        this.numTransacción=numTransacción;
    }

    @Override
    public String toString(){
        return "Tipo de Tarjeta: "+tipo+", numero de Transacción: "+numTransacción;
    }
}


