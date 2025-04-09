package practica.modelo;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.awt.Color;

public class ModeloHisteriaTest {
	private ModeloHisteria modelo;

    @Before
    public void setUp() {
        // Modo: "facil", adyacentes y diagonales activados
        modelo = new ModeloHisteria(3, 3, true, true, "facil");
    }

    @Test
    public void testInicializacionTablero() {
        for (int i = 0; i < modelo.getFilas(); i++) {
            for (int j = 0; j < modelo.getColumnas(); j++) {
                assertEquals(Color.DARK_GRAY, modelo.getColorCelda(i, j));
            }
        }
    }

    @Test
    public void testCeldaPulsadaCambiaColor() {
        Color antes = modelo.getColorCelda(1, 1);
        modelo.celdaPulsada(1, 1);
        Color despues = modelo.getColorCelda(1, 1);
        assertNotEquals("El color debería cambiar", antes, despues);
    }

    @Test
    public void testColisionYReinicio() {
        // Forzar una colisión: pulsar dos veces la misma celda para que se reinicie con vecinos
        modelo.celdaPulsada(1, 1);
        Color color = modelo.getColorCelda(1, 1);
        modelo.celdaPulsada(1, 1); // Esta puede generar colisión
        Color despues = modelo.getColorCelda(1, 1);

        // Si hubo colisión, se reinicia a DARK_GRAY
        assertTrue("La celda debería apagarse si hubo colisión",
                despues.equals(Color.DARK_GRAY) || !color.equals(despues));
    }

    @Test
    public void testIsBoardCompleteConTableroVacio() {
        assertFalse(modelo.isBoardComplete());
    }

    @Test
    public void testIsBoardCompleteConTableroLleno() {
        for (int i = 0; i < modelo.getFilas(); i++) {
            for (int j = 0; j < modelo.getColumnas(); j++) {
                modelo.celdaPulsada(i, j);
            }
        }
        assertTrue(modelo.isBoardComplete());
    }
}
