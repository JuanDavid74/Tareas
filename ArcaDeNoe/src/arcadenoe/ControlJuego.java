package arcadenoe;

import java.util.Random;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
// clases principal of the control 
public class ControlJuego {
    // integer of round and score
	private int ronda, score;
    // more integers for the control
	public int num1,num2,cCarta;  
    // 
	public static final int[] image= {1,2,3,4,5,6};
    // integers static for the variables 
	public static int var1,var2,var,v,v2,v3,v4,v5,v6;
   // int for score in text field
	public int punta = 0,puntajes;
    // vector for numbers of images
	private Vector<Integer> numImages = new Vector<Integer>();
    // vector for the images
	private Vector<ImageIcon> imagesE = new Vector<ImageIcon>();
    // image icon static
	private ImageIcon img,imagenBuffer2,imagenBuffer3,imagenBuffer4,imagenBuffer5,imagenBuffer6;
    //Declaration of the GUI in control of the images and buttons
	public static ImageIcon imagen,imgRev,imgc1,imgc2,imgc3,imgc4,imgc5,imgc6,imgc7,imgc8,imgc9,imgc10,imgc11,imgc12;
    // numbers for every button
	public int cont1,cont2,cont3,cont4,cont5,cont6;
    // division in the method perdióPunto
	public static int cona1,cona2,cona3,cona4,cona5,cona6,cona7,cona8,cona9,cona10,cona11,cona12;
	//constructor of the method
	public ControlJuego() {
		
// initialized cons 
		cona1=1;cona2=1;cona3=1;cona4=1;cona5=1;cona6=1;cona7=1;cona8=1;cona9=1;cona10=1;cona11=1;cona12=1;
// add numbers for the images in the vector
		numImages.add(1);
		numImages.add(2);
		numImages.add(3);
		numImages.add(4);
		numImages.add(5);
		numImages.add(6);
		numImages.add(7);
		numImages.add(8);
		numImages.add(9);
		numImages.add(10);
		numImages.add(11);
		numImages.add(12);
		//establish the images and the method getRandom for other occasion
		v = getRandom();
        img = new ImageIcon("src/imagenes/"+String.valueOf(v)+".png");
        // create a random for the image buffer
        v2 = getRandom();
        imagenBuffer2 = new ImageIcon("src/imagenes/"+String.valueOf(v2)+".png");
        v3 = getRandom();
        imagenBuffer3 = new ImageIcon("src/imagenes/"+String.valueOf(v3)+".png");
        v4 = getRandom();
        imagenBuffer4 = new ImageIcon("src/imagenes/"+String.valueOf(v4)+".png");
        v5 = getRandom();
        imagenBuffer5 = new ImageIcon("src/imagenes/"+String.valueOf(v5)+".png");
        v6 = getRandom();
        imagenBuffer6 = new ImageIcon("src/imagenes/"+String.valueOf(v6)+".png");
		
		imgRev = new ImageIcon();
		//ImageIcon = new ImageIcon("src/imagenes/locked.png");
		//contador = 1;
		cont1=1;cont2=1;cont3=1;cont4=1;cont5=1;cont6=1;
		ronda = 1;
		score = 0;
		
		
		
	}
	// this method fill the vector with numbers of the images
	public void rellenarVector() {
        for(int i=1; i<13; i++) {
        	numImages.add(i);
        }
    }

	// generate a random numbers in the range
	public int getRandom() {
// number 
        Random aleatorio = new Random(); //Instancia un objeto tipo Random
        cCarta  = aleatorio.nextInt(numImages.size()); //Numero aleatorio entre 1 y 8 [1,8]
        var1 = numImages.elementAt(cCarta);
// eliminating the variables, for this doesnt repeats
       eliminar(var1);
        if(numImages.size() == 0) {
        	rellenarVector();
        }
        return var1;
    }

	
	
	// this method put a image random on a button
	public ImageIcon putAnImage(JButton c1) {
		var = getRandom();
		imagen = new ImageIcon("src/imagenes/"+String.valueOf(var)+".png");  
		c1.setIcon(imagen);
		imagesE.add(imagen);
		return imagen;
	} 

