/**
 * Esta clase es la encargada de  darle  vida a la interfaz gráfica, al
 * ejecutarla (ya que contiene  un  método main), abrirá una ventana en
 * la que se puede interactuar para  comprar cosas. Recomiendo leer los
 * comentarios dentro del main por si hay errores al compilarlo.
 * 
 * Angers_Store hace instancia  de  MenuPrincipal y esta misma a otras
 * más  (MenuCompra  y   MenuPago)   esta  3  clases  no  cuentan  con
 * documentación asi que  ante  cualquier  duda o problema contactar a
 * los desarrolladores que son  aramirez2022@udec.cl (Angie Ramírez) o
 * a wzarate2022@udec.cl  (Walter  Zárate) los cuales podrán brindarle
 * aclaraciones.
 */
public class Angers_Store {
	/**
     * Aquí se crea  la  ventana  con  el  objeto "MenuPrincipal" y hay
     * que pasarle las rutas hacia las carpetas "Imágenes" y "Fuentes".
     * En teoría  no  debería  haber  ningún  error  con lo que ya está
     * colocado, pero  si  lo  llega  a  haber  se recomienda poner las
     * rutas  absolutas  hacia  los  archivos  "Imágenes  y Fuentes" de
     * la siguiente manera:
     * 
     * MenuPrincipal("C:/aquí/la/ruta/absoluta/a/Imágenes", "C:/aquí/la/ruta/absoluta/a/Fuentes");
     * 
     * Si siguen  habiendo  errores  después  de  realizar  el cambio y
     * desea poder  interactuar  con  la  interfaz  gráfica  se sugiere
     * contactar a los desarrolladores ya mencionados.
     */
    public static void main(String[] args) {
        MenuPrincipal mp = new MenuPrincipal("../../Imagenes", "../../Fuentes");
    }
}