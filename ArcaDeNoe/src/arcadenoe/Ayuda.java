/*
 * Programación Interactiva
 * Author: Juan David Olaya - 2026223
 * Case 1 : Game Arca de Noe
 */
package arcadenoe;
//importations
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import misComponentes.Titulos;

//principal class ayuda
public class Ayuda extends JFrame {
	
	// labels for the text, where is visualized the intructions
	private JLabel texto,carta1,carta2;
	// images for comparation and guide
	private ImageIcon imagen, imagenVolver;
	// button back to the principal window
	private JButton volver;
	// escucha for the action
	private Escuchas escucha;
	// frame GUI this is used for parameter in the constructor 
	private JFrame GUIArcaDeNoe;
	
	private JFrame miYo = this;
	// titulo is used for the title 
	private Titulos titulo;
	// panel for the texts and images
	private JPanel panelVolver,panelTexto, panelImagen;
	private JTextArea tTexto;
	// string where are written the instructions
	private String textoF;
	
	// public constructor 
	public Ayuda(JFrame GUIArcaDeNoe) {
	this.GUIArcaDeNoe = GUIArcaDeNoe;
	//define the images 
	imagenVolver = new ImageIcon("src/imagenes/volver.png");
	// start the GUI
	initGUI();
	// create the default options
	this.setUndecorated(true);
	//pack();
	this.setBounds(430,490,430,490);
	this.setLocationRelativeTo(null);
	this.setResizable(false);
	this.setVisible(false);
	
}

	private void initGUI( ) {
	
	// define window container and layout 
	this.getContentPane().setLayout(new GridBagLayout());
	GridBagConstraints contraints = new GridBagConstraints();
	this.getContentPane().setBackground(new Color(99, 211, 244));
	
	//create the "Escucha"
	escucha = new Escuchas();
	
	// Title
	titulo = new Titulos("Ayuda",30, new Color(249, 157, 79) );
	titulo.setPreferredSize(new Dimension(430,50));
	titulo.addMouseListener(escucha);
    titulo.addMouseMotionListener(escucha);
    titulo.setCursor(new Cursor(Cursor.MOVE_CURSOR));
	contraints.gridx=0; // busy column
	contraints.gridy=0; // busy row
	contraints.gridwidth = 3; // width 
	contraints.gridheight = 1; // height
	contraints.fill = GridBagConstraints.HORIZONTAL; // orientation
	add(titulo,contraints); // titulo is added into container with the contrains characteristics
	
	// create the GUI
	
	panelTexto = new JPanel();
	panelTexto = new JPanel();
	panelTexto.setLayout(new GridLayout(1,1));
	panelTexto.setBorder(new EmptyBorder(10,15,10,15) );
	panelTexto.setBackground(new Color(99, 211, 244));
	

	texto = new JLabel("Instrucciones");
	texto.setFont(new Font(Font.SERIF,Font.BOLD, 35));
	texto.setHorizontalAlignment(SwingConstants.CENTER);
	texto.setForeground(Color.white);
	texto.setBackground(new Color(99, 211, 244));
	contraints.gridx=0; // busy column
	contraints.gridy=1; // busy row
	contraints.gridwidth = 3; // width 
	contraints.gridheight = 1; // height
	add(texto,contraints);
	
	
	tTexto = new JTextArea();
	tTexto.setEditable(false);
	tTexto.setLineWrap(true);
	tTexto.setFont(new Font(Font.SERIF,Font.BOLD+Font.ITALIC, 18));
	textoF = "El juego consta de varias cartas, las cuales apare-  ceran al reverso, el usuario debera voltearlas y       conseguir parejas de cartas iguales (como se mu-   estra en la imagen), de ser asi, ganara punto, sino, perdera.";
	tTexto.setBorder(new MatteBorder(5,5,5,5, new Color(249, 157, 79) ));
	tTexto.setText(textoF);
	//tTexto.setHorizontalAlignment(SwingConstants.CENTER);
	//panelTexto.add(texto);
	panelTexto.add(tTexto);
	panelTexto.setBackground(new Color(99, 211, 244));
	contraints.gridx=0; // busy column
	contraints.gridy=2; // busy row
	contraints.gridwidth = 3; // width 
	contraints.gridheight = 1; // height
	//contraints.fill = GridBagConstraints.HORIZONTAL;
	add(panelTexto,contraints);
	
	
	panelImagen = new JPanel();
	panelImagen.setLayout(new GridLayout(1,2));
	panelImagen.setBorder(new EmptyBorder(10,15,10,15) );

	imagen = new ImageIcon("src/imagenes/1.png");
	carta1 = new JLabel(imagen);
	carta1.setBorder(new MatteBorder(5,5,5,2, new Color(249, 157, 79) ));
	imagen = new ImageIcon("src/imagenes/1.png");
	carta2 = new JLabel(imagen);
	carta2.setBorder(new MatteBorder(5,3,5,5, new Color(249, 157, 79) ));
	panelImagen.add(carta1);
	panelImagen.add(carta2);
	panelImagen.setBackground(new Color(99, 211, 244));
	contraints.gridx=0; // busy column
	contraints.gridy=3; // busy row
	contraints.gridwidth = 3; // width 
	contraints.gridheight = 1; // height
	contraints.fill = GridBagConstraints.CENTER;
	add(panelImagen,contraints);
	
	
	panelVolver = new JPanel();
	panelVolver.setLayout(new GridLayout(1,1));
	panelVolver.setBorder(new EmptyBorder(10,15,10,15) );
	
	volver = new JButton(imagenVolver);
	volver.setBorder(null);
	volver.addActionListener(escucha);
	volver.setBorder(new MatteBorder(3,3,3,3, new Color(99, 211, 244)));
	volver.setPreferredSize(new Dimension(80,40));
	panelVolver.add(volver);
	panelVolver.setBackground(new Color(99, 211, 244));
	contraints.gridx=0; // busy column
	contraints.gridy=4; // busy row
	contraints.gridwidth = 3; // width 
	contraints.gridheight = 1; // height
	contraints.fill = GridBagConstraints.CENTER;
	add(panelVolver,contraints);
	
	
}
	
	private class Escuchas extends MouseAdapter implements ActionListener,MouseListener, MouseMotionListener{
		private int x,y;
		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Esbozo de método generado automáticamente
			
			// only exist a button in this case, it is press, the actions
			// or events are, put invisible this window
				GUIArcaDeNoe.setEnabled(true);
				GUIArcaDeNoe.setVisible(true);
				setVisible(false);

			
		}
		
		public void mousePressed(MouseEvent eventMouse) {
			x= eventMouse.getX();
			y= eventMouse.getY();			
		
		}
		
		public void mouseDragged(MouseEvent eventMouse) { //Para desplazar la ventana

			/*El movimiento de la ventana se hace con mousePressed +mouseDragged
			 * vistaGridBagLayout.getLocation() posicion de la ventana
			 * x+eventMouseMotion.getX()-x numero de unidades que se esta moviendo el puntero
			 */
			// TODO Esbozo de método generado automáticamente
			// position of the window, number of the units thats move in x 
			setLocation(miYo.getLocation().x +eventMouse.getX()- x ,
			//position of the window, number of the units thats move in y 
					miYo.getLocation().y+eventMouse.getY()- y );
		}
		
	}
	
}
