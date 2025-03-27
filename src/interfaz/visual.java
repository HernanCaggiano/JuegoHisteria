package interfaz;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

public class visual {

	private JFrame frame;
	private JButton[][] botones;
	private final int FILAS = 5;
    private final int COLUMNAS = 5;

	/**
	 * Prueba 2
	 * 
	 * 
	 * 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					visual window = new visual();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public visual() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());
        
        JLabel lblTitulo = new JLabel("Histeria - Locura Cromática");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
        //lblTitulo.setBounds(100, 11, 250, 30);
        frame.getContentPane().add(lblTitulo, BorderLayout.NORTH);
        
        JPanel panelGrilla = new JPanel(new GridLayout(FILAS, COLUMNAS));
        botones = new JButton[FILAS][COLUMNAS];
        
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                botones[i][j] = new JButton();
                botones[i][j].setBackground(Color.LIGHT_GRAY);
                panelGrilla.add(botones[i][j]);
            }
        }
        
        //JButton btnIniciar = new JButton("Iniciar Juego");
        //btnIniciar.setBounds(150, 100, 150, 30);
        frame.getContentPane().add(panelGrilla, BorderLayout.CENTER);
        frame.setVisible(true);
		
		
	}

}
