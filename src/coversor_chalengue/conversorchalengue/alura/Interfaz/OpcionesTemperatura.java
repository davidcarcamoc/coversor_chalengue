package conversorchalengue.alura.Interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class OpcionesTemperatura extends JFrame {

	private JPanel contentPane;


	public OpcionesTemperatura() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		JPanel panel1 =new JPanel() ;
	    contentPane.add(panel1);
	}

}
