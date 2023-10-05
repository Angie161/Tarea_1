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

public class MenuPago {
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
	private JLabel error;
	private JPanel linea;
	private JPanel linea_2;
	private JPanel linea_3;
	private JPanel linea_4;
	private OrdenCompra ordenCompra;
	private JTextField textDire;
	private JButton pagar;
	private JButton auxB;
	private int pago = -1;
	private boolean pagando = false;
	private Pago[] pagos = new Pago[1];
	private Direccion direccion;
	private boolean fase = false;
	private String tipoBanco;
	private boolean cerrar = false;
	private boolean auxx = false;

	public MenuPago(int x, int y, Color[] color, Cliente cliente, OrdenCompra ordenCompra, String rutaIcono, String rutaFuente) {
		ingreso = new JPanel();
		bg = new JPanel();
		linea = new JPanel();
		linea_2 = new JPanel();
		linea_3 = new JPanel();
		linea_4 = new JPanel();
		this.cliente 	  = cliente;
		this.ordenCompra  = ordenCompra;
		this.color   	  = color;
		this.frame   	  = new JFrame("Pagando");
		this.precio  	  = new JLabel("CLP 00000,00");
		this.error  	  = new JLabel();
		this.bebida       = new JLabel();
		this.hamburguesa  = new JLabel();
		this.papitas      = new JLabel();
		this.completo2    = new JLabel();
		this.papitas2     = new JLabel();
		this.completo3    = new JLabel();
		this.hamburguesa3 = new JLabel();
		this.papitas3     = new JLabel();
		this.aux          = new JLabel();
		this.auxDes       = new JLabel();
		this.textDire     = new JTextField(30);
		this.contenido    = new JLabel("Pago");
		this.compra       = new JLabel("Ingresa tu dirección"); 
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
			fuentePersonalizada = new Font("Arial", Font.PLAIN, 12);
        }


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

        // JComboBox
        String[] opciones = {"Ninguno", "Efectivo", "Tarjeta", "Transferencia"};
            JComboBox<String> comboBox = new JComboBox<>(opciones);

