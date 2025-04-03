package practica;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

import org.junit.Before;
import org.junit.Test;

public class ControladorHisteriaTest {
	private ControladorHisteria controlador;
    private ModeloHisteria modelo;
    private VistaHisteria vista;
    private JButton boton;

    @Before
    public void setUp() {
        // Creamos el modelo y la vista reales
        modelo = new ModeloHisteria(5, 5);
        vista = new VistaHisteria(5, 5);
        
        // Inicializamos el controlador
        controlador = new ControladorHisteria(modelo, vista);
        
        // Creamos un botón de prueba y le asignamos propiedades
        boton = new JButton();
        boton.putClientProperty("fila", 2);
        boton.putClientProperty("columna", 3);
    }

    @Test
    public void testActionPerformed() {
        // Ejecutamos la acción como si se hubiese presionado el botón
        ActionEvent evento = new ActionEvent(boton, ActionEvent.ACTION_PERFORMED, "");
        controlador.actionPerformed(evento);

        // Verificamos que la celda en (2,3) haya cambiado de color (no sea COLOR_APAGADO)
        Color colorCelda = modelo.obtenerColorCelda(2, 3);
        assertNotEquals(ModeloHisteria.COLOR_APAGADO, colorCelda);

        // Simulamos que el tablero está apagado y verificamos victoria
        modelo.inicializarTableroApagado(5, 5);
        assertFalse(modelo.verificarVictoria());

        // Encendemos todas las celdas para simular una victoria
        for (int i = 0; i < modelo.getFilas(); i++) {
            for (int j = 0; j < modelo.getColumnas(); j++) {
                modelo.asignarColorCelda(i, j, ModeloHisteria.COLOR_ENCENDIDO);
            }
        }
        assertTrue(modelo.verificarVictoria());
    }

}
