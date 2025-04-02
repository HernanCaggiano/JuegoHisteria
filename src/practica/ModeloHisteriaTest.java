package practica;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

public class ModeloHisteriaTest {
	private ModeloHisteria modelo;
	
	@Before
	public void setUp() {
		modelo = new ModeloHisteria(5, 5);
	}
	
	@Test
	public void testInicializarTableroApagado() {
        // Inicializar el tablero con el color apagado
        modelo.inicializarTableroApagado(5, 5);

        // Verificar que todas las celdas estén en COLOR_APAGADO
        for (int i = 0; i < modelo.getFilas(); i++) {
            for (int j = 0; j < modelo.getColumnas(); j++) {
                assertEquals(ModeloHisteria.COLOR_APAGADO, modelo.obtenerColorCelda(i, j));
            }
        }
    }
	
	@Test
    public void testAsignarColorCelda() {
        // Asignar color a una celda y verificar que se haya actualizado
        modelo.asignarColorCelda(2, 2, Color.RED);
        assertEquals(Color.RED, modelo.obtenerColorCelda(2, 2));
    }

    @Test
    public void testVerificarVictoria() {
        // Verificar victoria en un tablero vacío (sin ninguna celda apagada)
        modelo.asignarColorCelda(0, 0, Color.WHITE); // Simulamos un cambio
        assertFalse(modelo.verificarVictoria()); // No debería haber victoria aún
    }

    @Test
    public void testCeldaPulsada() {
        // Probar que el método celdaPulsada cambia el estado de una celda
        int fila = 2, columna = 2;
        Color colorOriginal = modelo.obtenerColorCelda(fila, columna);
        modelo.celdaPulsada(fila, columna);
        assertNotEquals(colorOriginal, modelo.obtenerColorCelda(fila, columna)); // El color debería haber cambiado
    }

}
