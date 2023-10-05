import javax.swing.*;
import java.awt.*;  
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuCompra {
	private static ImageIcon icono;
	private JFrame frame;
	private JPanel bg;
	private JPanel ingreso;
	private Font fuentePersonalizada;
	private static int largo = 800;
	private static int ancho = 500;
	private Color[] color;
	private Cliente cliente;
	private JLabel compra;
	private JLabel precio;
	private JLabel contenido;
	private JLabel bebida;
	private JLabel hamburguesa;
	private JLabel papitas;
	private JLabel completo2;
	private JLabel papitas2;
	private JLabel completo3;
	private JLabel hamburguesa3;
	private JLabel papitas3;
	private JLabel aux;
	private JLabel auxDes;
	private OrdenCompra ordenCompra_1;
	private OrdenCompra ordenCompra_2;
	private OrdenCompra ordenCompra_3;
	private DetalleOrden bebidaDO;
	private DetalleOrden hamburguesaDO;
	private DetalleOrden completoDO;
	private DetalleOrden papitasDO;
	private DetalleOrden hamburguesaDO_2;
	private DetalleOrden completoDO_2;
	private DetalleOrden papitasDO_2;
	private DetalleOrden hamburguesaDO_3;
	private DetalleOrden completoDO_3;
	private DetalleOrden papitasDO_3;
	private Articulo bebidaA;
	private Articulo hamburguesaA;
	private Articulo completoA;
	private Articulo papitasA;
	private JButton pagar;
	private JButton auxB;
	private int pedido = 0;

	public MenuCompra(int x, int y, Color[] color, Cliente cliente, String rutaIcono, String rutaFuente) {

		ingreso = new JPanel();
		bg = new JPanel();
		this.cliente 	 = cliente;
		this.color   	 = color;
		this.frame   	 = new JFrame("En la tienda");
		this.precio  	 = new JLabel();
		this.bebida      = new JLabel();
		this.hamburguesa = new JLabel();
		this.papitas      = new JLabel();
		this.completo2    = new JLabel();
		this.papitas2     = new JLabel();
		this.completo3    = new JLabel();
		this.hamburguesa3 = new JLabel();
		this.papitas3     = new JLabel();
		this.aux     = new JLabel();
		this.auxDes     = new JLabel();
		this.contenido   = new JLabel("Contenido");
		this.compra      = new JLabel("Que deseas comprar");
		pagar = new JButton("Pagar"); 
		auxB = new JButton("?");
		try {
			icono = new ImageIcon(rutaIcono); 
			this.frame.setIconImage(icono.getImage());
        } catch (Exception e) {
        	System.err.println("Error al cargar el ícono: " + e.getMessage());
        }
		try {
        	fuentePersonalizada = Font.createFont(Font.TRUETYPE_FONT, new File(rutaFuente));
        } catch (Exception e) {
        	e.printStackTrace();System.err.println("Error al cargar la fuente: " + e.getMessage());
        }

		//   ▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽
		//   ▽▽▽▽▽▽▽▽▽▽  Prueba de Ariculos, DetalleOrden y OrdenCompra  ▽▽▽▽▽▽▽▽▽▽▽▽
		//   ▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽
		bebidaA      = new Articulo(0.5f, "Cocacola 500ml", "Botella de 500ml de Cocacola", 900);
		hamburguesaA = new Articulo(0.25f, "Hamburguesa plus", "Hamburguesa doble de carne con cebolla y pepinillos", 5000);
		completoA    = new Articulo(0.300f, "Completo italiano", "Completo con palta y tomate, lo clasico", 1700);
		papitasA     = new Articulo(0.200f, "Papitas grandes", "Porcion grande de papas fritas", 2000);

		bebidaDO        = new DetalleOrden();
		hamburguesaDO   = new DetalleOrden();
		papitasDO       = new DetalleOrden();
		completoDO_2    = new DetalleOrden();
		papitasDO_2     = new DetalleOrden();
		completoDO_3    = new DetalleOrden();
		hamburguesaDO_3 = new DetalleOrden();
		papitasDO_3     = new DetalleOrden();

		bebidaDO.AgregarArticulo(bebidaA);

		// Orden 1
		ordenCompra_1 = new OrdenCompra(bebidaDO);
		hamburguesaDO.AgregarArticulo(hamburguesaA);
		hamburguesaDO.AgregarArticulo(hamburguesaA);
		papitasDO.AgregarArticulo(papitasA);
		ordenCompra_1.addDetalleOrden(hamburguesaDO);
		ordenCompra_1.addDetalleOrden(papitasDO);

		// Orden 2
		ordenCompra_2 = new OrdenCompra(bebidaDO);
		completoDO_2.AgregarArticulo(completoA);
		completoDO_2.AgregarArticulo(completoA);
		papitasDO_2.AgregarArticulo(papitasA);
		ordenCompra_2.addDetalleOrden(completoDO_2);
		ordenCompra_2.addDetalleOrden(papitasDO_2);


		// Orden 3
		ordenCompra_3 = new OrdenCompra(bebidaDO);
		hamburguesaDO_3.AgregarArticulo(hamburguesaA);
		completoDO_3.AgregarArticulo(completoA);
		papitasDO_3.AgregarArticulo(papitasA);
		papitasDO_3.AgregarArticulo(papitasA);
		papitasDO_3.AgregarArticulo(papitasA);
		ordenCompra_3.addDetalleOrden(hamburguesaDO_3);
		ordenCompra_3.addDetalleOrden(completoDO_3);
		ordenCompra_3.addDetalleOrden(papitasDO_3);

		// Detalle Orden 1
		bebida.setText("CLP " + String.format("%.2f", bebidaDO.calcPrecio()) + "  " + String.valueOf(bebidaDO.getCantidad()) + " " + bebidaA.getNombreArt());
		hamburguesa.setText("CLP " + String.format("%.2f", hamburguesaDO.calcPrecio()) + "  " + String.valueOf(hamburguesaDO.getCantidad()) + " " + hamburguesaA.getNombreArt());
		papitas.setText("CLP " + String.format("%.2f", papitasDO.calcPrecio()) + "  " + String.valueOf(papitasDO.getCantidad()) + " " + papitasA.getNombreArt());

		// Detalle Orden 2
		completo2.setText("CLP " + String.format("%.2f", completoDO_2.calcPrecio()) + "  " + String.valueOf(completoDO_2.getCantidad()) + " " + completoA.getNombreArt());
		papitas2.setText("CLP " + String.format("%.2f", papitasDO_2.calcPrecio()) + "  " + String.valueOf(papitasDO_2.getCantidad()) + " " + papitasA.getNombreArt());

		// Detalle Orden 3
		completo3.setText("CLP " + String.format("%.2f", completoDO_3.calcPrecio()) + "  " + String.valueOf(completoDO_3.getCantidad()) + " " + completoA.getNombreArt());
		hamburguesa3.setText("CLP " + String.format("%.2f", hamburguesaDO_3.calcPrecio()) + "  " + String.valueOf(hamburguesaDO_3.getCantidad()) + " " + hamburguesaA.getNombreArt());
		papitas3.setText("CLP " + String.format("%.2f", papitasDO_3.calcPrecio()) + "  " + String.valueOf(papitasDO_3.getCantidad()) + " " + papitasA.getNombreArt());

		//   △△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△
		//   △△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△
		//   △△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△


		// Iniciando mi ventana
		this.frame.setBounds(x, y, largo, ancho);
        this.frame.setResizable(false);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Iniciando panel izquierdo
        this.bg.setBounds(0, 0, largo*2/7, ancho);
        this.bg.setBackground(this.color[3]);
        this.bg.setLayout(null); 

        // Iniciando panel derecho
        this.ingreso.setBounds(largo*2/7, 0, largo*2/7, ancho);
        this.ingreso.setBackground(this.color[0]);
        this.ingreso.setLayout(null); 

        this.pagar.setBounds(42,350,140,50);
        this.pagar.setFont(fuentePersonalizada.deriveFont(Font.PLAIN, 35));
        this.pagar.setForeground(this.color[3]);
        this.pagar.setBorderPainted(false);
        this.pagar.setBackground(this.color[0]);
        this.pagar.setFocusPainted(false);
        this.pagar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Este método se llama cuando se hace clic en el botón
                pagar.setFont(fuentePersonalizada.deriveFont(Font.PLAIN, 35));
                pagar.setBounds(42,350,140,50);
                if(pedido != 0) {
                	OrdenCompra[] oc = {ordenCompra_1, ordenCompra_2, ordenCompra_3};
                	frame.dispose();
                	MenuPago mp = new MenuPago(frame.getLocation().x, frame.getLocation().y, color, cliente, oc[pedido - 1], rutaIcono, rutaFuente);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            	// Este metodo se llama cuando el mouse esta sobre el boton
				pagar.setFont(fuentePersonalizada.deriveFont(Font.BOLD, 35));
				pagar.setBounds(41,349,142,52);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Este método se llama cuando el mouse sale del botón
                pagar.setFont(fuentePersonalizada.deriveFont(Font.PLAIN, 35));
                pagar.setBounds(42,350,140,50);
            }
        });

        this.auxB.setBounds(700,350,50,50);
        this.auxB.setFont(fuentePersonalizada.deriveFont(Font.PLAIN, 25));
        this.auxB.setForeground(this.color[0]);
        this.auxB.setBorderPainted(false);
        this.auxB.setBackground(this.color[3]);
        this.auxB.setFocusPainted(false);
        this.auxB.addMouseListener(new MouseListener() {
        	int x = 7;
            @Override
            public void mouseClicked(MouseEvent e) {
                // Este método se llama cuando se hace clic en el botón
                auxB.setFont(fuentePersonalizada.deriveFont(Font.PLAIN, 25));
                auxB.setBounds(700,350,50,50);
                if(pedido == 0) {
                	x = 7;
                	Timer timer = new Timer(2, new ActionListener() {
						int x = 0;
			            @Override
			            public void actionPerformed(ActionEvent e) {
			            	x++;
			            	auxB.setBackground(new Color(233,235-x*2,237-x*2));
			                if (x > 32) {
			                	auxB.setBackground(color[3]);
			                    ((Timer) e.getSource()).stop(); 
			                }
			            }
			        });
			        timer.start();
			        timer = null;
                	aux.setText("");
                	auxDes.setText("");
                } else if(x%5 == 0 && pedido == 1) {
                	x = 7;
                	aux.setText(papitasA.getNombreArt() + ", peso: " + papitasA.getPeso()*1000 + " gr.");
                	auxDes.setText(papitasA.getDescripción());
                } else if(x%6 == 0 && pedido == 1) {
                	aux.setText(hamburguesaA.getNombreArt() + ", peso: " + hamburguesaA.getPeso()*1000 + " gr.");
                	auxDes.setText(hamburguesaA.getDescripción());
                	x--;
                } else if(x%1 == 0 && pedido == 1) {
                	aux.setText(bebidaA.getNombreArt() + ", peso: " + bebidaA.getPeso()*1000 + " gr.");
                	auxDes.setText(bebidaA.getDescripción());
                	x--;           
                } else if(x%5 == 0 && pedido == 2) {
                	x = 7;
                	aux.setText(papitasA.getNombreArt() + ", peso: " + papitasA.getPeso()*1000 + " gr.");
                	auxDes.setText(papitasA.getDescripción());
                } else if(x%6 == 0 && pedido == 2) {
                	aux.setText(completoA.getNombreArt() + ", peso: " + completoA.getPeso()*1000 + " gr.");
                	auxDes.setText(completoA.getDescripción());
                	x--;
                } else if(x%1 == 0 && pedido == 2) {
                	aux.setText(bebidaA.getNombreArt() + ", peso: " + bebidaA.getPeso()*1000 + " gr.");
                	auxDes.setText(bebidaA.getDescripción());
                	x--;           
                } else if(x%4 == 0 && pedido == 3) {
                	x = 7;
                	aux.setText(papitasA.getNombreArt() + ", peso: " + papitasA.getPeso()*1000 + " gr.");
                	auxDes.setText(papitasA.getDescripción());
                } else if(x%5 == 0 && pedido == 3) {
                	aux.setText(completoA.getNombreArt() + ", peso: " + completoA.getPeso()*1000 + " gr.");
                	auxDes.setText(completoA.getDescripción());
                	x--;
                } else if(x%6 == 0 && pedido == 3) {
                	aux.setText(hamburguesaA.getNombreArt() + ", peso: " + hamburguesaA.getPeso()*1000 + " gr.");
                	auxDes.setText(hamburguesaA.getDescripción());
                	x--;
                } else if(x%1 == 0 && pedido == 3) {
                	aux.setText(bebidaA.getNombreArt() + ", peso: " + bebidaA.getPeso()*1000 + " gr.");
                	auxDes.setText(bebidaA.getDescripción());
                	x--;           
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            	// Este metodo se llama cuando el mouse esta sobre el boton
				auxB.setFont(fuentePersonalizada.deriveFont(Font.BOLD, 25));
				auxB.setBounds(699,349,52,52);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Este método se llama cuando el mouse sale del botón
                auxB.setFont(fuentePersonalizada.deriveFont(Font.PLAIN, 25));
                auxB.setBounds(700,350,50,50);
            }
        });

        labelSetUp(compra,25,50,200,30,0,20,true);
        labelSetUp(precio,45,200,200,35,0,25,true);
        labelSetUp(contenido,270,40,200,40,3,30,true);
        labelSetUp(bebida,270,130,400,40,1,18,false);
        labelSetUp(hamburguesa,270,180,400,40,1,18,false);
        labelSetUp(papitas,270,230,400,40,1,18,false);
        labelSetUp(completo2,270,180,400,40,1,18,false);
        labelSetUp(papitas2,270,230,400,40,1,18,false);
        labelSetUp(completo3,270,180,400,40,1,18,false);
        labelSetUp(hamburguesa3,270,230,400,40,1,18,false);
        labelSetUp(papitas3,270,280,400,40,1,18,false);
        labelSetUp(aux,270,340,400,40,2,21,false);
        labelSetUp(auxDes,270,370,400,40,2,18,false);
        precio.setText("CLP 0000,00");

        String[] opciones = {"Nada","Combo hamburguesa", "Combo completo", "Combo mixto"};
            JComboBox<String> comboBox = new JComboBox<>(opciones);

            // Agregar un ActionListener para manejar eventos de selección
            comboBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String seleccion = (String) comboBox.getSelectedItem();
                    switch(seleccion) {
                    case "Nada" : 
                    	aux.setText("");
                    	auxDes.setText("");
                    	pedido = 0;
                    	ingreso.removeAll();
				        ingreso.add(contenido);	
				        ingreso.add(auxB);
                    	precio.setText("CLP 00000,00");
                    	ingreso.repaint();
                    	bg.repaint();
                    	break;
                    case "Combo hamburguesa" : 
                    	pedido = 1;
                    	ingreso.removeAll();
				        ingreso.add(contenido);	
				        ingreso.add(auxB);
				        ingreso.add(aux);
				        ingreso.add(auxDes);
                    	ingreso.add(bebida);
                    	ingreso.add(hamburguesa);
                    	ingreso.add(papitas);
                    	precio.setText("CLP " + String.format("%.2f", ordenCompra_1.calcPrecio()));
                    	ingreso.repaint();
                    	bg.repaint();
                    	break;
                    case "Combo completo" : 
                    	pedido = 2;
                    	ingreso.removeAll();
				        ingreso.add(contenido);	
				        ingreso.add(auxB);
				        ingreso.add(aux);
				        ingreso.add(auxDes);
				        ingreso.add(bebida);
                    	ingreso.add(completo2);
                    	ingreso.add(papitas2);
                    	precio.setText("CLP " + String.format("%.2f", ordenCompra_2.calcPrecio()));
                    	ingreso.repaint();
                    	bg.repaint();
                    	break;
                    case "Combo mixto" : 
                    	pedido = 3;
                    	ingreso.removeAll();	
				        ingreso.add(contenido);	
				        ingreso.add(bebida);
				        ingreso.add(aux);
				        ingreso.add(auxDes);
                    	ingreso.add(hamburguesa3);
                    	ingreso.add(completo3);
                    	ingreso.add(papitas3);
				        ingreso.add(auxB);
                    	precio.setText("CLP " + String.format("%.2f", ordenCompra_3.calcPrecio()));
                    	ingreso.repaint();
                    	bg.repaint();
                    	break;
                    }
                }
        });
        comboBox.setBounds(25,90,178,30);



        //Agrego todas las cosas a las respectivas cosas
        this.bg.add(precio);
        this.bg.add(comboBox);
        this.bg.add(compra);
        this.bg.add(pagar);
        this.ingreso.add(contenido);	
        this.ingreso.add(auxB);	
		this.frame.add(this.bg);
        this.frame.add(this.ingreso);
        this.frame.setVisible(true);
	}

	// Metodo para iniciar algunas etiqutas
	private void labelSetUp(JLabel setUpLabel, int x, int y, int largo, int ancho, int indiceColor, int tamLetra, boolean bold) {
		setUpLabel.setBounds(x,y,largo,ancho);
        setUpLabel.setForeground(color[indiceColor]);
        if(bold) {
        	setUpLabel.setFont(fuentePersonalizada.deriveFont(Font.BOLD, tamLetra));
        } else {
        	setUpLabel.setFont(fuentePersonalizada.deriveFont(Font.PLAIN, tamLetra));
        }
	}
}