/**
 * Clase principal con la que se realizarán pruebas de las otras clases del proyecto, para así evaluar su funcionalidad.
 */
public class Main {
    /**
     * Método principal que inicia las pruebas del proyecto.
     * @param args Argumentos de línea de comandos.
     */
    public static void main(String[] args) {

        //-----------------------------------------Primera Prueba General-----------------------------------------
        //Cliente 1
        System.out.println("-----------------------------------------Primer Cliente-----------------------------------------");
        Direccion direccion1 = new Direccion("Hualpén");
        Cliente Walter = new Cliente("Walter Zárate", "21.999.153-3");
        Walter.setDireccion(direccion1);
        System.out.println("[[["+Walter.toString());

        //Artículos
        Articulo Completo = new Articulo(0.5f, "Completo Italiano", "Completo que incluye palta, tomate y mayonesa", 1200);
        Articulo PapasXL = new Articulo(0.3f, "Papas XL", "Papas fritas extra grandes", 1500);
        Articulo Jugo = new Articulo(0.2f, "Juego 200ml", "Juego en botella sabor platano naranja", 850);
        Articulo Pastel = new Articulo(0.6f, "Choco-Pastel","Pastel de chocolate y fresas con glaseado", 3000);

        //Detalle de Orden
        DetalleOrden ComidaSalada = new DetalleOrden();
        System.out.println("\nAntes de agregar los productos a consumir");
        System.out.println("[[[Detalle de la Comida Salada:");
        System.out.println("[[["+ComidaSalada.toString());
        System.out.println("[[[Peso total: "+ComidaSalada.calcPeso()+"kg");
        System.out.println("[[[Precio sin IVA: " +ComidaSalada.calcPrecioSinIVA());
        System.out.println("[[[IVA: "+ComidaSalada.calcIVA());
        System.out.println("[[[Precio total: "+ComidaSalada.calcPrecio()+"\n");

        ComidaSalada.AgregarArticulo(Completo);
        ComidaSalada.AgregarArticulo(PapasXL);
        ComidaSalada.AgregarArticulo(Jugo);
        System.out.println("Después de agregar los productos a consumir");
        System.out.println("[[[Detalle de la Comida Salada:");
        System.out.println("[[["+ComidaSalada.toString());
        System.out.println("[[[Peso total: "+ComidaSalada.calcPeso()+"kg");
        System.out.println("[[[Precio sin IVA: " +ComidaSalada.calcPrecioSinIVA());
        System.out.println("[[[IVA: "+ComidaSalada.calcIVA());
        System.out.println("[[[Precio total: "+ComidaSalada.calcPrecio()+"\n");

        DetalleOrden ComidaDulce = new DetalleOrden();
        ComidaDulce.AgregarArticulo(Pastel);
        System.out.println("[[[Detalle de la Comida Dulce:");
        System.out.println("[[["+ComidaDulce.toString());
        System.out.println("[[[Peso total: "+ComidaDulce.calcPeso()+"kg");
        System.out.println("[[[Precio sin IVA: " +ComidaDulce.calcPrecioSinIVA());
        System.out.println("[[[IVA: "+ComidaDulce.calcIVA());
        System.out.println("[[[Precio total: "+ComidaDulce.calcPrecio()+"\n");


        //Orden de Compra. Se crea una órden de compra.
        OrdenCompra OrdenWalter = new OrdenCompra();
        OrdenWalter.addDetalleOrden(ComidaSalada);
        OrdenWalter.addDetalleOrden(ComidaDulce);

        System.out.println("[[[Orden de Compra de Walter:");
        System.out.println("[[["+OrdenWalter.toString());
        System.out.println("[[[Peso total: "+OrdenWalter.calcPeso()+"kg");
        System.out.println("[[[Precio sin IVA: " +OrdenWalter.calcPrecioSinIVA());
        System.out.println("[[[IVA: "+OrdenWalter.calcIVA());
        System.out.println("[[[Precio total: "+OrdenWalter.calcPrecio()+"\n");
        //Documento tributario

        Efectivo dinero = new Efectivo(5000);
        System.out.println("Walter efectúa un pago de 5000 pesos");

        //-----------------------------------------Segunda Prueba General----------------------------------------
        System.out.println("----------------------------------------Segundo Cliente-----------------------------------------");
        Direccion direccion2 = new Direccion("Hualpén Chiquito");
        Cliente Angie = new Cliente("Angie Ramírez","25.911.115-2", direccion2);
        System.out.println(Angie.toString());

        //Artículos
        Articulo Sushi = new Articulo(0.5f,"Sushi tempura","30 rollos de Sushi tempura con mix de toppings",10000);
        Articulo Bebida = new Articulo(0.2f,"Cocacola","Bebida artificial", 600);
        Articulo PieDeLimon = new Articulo(0.5f, "Pie de Limón","Pie de limón casero con merengue", 1500);

        //Detalle de Orden
        DetalleOrden ComidaTotal = new DetalleOrden();

        //Orden de Compra
        OrdenCompra Orden1Angie = new OrdenCompra();
        System.out.println("Antes de agregar los productos a consumir:");
        System.out.println(OrdenWalter.toString());

        OrdenCompra Orden2Angie = new OrdenCompra();
    }
}
