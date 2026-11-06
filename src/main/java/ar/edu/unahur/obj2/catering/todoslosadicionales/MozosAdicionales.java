package ar.edu.unahur.obj2.catering.adicionales;

import ar.edu.unahur.obj2.catering.propuestas.Propuesta;

public class MozosAdicionales extends Adicional {
    public MozosAdicionales(Propuesta propuesta) {
        super(propuesta);
    }

    @Override
    public double precio() {
        return propuesta.precio() + 18000.0;
    }

    @Override
    public String descripcion() {
        return propuesta.descripcion() + " + Mozos adicionales";
    }
}
