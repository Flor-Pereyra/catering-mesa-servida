package ar.edu.unahur.obj2.catering;

import ar.edu.unahur.obj2.catering.adicionales.BebidaAlcoholica;
import ar.edu.unahur.obj2.catering.excepciones.PrecioNegativoException;
import ar.edu.unahur.obj2.catering.gestion.GestorDeCarta;
import ar.edu.unahur.obj2.catering.propuestas.Menu;
import ar.edu.unahur.obj2.catering.propuestas.Servicio;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CateringTest {

    @Test
    void dadoUnServicioConPrecioNegativo_alCrearlo_lanzaPrecioNegativoException() {
        assertThrows(PrecioNegativoException.class, () -> {
            new Servicio("Mesa de entradas", -1000.0);
        });
    }

    @Test
    void dadoUnServicioValido_alConsultarSusDatos_devuelveNombreYPrecioCorrectos() {
        Servicio servicio = new Servicio("Mesa de entradas", 80000.0);
        assertEquals("Mesa de entradas", servicio.descripcion());
        assertEquals(80000.0, servicio.precio());
        assertEquals(1, servicio.cantidadServicios());
        assertTrue(servicio.incluye("Mesa de entradas"));
    }

    @Test
    void dadoUnMenuCompuestoPorVariosServicios_calculaPrecioTotalYCantidadDeServiciosCorrectamente() {
        Menu menu = new Menu("Menú Boda");
        Servicio entrada = new Servicio("Recepción", 50000.0);
        Servicio principal = new Servicio("Asado con ensalada", 150000.0);

        menu.agregar(entrada);
        menu.agregar(principal);

        assertEquals(200000.0, menu.precio());
        assertEquals(2, menu.cantidadServicios());
        assertTrue(menu.incluye("Recepción"));
        assertTrue(menu.incluye("Asado con ensalada"));
    }

    @Test
    void dadoUnServicioBaseConAdicionalDeBebidaAlcoholica_calculaElPrecioConRecargo() {
        Servicio servicioBase = new Servicio("Cena Estándar", 100000.0);
        Servicio servicioConBebida = new BebidaAlcoholica(servicioBase);

        assertEquals(115000.0, servicioConBebida.precio());
        assertTrue(servicioConBebida.incluye("Cena Estándar"));
    }

    @Test
    void dadoUnGestorDeCarta_alAplicarYRevertirModificaciones_restauraElEstadoAnterior() {
        GestorDeCarta gestor = new GestorDeCarta();
        Servicio servicio = new Servicio("Postre", 30000.0);

        
    }
}
