package practica.modelo;

import static org.junit.Assert.*;

import java.awt.Component;
import java.awt.Frame;
import java.lang.reflect.Field;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;

import org.junit.Test;

public class ConfiguracionJuegoTest {
	private JSpinner getSpinner(ConfiguracionJuego config) throws Exception {
        Field field = ConfiguracionJuego.class.getDeclaredField("spinnerDimension");
        field.setAccessible(true);
        return (JSpinner) field.get(config);
    }

    private JRadioButton getRadioButton(ConfiguracionJuego config, String nombreCampo) throws Exception {
        Field field = ConfiguracionJuego.class.getDeclaredField(nombreCampo);
        field.setAccessible(true);
        return (JRadioButton) field.get(config);
    }

    private JButton getBotonAceptar(ConfiguracionJuego config) {
        // Recorremos todos los paneles hasta encontrar el botón "Iniciar Juego"
        for (Component c : config.getContentPane().getComponents()) {
            if (c instanceof JPanel panelPrincipal) {
                for (Component subComp : panelPrincipal.getComponents()) {
                    if (subComp instanceof JPanel subPanel) {
                        for (Component boton : subPanel.getComponents()) {
                            if (boton instanceof JButton b && "Iniciar Juego".equals(b.getText())) {
                                return b;
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    @Test
    public void testConfiguracionFacil() throws Exception {
        ConfiguracionJuego config = new ConfiguracionJuego((Frame) null);

        getSpinner(config).setValue(6);
        getRadioButton(config, "rbFacil").setSelected(true);

        JButton btn = getBotonAceptar(config);
        assertNotNull("Botón Iniciar Juego no encontrado", btn);
        btn.doClick();

        assertTrue(config.isConfirmado());
        assertEquals(6, config.getDimension());
        assertEquals("facil", config.getModoSeleccionado());
    }

    @Test
    public void testConfiguracionMedio() throws Exception {
        ConfiguracionJuego config = new ConfiguracionJuego((Frame) null);

        getSpinner(config).setValue(7);
        getRadioButton(config, "rbMedio").setSelected(true);

        JButton btn = getBotonAceptar(config);
        assertNotNull("Botón Iniciar Juego no encontrado", btn);
        btn.doClick();

        assertTrue(config.isConfirmado());
        assertEquals(7, config.getDimension());
        assertEquals("medio", config.getModoSeleccionado());
    }

    @Test
    public void testConfiguracionDificil() throws Exception {
        ConfiguracionJuego config = new ConfiguracionJuego((Frame) null);

        getSpinner(config).setValue(8);
        getRadioButton(config, "rbDificil").setSelected(true);

        JButton btn = getBotonAceptar(config);
        assertNotNull("Botón Iniciar Juego no encontrado", btn);
        btn.doClick();

        assertTrue(config.isConfirmado());
        assertEquals(8, config.getDimension());
        assertEquals("dificil", config.getModoSeleccionado());
    }
}
