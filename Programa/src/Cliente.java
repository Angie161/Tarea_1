/**
 * Esta clase es una simulacion de una persona que es cliente.
 */

public class Cliente {

	/**
	 * Caracteristicas de "Cliente" (Variables).
	 */
	private String nombre;
	private String rut;
	private String direccion;

	/**
	 * Constructor por defecto.
	 */
	public Cliente() {
		nombre = "------";
		rut = "00.000.000-0";
		direccion = "-------------";
	}

	/**
	 * Costructor con nombre, rut y dirección espesificos.
	 * 
	 * @param nombre    El texto que representa el nombre del cliente.
	 * @param rut       El texto que representa el rut del cliente.
	 * @param direccion La texto que representa la dirección del cliente.
	 */
	public Cliente(String nombre, String rut, Direccion direccion) {
		this.nombre = nombre;
		this.rut = rut;
		this.direccion = direccion.getDireccion();
	}

	/**
	 * Método getter de "nombre".
	 * 
	 * @return El nombre del cliente.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Método getter de "rut".
	 * 
	 * @return El rut del cliente.
	 */
	public String getRut() {
		return rut;
	}

	/**
	 * Método getter de "dirección".
	 * 
	 * @return La direccion del cliente.
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Override del método toString().
	 * 
	 * @return Las caracteristicas del objeto en un texto personalizado.
	 */
	@Override
	public String toString() {
		return "El rut y dirección de " + nombre + " son " + rut + " y " + direccion + " respectivamente.";
	}
}