import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Esta es una subclase de la clase DocTributario.
 */
public class Factura extends DocTributario {

	/**
	 * Constructor por defecto.
	 */
	public Factura() {
		fecha = new Date();
		numero = "00000000";
		rut = "00.000.000-0";
	}

	/**
	 * Constructor para fecha actual.
	 * 
	 * @param numero El numero de documento.
	 * @param rut    El rut del documento.
	 */
	public Factura(String numero, String rut) {
		fecha = new Date();
		this.numero = numero;
		this.rut = rut;
	}

	/**
	 * Constructor para fecha espesifica.
	 * 
	 * @param numero 	  El numero de documento.
	 * @param rut   	  El rut del documento.
	 * @param tiempoAtras La diferencia de tiempo entre la fecha actual y la fecha que deseo en milisegundos.
	 */
	@Deprecated
	public Factura(String numero, String rut, long tiempoAtras) {
		fecha = new Date(tiempoAtras);
		this.numero = numero;
		this.rut = rut;
	}

	/**
	 * Override del método toString().
	 * 
	 * @return Información sobre la factura.
	 */
	@Override
	public String toString() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return "La factura " + numero + " con el rut" + rut + " fue generado en la fecha: " + formato.format(fecha) + ".";
	}
}