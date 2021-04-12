/*
 * Programación Interactiva
 * Author: Juan David Olaya - 2026223
 * Case 1 : Game Arca de Noe
 */
package arcadenoe;
//importations
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import misComponentes.Titulos;

//principal class
public class GUIArcaDeNoe extends JFrame {
	
	// Diferents panels used for the interface 
	private JPanel panelN,panelC,panelS,panelSalida,panelP;
	// labes for score and round
	private JLabel lPuntaje,lRonda;
	// Text of score and round, this change for the cards
	public static JTextField jRonda, score;
	// images for the buttons, cards, and more
	private ImageIcon imagen,imagenExit,imagenAyuda,imagenReset;
	// images for the buttons, like locked, and random
	public static ImageIcon imagenReverse,imagenCopiada;
	// static boolean for the static random image
	public static Boolean siONo1,siONo2,siONo3,siONo4,siONo5,siONo6;
	// buttons for the cards
	public static JButton carta1,carta2,carta3,carta4,carta5,carta6,carta7,carta8,carta9,carta10,carta11,carta12,ayuda,salir,puntu;
	// "Escucha" for the actions 
	private Escuchas escucha;
	// score integer and round integer
	public static int puntaje = 0,ronda = 1;
	
	private JFrame miMisma = this;
	// it is used in the ayuda window where a parameter is the GUI
	private Ayuda ventanaAyuda = new Ayuda(miMisma);
	// class control for the other methods create in this class
	private static ControlJuego control;
	// timers, this control the time of the actions
	public static Timer timerWait,timerCompar;
	// vector used for fill the window (panels)
	public static Vector<JButton> cartitas = new Vector<JButton>();

	// method conctructor
	public GUIArcaDeNoe() {

		//in this part initialize all the components like integers, images, booleans, etc
		puntaje =0;
		ronda = 1;		
		siONo1=true;siONo2=true;siONo3=true;siONo4=true;siONo5=true;siONo6=true;
		// we create and defined a direction of the image
		imagen = new ImageIcon("src/imagenes/locked.png"); 
		imagenExit = new ImageIcon("src/imagenes/exit.png");
		imagenAyuda = new ImageIcon("src/imagenes/help.png");
		imagenReset = new ImageIcon("src/imagenes/reset.png");
		imagenCopiada = new ImageIcon();
		imagenReverse = new ImageIcon("src/imagenes/15.png");
		
		// initialize the Window and all the graphics components
		initGUI();
		// time and actions for the timers
		timerCompar = new Timer(2000,escucha);
		timerWait = new Timer(2200,escucha);
		//default window configuration
		this.setUndecorated(true);
		pack();
		//this.setBounds(850,700,850,700);
		
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);		
		
