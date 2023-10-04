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
		numero = String.valueOf(fecha.getTime());
		rut = "00.000.000-0";
		direccion = "------------";

		// Esto tiene el unico objetivo de hacer que dos boletas nunca tengan el mismo numero ya que hace que demore mas el construirla.
		this.toString();
	}

	/**
	 * Constructor personalizado.
	 * 
	 * @param rut El rut del cliente.
	 * @param direccion La dirección del cliente.
	 */
	public Factura(String rut, Direccion direccion) {
		fecha = new Date();
		numero = String.valueOf(fecha.getTime());
		this.rut = rut;
		this.direccion = direccion.getDireccion();

		// Esto tiene el unico objetivo de hacer que dos boletas nunca tengan el mismo numero ya que hace que demore mas el construirla.
		this.toString();
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