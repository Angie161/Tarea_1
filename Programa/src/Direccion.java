/**
 * Clase que representa una dirección, es decir, un lugar en este planeta.
 */
public class Direccion {

	/**
	 * Variable que guarda la dirección.
	 */
	private String direccion;

	/**
	 * Constructor por defecto
	 */
	public Direccion() {
		direccion = "-------------";
	}

	/**
	 * Constructor con dirección espesificada.
	 * 
	 * @param direccion El texto que representa la dirección.
	 */
	public Direccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Método getter de "dirección".
	 * 
	 * @return El texto asociado a la variable dirección.
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Override del método toString().
	 * 
	 * @return La dirección asociada.
	 */
	@Override
	public String toString() {
		return "El lugar asociado a esta dirección es " + direccion + ".";
	}
}