    // receive a two buttons and compare this images, depending on images, this put the image or icon card
    private void codigoRemp(JButton c1, JButton c2, boolean yesOrNo, int v, ImageIcon img) {
    	// make the compare 
        if(c2.getIcon() == GUIArcaDeNoe.imagenReverse) {
            if(yesOrNo == true) {
                c1.setIcon(img);
                yesOrNo = false;
            }else{
                c1.setIcon(img);
            }
        }else if(c2.getIcon() != GUIArcaDeNoe.imagenReverse){
            c1.setIcon(c2.getIcon());
        }
    }

    // make the codigoRemp in every card, with a respective number 	
    public void comparaciones(JButton c1, JButton c2, boolean yesOrNo, int n) {
        if(n == 1) {
            codigoRemp(c1, c2, yesOrNo, v, img);
        }
        if(n == 2){
            codigoRemp(c1, c2, yesOrNo, v2, imagenBuffer2);
        }
        if(n == 3) {
            codigoRemp(c1, c2, yesOrNo, v3, imagenBuffer3);
        }
        if(n == 4) {
            codigoRemp(c1, c2, yesOrNo, v4, imagenBuffer4);
        }
        if(n == 5) {
            codigoRemp(c1, c2, yesOrNo, v5, imagenBuffer5);
        }
        if(n == 6) {
            codigoRemp(c1, c2, yesOrNo, v6, imagenBuffer6);
        }

    }
    
	// received a element and delete of the vector
    public void eliminar(int elemento) {
    	for (int i = 0; i < numImages.size(); i++) {
    		if (numImages.elementAt(i)== elemento) {
    			numImages.remove(i);
    		}
    	}
    }
	
    // wait a determine time and put an image in a card
    public void tiempoEspera(JButton c) {
    	//instructions try catch for the wrong 
    	try {

    		if(c.getIcon() != GUIArcaDeNoe.imagenReverse){ 
    			//  timer wait 
    			Thread.sleep(0);	
    			c.setIcon(GUIArcaDeNoe.imagenReverse);
    			
    		}
    	}catch (InterruptedException ie){
    			// kind of the exception
    		Thread.currentThread().interrupt();
    	}
    		GUIArcaDeNoe.timerWait.stop();
    }
	
    // if two cards are the same image, they become invisible, for this round
	public void puntoForCambio(JButton l1, JButton l2) {
	
		if(l1.getIcon() == l2.getIcon() && l1.getIcon() != GUIArcaDeNoe.imagenReverse && l2.getIcon() != GUIArcaDeNoe.imagenReverse) {			
			l1.setVisible(false);
			l2.setVisible(false);
			GUIArcaDeNoe.timerWait.stop();
		}
	}