		//add cards in the vector
		cartitas.add(carta1);
		cartitas.add(carta2);
		cartitas.add(carta3);
		cartitas.add(carta4);
		cartitas.add(carta5);
		cartitas.add(carta6);
		cartitas.add(carta7);
		cartitas.add(carta8);
		cartitas.add(carta9);
		cartitas.add(carta10);
		cartitas.add(carta11);
		cartitas.add(carta12);
	}
	
	private void initGUI() {
		
		// define window container and layout 
		this.getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints contraints = new GridBagConstraints();
		this.getContentPane().setBackground(new Color(249, 157, 79));

		//create the "Escucha"
		escucha = new Escuchas();
		control = new ControlJuego();		
		
		// create the GUI
		// Title
		Titulos titulo = new Titulos("Arca de noe", 35, new Color(99, 211, 244));	
		titulo.addMouseListener(escucha);
        titulo.addMouseMotionListener(escucha);
        titulo.setCursor(new Cursor(Cursor.MOVE_CURSOR));
		contraints.gridx=0; // busy column
		contraints.gridy=0; // busy row
		contraints.gridwidth = 1; // width 
		contraints.gridheight = 1; // height
		contraints.fill = GridBagConstraints.HORIZONTAL; // orientation
		add(titulo,contraints); // titulo is added into container with the contrains characteristics
		
		// game zone - central panel
		panelP = new JPanel();
		//create label with his name Score
		lPuntaje = new JLabel("Score: ");
		// create the zone where the score change
		score = new JTextField();
		// method where received a JTextField and a JLabel
		paneles(score,puntaje);
		
		lRonda = new JLabel("Round: ");
		jRonda = new JTextField();
		paneles(jRonda,ronda);
		
		panelP.add(lPuntaje);
		panelP.add(score);
		panelP.add(lRonda);
		panelP.add(jRonda);
		panelP.setBackground(new Color(249, 157, 79));
		
		contraints.gridx = 0;
		contraints.gridy = 1;
		contraints.gridwidth = 1;
		contraints.gridheight = 1;
		contraints.fill = GridBagConstraints.NONE;
		add(panelP, contraints);
		
		// panel Up, contains 4 cards 
		// create the panel
		panelN = new JPanel(); 
		// defined properties like the layout
		panelN.setLayout(new GridLayout(1,3)); 
		// difined a border
		panelN.setBorder(new EmptyBorder(10,15,10,15) );	
		
		panelN = new JPanel();
		panelN.setLayout(new GridLayout(1,3));
		panelN.setBorder(new EmptyBorder(10,15,10,15) );
		
		//create the button card		
		carta1 = new JButton(imagenReverse);
		//method that received an image, put action ("Escucha")
		cartasT(carta1);
		// the card is add to the panel
		panelN.add(carta1);

		carta2 = new JButton(imagenReverse);
		cartasT(carta2);
		panelN.add(carta2);
		
		carta3 = new JButton(imagenReverse);
		cartasT(carta3);
		panelN.add(carta3);
		
		carta4 = new JButton(imagenReverse);
		cartasT(carta4);
		panelN.add(carta4);
		// define a Background color
		panelN.setBackground(new Color(249, 157, 79));
		//define the constrains and the panel ubication
		contraints.gridx=0; // busy column
		contraints.gridy=2; // busy row
		contraints.gridwidth = 1; // width 
		contraints.gridheight = 1; // height
		// add the panel to the window
		add(panelN,contraints);
		
		panelC = new JPanel();
		panelC.setLayout(new GridLayout(1,3));
		panelC.setBorder(new EmptyBorder(10,15,10,15) );
		
		carta5 = new JButton(imagen);
		cartasT(carta5);
		panelC.add(carta5);
		
		carta6 = new JButton(imagen);
		cartasT(carta6);
		panelC.add(carta6);
		
		carta7 = new JButton(imagen);
		cartasT(carta7);
		panelC.add(carta7);

		carta8 = new JButton(imagen);
		cartasT(carta8);
		panelC.add(carta8);
		
		panelC.setBackground(new Color(249, 157, 79));
		contraints.gridx=0; // busy column
		contraints.gridy=3; // busy row
		contraints.gridwidth = 1; // width 
		contraints.gridheight = 1; // height
		add(panelC,contraints);
		
		panelS = new JPanel();
		panelS.setLayout(new GridLayout(1,3));
		panelS.setBorder(new EmptyBorder(10,15,10,15) );
		
		carta9 = new JButton(imagen);
		cartasT(carta9);
		panelS.add(carta9);
		
		carta10 = new JButton(imagen);
		cartasT(carta10);
		panelS.add(carta10);
		
		carta11 = new JButton(imagen);
		cartasT(carta11);
		panelS.add(carta11);

		carta12 = new JButton(imagen);
		cartasT(carta12);
		panelS.add(carta12);
		
		panelS.setBackground(new Color(249, 157, 79));
		contraints.gridx=0; // busy column
		contraints.gridy=4; // busy row
		contraints.gridwidth = 1; // width 
		contraints.gridheight = 1; // height
		add(panelS,contraints);
		
		panelSalida = new JPanel();
		panelSalida.setLayout(new GridLayout(1,3));
		panelSalida.setBorder(new EmptyBorder(10,15,10,15) );
		salir = new JButton(imagenExit);
		salir.setBorder(null);
		salir.addActionListener(escucha);
		panelSalida.add(salir);
		
		
		ayuda = new JButton(imagenAyuda);
		ayuda.addActionListener(escucha);
		ayuda.setBorder(null);
		panelSalida.add(ayuda);
		
		
		puntu = new JButton(imagenReset);
		puntu.addActionListener(escucha);
		puntu.setBorder(null);
		panelSalida.add(puntu);
		panelSalida.setBackground(new Color(249, 157, 79));
		contraints.gridx=0; // busy column
		contraints.gridy=5; // busy row
		contraints.gridwidth = 1; // width 
		contraints.gridheight = 1; // height
		add(panelSalida,contraints);

		rondaJuego();
		
		
}
	// this method simplify the lines of code, return the jTextField
	public JTextField paneles(JTextField cartel,int valor) {
		cartel.setEditable(false);
		cartel.setText(String.valueOf(valor));
		cartel.setHorizontalAlignment(SwingConstants.CENTER);
		cartel.setPreferredSize(new Dimension(35,20));
		return cartel;
	}
	
	// this method simplify the lines of code, put the border, add action listener, and return the card
	public JButton cartasT(JButton cartaF) {
		cartaF.setBorder(null);
		cartaF.addActionListener(escucha);
		return cartaF;
	}
	
	// this method simplify the lines of code, it is received buttons, options, round, numer of card
	public void actions(JButton c1,JButton c2, boolean option, int par,int rondaJuego, int numerCarta ) {
		control.comparaciones(c1,c2,option,par);
		timerWait.start();
		timerCompar.start();
		control.compararImagen(rondaJuego,numerCarta);
	}

	// class escucha, where implements the actions and events of the buttons
	private class Escuchas extends MouseAdapter implements ActionListener,MouseListener, MouseMotionListener{
		//Variables x and y, this control the position of the window
		private int x,y;
		
		// control the actions where is occasioned for the buttons
		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Esbozo de método generado automáticamente
		
			//timer where run different methods, each bar
			if( event.getSource() == timerWait) {
				// methods thats executed for the card press
				control.lockedCarta();	
				control.subioDeNivel();
			}

			// the actions or events are controlated in the rounds
			if(ronda == 1) {

				//if this card is press, executed a action, and the same time
				//other card is press, occur a comparison between cards
				if(event.getSource() == carta1) {	
					actions(carta1,carta3,siONo1,1,ronda,1);
				}else if(event.getSource() == carta2){
					actions(carta2,carta4,siONo2,2,ronda,2);

				}else if(event.getSource() == carta3){					
					actions(carta3, carta1,siONo1,1,ronda,3);

				}else if(event.getSource() == carta4) {
					actions(carta4,carta2,siONo2,2,ronda,4);

				}
			}
			// same in the other rounds 
			if(ronda == 2) {
				if(event.getSource() == carta1) {
					actions(carta1,carta6,siONo1,1,ronda,1);
					
				}else if(event.getSource() == carta2){					
					actions(carta2,carta4,siONo2,2,ronda,2);
					
				}else if(event.getSource() == carta3){					
					actions(carta3,carta5,siONo3,3,ronda,3);				
					
				}else if(event.getSource() == carta4) {					
					actions(carta4,carta2,siONo2,2,ronda,4);										
					
				}else if(event.getSource() == carta5){					
					actions(carta5,carta3,siONo3,3,ronda,5);					
					
				}else if(event.getSource() == carta6) {					
					actions(carta6,carta1,siONo1,1,ronda,6);					
					
				}
			}
			if(ronda == 3) {
				if(event.getSource() == carta1) {
					actions(carta1,carta8,siONo1,1,ronda,1);				
					
				}else if(event.getSource() == carta2){
					actions(carta2,carta6,siONo2,2,ronda,2);					
					
				}else if(event.getSource() == carta3){
					actions(carta3,carta5,siONo3,3,ronda,3);					
					
				}else if(event.getSource() == carta4) {
					actions(carta4,carta7,siONo4,4,ronda,4);					
					
				}else if(event.getSource() == carta5){
					actions(carta5,carta3,siONo3,3,ronda,5);				
					
				}else if(event.getSource() == carta6) {
					actions(carta6,carta2,siONo2,2,ronda,6);					
					
				}else if(event.getSource() == carta7){
					actions(carta7,carta4,siONo4,4,ronda,7);
					
				}else if(event.getSource() == carta8) {
					actions(carta8,carta1,siONo1,1,ronda,8);					
					
				}
			}
			if(ronda == 4) {
				if(event.getSource() == carta1) {
					actions(carta1,carta7,siONo1,1,ronda,1);				
					
				}else if(event.getSource() == carta2){
					actions(carta2,carta3,siONo2,2,ronda,2);					
					
				}else if(event.getSource() == carta3){
					actions(carta3,carta2,siONo2,2,ronda,3);					
					
				}else if(event.getSource() == carta4) {
					actions(carta4,carta10,siONo3,3,ronda,4);					
					
				}else if(event.getSource() == carta5){
					actions(carta5,carta8,siONo4,4,ronda,5);					
					
				}else if(event.getSource() == carta6) {
					actions(carta6,carta9,siONo4,5,ronda,6);					
					
				}else if(event.getSource() == carta7){
					actions(carta7,carta1,siONo1,1,ronda,7);				
					
				}else if(event.getSource() == carta8) {
					actions(carta8,carta5,siONo4,4,ronda,8);					
					
				}else if(event.getSource() == carta9){
					actions(carta9,carta6,siONo4,5,ronda,9);				
					
				}else if(event.getSource() == carta10) {
					actions(carta10,carta4,siONo3,3,ronda,10);					
					
				}
			}
			if( ronda == 5) {
				if(event.getSource() == carta1) {
					actions(carta1,carta9,siONo1,1,ronda,1);					
					
				}else if(event.getSource() == carta2){
					actions(carta2,carta12,siONo2,2,ronda,2);					
					
				}else if(event.getSource() == carta3){
					actions(carta3,carta8,siONo3,3,ronda,3);					
					
				}else if(event.getSource() == carta4) {
					actions(carta4,carta5,siONo4,4,ronda,4);					
					
				}else if(event.getSource() == carta5){
					actions(carta5,carta4,siONo4,4,ronda,5);					
					
				}else if(event.getSource() == carta6) {
					actions(carta6,carta11,siONo5,5,ronda,6);					
					
				}else if(event.getSource() == carta7){
					actions(carta7,carta10,siONo6,6,ronda,7);					
					
				}else if(event.getSource() == carta8) {
					actions(carta8,carta3,siONo3,3,ronda,8);					
					
				}else if(event.getSource() == carta9){
					actions(carta9,carta1,siONo1,1,ronda,9);					
					
				}else if(event.getSource() == carta10) {
					actions(carta10,carta7,siONo6,6,ronda,10);					
					
				}else if(event.getSource() == carta11){
					actions(carta11,carta6,siONo5,5,ronda,11);					
					
				}else if(event.getSource() == carta12) {
					actions(carta12,carta2,siONo2,2,ronda,12);					
				}
			}
			
			
			//answer to the events by buttons revolver, ayuda, salir
			// this button exit the window
			if(event.getSource() == salir) {
				System.exit(0);
			// this button open the window help and put invisible principal window
			}else if(event.getSource() == ayuda) {
					//llamar a la ventana ayuda
				ventanaAyuda.setVisible(true);
				miMisma.setEnabled(false);
				miMisma.setVisible(false);
			//reset the game		
			}else if( event.getSource() == puntu) {
				// reinicia el jFrame
				dispose();
				GUIArcaDeNoe miVista = new GUIArcaDeNoe();				
				miVista.setVisible(true);
					
			}
			
	}
		//different options and events for the mouse
		@Override
		public void mouseClicked(MouseEvent event) {

			
		}
		public void mousePressed(MouseEvent eventMouse) {
			x= eventMouse.getX();
			y= eventMouse.getY();
		}

		/**
		 * mouseReleased. Indica un evento cuando el mouse esta sobre el area de un componente.
		 */
		
		@Override
		public void mouseReleased(MouseEvent eventMouse) {
		}

		/**
		 * mouseEntered. Indica un evento cuando se suelta un boton del mouse.
		 */
		@Override
		public void mouseEntered(MouseEvent eventMouse) {
		}
		/**
		 * mouseExited. Indica un evento cuando el mouse sale del area de un componente.
		 */
		@Override
		public void mouseExited(MouseEvent eventMouse) {
		}

		/**
		 * mouseDragged. Indica un evento cuando el mouse se oprime sobre un componente 
		 * y se mueve hacia otro lado mientras se mantiene presionado.
		 */
		
		@Override
		public void mouseDragged(MouseEvent eventMouse) { //Para desplazar la ventana

			/*El movimiento de la ventana se hace con mousePressed +mouseDragged
			 * vistaGridBagLayout.getLocation() posicion de la ventana
			 * x+eventMouseMotion.getX()-x numero de unidades que se esta moviendo el puntero
			 */
			// TODO Esbozo de método generado automáticamente
			// position of the window, number of the units thats move in x 
			setLocation(miMisma.getLocation().x +eventMouse.getX()- x ,
			//position of the window, number of the units thats move in y 
			miMisma.getLocation().y+eventMouse.getY()- y );
		}

		/**
		 * mouseMoved. Indica un evento cuando se mueve el mouse mientas está sobre un componente.
		 */
		@Override
		public void mouseMoved(MouseEvent eventMouseMotion) {
		}

	}
	
	//put in reverse the cards, for the vector that count the cards i need in the panels
	public static void puestasEnReverso(int numeroCartas) {
		for(int i=0; i < numeroCartas;i++) {
			cartitas.elementAt(i).setIcon(imagenReverse);
		}
	}
	
	// depending the round this method put in image reverse the buttons and put visible 
	public static void rondaJuego() {
		
		if(ronda == 2 ) {
			control.putVisible();
			//System.out.println("Entra");
			puestasEnReverso(6);
		}else if (ronda == 3 ) {
			control.putVisible();
			puestasEnReverso(8);
		}else if (ronda == 4 ) {
			control.putVisible();
			puestasEnReverso(10);
		}else if (ronda >= 5) {
			control.putVisible();
			puestasEnReverso(12);
			
			
		}		
	}
	
	
}	//last line