package coversorchalengue.alura.test;

import java.awt.EventQueue;

import conversorchalengue.alura.Interfaz.MenuPrincipal;

public class PantallaPrincipal {

    //private JFrame frame;

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MenuPrincipal window = new MenuPrincipal();     
                    window.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}