	// all the compares between images, work by the rounds
	public void compararImagen(int rondaCartas, int con) {
		// this declarations are used for simplify the code
		imgRev = GUIArcaDeNoe.imagenReverse;
		imgc1 = (javax.swing.ImageIcon) GUIArcaDeNoe.carta1.getIcon();
		imgc2 = (javax.swing.ImageIcon) GUIArcaDeNoe.carta2.getIcon();
		imgc3 = (javax.swing.ImageIcon) GUIArcaDeNoe.carta3.getIcon();
		imgc4 = (javax.swing.ImageIcon) GUIArcaDeNoe.carta4.getIcon();
		imgc5 = (javax.swing.ImageIcon) GUIArcaDeNoe.carta5.getIcon();
		imgc6 = (javax.swing.ImageIcon) GUIArcaDeNoe.carta6.getIcon();
		imgc7 = (javax.swing.ImageIcon) GUIArcaDeNoe.carta7.getIcon();
		imgc8 = (javax.swing.ImageIcon) GUIArcaDeNoe.carta8.getIcon();
		imgc9 = (javax.swing.ImageIcon) GUIArcaDeNoe.carta9.getIcon();
		imgc10 = (javax.swing.ImageIcon) GUIArcaDeNoe.carta10.getIcon();
		imgc11 = (javax.swing.ImageIcon) GUIArcaDeNoe.carta11.getIcon();
		imgc12 = (javax.swing.ImageIcon) GUIArcaDeNoe.carta12.getIcon();
		//compare the card in round 1 
		if(rondaCartas == 1 ){
			if((imgc1 != imgRev && imgc3 != imgRev) || ( imgc2 != imgRev && imgc4 != imgRev))  {
				ganoPunto();			
			}
				perdioPunto(con);
			

		}if(rondaCartas == 2 ) {
			if( (imgc1 != imgRev && imgc6 != imgRev) || ( imgc2 != imgRev && imgc4 != imgRev) || ( imgc3 != imgRev && imgc5 != imgRev) ) {			
				ganoPunto();
			}else {
				perdioPunto(con);
			}
				// if imagen is different to IMGreverse y his twin equal, the user win five points	
		}else if(rondaCartas == 3 ) {
			if ( (imgc1 != imgRev && imgc8 != imgRev) || ( imgc2 != imgRev && imgc6 != imgRev) || ( imgc3 != imgRev && imgc5 != imgRev) || ( imgc4 != imgRev && imgc7 != imgRev) ) {
				ganoPunto();
			}
			perdioPunto(con);
		}else if(rondaCartas == 4 ) { 
			if((imgc1 != imgRev && imgc7 != imgRev) || ( imgc2 != imgRev && imgc3 != imgRev) || ( imgc4 != imgRev && imgc10 != imgRev)) {
				ganoPunto();
			}else if((imgc5 != imgRev && imgc8 != imgRev) || ( imgc6 != imgRev && imgc9 != imgRev) ) {
				ganoPunto();
			}
				perdioPunto(con);
		}else if(rondaCartas >= 5) {
			if((imgc1 != imgRev && imgc9 != imgRev) || ( imgc2 != imgRev && imgc12 != imgRev) || ( imgc3 != imgRev && imgc8 != imgRev)) {
				ganoPunto();
			}else if((imgc4 != imgRev && imgc5 != imgRev) || ( imgc6 != imgRev && imgc11 != imgRev) || ( imgc7 != imgRev && imgc10 != imgRev)) {
				ganoPunto();
			}
				perdioPunto(con);
		}
		
		GUIArcaDeNoe.score.setText(String.valueOf(GUIArcaDeNoe.puntaje));
		//GUIArcaDeNoe.timerCompar.stop();
	}

	
	//depending the card is press rest a point in the score
	public void perdioPunto(int con) {
	if(con == 1) {			
		if(cona1 == 1) { cona1=0;
			//System.out.println("Entra: ");
		}else {GUIArcaDeNoe.score.setText(String.valueOf(GUIArcaDeNoe.puntaje -= 1));
			/*System.out.println("Resta ");*/} 		
	}else if(con == 2) {
		if(cona2 == 1) { cona2 = 0;			
		}else { GUIArcaDeNoe.score.setText(String.valueOf(GUIArcaDeNoe.puntaje -= 1));}		
	}else if(con == 3) {
		if(cona3== 1) {cona3 = 0;
		}else {GUIArcaDeNoe.score.setText(String.valueOf(GUIArcaDeNoe.puntaje -= 1));}		
	}else if(con == 4) {
		if(cona4== 1) {	cona4 = 0;
		}else {	GUIArcaDeNoe.score.setText(String.valueOf(GUIArcaDeNoe.puntaje -= 1));}		
	}else if(con == 5) {
		if(cona5== 1) {cona5 = 0;
		}else {GUIArcaDeNoe.score.setText(String.valueOf(GUIArcaDeNoe.puntaje -= 1));}	
	}else if(con == 6) {
		if(cona6== 1) {	cona6 = 0;
		}else {GUIArcaDeNoe.score.setText(String.valueOf(GUIArcaDeNoe.puntaje -= 1));}	
	}else if(con == 7) {
		if(cona7== 1) {	cona7 = 0;
		}else {GUIArcaDeNoe.score.setText(String.valueOf(GUIArcaDeNoe.puntaje -= 1));}	
	}else if(con == 8) {
		if(cona8== 1) {	cona8 = 0;
		}else {GUIArcaDeNoe.score.setText(String.valueOf(GUIArcaDeNoe.puntaje -= 1));}	
	}else if(con == 9) {
		if(cona9== 1) {	cona9 = 0;
		}else {GUIArcaDeNoe.score.setText(String.valueOf(GUIArcaDeNoe.puntaje -= 1));}	
	}else if(con == 10) {
		if(cona10== 1) {cona10 = 0;
		}else {GUIArcaDeNoe.score.setText(String.valueOf(GUIArcaDeNoe.puntaje -= 1));}	
	}else if(con == 11) {
		if(cona11== 1) {cona11 = 0;
		}else {GUIArcaDeNoe.score.setText(String.valueOf(GUIArcaDeNoe.puntaje -= 1));}	
	}else if(con == 12) {
		if(cona12== 1) {cona12 = 0;
		}else {GUIArcaDeNoe.score.setText(String.valueOf(GUIArcaDeNoe.puntaje -= 1));}	
	}
	
	}
	
