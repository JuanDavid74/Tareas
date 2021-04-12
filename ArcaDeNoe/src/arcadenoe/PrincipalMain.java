package arcadenoe;

import java.awt.EventQueue;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class PrincipalMain {

public static void main(String[] args) {
		
		// TODO Esbozo de método generado automáticamente
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Esbozo de método generado automáticamente
				GUIArcaDeNoe miVista = new GUIArcaDeNoe();
				//GUIArcaNoe miVista = new GUIArcaNoe();
				ControlJuego juego = new ControlJuego();
				
				//juego.comparaciones(miVista.carta1, miVista.carta2);
				
			} ;
	});


}
}
