package practica;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class HisteriaPrincipal {
    public static void main(String[] args) {
        // Se invoca en el hilo de eventos para asegurar la correcta actualización de la GUI
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	
            	// Mostrar cuadro de diálogo para seleccionar el nivel
                String[] opciones = {"Fácil (5x5)", "Avanzado (8x8)"};
                int seleccion = JOptionPane.showOptionDialog(null, "Selecciona el nivel de juego:", "Nivel de Juego",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
                    
                int filas = (seleccion == 0) ? 5 : 8;
                int columnas = (seleccion == 0) ? 5 : 8;
                    
                ModeloHisteria modelo = new ModeloHisteria(filas, columnas);
                VistaHisteria vista = new VistaHisteria(filas, columnas);
                ControladorHisteria controlador = new ControladorHisteria(modelo, vista);
                    
                vista.setVisible(true);
            }
        });
    }
}