	// if the compare is true, the user win 5 points
	public void ganoPunto() {
	
		GUIArcaDeNoe.puntaje += 5;
		GUIArcaDeNoe.score.setText(String.valueOf(punta));
		//GUIArcaDeNoe.timerCompar.stop();
		
		
	}
	//Council two methods, it is executed in a determine time
	// for example if one card isnt his pair, wait 2 seconds and put the image reverse
	public void lockedCarta() {
		// for any round make the compare and time
		if(GUIArcaDeNoe.ronda == 1) {
			puntoForCambio(GUIArcaDeNoe.carta1, GUIArcaDeNoe.carta3);
			puntoForCambio(GUIArcaDeNoe.carta2,GUIArcaDeNoe.carta4);

			tiempoEspera(GUIArcaDeNoe.carta1);
			tiempoEspera(GUIArcaDeNoe.carta2);
			tiempoEspera(GUIArcaDeNoe.carta3);
			tiempoEspera(GUIArcaDeNoe.carta4);	
			
		}else if(GUIArcaDeNoe.ronda == 2) {
			puntoForCambio(GUIArcaDeNoe.carta1, GUIArcaDeNoe.carta6);
			puntoForCambio(GUIArcaDeNoe.carta2,GUIArcaDeNoe.carta4);
			puntoForCambio(GUIArcaDeNoe.carta3, GUIArcaDeNoe.carta5);
						
			tiempoEspera(GUIArcaDeNoe.carta1);
			tiempoEspera(GUIArcaDeNoe.carta2);
			tiempoEspera(GUIArcaDeNoe.carta3);
			tiempoEspera(GUIArcaDeNoe.carta4);	
			tiempoEspera(GUIArcaDeNoe.carta5);
			tiempoEspera(GUIArcaDeNoe.carta6);	
		}else if(GUIArcaDeNoe.ronda == 3) {
			puntoForCambio(GUIArcaDeNoe.carta1, GUIArcaDeNoe.carta8);
			puntoForCambio(GUIArcaDeNoe.carta2,GUIArcaDeNoe.carta6);
			puntoForCambio(GUIArcaDeNoe.carta3, GUIArcaDeNoe.carta5);
			puntoForCambio(GUIArcaDeNoe.carta4, GUIArcaDeNoe.carta7);
			
			tiempoEspera(GUIArcaDeNoe.carta1);
			tiempoEspera(GUIArcaDeNoe.carta2);
			tiempoEspera(GUIArcaDeNoe.carta3);
			tiempoEspera(GUIArcaDeNoe.carta4);	
			tiempoEspera(GUIArcaDeNoe.carta5);
			tiempoEspera(GUIArcaDeNoe.carta6);	
			tiempoEspera(GUIArcaDeNoe.carta7);
			tiempoEspera(GUIArcaDeNoe.carta8);
		}else if(GUIArcaDeNoe.ronda == 4) {
			puntoForCambio(GUIArcaDeNoe.carta1, GUIArcaDeNoe.carta7);
			puntoForCambio(GUIArcaDeNoe.carta2,GUIArcaDeNoe.carta3);
			puntoForCambio(GUIArcaDeNoe.carta4, GUIArcaDeNoe.carta10);
			puntoForCambio(GUIArcaDeNoe.carta5, GUIArcaDeNoe.carta8);
			puntoForCambio(GUIArcaDeNoe.carta6, GUIArcaDeNoe.carta9);
			
			tiempoEspera(GUIArcaDeNoe.carta1);
			tiempoEspera(GUIArcaDeNoe.carta2);
			tiempoEspera(GUIArcaDeNoe.carta3);
			tiempoEspera(GUIArcaDeNoe.carta4);	
			tiempoEspera(GUIArcaDeNoe.carta5);
			tiempoEspera(GUIArcaDeNoe.carta6);	
			tiempoEspera(GUIArcaDeNoe.carta7);
			tiempoEspera(GUIArcaDeNoe.carta8);
			tiempoEspera(GUIArcaDeNoe.carta9);
			tiempoEspera(GUIArcaDeNoe.carta10);	
			
		}else if(GUIArcaDeNoe.ronda >= 5 ) {
			puntoForCambio(GUIArcaDeNoe.carta1, GUIArcaDeNoe.carta9);
			puntoForCambio(GUIArcaDeNoe.carta2,GUIArcaDeNoe.carta12);
			puntoForCambio(GUIArcaDeNoe.carta3, GUIArcaDeNoe.carta8);
			puntoForCambio(GUIArcaDeNoe.carta4, GUIArcaDeNoe.carta5);
			puntoForCambio(GUIArcaDeNoe.carta6, GUIArcaDeNoe.carta11);
			puntoForCambio(GUIArcaDeNoe.carta7, GUIArcaDeNoe.carta10);
			
			tiempoEspera(GUIArcaDeNoe.carta1);
			tiempoEspera(GUIArcaDeNoe.carta2);
			tiempoEspera(GUIArcaDeNoe.carta3);
			tiempoEspera(GUIArcaDeNoe.carta4);	
			tiempoEspera(GUIArcaDeNoe.carta5);
			tiempoEspera(GUIArcaDeNoe.carta6);	
			tiempoEspera(GUIArcaDeNoe.carta7);
			tiempoEspera(GUIArcaDeNoe.carta8);
			tiempoEspera(GUIArcaDeNoe.carta9);
			tiempoEspera(GUIArcaDeNoe.carta10);	
			tiempoEspera(GUIArcaDeNoe.carta11);
			tiempoEspera(GUIArcaDeNoe.carta12);	
			
		}
	}
	
