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
			// TODO Bloque catch generado autom�ticamente
			JOptionPane.showMessageDialog(null,"Upps hay un da�o en la JVM");
		}
		
		// TODO Esbozo de m�todo generado autom�ticamente
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Esbozo de m�todo generado autom�ticamente
				Rompecocos miVista = new Rompecocos();
			} ;
	});

}
	}
