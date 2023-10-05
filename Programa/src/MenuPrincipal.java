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

public class MenuPrincipal {
	private static ImageIcon icono;
	private JFrame frame;
	private JPanel bg;
	private JPanel ingreso;
	private JLabel titulo_1;
	private JLabel titulo_2;
	private JLabel again;
	private JLabel welcome;
	private JLabel error;
	private JButton logIn;
	private JButton back;
	private Font fuentePersonalizada;
	private static int largo = 800;
	private static int ancho = 500;
	private Color[] color = {new Color(0x225271), new Color(0x78cc97), new Color(0x0f978e), new Color(0xe9ebed)};
	private String rutaIcono;
	private String rutaFuente;

	// Constructor
	public MenuPrincipal(String rutaIcono, String rutaFuente) {
		int x = 0;
		int y = 0;
		this.rutaIcono = rutaIcono + "/Icono.png";
		this.rutaFuente = rutaFuente + "/Fuente.TTF";
		// Inicializacion de las variables	
		this.frame = new JFrame("Anger's Store");
		logIn = new JButton("Comprar");
		welcome = new JLabel("Ingrese");
		again = new JLabel("sus datos");
		ingreso = new JPanel();
		bg = new JPanel();
		error = new JLabel();
		this.titulo_1 = new JLabel("ANGER'S");
		this.titulo_2 = new JLabel("STORE");
		try {
			icono = new ImageIcon(this.rutaIcono); 
			this.frame.setIconImage(icono.getImage());
        } catch (Exception e) {
        	System.err.println("Error al cargar el ícono: " + e.getMessage());
        }
        try {
        	fuentePersonalizada = Font.createFont(Font.TRUETYPE_FONT, new File(this.rutaFuente));
        } catch (Exception e) {
        	e.printStackTrace();System.err.println("Error al cargar la fuente: " + e.getMessage());
        }

	// Iniciando mi ventana
	this.frame.setBounds(x, y, largo, ancho);
        this.frame.setResizable(false);
	this.frame.setLocationRelativeTo(null);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Iniciando panel izquierdo
        this.bg.setBounds(0, 0, largo/2, ancho);
        this.bg.setBackground(this.color[3]);
        this.bg.setLayout(null); 

        // Iniciando panel derecho
        this.ingreso.setBounds(largo/2, 0, largo/2, ancho);
        this.ingreso.setBackground(this.color[0]);
        this.ingreso.setLayout(null); 

        // Iniciando titulos
        labelSetUp(this.titulo_1,60,120,600,100,0,80,true);
        labelSetUp(this.titulo_2,60,230,600,100,0,80,true);
        labelSetUp(this.welcome,40,140,600,80,0,60,true);
        labelSetUp(this.again,40,230,600,80,0,60,true);

        // Iniciando botones de login
        this.logIn.setBounds(510,200,180,50);
        this.logIn.setFont(fuentePersonalizada.deriveFont(Font.PLAIN, 35));
        this.logIn.setForeground(this.color[0]);
        this.logIn.setBorderPainted(false);
        this.logIn.setBackground(this.color[3]);
        this.logIn.setFocusPainted(false);

        // Funcionalidades de los botones de login y signup
        this.logIn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Este método se llama cuando se hace clic en el botón
                logIn.setFont(fuentePersonalizada.deriveFont(Font.PLAIN, 35));
                logIn.setBounds(510,200,180,50);
                logInSetUp();
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
				logIn.setFont(fuentePersonalizada.deriveFont(Font.BOLD, 35));
				logIn.setBounds(509,199,182,52);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Este método se llama cuando el mouse sale del botón
                logIn.setFont(fuentePersonalizada.deriveFont(Font.PLAIN, 35));
                logIn.setBounds(510,200,180,50);
            }
        });

        //Agrego todas las cosas a las respectivas cosas
        this.bg.add(this.titulo_1);
        this.bg.add(this.titulo_2);
        ingreso.add(logIn);
		this.frame.add(this.bg);
        this.frame.add(this.ingreso);
        this.frame.setVisible(true);
	}

	// Metodo para abrir la seccion de login
	private void logInSetUp() {
		// Variables
		JPanel linea = new JPanel();
		JPanel linea_2 = new JPanel();
		JPanel linea_3 = new JPanel();
		JPanel linea_4 = new JPanel();
		JPanel linea2 = new JPanel();
		JPanel linea2_2 = new JPanel();
		JPanel linea2_3 = new JPanel();
		JPanel linea2_4 = new JPanel();
		JPanel box = new JPanel();
		JPanel box2 = new JPanel();
        JLabel logInUser = new JLabel("Nombre");
        JLabel logInPass = new JLabel("Rut");
        JLabel b = new JLabel();
        JButton logInButton = new JButton("Ingresar");
        JButton xd = new JButton("owo");
        JTextField textUser = new JTextField(30);
        JTextField textPass = new JTextField(30);

        // Animacion de entrada
		Timer timer = new Timer(1, new ActionListener() {
			int x = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
            	x++;
                bg.setBounds(0, 0, largo/2 - x*2, ancho);
				ingreso.setBounds(largo/2 - x*2, 0, largo/2 + x*2, ancho);
				titulo_1.setBounds(60 + (int) (x*1.71),120-(int) (x*2.85),600,100 - 2*x);
		        titulo_1.setFont(fuentePersonalizada.deriveFont(Font.BOLD, 80 - (int) (x*1.55)));
		        titulo_2.setBounds(60 + (int) (x*4.34),230-(int) (x*5.89),600,100 - 2*x);
		        titulo_2.setFont(fuentePersonalizada.deriveFont(Font.BOLD, 80 - (int) (x*1.55)));
				bg.revalidate();
				ingreso.revalidate();
                bg.repaint();
                ingreso.repaint();
                if(x == 35) {
                	bg.add(welcome);
			        bg.add(again);
			        bg.add(back);
			        bg.add(xd);
			        ingreso.add(logInUser);
			        ingreso.add(logInPass);
			        ingreso.add(textUser);
			        ingreso.add(textPass);
			        ingreso.add(linea);
			        ingreso.add(linea_2);
			        ingreso.add(linea_3);
			        ingreso.add(linea_4);
			        ingreso.add(linea2);
			        ingreso.add(linea2_2);
			        ingreso.add(linea2_3);
			        ingreso.add(linea2_4);
			        ingreso.add(logInButton);
			        ingreso.add(box);
			        ingreso.add(box2);
			        bg.revalidate();
					ingreso.revalidate();
	                bg.repaint();
	                ingreso.repaint();
                }
                if (x > 35) {
                    ((Timer) e.getSource()).stop();
                }
            }
        });
        timer.start();
        timer = null;

        // Subtitulo de Usuario
        labelSetUp(logInUser,375,130,300,30,3,30,false);

        // Caja de texto para usuario
        textUser.setBounds(375,170,250,30);
        textUser.setBorder(null); // Elimina los bordes
		textUser.setOpaque(false);
		textUser.setText("Tu nombre");
		textUser.setForeground(color[2]);
		textUser.setFont(fuentePersonalizada.deriveFont(Font.PLAIN, 18));
		textUser.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                	try {b.setBounds(900,500,100,100); ingreso.remove(b);} catch(Exception f) {;}
                	textUser.setForeground(color[3]);
		    		linea.setBackground(color[3]);
		    		linea_2.setBackground(color[3]);
		    		linea_3.setBackground(color[3]);
		    		linea_4.setBackground(color[3]);
                    if (textUser.getText().equals("Tu nombre")) {
                        textUser.setText("");
                        textUser.setForeground(color[3]);
                    } 
                  	Timer timer = new Timer(1, new ActionListener() {
						int x = 0;
			            @Override
			            public void actionPerformed(ActionEvent e) {
			            	x++;
			            	if(x < 8 && x >= 0){
			            		linea_2.setBounds(373,199 - (int) (x*4.15),1, (int) (x*4.29));
			            	} else if(x < 16 && x >= 8){
			            		linea_3.setBounds(373,170,(int) ((x - 8)*36),1);
			            	} else if(x < 24 && x >= 16){
			            		linea_4.setBounds(625,170,1,(int) ((x - 16)*4.5));
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
                    if (textUser.getText().isEmpty()) {
                        textUser.setText("Tu nombre");
                        textUser.setForeground(color[2]);
                    }
                    Timer timer = new Timer(1, new ActionListener() {
						int x = 0;
			            @Override
			            public void actionPerformed(ActionEvent e) {
			            	x++;
			            	if(x < 8 && x >= 0) {
			            		linea_2.setBounds(373,170,1, 30 - (int) (x*4.29));
			            	} else if(x < 16 && x >= 8){
			            		linea_3.setBounds(373 + (int) ((x-8)*36),170,252 - (int) ((x - 8)*36),1);
			            	} else if(x < 24 && x >= 16){
			            		linea_4.setBounds(625,170 + (int) ((x - 16)*4.43),1,30 - (int) ((x - 16)*4.43));
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
        linea.setBounds(373,200,253,1);

        // Subtitulo de Contraseña
        labelSetUp(logInPass,375,260,300,30,3,30,false);

        // Caja de texto para contraseña
        textPass.setBounds(375,300,250,30);
        textPass.setBorder(null); // Elimina los bordes
		textPass.setOpaque(false);
		textPass.setText("Tu rut, ej \"12.345.678-9\"");
		textPass.setForeground(color[2]);
		textPass.setFont(fuentePersonalizada.deriveFont(Font.PLAIN, 18));
		textPass.addFocusListener(new FocusListener() {
                 @Override
                public void focusGained(FocusEvent e) {
                	try {b.setBounds(900,500,100,100); ingreso.remove(b);} catch(Exception f) {;}
                	textPass.setForeground(color[3]);
		    		linea2.setBackground(color[3]);
		    		linea2_2.setBackground(color[3]);
		    		linea2_3.setBackground(color[3]);
		    		linea2_4.setBackground(color[3]);
                    if (textPass.getText().equals("Tu rut, ej \"12.345.678-9\"")) {
                        textPass.setText("");
                        textPass.setForeground(color[3]);
                    } 
                  	Timer timer = new Timer(1, new ActionListener() {
						int x = 0;
			            @Override
			            public void actionPerformed(ActionEvent e) {
			            	x++;
			            	if(x < 8 && x >= 0){
			            		linea2_2.setBounds(373,329 - (int) (x*4.15),1, (int) (x*4.29));
			            	} else if(x < 16 && x >= 8){
			            		linea2_3.setBounds(373,300,(int) ((x - 8)*36),1);
			            	} else if(x < 24 && x >= 16){
			            		linea2_4.setBounds(625,300,1,(int) ((x - 16)*4.5));
			            	}
			                if (x > 32) {
			                    ((Timer) e.getSource()).stop(); // Detiene la animación cuando llega al final
			                }
			            }
			        });
			        timer.start();
			        timer = null;

                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (textPass.getText().isEmpty()) {
                        textPass.setText("Tu rut, ej \"12.345.678-9\"");
                        textPass.setForeground(color[2]);
                    }
                    Timer timer = new Timer(1, new ActionListener() {
						int x = 0;
			            @Override
			            public void actionPerformed(ActionEvent e) {
			            	x++;
			            	if(x < 8 && x >= 0){
			            		linea2_2.setBounds(373,300,1, 30 - (int) (x*4.29));
			            	} else if(x < 16 && x >= 8){
			            		linea2_3.setBounds(373 + (int) ((x-8)*36),300,252 - (int) ((x - 8)*36),1);
			            	} else if(x < 24 && x >= 16){
			            		linea2_4.setBounds(625,300 + (int) ((x - 16)*4.43),1,30 - (int) ((x - 16)*4.43));
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
		linea2.setBounds(373,330,252,1);

		// Boton para volver
		back = new JButton();
		back.setContentAreaFilled(false);
		back.setIcon(new ImageIcon("Imagenes\\back.png"));
		back.setBorderPainted(false);
		back.setBounds(13,10,40,40);
		back.setFocusPainted(false);
		back.setOpaque(false);
		back.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Este método se llama cuando se hace clic en el botón
            }

            @Override
            public void mousePressed(MouseEvent e) {
            	Timer timer = new Timer(1, new ActionListener() {
					int x = 0;
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	x++;

		                bg.setBounds(0, 0, largo/2 - 70 + x*2, ancho);
						ingreso.setBounds(largo/2 - 70 + x*2, 0, largo/2 + 70 - x*2, ancho);
						titulo_1.setBounds(60 + 61 - (int) (x*1.71),120 - 102 + (int) (x*2.85),600,100 - 59 + (int) (x * 1.71));
				        titulo_1.setFont(fuentePersonalizada.deriveFont(Font.BOLD, 80 - 55 + (int) (x*1.55)));
				        titulo_2.setBounds(60 + 156 - (int) (x*4.34),230 - 212 + (int) (x*5.89),600,100 - 59 + (int) (x * 1.71));
				        titulo_2.setFont(fuentePersonalizada.deriveFont(Font.BOLD, 80 - 55 + (int) (x*1.55)));
						bg.revalidate();
						ingreso.revalidate();
		                bg.repaint();
		                ingreso.repaint(); // Vuelve a dibujar la línea con la nueva posición
		                if (x > 35) {
		                    ((Timer) e.getSource()).stop(); // Detiene la animación cuando llega al final
		                }
		            }
		        });
		        timer.start();
		        timer = null;
		        bg.setLayout(null); 
		        ingreso.setLayout(null); 
                bg.remove(welcome);
		        bg.remove(back);
		        bg.remove(again);
		        bg.remove(xd);	
		        ingreso.add(logIn);
		        ingreso.remove(logInUser);
		        ingreso.remove(logInPass);
		        ingreso.remove(textUser);
		        ingreso.remove(textPass);
		        ingreso.remove(linea);
		        ingreso.remove(linea_2);
		        ingreso.remove(linea_3);
		        ingreso.remove(linea_4);
		        ingreso.remove(linea2);
		        ingreso.remove(linea2_2);
		        ingreso.remove(linea2_3);
		        ingreso.remove(linea2_4);
		        ingreso.remove(logInButton);
		        ingreso.remove(box);
		        ingreso.remove(box2);
		        try {ingreso.remove(b);} catch (Exception f) {;}
		        ingreso.revalidate();
		        bg.revalidate();
		        bg.repaint();
		        ingreso.repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
				back.setBounds(10,10,43,40);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Este método se llama cuando el mouse sale del botón
                back.setBounds(13,10,40,40);
                // Realiza la acción deseada aquí
            }
        });

        // Boton de LogIn
        logInButton.setFont(fuentePersonalizada.deriveFont(Font.PLAIN, 20));
		logInButton.setBorderPainted(false);
		logInButton.setFocusPainted(false);
		logInButton.setBounds(660,110,100,30);
		logInButton.setForeground(color[0]);
		logInButton.setFocusPainted(false);
		logInButton.setBackground(color[3]);
		logInButton.addMouseListener(new MouseListener() {
			int aux = 0;
            @Override
            public void mouseClicked(MouseEvent e) {
                // Este método se llama cuando se hace clic en el botón
                if(aux == 0) {
                	Timer timer = new Timer(1, new ActionListener() {
                					int x = 0;
                		            @Override
                		            public void actionPerformed(ActionEvent e) {
                		            	x++;
                		            	if(x < 56){
                		               		logInButton.setBounds(660,110 + (int) (x*x*0.0736112),100,37);
                		               	} else {
                		               		logInButton.setBounds(660,110 + (int) (x*x*0.0736112),100,37 - (int) (x*x*0.00194444));
                		               	}
                		                bg.repaint();
                		                if (x > 59) {
                		                    ((Timer) e.getSource()).stop(); 
						    		    	aux = 0;
						    		    	if(!textUser.getText().equals("Tu nombre") && !textPass.getText().equals("Tu rut, ej \"12.345.678-9\"")){
							    		    	frame.dispose();

	//   ▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽
	//   ▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽ Prueba de clase Cliente ▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽
	//   ▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽▽
							    		    	MenuCompra menuCompra = new MenuCompra(frame.getLocation().x, frame.getLocation().y, color, new Cliente(textUser.getText(), textPass.getText()), rutaIcono, rutaFuente);
	//   △△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△
	//   △△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△
	//   △△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△△
										    } else if (!textUser.getText().equals("Tu nombre") && textPass.getText().equals("Tu rut, ej \"12.345.678-9\"")) {
										    	Timer timer1 = new Timer(1, new ActionListener() {
							    					int y = 60;
							    		            @Override
							    		            public void actionPerformed(ActionEvent f) {
							    		            	aux = 1;
							    		            	y--;
							    		               	logInButton.setBounds(660,110 + (int) (y*y*0.0736112),100,30 + (int) (y*y*0.00194444));
							    		                bg.repaint();
							    		                if (y < 1) {
							    		                	aux = 0;
							    		                	((Timer) f.getSource()).stop();
							    		                }
							    		            }
							    		        });
							    		        timer1.start();
							    		        timer1 = null;
							    		        error.setText("Ingresa un rut.");
									    		error.setBounds(375,370,250,30);
										        error.setFont(fuentePersonalizada.deriveFont(Font.PLAIN, 18));
										        error.setForeground(color[2]);
										        ingreso.add(error);
									    		textPass.setForeground(color[2]);
									    		linea2.setBackground(color[2]);
									    		linea2_2.setBackground(color[2]);
									    		linea2_3.setBackground(color[2]);
									    		linea2_4.setBackground(color[2]);
										        Timer timer2 = new Timer(1, new ActionListener() {
													int x = 0;
										            @Override
										            public void actionPerformed(ActionEvent e) {
										            	x++;
										            	if(x < 8 && x >= 0){
										            		linea2_2.setBounds(373,329 - (int) (x*4.15),1, (int) (x*4.29));
										            	} else if(x < 16 && x >= 8){
										            		linea2_3.setBounds(373,300,(int) ((x - 8)*36),1);
										            	} else if(x < 24 && x >= 16){
										            		linea2_4.setBounds(625,300,1,(int) ((x - 16)*4.5));
										            	}
										                if (x > 32) {
										                    ((Timer) e.getSource()).stop(); // Detiene la animación cuando llega al final
										                }
										            }
										        });
										        timer2.start();
										        timer2 = null;
										    } else if (textUser.getText().equals("Tu nombre") && !textPass.getText().equals("Tu rut, ej \"12.345.678-9\"")) {
										    	Timer timer1 = new Timer(1, new ActionListener() {
							    					int y = 60;
							    		            @Override
							    		            public void actionPerformed(ActionEvent f) {
							    		            	aux = 1;
							    		            	y--;
							    		               	logInButton.setBounds(660,110 + (int) (y*y*0.0736112),100,30 + (int) (y*y*0.00194444));
							    		                bg.repaint();
							    		                if (y < 1) {
							    		                	aux = 0;
							    		                	((Timer) f.getSource()).stop();
							    		                }
							    		            }
							    		        });
							    		        timer1.start();
							    		        timer1 = null;
							    		        error.setText("Ingresa un nombre.");
									    		error.setBounds(375,370,250,30);
										        error.setFont(fuentePersonalizada.deriveFont(Font.PLAIN, 18));
										        error.setForeground(color[2]);
										        ingreso.add(error);
									    		textUser.setForeground(color[2]);
									    		linea.setBackground(color[2]);
									    		linea_2.setBackground(color[2]);
									    		linea_3.setBackground(color[2]);
									    		linea_4.setBackground(color[2]);
										        Timer timer3 = new Timer(1, new ActionListener() {
													int x = 0;
										            @Override
										            public void actionPerformed(ActionEvent e) {
										            	x++;
										            	if(x < 8 && x >= 0){
										            		linea_2.setBounds(373,199 - (int) (x*4.15),1, (int) (x*4.29));
										            	} else if(x < 16 && x >= 8){
										            		linea_3.setBounds(373,170,(int) ((x - 8)*36),1);
										            	} else if(x < 24 && x >= 16){
										            		linea_4.setBounds(625,170,1,(int) ((x - 16)*4.5));
										            	}
										                if (x > 32) {
										                    ((Timer) e.getSource()).stop(); 
										                }
										            }
										        });
										        timer3.start();
										        timer3 = null;
										    }else {
										    	Timer timer1 = new Timer(1, new ActionListener() {
							    					int y = 60;
							    		            @Override
							    		            public void actionPerformed(ActionEvent f) {
							    		            	aux = 1;
							    		            	y--;
							    		               	logInButton.setBounds(660,110 + (int) (y*y*0.0736112),100,30 + (int) (y*y*0.00194444));
							    		                bg.repaint();
							    		                if (y < 1) {
							    		                	aux = 0;
							    		                	((Timer) f.getSource()).stop();
							    		                }
							    		            }
							    		        });
							    		        timer1.start();
							    		        timer1 = null;
							    		        error.setText("Ingresa un nombre y un rut.");
									    		error.setBounds(375,370,250,30);
										        error.setFont(fuentePersonalizada.deriveFont(Font.PLAIN, 18));
										        error.setForeground(color[2]);
										        ingreso.add(error);
									    		textUser.setForeground(color[2]);
									    		textPass.setForeground(color[2]);
									    		linea.setBackground(color[2]);
									    		linea_2.setBackground(color[2]);
									    		linea_3.setBackground(color[2]);
									    		linea_4.setBackground(color[2]);
										        Timer timer3 = new Timer(1, new ActionListener() {
													int x = 0;
										            @Override
										            public void actionPerformed(ActionEvent e) {
										            	x++;
										            	if(x < 8 && x >= 0){
										            		linea_2.setBounds(373,199 - (int) (x*4.15),1, (int) (x*4.29));
										            	} else if(x < 16 && x >= 8){
										            		linea_3.setBounds(373,170,(int) ((x - 8)*36),1);
										            	} else if(x < 24 && x >= 16){
										            		linea_4.setBounds(625,170,1,(int) ((x - 16)*4.5));
										            	}
										                if (x > 32) {
										                    ((Timer) e.getSource()).stop(); 
										                }
										            }
										        });
										        timer3.start();
										        timer3 = null;
										        linea2.setBackground(color[2]);
									    		linea2_2.setBackground(color[2]);
									    		linea2_3.setBackground(color[2]);
									    		linea2_4.setBackground(color[2]);
										        Timer timer2 = new Timer(1, new ActionListener() {
													int x = 0;
										            @Override
										            public void actionPerformed(ActionEvent e) {
										            	x++;
										            	if(x < 8 && x >= 0){
										            		linea2_2.setBounds(373,329 - (int) (x*4.15),1, (int) (x*4.29));
										            	} else if(x < 16 && x >= 8){
										            		linea2_3.setBounds(373,300,(int) ((x - 8)*36),1);
										            	} else if(x < 24 && x >= 16){
										            		linea2_4.setBounds(625,300,1,(int) ((x - 16)*4.5));
										            	}
										                if (x > 32) {
										                    ((Timer) e.getSource()).stop(); // Detiene la animación cuando llega al final
										                }
										            }
										        });
										        timer2.start();
										        timer2 = null;
										    }
                		                }
                		            }
                		        });
                		        timer.start();
                		        timer = null;
                		        aux = 1;
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
				if(aux == 0){Timer timer = new Timer(1, new ActionListener() {
									int x = 0;
						            @Override
						            public void actionPerformed(ActionEvent e) {
						            	x++;
						                logInButton.setBounds(660,110 - (int) (x*0.7),100,30 + (int) (x*0.7));
						                bg.repaint();
						                if (x > 10) {
						                    ((Timer) e.getSource()).stop(); // Detiene la animación cuando llega al final
						                }
						            }
						        });
						        timer.start();
						        timer = null;}

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Este método se llama cuando el mouse sale del botón
	             if(aux == 0){Timer timer = new Timer(1, new ActionListener() {
	             						int x = 0;
	             			            @Override
	             			            public void actionPerformed(ActionEvent e) {
	             			            	x++;
	             			                logInButton.setBounds(660,103 + (int) (x*0.7),100,37 - (int) (x*0.7));
	             			                bg.repaint();
	             			                if (x > 10) {
	             			                    ((Timer) e.getSource()).stop(); // Detiene la animación cuando llega al final
	             			                }
	             			            }
	             			        });
	             			        timer.start();
	             			        timer = null;}
                // Realiza la acción deseada aquí
            }
        });

		// Caja login
		box.setBounds(660,375,100,30);
		box.setBackground(color[0]);
		box2.setBounds(656,375,108,34);
		box2.setBackground(color[3]);

		// Isteregg
        xd.setFont(fuentePersonalizada.deriveFont(Font.PLAIN, 20));
		xd.setBorderPainted(false);
		xd.setFocusPainted(false);
		xd.setBounds(13,410,75,30);
		xd.setForeground(color[0]);
		xd.setFocusPainted(false);
		xd.setBackground(color[3]);
		xd.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Este método se llama cuando se hace clic en el botón
            }

            @Override
            public void mousePressed(MouseEvent e) {
            	Timer timer = new Timer(2, new ActionListener() {
					int x = 0;
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	x++;
		                xd.setText("QwQ");
		            	if(x%2 == 0) {
		            		xd.setBounds(13 - (int) (x*0.07),410 + (int) (x*0.07),75,30);
		            	} else {
		            		xd.setBounds(13 + (int) (x*0.07),410 - (int) (x*0.07),75,30);
		            	}
		                bg.repaint();
		                if (x > 100) {
		                	xd.setBounds(13,410,75,30);
		                    ((Timer) e.getSource()).stop(); // Detiene la animación cuando llega al final
		                }
		            }
		        });
		        timer.start();
		        timer = null;

            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
				xd.setText("OwO");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Este método se llama cuando el mouse sale del botón
               xd.setText("owo");
                // Realiza la acción deseada aquí
            }
        });

        //Adision de componentes
        this.ingreso.remove(this.logIn);
        this.bg.revalidate();
        this.ingreso.revalidate();
        this.bg.repaint();
		this.ingreso.repaint();
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