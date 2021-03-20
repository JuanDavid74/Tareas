package rompecocos;

import java.awt.EventQueue;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class principalMain {

	public static void main(String[] args) {
		
		try {
			String javaLookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();
			UIManager.setLookAndFeel(javaLookAndFeel);
		} catch (Exception e) {
			// TODO Bloque catch generado automáticamente
			JOptionPane.showMessageDialog(null,"Upps hay un daño en la JVM");
		}
		
		// TODO Esbozo de método generado automáticamente
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Esbozo de método generado automáticamente
				Rompecocos miVista = new Rompecocos();
			} ;
	});

}
	}
