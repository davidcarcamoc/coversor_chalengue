package conversorchalengue.alura.Interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import conversorchalengue.alura.control.img.CargarIcono;
import conversorchalengue.alura.control.img.PanelImagen;

public class OpcionesMoneda extends JFrame {

    private JComboBox<String> comboBox;
    private String deOpcion;
    private  String hastaOpcion; 
    
    public OpcionesMoneda() {
    	
        setTitle("Tipo de Cambio");
        setSize(400, 260);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CargarIcono icono = new CargarIcono();
        setIconImage(icono.getImage());

        PanelImagen PanelImagen = new PanelImagen("/conversor_chalengue/img/pexels-worldspectrum-844124.jpg");
        setContentPane(PanelImagen);
        PanelImagen.setLayout(null);
        
        setPreferredSize(new Dimension(368, 287));
        String[] opciones = { "Lempira a Dolar", "Lempira a Euro", "Lempira a Libras", "Lempira a Yen",
                "Dolar a Lempira", "Euro a Lempira", "Libras a Lempira", "Yen a Lempira" };

        getContentPane().setLayout(null);
        comboBox = new JComboBox<String>(opciones);
        comboBox.setBounds(98, 81, 185, 27);
        getContentPane().add(comboBox);
        
        JLabel lblTipoCambio = new JLabel("Ingrese el tipo de cambio");
        Color azulMarino = new Color(0, 0, 30);
        lblTipoCambio.setBackground(azulMarino);
        int padding = 5; 
        lblTipoCambio.setBorder(BorderFactory.createEmptyBorder(padding, padding, padding, padding));        
        lblTipoCambio.setOpaque(true);
        lblTipoCambio.setForeground(Color.WHITE);
        lblTipoCambio.setBounds(98, 48, 185, 27);
        getContentPane().add(lblTipoCambio);
        
        JButton btnMonedaOk = new JButton("OK");
        btnMonedaOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnMonedaOk) {
                	//instancia de mi clase inputCantidad
                	InputCantidad InputCantidad = new InputCantidad();
                	//constructor para capturar la opcion selecionada
                    String monedaSeleccionada = obtenerMonedaSeleccionada();
                    switch (monedaSeleccionada) {
                    case "Lempira a Dolar":
                    	deOpcion=("HNL");
                    	hastaOpcion=("USD");
                        break;
                    case "Lempira a Euro":
                    	deOpcion=("HNL");
                    	hastaOpcion=("EUR");
                        break;
                    case "Lempira a Libras":
                    	deOpcion=("HNL");
                    	hastaOpcion=("GBP");
                        break;
                    case "Lempira a Yen":
                    	deOpcion=("HNL");
                    	hastaOpcion=("JPY");
                        break;
                    case "Dolar a Lempira":
                    	deOpcion=("USD");
                    	hastaOpcion=("HNL");
                        break;
                    case "Euro a Lempira":
                    	deOpcion=("EUR");
                    	hastaOpcion=("HNL");
                        break;
                    case "Libras a Lempira":
                    	deOpcion=("GBP");
                    	hastaOpcion=("HNL");
                        break;
                    case "Yen a Lempira":
                    	deOpcion=("JPY");
                    	hastaOpcion=("HNL");
                        break;
                    default:
                        //Aqui debe ir un caso por defecto
                        break;
                        
                    }
                    //capturo los datos seleccionados para trabajarlos en mi clase InputCantidad
                    InputCantidad.setDe(deOpcion);
                    InputCantidad.setHasta(hastaOpcion);

                    InputCantidad.setVisible(true);
                    dispose();
                }
            }
            private String obtenerMonedaSeleccionada() {
                return (String) comboBox.getSelectedItem();
            }
        });
        btnMonedaOk.setBounds(98, 119, 75, 25);
        getContentPane().add(btnMonedaOk);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MenuPrincipal PantallaPrincipal = new MenuPrincipal();
                PantallaPrincipal.setVisible(true);
                OpcionesMoneda.this.dispose();
            }
        });
        btnCancelar.setBounds(191, 119, 92, 25);
        getContentPane().add(btnCancelar);
    }
}

