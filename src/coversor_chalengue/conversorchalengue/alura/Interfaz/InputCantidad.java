package conversorchalengue.alura.Interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conversorchalengue.alura.apiexterna.ExchangeRatesApp;
import conversorchalengue.alura.control.img.CargarIcono;
import conversorchalengue.alura.control.img.PanelImagen;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class InputCantidad extends JFrame {

	private double cantidad;
	private String de;
	private String hasta;
	private JTextPane textPane; 

	public String getDe() {
		return de;
	}

	public void setDe(String de) {
		this.de = de;
	}

	public String getHasta() {
		return hasta;
	}

	public void setHasta(String hasta) {
		this.hasta = hasta;
	}

	private JPanel contentPane;

    public InputCantidad() {
        setTitle("Cantidad a covertir");
        setSize(400, 260);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CargarIcono icono = new CargarIcono();
        setIconImage(icono.getImage());
        
        contentPane = new PanelImagen("/conversor_chalengue/img/pexels-worldspectrum-844124.jpg");
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPane);
        contentPane.setLayout(null);
        
        setContentPane(contentPane);
        contentPane.setLayout(null);
        textPane = new JTextPane();
        textPane.setBounds(98, 81, 185, 27);
        contentPane.add(textPane);

        JLabel lblInput = new JLabel("Ingrese cantidad a convertir");
        lblInput.setBounds(98, 48, 185, 27);
        Color azulMarino = new Color(0, 0, 30);
        int padding = 5; 
        lblInput.setBorder(BorderFactory.createEmptyBorder(padding, padding, padding, padding));
        lblInput.setBackground(azulMarino);
        lblInput.setOpaque(true);
        lblInput.setForeground(Color.WHITE);
        contentPane.add(lblInput);
       
        JButton btnInputOk = new JButton("Ok");
        btnInputOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Rescato o capturo el valor del textPane
                String cantidadStr = textPane.getText();
                if (cantidadStr.matches("\\d+")) {
                	cantidad = Double.parseDouble(cantidadStr);
                	   ExchangeRatesApp ventanaApi = new ExchangeRatesApp();
                       ventanaApi.setDe(getDe());
                       ventanaApi.setHasta(getHasta());
                       ventanaApi.setCantidad(cantidad);
                       ventanaApi.getExchangeRates();
                       // Llamo a un método que obtiene los datos de la API y espera a que se completen
                       ventanaApi.obtenerDatosAPI();
                       // Obtengo el resultado de la API
                       double campoDeseado = ventanaApi.obtenerDatosAPI();
                       // Llamo a la clase RespuestaDivisa para mostrar respuesta al usuario
                       RespuestaDivisa frame = new RespuestaDivisa();
                       frame.actualizarResultado(campoDeseado); // Pasa el resultado como argumento
                       frame.setVisible(true);
                       dispose();
                }else {
                	JOptionPane.showMessageDialog(null, "Valor no válido. Debe ingresar solo números.", "Error", JOptionPane.ERROR_MESSAGE);
                	textPane.setText("");
                }
            }
        });
        btnInputOk.setBounds(98, 119, 75, 25);
        contentPane.add(btnInputOk);

        JButton btnInputCAnceler = new JButton("Cancelar");
        btnInputCAnceler.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                OpcionesMoneda mostrar=new OpcionesMoneda();
                mostrar.setVisible(true);
            }
        });
        btnInputCAnceler.setBounds(191, 119, 92, 25);
        contentPane.add(btnInputCAnceler);
    }
}

