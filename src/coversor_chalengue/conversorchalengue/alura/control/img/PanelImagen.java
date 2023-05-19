package conversorchalengue.alura.control.img;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelImagen extends JPanel {
	
	private Image panel;

    public PanelImagen(String imagePath) {
    	panel = new ImageIcon(getClass().getResource(imagePath)).getImage();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(panel, 0, 0, getWidth(), getHeight(), this);
    }

}
