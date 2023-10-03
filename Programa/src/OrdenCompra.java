import java.util.Date;
import java.util.ArrayList;


/**
 * Esta clase es la encargada de gestionar la compra de artículos.
 */
public class OrdenCompra {

	/**
	 * Características de OrdenCompra (Variables)
	 */
	private Date fecha;
	private String estado;
	private ArrayList<DetalleOrden> detallesOrdenes;
	private float montoPagado;

	/**
	 * Constructor por defecto 
	 */
	public OrdenCompra() {
		fecha = new Date();
		estado = "en espera";
		detallesOrdenes = new ArrayList<DetalleOrden>();
		montoPagado = 0;
	}

	/**
	 * Constructor personalizado.
	 * 
	 * @param detalleOrden Un objeto de tipo "DetalleOrden" que representa cosas que se quieren comprar.
	 */
	public OrdenCompra(DetalleOrden detalleOrden) {
		fecha = new Date();
		estado = "en espera";
		detallesOrdenes = new ArrayList<DetalleOrden>();
		detallesOrdenes.add(detalleOrden);
	}

	/**
	 * Método getter de "estado".
	 * 
	 * @return El estado de la orden.
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * Método para añadir una orden de compra (DetalleOrden).
	 * 
	 * @param detalleOrden Un objeto de tipo "DetalleOrden" que representa cosas que se quieren comprar.
	 */
	public void addDetalleOrden(DetalleOrden detalleOrden) {
		detallesOrdenes.add(detalleOrden);
	}

	/**
	 * Método para calcular el precio sin IVA.
	 * 
	 * @return El precio de toda la orden sin IVA.
	 */
	public float calcPrecioSinIVA() {
		float precioSinIVA = 0;
		for(int i = 0; i < detallesOrdenes.size(); i++) {
			precioSinIVA += detallesOrdenes.get(i).calcPrecioSinIVA();
		}
		return precioSinIVA;
	}

	/**
	 * Método para calcular el IVA.
	 * 
	 * @return El IVA de toda la orden.
	 */
	public float calcIVA() {
		return calcPrecioSinIVA()*0.19f;
	}

	/**
	 * Método para calcular el precio de la orden.
	 * 
	 * @return El precio con IVA de la orden.
	 */
	public float calcPrecio() {
		return calcPrecioSinIVA()*1.19f;
	}

	/**
	 * Método para calcular el peso de la orden.
	 * 
	 * @return El peso de toda la orden.
	 */
	public float calcPeso() {
		float peso = 0;
		for(int i = 0; i < detallesOrdenes.size(); i++) {
			peso += detallesOrdenes.get(i).calcPeso();
		}
		return peso;
	}

	/**
	 * Método para calcular el dinero que falta por pagar de la orden.
	 * 
	 * @return El precio faltante por pagar.
	 */
	public float calcMontoFaltante() {
		return calcPrecio() - montoPagado;
	}

	/**
	 * Método para pagar la orden.
	 * 
	 * @param cliente       La persona que está comprando los artículos.
	 * @param pago          Un arreglo de pagos para poder comprar la orden.
	 * @param boletaFactura El tipo de documento tributario que se desea, puede ser solo "boleta" o "factura".
	 * @param direccion     La dirección que se asociara con el documento tributario.
	 * 
	 * Agregar en calcular devolución que te devuelva el dinero solo si
	 */
	public DocTributario pagar(Cliente cliente, Pago[] pago, String boletaFactura, Direccion direccion) {
		if(!estado.equals("pagada")){
			float monto = 0;
			for(int i = 0; i < pago.length; i++) {
				monto += pago[i].GetMonto();
			}
			if(boletaFactura.equals("boleta") && monto >= this.calcMontoFaltante()){
				if(pago.length == 1) {
					try{
						System.out.println("Su vuelto es CLP " + String.valueOf(((Efectivo) pago[0]).calcDevolucion(this)) + ".");	
					}catch(Exception e) {;}
				}
				estado = "pagada";
				System.out.println(this);
				return new Boleta(cliente.getRut(), direccion);
			} else if(boletaFactura.equals("factura") && monto >= this.calcMontoFaltante()) {
				if(pago.length == 1) {
					try{
						System.out.println("Su vuelto es CLP " + String.valueOf(((Efectivo) pago[0]).calcDevolucion(this)) + ".");	
					}catch(Exception e) {;}
				}
				estado = "pagada";
				System.out.println(this);
				return new Factura(cliente.getRut(), direccion);
			} else if(!boletaFactura.equals("factura") && !boletaFactura.equals("boleta") && monto >= this.calcMontoFaltante()) {
				System.out.println("Error al ingresar el tipo de documento tributario, ingrese : \"boleta\" o \"factura\".");
				return null;
			} else if (monto < this.calcMontoFaltante()) {
				System.out.println("Pago inferior al precio de la orden, ingrese dinero faltante.");
				montoPagado = monto;
				return null;
			} else {
				System.out.println("Error desconocido.");
				return null;
			}
		} else {
			System.out.println("La orden ya esta pagada");
			return null;
		}
	}

	/**
	 * Override del método toString().
	 * 
	 * @return Información sobre la OrdenCompra.
	 */
	@Override
	public String toString() {
		return "Esta Orden se encuentra " + estado + ".";
	}
}