package ar.edu.unahur.obj2.catering.adicionales;

import ar.edu.unahur.obj2.catering.propuestas.Propuesta;
import java.util.Collections;
import java.util.List;

public abstract class Adicional implements Propuesta {
    protected Propuesta propuesta;

    public Adicional(Propuesta propuesta) {
        this.propuesta = propuesta;
    }

    @Override
    public int cantidadServicios() {
        return propuesta.cantidadServicios();
    }

    @Override
    public boolean incluye(String nombreServicio) {
        return propuesta.incluye(nombreServicio);
    }

    @Override
    public List<Propuesta> getComponentesDirectos() {
        return propuesta.getComponentesDirectos();
    }
}