	// this method is executed every time, because needed know the score for level up
	// and when the level up change the round and the cards visible are more
	public void subioDeNivel() {
		if(GUIArcaDeNoe.ronda == 1) {
			
			GUIArcaDeNoe.ronda = 1;
			GUIArcaDeNoe.jRonda.setText(String.valueOf(1));
			GUIArcaDeNoe.rondaJuego();		
		}if( GUIArcaDeNoe.carta1.isVisible() == false && GUIArcaDeNoe.carta2.isVisible()== false &&
				GUIArcaDeNoe.carta3.isVisible()== false && GUIArcaDeNoe.carta4.isVisible()== false &&
				GUIArcaDeNoe.carta5.isVisible() == true) {
			cona1=1;cona2=1;cona3=1;cona4=1;
			GUIArcaDeNoe.ronda = 2; 
			GUIArcaDeNoe.jRonda.setText(String.valueOf(2));
			GUIArcaDeNoe.rondaJuego();
		}if(GUIArcaDeNoe.carta1.isVisible() == false && GUIArcaDeNoe.carta2.isVisible()== false &&
			GUIArcaDeNoe.carta3.isVisible()== false && GUIArcaDeNoe.carta4.isVisible()== false &&
			GUIArcaDeNoe.carta5.isVisible()== false && GUIArcaDeNoe.carta6.isVisible()== false &&
			GUIArcaDeNoe.carta7.isVisible() == true ) {
			cona1=1;cona2=1;cona3=1;cona4=1;cona5=1;cona6=1;
			GUIArcaDeNoe.ronda = 3;
			GUIArcaDeNoe.jRonda.setText(String.valueOf(3));
			GUIArcaDeNoe.rondaJuego();
		}if(GUIArcaDeNoe.carta1.isVisible() == false && GUIArcaDeNoe.carta2.isVisible()== false &&
				GUIArcaDeNoe.carta3.isVisible()== false && GUIArcaDeNoe.carta4.isVisible()== false &&
				GUIArcaDeNoe.carta5.isVisible()== false && GUIArcaDeNoe.carta6.isVisible()== false &&
				GUIArcaDeNoe.carta7.isVisible() == false && GUIArcaDeNoe.carta8.isVisible()== false &&
				GUIArcaDeNoe.carta9.isVisible()== true) {
			cona1=1;cona2=1;cona3=1;cona4=1;cona5=1;cona6=1;cona7=1;cona8=1;;
			GUIArcaDeNoe.ronda = 4;
			GUIArcaDeNoe.jRonda.setText(String.valueOf(4));
			GUIArcaDeNoe.rondaJuego();
		}if(GUIArcaDeNoe.carta1.isVisible() == false && GUIArcaDeNoe.carta2.isVisible()== false &&
			GUIArcaDeNoe.carta3.isVisible()== false && GUIArcaDeNoe.carta4.isVisible()== false &&
			GUIArcaDeNoe.carta5.isVisible()== false && GUIArcaDeNoe.carta6.isVisible()== false &&
			GUIArcaDeNoe.carta7.isVisible() == false && GUIArcaDeNoe.carta8.isVisible()== false && 
			GUIArcaDeNoe.carta9.isVisible() == false && GUIArcaDeNoe.carta10.isVisible()== false && GUIArcaDeNoe.carta11.isVisible()== true) {
			cona1=1;cona2=1;cona3=1;cona4=1;cona5=1;cona6=1;cona7=1;cona8=1;cona9=1;cona10=1;cona11=1;cona12=1;
			GUIArcaDeNoe.ronda = 5;
			GUIArcaDeNoe.jRonda.setText(String.valueOf(5));
			GUIArcaDeNoe.rondaJuego();
			
		}if(GUIArcaDeNoe.carta1.isVisible() == false && GUIArcaDeNoe.carta2.isVisible()== false &&
				GUIArcaDeNoe.carta3.isVisible()== false && GUIArcaDeNoe.carta4.isVisible()== false &&
				GUIArcaDeNoe.carta5.isVisible()== false && GUIArcaDeNoe.carta6.isVisible()== false &&
				GUIArcaDeNoe.carta7.isVisible() == false && GUIArcaDeNoe.carta8.isVisible()== false && 
				GUIArcaDeNoe.carta9.isVisible() == false && GUIArcaDeNoe.carta10.isVisible()== false) {
				cona1=1;cona2=1;cona3=1;cona4=1;cona5=1;cona6=1;cona7=1;cona8=1;cona9=1;cona10=1;cona11=1;cona12=1;
				GUIArcaDeNoe.ronda = 5;
				GUIArcaDeNoe.jRonda.setText(String.valueOf(5));
				GUIArcaDeNoe.rondaJuego();
				
			}
		
	}

