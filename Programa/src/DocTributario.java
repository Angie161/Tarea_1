import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Esta es una clase abstracta que representa un documento tributario 
 * que puede ser boleta o factura, estas dos seran las subclases.
 */
public abstract class DocTributario {

	/**
	 * Información del documento (Variables).
	 */
	protected Date fecha;
	protected String numero;
	protected String rut;

	/**
	 * Método getter de "número".
	 * 
	 * @return El número del documento.
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * Método getter de "rut".
	 * 
	 * @return El rut del documento.
	 */
	public String getRut() {
		return rut;
	}

	/**
	 * Método getter de "fecha".
	 * 
	 * @return La fecha del documento.
	 */
	public Date getFecha() {
		return fecha;
	}
}