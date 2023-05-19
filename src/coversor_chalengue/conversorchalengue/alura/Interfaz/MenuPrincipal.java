package conversorchalengue.alura.Interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import conversorchalengue.alura.control.img.CargarIcono;
import conversorchalengue.alura.control.img.PanelImagen;

public class MenuPrincipal extends JFrame {
	
	 private JFrame frame;
	 
	   public MenuPrincipal() {
	        initialize();
	    }

	    private void initialize() {
	        frame = new JFrame("Menu");
	        frame.setSize(400, 260);
	        frame.setLocationRelativeTo(null);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        CargarIcono icono = new CargarIcono();
	        frame.setIconImage(icono.getImage());
	        
	        PanelImagen PanelImagen = new PanelImagen("/conversor_chalengue/img/pexels-worldspectrum-844124.jpg");
	        frame.getContentPane().add(PanelImagen);
	        PanelImagen.setLayout(null);

	        JLabel lblOpcion = new JLabel("Ingrese opcion de conversion");
	        lblOpcion.setBounds(98, 48, 185, 27);
	        Color azulMarino = new Color(0, 0, 30);
	        int padding = 5; 
	        lblOpcion.setBorder(BorderFactory.createEmptyBorder(padding, padding, padding, padding));
	        lblOpcion.setBackground(azulMarino);
	        lblOpcion.setOpaque(true);
	        lblOpcion.setForeground(Color.WHITE);
	        lblOpcion.setFont(new Font("Tahoma", Font.PLAIN, 13));
	        PanelImagen.add(lblOpcion);

	        String[] opciones = { "Convertir Moneda", "Convertir Temperatura" };
	        JComboBox principalComboBox = new JComboBox(opciones);
	        principalComboBox.setBounds(98, 81, 185, 27);
	        principalComboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
	        PanelImagen.add(principalComboBox);

	        JButton btnPrincipalOk = new JButton("Ok");
	        btnPrincipalOk.setBounds(98, 119, 75, 25);
	        btnPrincipalOk.setFont(new Font("Tahoma", Font.PLAIN, 13));
	        PanelImagen.add(btnPrincipalOk);

	        JButton btnPrincipalCancelar = new JButton("Cerrar");
	        btnPrincipalCancelar.setBounds(191, 119, 92, 25);
	        btnPrincipalCancelar.setFont(new Font("Tahoma", Font.PLAIN, 13));
	        PanelImagen.add(btnPrincipalCancelar);

	        btnPrincipalOk.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {	
	                String seleccion = (String) principalComboBox.getSelectedItem();
	                if (seleccion.equals("Convertir Moneda")) {
	                	OpcionesMoneda opcionesMoneda = new OpcionesMoneda();//se crea la instancia de la clase
	                    opcionesMoneda.setVisible(true);//me visibilisa el jpanel moneda
	                    frame.dispose();//este me sierra el Jframe
	                } else if (seleccion.equals("Convertir Temperatura")) {
	                    OpcionesTemperatura opcionesTemperatura = new OpcionesTemperatura();//se crea la instancia de la clase
	                    opcionesTemperatura.setVisible(true);
	                    frame.dispose();//este me sierra el Jframe
	                }
	            }
	        });

	        btnPrincipalCancelar.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                principalComboBox.setSelectedIndex(0);
	                System.exit(0);
	            }
	        });;

	    }
	   //metodo para controlar el boton cancelar de la clase opcionesMoneda
		public void setVisible(boolean b) {
			frame.setVisible(b);
			
		}
}