            // Agregar un ActionListener para manejar eventos de selección
            comboBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String seleccion = (String) comboBox.getSelectedItem();
                    switch(seleccion) {
                    case "Ninguno" : 
                    	pago = 0;
                    	ingreso.removeAll();
				        ingreso.add(contenido);	
				        ingreso.add(auxB);
				        ingreso.add(aux);
				        ingreso.add(auxDes);
                    	hamburguesa.setText("Ninguna forma de pago seleccionada.");
                    	ingreso.add(hamburguesa);
                    	precio.setText("CLP 00000,00");
                    	bg.add(precio);
                    	ingreso.repaint();
                    	bg.repaint();
                    	break;
                    case "Efectivo" : 
                    	pago = 1;
                    	labelSetUp(hamburguesa,270,180,400,40,1,22,false);
                    	ingreso.removeAll();
				        ingreso.removeAll();
				        ingreso.add(contenido);	
				        ingreso.add(auxB);
				        ingreso.add(aux);
				        ingreso.add(auxDes);
                    	hamburguesa.setText("CLP 30000 en efectivo.");
                    	ingreso.add(hamburguesa);
                    	precio.setText("CLP 30000,00");
                    	bg.add(precio);
                    	ingreso.repaint();
                    	bg.repaint();
                    	break;
                    case "Tarjeta" : 
                    	pago = 2;
                    	labelSetUp(hamburguesa,270,180,400,40,1,22,false);
                    	ingreso.removeAll();
				        ingreso.add(contenido);	
				        ingreso.add(auxB);
				        ingreso.add(aux);
				        ingreso.add(auxDes);
				        bebida.setText("Haz seleccionado tarjeta.");
                    	ingreso.add(bebida);
                    	hamburguesa.setText("Debera ingresar el tipo");
                    	ingreso.add(hamburguesa);
                    	papitas.setText("de tarjeta y el numero.");
                    	ingreso.add(papitas);
                    	precio.setText("CLP " + String.format("%.2f", ordenCompra.calcPrecio()));
                    	bg.add(precio);
                    	ingreso.repaint();
                    	bg.repaint();
                    	break;
                    case "Transferencia" : 
                    	pago = 3;
                    	labelSetUp(hamburguesa,270,180,400,40,1,22,false);
                    	ingreso.removeAll();
				        ingreso.add(contenido);	
				        ingreso.add(auxB);
				        ingreso.add(aux);
				        ingreso.add(auxDes);
				        bebida.setText("Haz seleccionado Transferencia.");
				        ingreso.add(bebida);
                    	hamburguesa.setText("Debera ingresar el banco");
                    	ingreso.add(hamburguesa);
                    	papitas.setText("y el número de cuenta.");
                    	ingreso.add(papitas);
                    	precio.setText("CLP " + String.format("%.2f", ordenCompra.calcPrecio()));
                    	bg.add(precio);
                    	ingreso.repaint();
                    	bg.repaint();
                    	break;
                    }
                }
        });
        comboBox.setBounds(25,90,178,30);

        this.pagar.setBounds(42,350,140,50);
        this.pagar.setFont(fuentePersonalizada.deriveFont(Font.PLAIN, 30));
        this.pagar.setForeground(this.color[3]);
        this.pagar.setBorderPainted(false);
        this.pagar.setBackground(this.color[0]);
        this.pagar.setFocusPainted(false);
        this.pagar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	if(cerrar) {
            		frame.dispose();
            		System.exit(0);
                } else if(pago == 1 && !pagando  && !auxx) {
                	pagando = true;
                	textDire = null;
                	bg.removeAll();
                	ingreso.removeAll();
                	pagar.setText("Aceptar");
                	bg.add(pagar);
                	pagos[0] = new Efectivo(30000);
                	pagar();
                } else if(pago == 2 && !pagando  && !auxx) {
                	pagando = true;
                	textDire = null;
                	bg.removeAll();
                	ingreso.removeAll();
                	pagar.setText("Aceptar");
                	compra.setText("Tipo de tarjeta");
					textDire = new JTextField(30);
					textDire.setBounds(25,90,180,30);
				    textDire.setBorder(null);
					textDire.setOpaque(false);
					textDire.setText("Ingrese el tipo");
					textDire.setForeground(color[2]);
					textDire.setFont(fuentePersonalizada.deriveFont(Font.PLAIN, 18));
					textDire.addFocusListener(new FocusListener() {
				            @Override
				            public void focusGained(FocusEvent e) {
				            	try {error.setBounds(900,500,100,100); ingreso.remove(error);} catch(Exception f) {;}
				            	textDire.setForeground(color[0]);
					    		linea.setBackground(color[0]);
					    		linea_2.setBackground(color[0]);
					    		linea_3.setBackground(color[0]);
					    		linea_4.setBackground(color[0]);
				                if (textDire.getText().equals("Ingrese el tipo")) {
				                    textDire.setText("");
				                    textDire.setForeground(color[0]);
				                } 
				              	Timer timer = new Timer(2, new ActionListener() {
									int x = 0;
						            @Override
						            public void actionPerformed(ActionEvent e) {
						            	x++;
						            	if(x < 8 && x >= 0){
						            		linea_2.setBounds(23,121 - (int) (x*4.429),1, (int) (x*4.286));
						            	} else if(x < 16 && x >= 8){
						            		linea_3.setBounds(23,90,(int) ((x - 8)*26.15),1);
						            	} else if(x < 24 && x >= 16){
						            		linea_4.setBounds(206,90,1,(int) ((x - 16)*4.286));
						            	}
						                if (x > 32) {
						                    ((Timer) e.getSource()).stop(); 
						                }
						            }
						        });
						        timer.start();
						        timer = null;
				            }

				            @Override
				            public void focusLost(FocusEvent e) {
				                if (textDire.getText().isEmpty()) {
				                    textDire.setText("Ingrese el tipo");
				                    textDire.setForeground(color[2]);
				                }
				                Timer timer = new Timer(1, new ActionListener() {
									int x = 0;
						            @Override
						            public void actionPerformed(ActionEvent e) {
						            	x++;
						            	if(x < 8 && x >= 0){
						            		linea_2.setBounds(23,90,1, 30 - (int) (x*4.29));
						            	} else if(x < 16 && x >= 8){
						            		linea_3.setBounds(23 + (int) ((x-8)*26.16),90,183 - (int) ((x - 8)*26.16),1);
						            	} else if(x < 24 && x >= 16){
						            		linea_4.setBounds(206,90 + (int) ((x - 16)*4.43),1,30 - (int) ((x - 16)*4.43));
						            	}
						                if (x > 32) {
						                    ((Timer) e.getSource()).stop(); // Detiene la animación cuando llega al final
						                }
						            }
						        });
						        timer.start();
						        timer = null;
				            }
				    });
				    linea.setBounds(23,120,184,1);
					bg.add(textDire);
					bg.add(linea);
					bg.add(linea_4);
					bg.add(linea_2);
					bg.add(linea_3);
                	bg.add(pagar);
                	bg.add(textDire);
                	bg.add(compra);
                	frame.repaint();
                } else if(pago == 3 && !pagando  && !auxx) {
                	pagando = true;
                	textDire = null;
                	bg.removeAll();
                	ingreso.removeAll();
                	pagar.setText("Aceptar");
                	compra.setText("Banco");
					textDire = new JTextField(30);
					textDire.setBounds(25,90,180,30);
				    textDire.setBorder(null);
					textDire.setOpaque(false);
					textDire.setText("Ingrese su banco");
					textDire.setForeground(color[2]);
					textDire.setFont(fuentePersonalizada.deriveFont(Font.PLAIN, 18));
					textDire.addFocusListener(new FocusListener() {
				            @Override
				            public void focusGained(FocusEvent e) {
				            	try {error.setBounds(900,500,100,100); ingreso.remove(error);} catch(Exception f) {;}
				            	textDire.setForeground(color[0]);
					    		linea.setBackground(color[0]);
					    		linea_2.setBackground(color[0]);
					    		linea_3.setBackground(color[0]);
					    		linea_4.setBackground(color[0]);
				                if (textDire.getText().equals("Ingrese su banco")) {
				                    textDire.setText("");
				                    textDire.setForeground(color[0]);
				                } 
				              	Timer timer = new Timer(2, new ActionListener() {
									int x = 0;
						            @Override
						            public void actionPerformed(ActionEvent e) {
						            	x++;
						            	if(x < 8 && x >= 0){
						            		linea_2.setBounds(23,121 - (int) (x*4.429),1, (int) (x*4.286));
						            	} else if(x < 16 && x >= 8){
						            		linea_3.setBounds(23,90,(int) ((x - 8)*26.15),1);
						            	} else if(x < 24 && x >= 16){
						            		linea_4.setBounds(206,90,1,(int) ((x - 16)*4.286));
						            	}
						                if (x > 32) {
						                    ((Timer) e.getSource()).stop(); 
						                }
						            }
						        });
						        timer.start();
						        timer = null;
				            }

				            @Override
				            public void focusLost(FocusEvent e) {
				                if (textDire.getText().isEmpty()) {
				                    textDire.setText("Ingrese su banco");
				                    textDire.setForeground(color[2]);
				                }
				                Timer timer = new Timer(1, new ActionListener() {
									int x = 0;
						            @Override
						            public void actionPerformed(ActionEvent e) {
						            	x++;
						            	if(x < 8 && x >= 0){
						            		linea_2.setBounds(23,90,1, 30 - (int) (x*4.29));
						            	} else if(x < 16 && x >= 8){
						            		linea_3.setBounds(23 + (int) ((x-8)*26.16),90,183 - (int) ((x - 8)*26.16),1);
						            	} else if(x < 24 && x >= 16){
						            		linea_4.setBounds(206,90 + (int) ((x - 16)*4.43),1,30 - (int) ((x - 16)*4.43));
						            	}
						                if (x > 32) {
						                    ((Timer) e.getSource()).stop(); // Detiene la animación cuando llega al final
						                }
						            }
						        });
						        timer.start();
						        timer = null;
				            }
				    });
				    linea.setBounds(23,120,184,1);
					bg.add(textDire);
					bg.add(linea);
					bg.add(linea_4);
					bg.add(linea_2);
					bg.add(linea_3);
                	bg.add(pagar);
                	bg.add(textDire);
                	bg.add(compra);
                	frame.repaint();
                } else if(pago == 0 && !pagando) {
                	hamburguesa.setForeground(new Color(255,165,145));
                } else if(!textDire.getText().equals("Tu dirección") && pago == -1 && !pagando  && !auxx) {
                	aux.setText("Tu dirección :");
    //   ▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽
	//   ▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽ Prueba de clase Dirección ▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽
	//   ▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽
                	direccion = new Direccion(textDire.getText());
                	cliente.setDireccion(direccion);
                	auxDes.setText(cliente.getDireccion());
    //   △△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△
	//   △△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△
	//   △△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△
                	compra.setText("Selecciona un pago");
                	hamburguesa.setText("Ninguna forma de pago seleccionada.");
                	ingreso.add(hamburguesa);
                	ingreso.add(aux);
                	ingreso.add(auxDes);
                	bg.remove(textDire);
                	bg.remove(linea);
                	bg.remove(linea_2);
                	bg.remove(linea_3);
                	bg.remove(linea_4);
                	bg.add(comboBox);
                	bg.add(precio);
                	frame.repaint();
                	pago = 0;
                } else if(textDire.getText().equals("Tu dirección") && pago == -1 && !pagando  && !auxx){
                	error.setText("Ingresa una dirección");
		    		error.setBounds(25,130,180,30);
			        error.setFont(fuentePersonalizada.deriveFont(Font.PLAIN, 18));
			        error.setForeground(color[2]);
			        bg.add(error);
		    		textDire.setForeground(color[2]);
		    		linea.setBackground(color[2]);
		    		linea_2.setBackground(color[2]);
		    		linea_3.setBackground(color[2]);
		    		linea_4.setBackground(color[2]);
		    		Timer timer = new Timer(2, new ActionListener() {
						int x = 0;
			            @Override
			            public void actionPerformed(ActionEvent f) {
			            	x++;
			            	if(x < 8 && x >= 0){
			            		linea_2.setBounds(23,121 - (int) (x*4.429),1, (int) (x*4.286));
			            	} else if(x < 16 && x >= 8){
			            		linea_3.setBounds(23,90,(int) ((x - 8)*26.15),1);
			            	} else if(x < 24 && x >= 16){
			            		linea_4.setBounds(206,90,1,(int) ((x - 16)*4.286));
			            	}
			                if (x > 32) {
			                    ((Timer) f.getSource()).stop(); 
			                }
			            }
			        });
			        timer.start();
			        timer = null;
			    } else if(!textDire.getText().equals("Ingrese el tipo") && pago == 2 && pagando && !fase && !auxx) {
                	compra.setText("N° de tarjeta");
                	tipoBanco = textDire.getText();
                	bg.removeAll();
                	textDire = null;
                	ingreso.removeAll();
					textDire = new JTextField(30);
					textDire.setBounds(25,90,180,30);
				    textDire.setBorder(null);
					textDire.setOpaque(false);
					textDire.setText("Ingrese el n°");
					textDire.setForeground(color[2]);
					textDire.setFont(fuentePersonalizada.deriveFont(Font.PLAIN, 18));
					textDire.addFocusListener(new FocusListener() {
				            @Override
				            public void focusGained(FocusEvent e) {
				            	try {error.setBounds(900,500,100,100); ingreso.remove(error);} catch(Exception f) {;}
				            	textDire.setForeground(color[0]);
					    		linea.setBackground(color[0]);
					    		linea_2.setBackground(color[0]);
					    		linea_3.setBackground(color[0]);
					    		linea_4.setBackground(color[0]);
				                if (textDire.getText().equals("Ingrese el n°")) {
				                    textDire.setText("");
				                    textDire.setForeground(color[0]);
				                } 
				              	Timer timer = new Timer(2, new ActionListener() {
									int x = 0;
						            @Override
						            public void actionPerformed(ActionEvent e) {
						            	x++;
						            	if(x < 8 && x >= 0){
						            		linea_2.setBounds(23,121 - (int) (x*4.429),1, (int) (x*4.286));
						            	} else if(x < 16 && x >= 8){
						            		linea_3.setBounds(23,90,(int) ((x - 8)*26.15),1);
						            	} else if(x < 24 && x >= 16){
						            		linea_4.setBounds(206,90,1,(int) ((x - 16)*4.286));
						            	}
						                if (x > 32) {
						                    ((Timer) e.getSource()).stop(); 
						                }
						            }
						        });
						        timer.start();
						        timer = null;
				            }

				            @Override
				            public void focusLost(FocusEvent e) {
				                if (textDire.getText().isEmpty()) {
				                    textDire.setText("Ingrese el n°");
				                    textDire.setForeground(color[2]);
				                }
				                Timer timer = new Timer(1, new ActionListener() {
									int x = 0;
						            @Override
						            public void actionPerformed(ActionEvent e) {
						            	x++;
						            	if(x < 8 && x >= 0){
						            		linea_2.setBounds(23,90,1, 30 - (int) (x*4.29));
						            	} else if(x < 16 && x >= 8){
						            		linea_3.setBounds(23 + (int) ((x-8)*26.16),90,183 - (int) ((x - 8)*26.16),1);
						            	} else if(x < 24 && x >= 16){
						            		linea_4.setBounds(206,90 + (int) ((x - 16)*4.43),1,30 - (int) ((x - 16)*4.43));
						            	}
						                if (x > 32) {
						                    ((Timer) e.getSource()).stop(); // Detiene la animación cuando llega al final
						                }
						            }
						        });
						        timer.start();
						        timer = null;
				            }
				    });
				    linea.setBounds(23,120,184,1);
					bg.add(textDire);
					bg.add(linea);
					bg.add(linea_4);
					bg.add(linea_2);
					bg.add(linea_3);
                	bg.add(pagar);
                	bg.add(compra);
                	fase = true;
                	frame.repaint();
                } else if(textDire.getText().equals("Ingrese el tipo") && pago == 2 && pagando && !fase && !auxx){
                	error.setText("¡Ingresa un tipo!");
		    		error.setBounds(25,130,180,30);
			        error.setFont(fuentePersonalizada.deriveFont(Font.PLAIN, 18));
			        error.setForeground(color[2]);
			        bg.add(error);
		    		textDire.setForeground(color[2]);
		    		linea.setBackground(color[2]);
		    		linea_2.setBackground(color[2]);
		    		linea_3.setBackground(color[2]);
		    		linea_4.setBackground(color[2]);
		    		Timer timer = new Timer(2, new ActionListener() {
						int x = 0;
			            @Override
			            public void actionPerformed(ActionEvent f) {
			            	x++;
			            	if(x < 8 && x >= 0){
			            		linea_2.setBounds(23,121 - (int) (x*4.429),1, (int) (x*4.286));
			            	} else if(x < 16 && x >= 8){
			            		linea_3.setBounds(23,90,(int) ((x - 8)*26.15),1);
			            	} else if(x < 24 && x >= 16){
			            		linea_4.setBounds(206,90,1,(int) ((x - 16)*4.286));
			            	}
			                if (x > 32) {
			                    ((Timer) f.getSource()).stop(); 
			                }
			            }
			        });
			        timer.start();
			        timer = null;
			        frame.repaint();
			    } else if(!textDire.getText().equals("Ingrese el n°") && pago == 2 && pagando && fase && !auxx) {
			    	pagos[0] = new Tarjeta(ordenCompra.calcPrecio(), tipoBanco, textDire.getText());
			    	bg.remove(textDire);
			    	textDire = null;
			    	auxx = true;
			    	pagar();
                } else if(textDire.getText().equals("Ingrese el n°") && pago == 2 && pagando && fase && !auxx){
                	error.setText("¡Ingresa un n°!");
		    		error.setBounds(25,130,180,30);
			        error.setFont(fuentePersonalizada.deriveFont(Font.PLAIN, 18));
			        error.setForeground(color[2]);
			        bg.add(error);
		    		textDire.setForeground(color[2]);
		    		linea.setBackground(color[2]);
		    		linea_2.setBackground(color[2]);
		    		linea_3.setBackground(color[2]);
		    		linea_4.setBackground(color[2]);
		    		Timer timer = new Timer(2, new ActionListener() {
						int x = 0;
			            @Override
			            public void actionPerformed(ActionEvent f) {
			            	x++;
			            	if(x < 8 && x >= 0){
			            		linea_2.setBounds(23,121 - (int) (x*4.429),1, (int) (x*4.286));
			            	} else if(x < 16 && x >= 8){
			            		linea_3.setBounds(23,90,(int) ((x - 8)*26.15),1);
			            	} else if(x < 24 && x >= 16){
			            		linea_4.setBounds(206,90,1,(int) ((x - 16)*4.286));
			            	}
			                if (x > 32) {
			                    ((Timer) f.getSource()).stop(); 
			                }
			            }
			        });
			        timer.start();
			        timer = null;
			    } else if(!textDire.getText().equals("Ingrese su banco") && pago == 3 && pagando && !fase && !auxx) {
                	compra.setText("N° de cuenta");
                	tipoBanco = textDire.getText();
                	bg.removeAll();
                	textDire = null;
                	ingreso.removeAll();
					textDire = new JTextField(30);
					textDire.setBounds(25,90,180,30);
				    textDire.setBorder(null);
					textDire.setOpaque(false);
					textDire.setText("Ingrese el n°");
					textDire.setForeground(color[2]);
					textDire.setFont(fuentePersonalizada.deriveFont(Font.PLAIN, 18));
					textDire.addFocusListener(new FocusListener() {
				            @Override
				            public void focusGained(FocusEvent e) {
				            	try {error.setBounds(900,500,100,100); ingreso.remove(error);} catch(Exception f) {;}
				            	textDire.setForeground(color[0]);
					    		linea.setBackground(color[0]);
					    		linea_2.setBackground(color[0]);
					    		linea_3.setBackground(color[0]);
					    		linea_4.setBackground(color[0]);
				                if (textDire.getText().equals("Ingrese el n°")) {
				                    textDire.setText("");
				                    textDire.setForeground(color[0]);
				                } 
				              	Timer timer = new Timer(2, new ActionListener() {
									int x = 0;
						            @Override
						            public void actionPerformed(ActionEvent e) {
						            	x++;
						            	if(x < 8 && x >= 0){
						            		linea_2.setBounds(23,121 - (int) (x*4.429),1, (int) (x*4.286));
						            	} else if(x < 16 && x >= 8){
						            		linea_3.setBounds(23,90,(int) ((x - 8)*26.15),1);
						            	} else if(x < 24 && x >= 16){
						            		linea_4.setBounds(206,90,1,(int) ((x - 16)*4.286));
						            	}
						                if (x > 32) {
						                    ((Timer) e.getSource()).stop(); 
						                }
						            }
						        });
						        timer.start();
						        timer = null;
				            }

				            @Override
				            public void focusLost(FocusEvent e) {
				                if (textDire.getText().isEmpty()) {
				                    textDire.setText("Ingrese el n°");
				                    textDire.setForeground(color[2]);
				                }
				                Timer timer = new Timer(1, new ActionListener() {
									int x = 0;
						            @Override
						            public void actionPerformed(ActionEvent e) {
						            	x++;
						            	if(x < 8 && x >= 0){
						            		linea_2.setBounds(23,90,1, 30 - (int) (x*4.29));
						            	} else if(x < 16 && x >= 8){
						            		linea_3.setBounds(23 + (int) ((x-8)*26.16),90,183 - (int) ((x - 8)*26.16),1);
						            	} else if(x < 24 && x >= 16){
						            		linea_4.setBounds(206,90 + (int) ((x - 16)*4.43),1,30 - (int) ((x - 16)*4.43));
						            	}
						                if (x > 32) {
						                    ((Timer) e.getSource()).stop(); // Detiene la animación cuando llega al final
						                }
						            }
						        });
						        timer.start();
						        timer = null;
				            }
				    });
				    linea.setBounds(23,120,184,1);
					bg.add(textDire);
					bg.add(linea);
					bg.add(linea_4);
					bg.add(linea_2);
					bg.add(linea_3);
                	bg.add(pagar);
                	bg.add(compra);
                	fase = true;
                	frame.repaint();
                } else if(textDire.getText().equals("Ingrese su banco") && pago == 3 && pagando && !fase && !auxx){
                	error.setText("¡Ingresa un banco!");
		    		error.setBounds(25,130,180,30);
			        error.setFont(fuentePersonalizada.deriveFont(Font.PLAIN, 18));
			        error.setForeground(color[2]);
			        bg.add(error);
		    		textDire.setForeground(color[2]);
		    		linea.setBackground(color[2]);
		    		linea_2.setBackground(color[2]);
		    		linea_3.setBackground(color[2]);
		    		linea_4.setBackground(color[2]);
		    		Timer timer = new Timer(2, new ActionListener() {
						int x = 0;
			            @Override
			            public void actionPerformed(ActionEvent f) {
			            	x++;
			            	if(x < 8 && x >= 0){
			            		linea_2.setBounds(23,121 - (int) (x*4.429),1, (int) (x*4.286));
			            	} else if(x < 16 && x >= 8){
			            		linea_3.setBounds(23,90,(int) ((x - 8)*26.15),1);
			            	} else if(x < 24 && x >= 16){
			            		linea_4.setBounds(206,90,1,(int) ((x - 16)*4.286));
			            	}
			                if (x > 32) {
			                    ((Timer) f.getSource()).stop(); 
			                }
			            }
			        });
			        timer.start();
			        timer = null;
			        frame.repaint();
			    } else if(!textDire.getText().equals("Ingrese el n°") && pago == 3 && pagando && fase && !auxx) {
			    	pagos[0] = new Transferencia(ordenCompra.calcPrecio(), tipoBanco, textDire.getText());
			    	bg.remove(textDire);
			    	textDire = null;
			    	auxx = true;
			    	pagar();
                } else if(textDire.getText().equals("Ingrese el n°") && pago == 3 && pagando && fase && !auxx){
                	error.setText("¡Ingresa un n°!");
		    		error.setBounds(25,130,180,30);
			        error.setFont(fuentePersonalizada.deriveFont(Font.PLAIN, 18));
			        error.setForeground(color[2]);
			        bg.add(error);
		    		textDire.setForeground(color[2]);
		    		linea.setBackground(color[2]);
		    		linea_2.setBackground(color[2]);
		    		linea_3.setBackground(color[2]);
		    		linea_4.setBackground(color[2]);
		    		Timer timer = new Timer(2, new ActionListener() {
						int x = 0;
			            @Override
			            public void actionPerformed(ActionEvent f) {
			            	x++;
			            	if(x < 8 && x >= 0){
			            		linea_2.setBounds(23,121 - (int) (x*4.429),1, (int) (x*4.286));
			            	} else if(x < 16 && x >= 8){
			            		linea_3.setBounds(23,90,(int) ((x - 8)*26.15),1);
			            	} else if(x < 24 && x >= 16){
			            		linea_4.setBounds(206,90,1,(int) ((x - 16)*4.286));
			            	}
			                if (x > 32) {
			                    ((Timer) f.getSource()).stop(); 
			                }
			            }
			        });
			        timer.start();
			        timer = null;
			    } else if((textDire.getText().equals("Boleta") || textDire.getText().equals("boleta")) && pagando) {
					DocTributario docTrib = ordenCompra.pagar(cliente, pagos, "boleta", direccion);
					cerrar = true;
                	bg.remove(textDire);
                	bg.remove(linea);
                	bg.remove(linea_2);
                	bg.remove(linea_3);
                	bg.remove(linea_4);
                	compra.setText("Creando boleta...");
                	JPanel top = new JPanel();
                	JPanel right = new JPanel();
                	JPanel left = new JPanel();
                	JPanel bot = new JPanel();
                	JPanel separador = new JPanel();
                	JPanel separador2 = new JPanel();
                	JPanel separador3 = new JPanel();
                	JPanel separador4 = new JPanel();
                	JLabel titulo1 = new JLabel();
                	String titulo1s = "Anger's Store";
                	JLabel titulo2 = new JLabel();
                	JLabel titulo4 = new JLabel();
                	JLabel titulo5 = new JLabel();
                	JLabel titulo6 = new JLabel();
                	JLabel titulo7 = new JLabel();
                	JLabel titulo8 = new JLabel();
                	JLabel titulo9 = new JLabel();
                	JLabel titulo10 = new JLabel();
                	JLabel titulo11 = new JLabel();
                	JLabel titulo12 = new JLabel();
                	JLabel titulo13 = new JLabel();
                	JLabel titulo14 = new JLabel("");
                	JLabel titulo15 = new JLabel("");
                	labelSetUp(titulo1,456,50,300,30,3,20,true);
                	labelSetUp(titulo2,380,92,268,30,3,14,false);
                	labelSetUp(titulo4,490,125,268,30,3,14,true);
                	labelSetUp(titulo5,380,160,268,30,3,14,false);
                	labelSetUp(titulo6,380,180,268,30,3,14,false);
                	labelSetUp(titulo7,380,200,268,30,3,14,false);
                	labelSetUp(titulo9,380,232,268,30,3,14,false);
                	labelSetUp(titulo10,380,252,268,30,3,14,false);
                	labelSetUp(titulo11,380,272,268,30,3,14,false);
                	labelSetUp(titulo12,380,292,268,30,3,14,false);
                	labelSetUp(titulo13,380,312,268,30,3,14,false);
                	labelSetUp(titulo14,382,363,280,30,1,18,false);
                	top.setBackground(color[3]);
		    		right.setBackground(color[3]);
		    		left.setBackground(color[3]);
		    		bot.setBackground(color[3]);
		    		separador.setBackground(color[3]);
		    		separador2.setBackground(color[3]);
		    		separador3.setBackground(color[3]);
		    		separador4.setBackground(color[3]);
                	Timer timer = new Timer(2, new ActionListener() {
						int x = 0;
			            @Override
			            public void actionPerformed(ActionEvent f) {
			            	x++;
			            	if(x < 16 && x >= 0){
			            		top.setBounds(371, 40, (int) (x*19.07), 1);
			            	} else if(x < 32 && x >= 16){
			            		right.setBounds(657,40,1,(int) ((x - 16)*25.334));
			            	} else if(x < 48 && x >= 32){
			            		bot.setBounds(657 - (int) ((x - 32)*19.07), 420, (int) ((x - 32)*19.07), 1);
			            	} else if(x < 64 && x >= 48) {
			            		left.setBounds(371,420 - (int) ((x - 48)*25.334),1,(int) ((x - 48)*25.334));
			            	} else if(x < 80 && x >= 64) {
			            		switch(x) {
			            		case 64:
			            			titulo1.setText(titulo1s.substring(0,1));
			            			break;
			            		case 65:
			            			titulo1.setText(titulo1s.substring(0,2));
			            			break;
			            		case 66:
			            			titulo1.setText(titulo1s.substring(0,3));
			            			break;
			            		case 68:
			            			titulo1.setText(titulo1s.substring(0,4));
			            			break;
			            		case 69:
			            			titulo1.setText(titulo1s.substring(0,5));
			            			break;
			            		case 70:
			            			titulo1.setText(titulo1s.substring(0,6));
			            			break;
			            		case 72:
			            			titulo1.setText(titulo1s.substring(0,7));
			            			break;
			            		case 73:
			            			titulo1.setText(titulo1s.substring(0,8));
			            			break;
			            		case 74:
			            			titulo1.setText(titulo1s.substring(0,9));
			            			break;
			            		case 76:
			            			titulo1.setText(titulo1s.substring(0,10));
			            			break;
			            		case 77:
			            			titulo1.setText(titulo1s.substring(0,11));
			            			break;
			            		case 78:
			            			titulo1.setText(titulo1s.substring(0,12));
			            			break;
			            		case 79:
			            			titulo1.setText(titulo1s.substring(0,13));
			            			break;

			            		}
			            	} else if(x < 96 && x >= 80) {
			            		separador.setBounds(371, 90, (int) ((x - 80)*19.066667), 1);
			            	} else if(x < 112 && x >= 96) {
			            		if(x == 96) {titulo2.setText(ordenCompra.toString());}
			            		separador2.setBounds(371, 125, (int) ((x - 96)*19.066667), 1);
			            	} else if(x < 128 && x >= 112) {
			            		if(x == 112) {titulo4.setText("Boleta");}
			            		else if(x == 115) {titulo5.setText("Numero     : " + docTrib.getNumero());}
			            		else if(x == 118) {titulo6.setText("Rut         : " + cliente.getRut());}
			            		else if(x == 121) {titulo7.setText("Direccion    : " + docTrib.getDireccion());}
			            		separador3.setBounds(371, 235, (int) ((x - 112)*19.066667), 1);
			            	} else if(x < 144 && x >= 128) {
			            		if(x == 128) {titulo9.setText(      "Precio neto   : CLP " + ordenCompra.calcPrecioSinIVA());}
			            		else if(x == 131) {titulo10.setText("IVA          : CLP " + ordenCompra.calcIVA());}
			            		else if(x == 134) {titulo11.setText("Precio total   : CLP " + ordenCompra.calcPrecio());}
			            		else if(x == 137) {titulo12.setText("Efectivo      : CLP " + pagos[0].getMonto());}
			            		else if(x == 141) {
			            			if(pago == 1) {
										titulo13.setText("Vuelto        : CLP " + (pagos[0].getMonto() - ordenCompra.calcPrecio())); // Sin uso de .calcDevolucion() debido a reaccion imprevista despues de adaptacion para su funcionamiento en el metodo Main (el evaluado).
			            			}else if(pago == 2) {
			            				titulo13.setText("Pagado con   : Tarjeta");
			            			}else if(pago == 3) {
										titulo13.setText("Pagado con   : Transferencia");
			            			}
			            		}
			            		separador4.setBounds(371, 340, (int) ((x - 128)*19.066667), 1);
			            	} 
			                if (x >= 144) {
			                	titulo14.setText("¡Gracias por comprar con nosotros!");
			                	compra.setText("¡Boleta lista!");
			                	pagar.setText("Cerrar");
			                    ((Timer) f.getSource()).stop(); 
			                }
			            }
			        });
			        timer.start();
			        timer = null;
			        ingreso.add(top);
		    		ingreso.add(bot);
		    		ingreso.add(left);
		    		ingreso.add(right);
		    		ingreso.add(separador);
		    		ingreso.add(separador2);
		    		ingreso.add(separador3);
		    		ingreso.add(separador4);
		    		ingreso.add(titulo1);
		    		ingreso.add(titulo2);
		    		ingreso.add(titulo4);
		    		ingreso.add(titulo5);
		    		ingreso.add(titulo6);
		    		ingreso.add(titulo7);
		    		ingreso.add(titulo8);
		    		ingreso.add(titulo9);
		    		ingreso.add(titulo10);
		    		ingreso.add(titulo11);
		    		ingreso.add(titulo12);
		    		ingreso.add(titulo13);
		    		ingreso.add(titulo14);
                	frame.repaint();
                } else if((textDire.getText().equals("Factura") || textDire.getText().equals("factura")) && pagando) {
					pagos[0] = new Efectivo(30000);
					DocTributario docTrib = ordenCompra.pagar(cliente, pagos, "boleta", direccion);
					cerrar = true;
                	bg.remove(textDire);
                	bg.remove(linea);
                	bg.remove(linea_2);
                	bg.remove(linea_3);
                	bg.remove(linea_4);
                	compra.setText("Creando factura...");
                	JPanel top = new JPanel();
                	JPanel right = new JPanel();
                	JPanel left = new JPanel();
                	JPanel bot = new JPanel();
                	JPanel separador = new JPanel();
                	JPanel separador2 = new JPanel();
                	JPanel separador3 = new JPanel();
                	JPanel separador4 = new JPanel();
                	JLabel titulo1 = new JLabel();
                	String titulo1s = "Anger's Store";
                	JLabel titulo2 = new JLabel();
                	JLabel titulo3 = new JLabel();
                	JLabel titulo4 = new JLabel();
                	JLabel titulo5 = new JLabel();
                	JLabel titulo6 = new JLabel();
                	JLabel titulo7 = new JLabel();
                	JLabel titulo8 = new JLabel();
                	JLabel titulo9 = new JLabel();
                	JLabel titulo10 = new JLabel();
                	JLabel titulo11 = new JLabel();
                	JLabel titulo12 = new JLabel();
                	JLabel titulo13 = new JLabel();
                	JLabel titulo14 = new JLabel();
                	JLabel titulo15 = new JLabel("");
                	labelSetUp(titulo1,456,50,300,30,3,20,true);
                	labelSetUp(titulo2,380,92,268,30,3,14,false);
                	labelSetUp(titulo3,25,100,268,30,0,20,true);
                	labelSetUp(titulo4,490,125,268,30,3,14,true);
                	labelSetUp(titulo5,380,160,268,30,3,14,false);
                	labelSetUp(titulo6,380,180,268,30,3,14,false);
                	labelSetUp(titulo7,380,200,268,30,3,14,false);
                	labelSetUp(titulo9,380,232,268,30,3,14,false);
                	labelSetUp(titulo10,380,252,268,30,3,14,false);
                	labelSetUp(titulo11,380,272,268,30,3,14,false);
                	labelSetUp(titulo12,380,292,268,30,3,14,false);
                	labelSetUp(titulo13,380,312,268,30,3,14,false);
                	labelSetUp(titulo14,382,363,280,30,1,18,false);
                	top.setBackground(color[3]);
		    		right.setBackground(color[3]);
		    		left.setBackground(color[3]);
		    		bot.setBackground(color[3]);
		    		separador.setBackground(color[3]);
		    		separador2.setBackground(color[3]);
		    		separador3.setBackground(color[3]);
		    		separador4.setBackground(color[3]);
                	Timer timer = new Timer(2, new ActionListener() {
						int x = 0;
			            @Override
			            public void actionPerformed(ActionEvent f) {
			            	x++;
			            	if(x < 16 && x >= 0){
			            		top.setBounds(371, 40, (int) (x*19.07), 1);
			            	} else if(x < 32 && x >= 16){
			            		right.setBounds(657,40,1,(int) ((x - 16)*25.334));
			            	} else if(x < 48 && x >= 32){
			            		bot.setBounds(657 - (int) ((x - 32)*19.07), 420, (int) ((x - 32)*19.07), 1);
			            	} else if(x < 64 && x >= 48) {
			            		left.setBounds(371,420 - (int) ((x - 48)*25.334),1,(int) ((x - 48)*25.334));
			            	} else if(x < 80 && x >= 64) {
			            		switch(x) {
			            		case 64:
			            			titulo1.setText(titulo1s.substring(0,1));
			            			break;
			            		case 65:
			            			titulo1.setText(titulo1s.substring(0,2));
			            			break;
			            		case 66:
			            			titulo1.setText(titulo1s.substring(0,3));
			            			break;
			            		case 68:
			            			titulo1.setText(titulo1s.substring(0,4));
			            			break;
			            		case 69:
			            			titulo1.setText(titulo1s.substring(0,5));
			            			break;
			            		case 70:
			            			titulo1.setText(titulo1s.substring(0,6));
			            			break;
			            		case 72:
			            			titulo1.setText(titulo1s.substring(0,7));
			            			break;
			            		case 73:
			            			titulo1.setText(titulo1s.substring(0,8));
			            			break;
			            		case 74:
			            			titulo1.setText(titulo1s.substring(0,9));
			            			break;
			            		case 76:
			            			titulo1.setText(titulo1s.substring(0,10));
			            			break;
			            		case 77:
			            			titulo1.setText(titulo1s.substring(0,11));
			            			break;
			            		case 78:
			            			titulo1.setText(titulo1s.substring(0,12));
			            			break;
			            		case 79:
			            			titulo1.setText(titulo1s.substring(0,13));
			            			break;

			            		}
			            	} else if(x < 96 && x >= 80) {
			            		separador.setBounds(371, 90, (int) ((x - 80)*19.066667), 1);
			            	} else if(x < 112 && x >= 96) {
			            		if(x == 96) {titulo2.setText(ordenCompra.toString());}
			            		separador2.setBounds(371, 125, (int) ((x - 96)*19.066667), 1);
			            	} else if(x < 128 && x >= 112) {
			            		if(x == 112) {titulo4.setText("Factura");}
			            		else if(x == 115) {titulo5.setText("Numero     : " + docTrib.getNumero());}
			            		else if(x == 118) {titulo6.setText("Rut         : " + cliente.getRut());}
			            		else if(x == 121) {titulo7.setText("Direccion    : " + docTrib.getDireccion());}
			            		separador3.setBounds(371, 235, (int) ((x - 112)*19.066667), 1);
			            	} else if(x < 144 && x >= 128) {
			            		if(x == 128) {titulo9.setText(      "Precio neto   : CLP " + ordenCompra.calcPrecioSinIVA());}
			            		else if(x == 131) {titulo10.setText("IVA          : CLP " + ordenCompra.calcIVA());}
			            		else if(x == 134) {titulo11.setText("Precio total   : CLP " + ordenCompra.calcPrecio());}
			            		else if(x == 137) {titulo12.setText("Efectivo      : CLP " + pagos[0].getMonto());}
			            		else if(x == 141) {
			            			if(pago == 1) {
			            				titulo13.setText("Vuelto        : CLP " + (pagos[0].getMonto() - ordenCompra.calcPrecio())); // Sin uso de .calcDevolucion() debido a reaccion imprevista despues de adaptacion para su funcionamiento en el metodo Main (el evaluado).
			            			}else if(pago == 2) {
			            				titulo13.setText("Pagado con   : Tarjeta");
			            			}else if(pago == 3) {
										titulo13.setText("Pagado con   : Transferencia");
			            			}
			            		}
			            		separador4.setBounds(371, 340, (int) ((x - 128)*19.066667), 1);
			            	} 
			                if (x >= 144) {
			                	titulo14.setText("¡Gracias por comprar con nosotros!");
			                	compra.setText("¡Factura lista!");
			                	pagar.setText("Cerrar");
			                    ((Timer) f.getSource()).stop(); 
			                }
			            }
			        });
			        timer.start();
			        timer = null;
			        ingreso.add(top);
		    		ingreso.add(bot);
		    		ingreso.add(left);
		    		ingreso.add(right);
		    		ingreso.add(separador);
		    		ingreso.add(separador2);
		    		ingreso.add(separador3);
		    		ingreso.add(separador4);
		    		ingreso.add(titulo1);
		    		ingreso.add(titulo2);
		    		ingreso.add(titulo4);
		    		ingreso.add(titulo5);
		    		ingreso.add(titulo6);
		    		ingreso.add(titulo7);
		    		ingreso.add(titulo8);
		    		ingreso.add(titulo9);
		    		ingreso.add(titulo10);
		    		ingreso.add(titulo11);
		    		ingreso.add(titulo12);
		    		ingreso.add(titulo13);
		    		ingreso.add(titulo14);
                	frame.repaint();
                } else if(!textDire.getText().equals("boleta") && !textDire.getText().equals("factura") && !textDire.getText().equals("Boleta") && !textDire.getText().equals("Factura") && pagando) {
                	error.setText("¡\"boleta\" o \"factura\"!");
		    		error.setBounds(25,130,180,30);
			        error.setFont(fuentePersonalizada.deriveFont(Font.PLAIN, 18));
			        error.setForeground(color[2]);
			        bg.add(error);
		    		textDire.setForeground(color[2]);
		    		linea.setBackground(color[2]);
		    		linea_2.setBackground(color[2]);
		    		linea_3.setBackground(color[2]);
		    		linea_4.setBackground(color[2]);
		    		Timer timer = new Timer(2, new ActionListener() {
						int x = 0;
			            @Override
			            public void actionPerformed(ActionEvent f) {
			            	x++;
			            	if(x < 8 && x >= 0){
			            		linea_2.setBounds(23,121 - (int) (x*4.429),1, (int) (x*4.286));
			            	} else if(x < 16 && x >= 8){
			            		linea_3.setBounds(23,90,(int) ((x - 8)*26.15),1);
			            	} else if(x < 24 && x >= 16){
			            		linea_4.setBounds(206,90,1,(int) ((x - 16)*4.286));
			            	}
			                if (x > 32) {
			                    ((Timer) f.getSource()).stop(); 
			                }
			            }
			        });
			        timer.start();
			        timer = null;
                }
                pagar.setFont(fuentePersonalizada.deriveFont(Font.PLAIN, 30));
                pagar.setBounds(42,350,140,50);
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
				pagar.setFont(fuentePersonalizada.deriveFont(Font.BOLD, 30));
				pagar.setBounds(41,349,142,52);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Este método se llama cuando el mouse sale del botón
                pagar.setFont(fuentePersonalizada.deriveFont(Font.PLAIN, 30));
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
                if(pago == 0 || pago == -1) {
                	x = 7;
                	Timer timer = new Timer(2, new ActionListener() {
						int y = 0;
			            @Override
			            public void actionPerformed(ActionEvent e) {
			            	y++;
			            	auxB.setBackground(new Color(233,235-y*2,237-y*2));
			                if (y > 32) {
			                	auxB.setBackground(color[3]);
			                    ((Timer) e.getSource()).stop(); 
			                }
			            }
			        });
			        timer.start();
			        timer = null;
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



        textDire.setBounds(25,90,180,30);
        textDire.setBorder(null); // Elimina los bordes
		textDire.setOpaque(false);
		textDire.setText("Tu dirección");
		textDire.setForeground(color[2]);
		textDire.setFont(fuentePersonalizada.deriveFont(Font.PLAIN, 18));
		textDire.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                	try {error.setBounds(900,500,100,100); ingreso.remove(error);} catch(Exception f) {;}
                	textDire.setForeground(color[0]);
		    		linea.setBackground(color[0]);
		    		linea_2.setBackground(color[0]);
		    		linea_3.setBackground(color[0]);
		    		linea_4.setBackground(color[0]);
                    if (textDire.getText().equals("Tu dirección")) {
                        textDire.setText("");
                        textDire.setForeground(color[0]);
                    } 
                  	Timer timer = new Timer(2, new ActionListener() {
						int x = 0;
			            @Override
			            public void actionPerformed(ActionEvent e) {
			            	x++;
			            	if(x < 8 && x >= 0){
			            		linea_2.setBounds(23,121 - (int) (x*4.429),1, (int) (x*4.286));
			            	} else if(x < 16 && x >= 8){
			            		linea_3.setBounds(23,90,(int) ((x - 8)*26.15),1);
			            	} else if(x < 24 && x >= 16){
			            		linea_4.setBounds(206,90,1,(int) ((x - 16)*4.286));
			            	}
			                if (x > 32) {
			                    ((Timer) e.getSource()).stop(); 
			                }
			            }
			        });
			        timer.start();
			        timer = null;
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (textDire.getText().isEmpty()) {
                        textDire.setText("Tu dirección");
                        textDire.setForeground(color[2]);
                    }
                    Timer timer = new Timer(1, new ActionListener() {
						int x = 0;
			            @Override
			            public void actionPerformed(ActionEvent e) {
			            	x++;
			            	if(x < 8 && x >= 0){
			            		linea_2.setBounds(23,90,1, 30 - (int) (x*4.29));
			            	} else if(x < 16 && x >= 8){
			            		linea_3.setBounds(23 + (int) ((x-8)*26.16),90,183 - (int) ((x - 8)*26.16),1);
			            	} else if(x < 24 && x >= 16){
			            		linea_4.setBounds(206,90 + (int) ((x - 16)*4.43),1,30 - (int) ((x - 16)*4.43));
			            	}
			                if (x > 32) {
			                    ((Timer) e.getSource()).stop(); // Detiene la animación cuando llega al final
			                }
			            }
			        });
			        timer.start();
			        timer = null;
                }
        });
        linea.setBounds(23,120,184,1);


        labelSetUp(compra,25,50,250,30,0,20,true);
        labelSetUp(precio,45,200,200,35,0,25,true);
        labelSetUp(contenido,270,40,200,40,3,30,true);
        labelSetUp(bebida,270,130,400,40,1,22,false);
        labelSetUp(hamburguesa,270,180,400,40,1,22,false);
        labelSetUp(papitas,270,230,400,40,1,22,false);
        labelSetUp(completo2,270,180,400,40,1,22,false);
        labelSetUp(papitas2,270,230,400,40,1,18,false);
        labelSetUp(completo3,270,180,400,40,1,18,false);
        labelSetUp(hamburguesa3,270,230,400,40,1,22,false);
        labelSetUp(papitas3,270,280,400,40,1,22,false);
        labelSetUp(aux,270,340,400,40,2,21,false);
        labelSetUp(auxDes,270,370,400,40,2,18,false);


        //Agrego todas las cosas a las respectivas cosas
        //this.bg.add(precio);
        //this.bg.add(comboBox);
        this.bg.add(compra);
        this.bg.add(pagar);
        this.bg.add(textDire);   
        this.bg.add(linea);   
        this.bg.add(linea_2);   
        this.bg.add(linea_3);   
        this.bg.add(linea_4);   
        this.ingreso.add(contenido);	
        this.ingreso.add(auxB);	
		this.frame.add(this.bg);
        this.frame.add(this.ingreso);
        this.frame.setVisible(true);
	}

	// Metodo de pago 
	private void pagar() {
		compra.setText("¿Boleta o Factura?");
		textDire = new JTextField(30);
		textDire.setBounds(25,90,180,30);
        textDire.setBorder(null);
		textDire.setOpaque(false);
		textDire.setText("Tu respuesta");
		textDire.setForeground(color[2]);
		textDire.setFont(fuentePersonalizada.deriveFont(Font.PLAIN, 18));
		textDire.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                	try {error.setBounds(900,500,100,100); ingreso.remove(error);} catch(Exception f) {;}
                	textDire.setForeground(color[0]);
		    		linea.setBackground(color[0]);
		    		linea_2.setBackground(color[0]);
		    		linea_3.setBackground(color[0]);
		    		linea_4.setBackground(color[0]);
                    if (textDire.getText().equals("Tu respuesta")) {
                        textDire.setText("");
                        textDire.setForeground(color[0]);
                    } 
                  	Timer timer = new Timer(2, new ActionListener() {
						int x = 0;
			            @Override
			            public void actionPerformed(ActionEvent e) {
			            	x++;
			            	if(x < 8 && x >= 0){
			            		linea_2.setBounds(23,121 - (int) (x*4.429),1, (int) (x*4.286));
			            	} else if(x < 16 && x >= 8){
			            		linea_3.setBounds(23,90,(int) ((x - 8)*26.15),1);
			            	} else if(x < 24 && x >= 16){
			            		linea_4.setBounds(206,90,1,(int) ((x - 16)*4.286));
			            	}
			                if (x > 32) {
			                    ((Timer) e.getSource()).stop(); 
			                }
			            }
			        });
			        timer.start();
			        timer = null;
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (textDire.getText().isEmpty()) {
                        textDire.setText("Tu respuesta");
                        textDire.setForeground(color[2]);
                    }
                    Timer timer = new Timer(1, new ActionListener() {
						int x = 0;
			            @Override
			            public void actionPerformed(ActionEvent e) {
			            	x++;
			            	if(x < 8 && x >= 0){
			            		linea_2.setBounds(23,90,1, 30 - (int) (x*4.29));
			            	} else if(x < 16 && x >= 8){
			            		linea_3.setBounds(23 + (int) ((x-8)*26.16),90,183 - (int) ((x - 8)*26.16),1);
			            	} else if(x < 24 && x >= 16){
			            		linea_4.setBounds(206,90 + (int) ((x - 16)*4.43),1,30 - (int) ((x - 16)*4.43));
			            	}
			                if (x > 32) {
			                    ((Timer) e.getSource()).stop(); // Detiene la animación cuando llega al final
			                }
			            }
			        });
			        timer.start();
			        timer = null;
                }
        });
        linea.setBounds(23,120,184,1);
		bg.add(compra);
		bg.add(textDire);
		bg.add(linea);
		bg.add(linea_4);
		bg.add(linea_2);
		bg.add(linea_3);
		frame.repaint();
	}

	// crear transferencia y tarjeta

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