package conversorchalengue.alura.control.img;

import java.awt.Image;

import javax.swing.ImageIcon;

public class CargarIcono {
	
	 public Image getImage() {
	        ImageIcon javaIcono = new ImageIcon(getClass().getResource("/conversor_chalengue/img/java.png"));
	        Image iconoRedimensionado = javaIcono.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
	        return iconoRedimensionado;
	        }
}
