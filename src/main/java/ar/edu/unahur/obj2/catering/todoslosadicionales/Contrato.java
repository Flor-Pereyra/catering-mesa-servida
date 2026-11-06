package ar.edu.unahur.obj2.catering.contratos;

import ar.edu.unahur.obj2.catering.propuestas.Propuesta;

public class Contrato {
    private String cliente;
    private double importeFijo;
    private String descripcionFija;

    public Contrato(String cliente, Propuesta propuestaContratada) {
        this.cliente = cliente;
        this.importeFijo = propuestaContratada.precio();
        this.descripcionFija = propuestaContratada.descripcion();
    }

    public double consultarImporte() {
        return this.importeFijo;
    }

    public String consultarDescripcion() {
        return this.descripcionFija;
    }
}
