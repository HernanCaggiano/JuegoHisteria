package practica.controlador;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import practica.modelo.ModeloHisteria;
import practica.vista.VistaHisteria;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

public class ControladorHisteriaTest {
	private ModeloHisteria modelo;
    private VistaHisteria vista;
    private ControladorHisteria controlador;

    @Before
    public void setUp() {
        modelo = new ModeloHisteria(3, 3, true, true, "facil");
        vista = new VistaHisteria(3, 3); // Vista real
        controlador = new ControladorHisteria(modelo, vista);
    }

    @Test
    public void testCeldaPulsadaActualizaModelo() {
    	Color antes = modelo.getColorCelda(1, 1);

        JButton boton = new JButton();
        boton.putClientProperty("fila", 1);
        boton.putClientProperty("columna", 1);
        boton.setActionCommand("1,1");

        ActionEvent evento = new ActionEvent(boton, ActionEvent.ACTION_PERFORMED, "1,1");
        controlador.actionPerformed(evento);

        Color despues = modelo.getColorCelda(1, 1);
        assertNotEquals("El color debe cambiar tras el clic", antes, despues);
    }

    @Test
    public void testActualizarVistaSinError() {
    	JButton boton = new JButton();
        boton.setActionCommand("1,1");
        boton.putClientProperty("fila", 1);
        boton.putClientProperty("columna", 1);

        ActionEvent evento = new ActionEvent(boton, ActionEvent.ACTION_PERFORMED, "1,1");

        try {
            controlador.actionPerformed(evento);
        } catch (Exception e) {
            fail("actualizarVista lanzó una excepción: " + e.getMessage());
        }
    }

    @Test
    public void testVictoriaMostradaSinError() {
    	JButton boton = new JButton();
        boton.setActionCommand("0,0");
        boton.putClientProperty("fila", 0);
        boton.putClientProperty("columna", 0);

        ActionEvent evento = new ActionEvent(boton, ActionEvent.ACTION_PERFORMED, "0,0");

        try {
            controlador.actionPerformed(evento);
            // Si tu controlador automáticamente muestra victoria al dar clic en alguna celda ganadora,
            // este test pasará si no hay excepciones.
        } catch (Exception e) {
            fail("mostrarMensajeVictoria lanzó una excepción: " + e.getMessage());
        }
    }
}
