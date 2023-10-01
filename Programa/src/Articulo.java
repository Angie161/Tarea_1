public class Articulo {
    private float peso;
    private String nombre;
    private String descripción;
    private float precio;

    public Articulo(float peso, String nombre, String descripción, float precio){
    this.peso=peso;
    this.nombre=nombre;
    this.descripción=descripción;
    this.precio=precio;
    }

    @Override
    public String toString(){
        return "Nombre: "+nombre+", descripción: "+descripción+", peso del producto: "+String.valueOf(peso)+", precio: "+String.valueOf(precio)+" pesos chilenos.";
    }

    public float getPeso(){
        return peso;
    }

    public String getNombreArt(){
        return nombre;
    }

    public String getDescripción(){
        return descripción;
    }

}
