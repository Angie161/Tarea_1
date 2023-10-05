import java.io.BufferedWriter;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;

/**
 * Clase principal con la que se realizarán pruebas de las otras clases del proyecto, para así evaluar su funcionalidad.
 *
 * @author Angie Ramírez
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


        //Artículos (4)
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
        System.out.println("[[[Precio sin IVA: CLP " +ComidaSalada.calcPrecioSinIVA());
        System.out.println("[[[IVA: CLP "+ComidaSalada.calcIVA());
        System.out.println("[[[Precio total: CLP "+ComidaSalada.calcPrecio()+"\n");

        ComidaSalada.agregarArticulo(Completo);
        ComidaSalada.agregarArticulo(PapasXL);
        ComidaSalada.agregarArticulo(Jugo);
        System.out.println("Después de agregar los productos a consumir");
        System.out.println("[[[Detalle de la Comida Salada:");
        System.out.println("[[["+ComidaSalada.toString());
        System.out.println("[[[Peso total: "+ComidaSalada.calcPeso()+"kg");
        System.out.println("[[[Precio sin IVA: CLP " +ComidaSalada.calcPrecioSinIVA());
        System.out.println("[[[IVA: CLP "+ComidaSalada.calcIVA());
        System.out.println("[[[Precio total: CLP "+ComidaSalada.calcPrecio()+"\n");

        DetalleOrden ComidaDulce = new DetalleOrden();
        ComidaDulce.agregarArticulo(Pastel);
        System.out.println("[[[Detalle de la Comida Dulce:");
        System.out.println("[[["+ComidaDulce.toString());
        System.out.println("[[[Peso total: "+ComidaDulce.calcPeso()+"kg");
        System.out.println("[[[Precio sin IVA: CLP " +ComidaDulce.calcPrecioSinIVA());
        System.out.println("[[[IVA: CLP "+ComidaDulce.calcIVA());
        System.out.println("[[[Precio total: CLP "+ComidaDulce.calcPrecio()+"\n");


        //Orden 1.
        OrdenCompra OrdenWalter = new OrdenCompra();
        OrdenWalter.addDetalleOrden(ComidaSalada);
        OrdenWalter.addDetalleOrden(ComidaDulce);

        System.out.println("{{{Orden de Compra de comida de Walter: (Incluye Detalles de Comida dulce y salada)");
        System.out.println("{{{"+OrdenWalter.toString());
        System.out.println("{{{Peso total: "+OrdenWalter.calcPeso()+"kg");
        System.out.println("{{{Precio sin IVA: CLP " +OrdenWalter.calcPrecioSinIVA());
        System.out.println("{{{IVA: CLP "+OrdenWalter.calcIVA());
        System.out.println("{{{Precio total: CLP "+OrdenWalter.calcPrecio()+"\n");


        //Pagos (1 y 2, ambos con efectivo)
        Pago[] PagosAEfectuar = new Pago[1];
        Efectivo cincomil = new Efectivo(5000);
        PagosAEfectuar[0]=cincomil;
        System.out.println("*Walter efectúa un pago de 5000 pesos, elije boleta*");
        OrdenWalter.pagar(Walter,PagosAEfectuar,"boleta",direccion1);
        System.out.println("Su vuelto es CLP "+cincomil.calcDevolucion(OrdenWalter)+".");
        System.out.println("Estado: "+OrdenWalter.toString());
        System.out.println("Dinero por pagar: CLP "+OrdenWalter.calcMontoFaltante()+"\n");

        Pago[] PagosAEfectuar2 = new Pago[1];
        Efectivo sietemil = new Efectivo(7000);
        PagosAEfectuar2[0]=sietemil;
        System.out.println("*Walter efectúa un pago de 7000 pesos, elije boleta*");
        OrdenWalter.pagar(Walter,PagosAEfectuar2,"boleta",direccion1);
        System.out.println("Dinero por pagar: CLP "+OrdenWalter.calcMontoFaltante()+"\n");

        //-----------------------------------------Segunda Prueba General----------------------------------------
        System.out.println("----------------------------------------Segundo Cliente-----------------------------------------");
        Direccion direccion2 = new Direccion("Santiago");
        Cliente Angie = new Cliente("Angie Ramírez","25.911.115-2", direccion2);
        System.out.println(Angie.toString()+"\n");

        //Artículos (3)
        Articulo Sushi = new Articulo(0.5f,"Sushi tempura","30 rollos de Sushi tempura con mix de toppings",10000);
        Articulo Bebida = new Articulo(0.2f,"Cocacola","Bebida artificial", 600);
        Articulo PieDeLimon = new Articulo(0.5f, "Pie de Limón","Pie de limón casero con merengue", 1500);

        //Detalle de Orden
        DetalleOrden ComidaPrincipal = new DetalleOrden();

        ComidaPrincipal.agregarArticulo(Sushi);
        ComidaPrincipal.agregarArticulo(Bebida);
        System.out.println("[[[Detalle del MENÚ SELECCIONADO:");
        System.out.println("[[["+ComidaPrincipal.toString());
        System.out.println("[[[Peso total: "+ComidaPrincipal.calcPeso()+"kg");
        System.out.println("[[[Precio sin IVA: CLP " +ComidaPrincipal.calcPrecioSinIVA());
        System.out.println("[[[IVA: CLP "+ComidaPrincipal.calcIVA());
        System.out.println("[[[Precio total: CLP "+ComidaPrincipal.calcPrecio()+"\n");

        //Orden 2
        OrdenCompra PrimOrdenAngie = new OrdenCompra();
        PrimOrdenAngie.addDetalleOrden(ComidaPrincipal);

        System.out.println("{{{Orden de Compra de MENÚ SELECCIONADO:");
        System.out.println("{{{"+PrimOrdenAngie.toString()+"\n");

        //Pago 3 (Tranferencia)
        Pago[] Transferencia = new Pago[1];
        Transferencia transf = new Transferencia(12614.001f,"Banco Estado","1111111111");
        Transferencia[0]=transf;
        System.out.println("*Angie efectúa una transferencia con la cantidad exacta, elije factura*");
        System.out.println(transf.toString());
        PrimOrdenAngie.pagar(Angie,Transferencia,"factura",direccion2);

        System.out.println("\n*Angie antes de irse del local se da cuenta de que quiere un postre y vuelve para comprar uno*");
        //Detalle de Orden

        DetalleOrden Comidaextra = new DetalleOrden();

        Comidaextra.agregarArticulo(PieDeLimon);
        System.out.println("\n[[[Detalle del MENÚ POSTRE:");
        System.out.println("[[["+Comidaextra.toString());
        System.out.println("[[[Peso total: "+Comidaextra.calcPeso()+"kg");
        System.out.println("[[[Precio sin IVA: CLP " +Comidaextra.calcPrecioSinIVA());
        System.out.println("[[[IVA: CLP "+Comidaextra.calcIVA());
        System.out.println("[[[Precio total: CLP "+Comidaextra.calcPrecio()+"\n");

        //Orden 3
        OrdenCompra SegOrdenAngie = new OrdenCompra();
        SegOrdenAngie.addDetalleOrden(Comidaextra);

        System.out.println("{{{Orden de Compra de MENÚ POSTRE:");
        System.out.println("{{{"+SegOrdenAngie.toString()+"\n");

        //Pago 4 (Tarjeta)
        Pago[] Tarjeta = new Pago[1];
        Tarjeta Deb = new Tarjeta(1785.0001f,"Débito","000000001");
        Tarjeta[0]=Deb;
        System.out.println("*Angie efectúa un pago con tarjeta con la cantidad exacta, elije boleta*");
        System.out.println(Deb.toString());
        SegOrdenAngie.pagar(Angie,Tarjeta,"boleta",direccion2);
    }
}
