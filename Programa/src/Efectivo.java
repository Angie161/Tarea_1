class Efectivo extends Pago {
    public Efectivo(float monto, OrdenCompra Boleta){
        super(monto,Boleta);
    }

    public float calDevolucion(){
        if(Boleta.calcPrecio()<GetMonto()){
            return Boleta.calcPrecio()-GetMonto();
        }
        else{
            return 0;
        }
    }

    @Override
    public String toString(){
        return "Esto es efectivo";
    }
}
