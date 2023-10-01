import java.util.ArrayList;

public class DetalleOrden {

    private int cantidad;
    private ArrayList<Articulo> detalle;

    public DetalleOrden(){
        cantidad=0;
        detalle=new ArrayList<Articulo>();
    }

    public void AgregarArticulo(Articulo articulo){
        cantidad++;
        detalle.add(articulo);
    }

    public float calcPrecio(){
        return calcPrecioSinIVA()*1.19f;
    }

    public float calcPrecioSinIVA(){
        float PrecioSinIVA=0;
        for (int i=0; i<detalle.size();i++){
            PrecioSinIVA+= detalle.get(i).getPrecio();
        }
        return PrecioSinIVA;
    }

    public float calcIVA(){
        return calcPrecioSinIVA()*0.19f;
    }

    public float calcPeso(){
        float PesoT=0;
        for(int i=0; i<detalle.size();i++){
            PesoT+=detalle.get(i).getPeso();
        }
        return PesoT;
    }

    public int getCantidad(){
        return cantidad;
    }

    @Override
    public String toString(){
        StringBuilder cadena = new StringBuilder();
        cadena.append(", Articulos solicitados: ");
        for(int i=0; i<detalle.size();i++){
            cadena.append(detalle.get(i).getNombreArt());
            if(i==detalle.size()-1){
                cadena.append(" ");
            }
            else{
                cadena.append(", ");
            }
        }

        return "Cantidad de productos: "+cantidad+cadena;
    }
}
