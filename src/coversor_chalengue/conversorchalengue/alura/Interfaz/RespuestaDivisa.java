package conversorchalengue.alura.Interfaz;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import conversorchalengue.alura.control.img.CargarIcono;
import conversorchalengue.alura.control.img.PanelImagen;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RespuestaDivisa extends JFrame {

    private JLabel lblRespuestaDivisa;

    public RespuestaDivisa() {
    	 setTitle("Respuesta");
         setSize(300, 160);
         setLocationRelativeTo(null);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         CargarIcono icono = new CargarIcono();
         setIconImage(icono.getImage());
       
        PanelImagen panelImagen = new PanelImagen("/conversor_chalengue/img/kelly-sikkema-4xHgz_ZllQs-unsplash.jpg");
        getContentPane().add(panelImagen);
        panelImagen.setLayout(null);
        
        lblRespuestaDivisa = new JLabel();
        lblRespuestaDivisa.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblRespuestaDivisa.setBackground(Color.WHITE);
        lblRespuestaDivisa.setOpaque(true);
        int padding = 5; 
        lblRespuestaDivisa.setBorder(BorderFactory.createEmptyBorder(padding, padding, padding, padding));
        lblRespuestaDivisa.setBounds(69, 52, 160, 24);
        lblRespuestaDivisa.setHorizontalAlignment(SwingConstants.CENTER);
        panelImagen.add(lblRespuestaDivisa);
        
        JLabel lblRespuestaDivisa_1 = new JLabel();
        lblRespuestaDivisa_1.setFont(new Font("Calibri", Font.BOLD, 14));
        lblRespuestaDivisa_1.setText("El cambio de su  divisa es :");
        Color azulMarino = new Color(0, 0, 30);
        lblRespuestaDivisa_1.setBackground(UIManager.getColor("CheckBox.focus"));
        lblRespuestaDivisa.setOpaque(true);
        lblRespuestaDivisa_1.setForeground(Color.WHITE);
        lblRespuestaDivisa_1.setToolTipText("");
        lblRespuestaDivisa_1.setBounds(75, 30, 154, 24);
        lblRespuestaDivisa_1.setHorizontalAlignment(SwingConstants.CENTER);
        panelImagen.add(lblRespuestaDivisa_1);
        
        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//para pasar de ingles al español
        		UIManager.put("OptionPane.yesButtonText", "Sí");
                UIManager.put("OptionPane.noButtonText", "No");
                UIManager.put("OptionPane.cancelButtonText", "Cancelar");

                UIManager.put("OptionPane.questionIcon", new ImageIcon(icono.getImage()));

                int opcion = JOptionPane.showConfirmDialog(null, "¿Desea continuar usando el programa?", "Confirmación",
                        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        		
                      if (opcion == JOptionPane.YES_OPTION) {
                    	  
                          // Regresar al menú principal para escoger otra opción de conversión
                    	  MenuPrincipal PantallaPrincipal = new MenuPrincipal();
                          PantallaPrincipal.setVisible(true);
                          RespuestaDivisa.this.dispose();
                          
                      } else {
                    	  UIManager.put("OptionPane.warningIcon", new ImageIcon(icono.getImage()));
                          JOptionPane.showMessageDialog(null, "Programa Finalizado");
                          System.exit(0);
                      }
        	}
        });
        btnCerrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnCerrar.setBounds(98, 87, 94, 23);
        panelImagen.add(btnCerrar);
    }
    // Método para actualizar el contenido del JLabel con el resultado obtenido de ExchangeRatesApp
    public void actualizarResultado(double resultado) { // Acepta el resultado como argumento
    	
        String valorString = Double.toString(resultado);
        lblRespuestaDivisa.setText(valorString);
    }
}
