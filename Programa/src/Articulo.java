/**
 * Esta clase almacenará y mostrará la información de cada artículo pedido por el cliente,
 * lo que permitirá posteriormente el cálculo del peso y los diferentes precios a pagar en la clase DetalleOrden.
 *
 * @author Angie Ramírez
 */
public class Articulo {

    /** Características de la clase Artículo*/
    private float peso;
    private String nombre;
    private String descripcion;
    private float precio;

    /**
     * Constructor de la clase Artículo.
     * @param peso float con el peso del artículo en kilogramos.
     * @param nombre String que contiene el nombre del artículo.
     * @param descripcion String con la descripción general del producto.
     * @param precio float con el precio del artículo en pesos chilenos.
     */
    public Articulo(float peso, String nombre, String descripcion, float precio){
    this.peso=peso;
    this.nombre=nombre;
    this.descripcion=descripcion;
    this.precio=precio;
    }

    /**
     * Override del método toString. Devuelve la información almacenada del producto.
     * @return Una cadena de texto con los datos del producto.
     */
    @Override
    public String toString(){
        return "Nombre: "+nombre+", descripción: "+descripcion+", peso del producto: "+String.valueOf(peso)+"kg, precio: "+String.valueOf(precio)+" pesos chilenos.";
    }

    /**
     * Getter de la variable peso.
     * @return float con el valor de peso.
     */
    public float getPeso(){
        return peso;
    }

    /**
     * Getter de la variable nombre.
     * @return String con el nombre del artículo.
     */
    public String getNombreArt(){
        return nombre;
    }

    /**
     * Getter de los datos almacenados en la variable descripción.
     * @return String con la descripción del producto.
     */
    public String getDescripcion(){
        return descripcion;
    }

    /**
     * Getter de los datos almacenados en la variable precio.
     * @return float con el precio del producto.
     */
    public float getPrecio(){
        return precio;
    }

}
