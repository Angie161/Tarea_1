class Efectivo extends Pago {
    public Efectivo(float monto){
        super(monto);
    }

    public float calDevolucion(OrdenBoleta ordenboleta){
        if(ordenboleta.calcPrecio()<GetMonto()){
            return ordenboleta.calcPrecio()-GetMonto();
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
