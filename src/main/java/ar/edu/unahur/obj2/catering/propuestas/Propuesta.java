package ar.edu.unahur.obj2.catering.propuestas;

import java.util.List;

public interface Propuesta {
    double precio();
    String descripcion();
    int cantidadServicios();
    boolean incluye(String nombreServicio);
    List<Propuesta> getComponentesDirectos();
}
