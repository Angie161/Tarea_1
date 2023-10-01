/**
 * Esta clase almacenará y mostrará la información de cada artículo pedido por el cliente.
 */
public class Articulo {
    /** Variable float que almacenará el peso del artículo. */
    private float peso;
    /** String con el nombre del producto. */
    private String nombre;
    /** String con la descripción general del producto. */
    private String descripción;
    /** Float que contendrá el valor del artículo en pesos chilenos. */
    private float precio;

    /**
     * Constructor de la clase Artículo.
     */
    public Articulo(float peso, String nombre, String descripción, float precio){
    this.peso=peso;
    this.nombre=nombre;
    this.descripción=descripción;
    this.precio=precio;
    }

    /**
     * Override del método toString. Devuelve la información almacenada del producto.
     * @return cadena de String con los datos del producto.
     */
    @Override
    public String toString(){
        return "Nombre: "+nombre+", descripción: "+descripción+", peso del producto: "+String.valueOf(peso)+", precio: "+String.valueOf(precio)+" pesos chilenos.";
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
    public String getDescripción(){
        return descripción;
    }

}
