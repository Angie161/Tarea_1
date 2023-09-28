import java.text.SimpleDateFormat;
import java.util.Date;

public class Pago {
    private float monto;
    private Date fecha;

    public Pago(float monto, OrdenCompra boleta){
        fecha=new Date();
        this.monto=monto;
    }

    @Override
    public String toString(){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return "Monto ingresado para el pago: "+monto+", fecha: "+formato.format(fecha);
    }

    public float GetMonto(){
        return monto;
    }
}





// Cuando se cree un pago se le asociará una orden de compra
//a través de un método llamado "pagar(Pago Nombredelpago)" en
//donde se modificará el estado del "estado";


