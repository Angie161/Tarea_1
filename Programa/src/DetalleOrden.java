import java.util.ArrayList;

/**
 * Esta clase simula el detalle de orden de la Orden de compra, la cual nos permitirá conocer los detalles de los artículos del cliente.
 * Permite calcular el peso y precio de cada uno de estos para luego ser almacenados en OrdenCompra.
 */

public class DetalleOrden {

    /** Entero que almacena la cantidad de artículos que incluye el detalle de orden. */
    private int cantidad;
    /** Arreglo de Artículos en el que guardaremos el registro de todos los productos a comprar*/
    private ArrayList<Articulo> detalle;

    /**
     * Constructor por defecto, crea un arreglo de artículos e inicializa la cantidad de estos en 0, pues se está creando el Detalle de Orden.
     */
    public DetalleOrden(){
        cantidad=0;
        detalle=new ArrayList<Articulo>();
    }

    /** Adiciona productos al arreglo de artículos, aumentando la cantidad de estos en 1.
     * @param articulo Producto a agregar
     */
    public void AgregarArticulo(Articulo articulo){
        cantidad++;
        detalle.add(articulo);
    }

    /**
     * Calcula el Precio total de la compra, incluyendo el IVA. Recurre al método de cálculo del precio sin IVA.
     * @return float con el precio total a pagar por todos los artículos en detalle de orden.
     */
    public float calcPrecio(){
        return calcPrecioSinIVA()*1.19f;
    }

    /**
     * Calcula la suma de los precios de todos los artículos a comprar.
     * @return float con el Precio total sin incluir el IVA.
     */
    public float calcPrecioSinIVA(){
        float PrecioSinIVA=0;
        for (int i=0; i<detalle.size();i++){
            PrecioSinIVA+= detalle.get(i).getPrecio();
        }
        return PrecioSinIVA;
    }

    /**
     * Calcula únicamente el IVA asociado al precio total de la compra.
     * @return float que almacena el IVA correspondiente, que luego será expresado en pesos chilenos.
     */
    public float calcIVA(){
        return calcPrecioSinIVA()*0.19f;
    }

    /**
     * Caclula el peso total de los productos del cliente en este Detalle de Orden.
     * @return float con el peso correspondiente, que será expresado en kilogramos.
     */
    public float calcPeso(){
        float PesoT=0;
        for(int i=0; i<detalle.size();i++){
            PesoT+=detalle.get(i).getPeso();
        }
        return PesoT;
    }

    /**
     * Getter de la cantidad de productos almacenados.
     * @return int con el valor de la cantidad de artículos.
     */
    public int getCantidad(){
        return cantidad;
    }

    /**
     * Override del método toString. Entrega la información en detalle de los artículos solicitados
     * @return cadena de texto que incluye la cantidad de productos y la lista con el nombre de los artículos solicitados.
     */
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

        return "Cantidad de productos: "+String.valueOf(cantidad)+cadena;
    }
}
