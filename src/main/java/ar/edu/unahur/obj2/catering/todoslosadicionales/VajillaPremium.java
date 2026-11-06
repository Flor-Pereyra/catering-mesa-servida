package ar.edu.unahur.obj2.catering.adicionales;

import ar.edu.unahur.obj2.catering.propuestas.Propuesta;

public class VajillaPremium extends Adicional {
    public VajillaPremium(Propuesta propuesta) {
        super(propuesta);
    }

    @Override
    public double precio() {
        return propuesta.precio() + 12000.0;
    }

    @Override
    public String descripcion() {
        return propuesta.descripcion() + " + Vajilla premium";
    }
}
