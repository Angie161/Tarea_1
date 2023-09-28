public class Transferencia extends Pago {
    private String banco;
    private String numCuenta;

    public Transferencia(float monto, String banco,String numCuenta){
        super(monto);
        this.banco = banco;
        this.numCuenta = numCuenta;
    }

    @Override
    public String toString(){
        return "Transferencia desde el banco: "+banco+", Numero de Cuenta: "+numCuenta;
    }
}
