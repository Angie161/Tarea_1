public class Transferencia extends Pago {
    private String banco;
    private String numCuenta;

    public Transferencia(float monto,OrdenCompra Boleta, String banco,String numCuenta){
        super(monto,Boleta);
        this.banco = banco;
        this.numCuenta = numCuenta;
    }

    @Override
    public String toString(){
        return "Transferencia desde el banco: "+banco+", Numero de Cuenta: "+numCuenta;
    }
}
