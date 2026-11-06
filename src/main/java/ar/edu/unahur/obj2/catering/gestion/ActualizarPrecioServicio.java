package ar.edu.unahur.obj2.catering.gestion;

import ar.edu.unahur.obj2.catering.propuestas.Servicio;

public class ActualizarPrecioServicio implements Modificacion {
    private Servicio servicio;
    private double precioNuevo;
    private double precioAnterior;

    public ActualizarPrecioServicio(Servicio servicio, double precioNuevo) {
        this.servicio = servicio;
        this.precioNuevo = precioNuevo;
        this.precioAnterior = servicio.precio();
    }

    @Override
    public void aplicar() {
        this.servicio.setPrecio(precioNuevo);
    }

    @Override
    public void revertir() {
        this.servicio.setPrecio(precioAnterior);
    }
}