	// put visible the card dependig the round
	public void putVisible( ) {
			
		if(GUIArcaDeNoe.ronda == 2) {
			GUIArcaDeNoe.carta1.setVisible(true);
			GUIArcaDeNoe.carta2.setVisible(true);
			GUIArcaDeNoe.carta3.setVisible(true);
			GUIArcaDeNoe.carta4.setVisible(true);
		}else if(GUIArcaDeNoe.ronda == 3) {
			GUIArcaDeNoe.carta1.setVisible(true);
			GUIArcaDeNoe.carta2.setVisible(true);
			GUIArcaDeNoe.carta3.setVisible(true);
			GUIArcaDeNoe.carta4.setVisible(true);
			GUIArcaDeNoe.carta5.setVisible(true);
			GUIArcaDeNoe.carta6.setVisible(true);
		}else if(GUIArcaDeNoe.ronda == 4 ) {
			GUIArcaDeNoe.carta1.setVisible(true);
			GUIArcaDeNoe.carta2.setVisible(true);
			GUIArcaDeNoe.carta3.setVisible(true);
			GUIArcaDeNoe.carta4.setVisible(true);
			GUIArcaDeNoe.carta5.setVisible(true);
			GUIArcaDeNoe.carta6.setVisible(true);
			GUIArcaDeNoe.carta7.setVisible(true);
			GUIArcaDeNoe.carta8.setVisible(true);

		}else if(GUIArcaDeNoe.ronda >= 5 ) {
			GUIArcaDeNoe.carta1.setVisible(true);
			GUIArcaDeNoe.carta2.setVisible(true);
			GUIArcaDeNoe.carta3.setVisible(true);
			GUIArcaDeNoe.carta4.setVisible(true);
			GUIArcaDeNoe.carta5.setVisible(true);
			GUIArcaDeNoe.carta6.setVisible(true);
			GUIArcaDeNoe.carta7.setVisible(true);
			GUIArcaDeNoe.carta8.setVisible(true);
			GUIArcaDeNoe.carta9.setVisible(true);
			GUIArcaDeNoe.carta10.setVisible(true);
			GUIArcaDeNoe.carta11.setVisible(true);
			GUIArcaDeNoe.carta12.setVisible(true);
		}
	}

}