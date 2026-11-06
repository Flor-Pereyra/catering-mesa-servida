package ar.edu.unahur.obj2.catering;

import ar.edu.unahur.obj2.catering.excepciones.PrecioNegativoException;
import ar.edu.unahur.obj2.catering.propuestas.Servicio;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ServicioTest {

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
}
