import java.util.Date;
import java.util.ArrayList;


/**
 * Esta clase es la encargada de gestionar la compra de articulos.
 */
public class OrdenCompra {

	/**
	 * Caracteristicas de OrdenCompra (Variables)	 
	 */
	private Date fecha;
	private String estado;
	private ArrayList<DetalleOrden> detallesOrdenes;

	/**
	 * Constructor por defecto 
	 */
	public OrdenCompra() {
		fecha = new Date();
		estado = "En espera";
		detallesOrdenes = new ArrayList<DetalleOrden>();
	}

	/**
	 * Constructor personalizado.
	 * 
	 * @param detalleOrden Un objeto de tipo "DetalleOrden" que repesenta cosas que se quieren comprar.
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
	 * @param detalleOrden Un objeto de tipo "DetalleOrden" que repesenta cosas que se quieren comprar.
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
	 * Método para pagar la orden.
	 * 
	 * @param cliente       La persona que esta comprando los articulos.
	 * @param pago          Un arreglo de pagos para poder comprar la orden.
	 * @param boletaFactura El tipo de documetno tributario que se desea, puede ser solo "boleta" o "factura".
	 * 
	 * agregar en clacular debolucion que te devuelva el dinero solo si 
	 */
	public DocTributario pagar(Cliente cliente, Pago[] pago, String boletaFactura) {
		if(!estado.equals("Pagado")){
			float monto = 0;
			for(int i = 0; i < pago.length; i++) {
				monto += pago[i].GetMonto();
			}
			if(boletaFactura.equals("boleta") && monto >= this.calcPrecio()){
				if(pago.length == 1) {
					try{
						System.out.println("Su vuelto es CLP " + String.valueOf(((Efectivo) pago[0]).calDevolucion(this)) + ".");	
					}catch(NoSuchMethodError e) {;}
				}
				estado = "Pagado";
				System.out.println(this);
				return new Boleta(cliente.getRut(), cliente.getDireccion());
			} else if(boletaFactura.equals("factura") && monto >= this.calcPrecio()) {
				if(pago.length == 1) {
					try{
						System.out.println("Su vuelto es CLP " + String.valueOf(((Efectivo) pago[0]).calDevolucion(this)) + ".");	
					}catch(NoSuchMethodError e) {;}
				}
				estado = "Pagado";
				System.out.println(this);
				return new Factura(cliente.getRut(), cliente.getDireccion());
			} else if(!boletaFactura.equals("factura") && !boletaFactura.equals("boleta") && monto >= this.calcPrecio()) {
				System.out.println("Error al ingresar el tipo de documento tributario, ingrese : \"boleta\" o \"factura\".");
				return null;
			} else if (monto < this.calcPrecio()) {
				System.out.println("Pago inferior al precio de la orden.");
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
	 * @return Información sobre la OrdenCoompra.
	 */
	@Override
	public String toString() {
		return "Esta Orden se encuentra " + estado + ".";
	}
}