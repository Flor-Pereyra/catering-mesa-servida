package ar.edu.unahur.obj2.catering.propuestas;

import ar.edu.unahur.obj2.catering.excepciones.PrecioNegativoException;
import java.util.Collections;
import java.util.List;

public class Servicio implements Propuesta {
    private String nombre;
    private double precio;

    public Servicio(String nombre, double precio) {
        if (precio < 0) {
            throw new PrecioNegativoException("El precio de un servicio no puede ser negativo.");
        }
        this.nombre = nombre;
        this.precio = precio;
    }

    public void setPrecio(double precio) {
        if (precio < 0) {
            throw new PrecioNegativoException("El precio no puede ser negativo.");
        }
        this.precio = precio;
    }

    @Override
    public double precio() {
        return this.precio;
    }

    @Override
    public String descripcion() {
        return this.nombre;
    }

    @Override
    public int cantidadServicios() {
        return 1;
    }

    @Override
    public boolean incluye(String nombreServicio) {
        return this.nombre.equalsIgnoreCase(nombreServicio);
    }

    @Override
    public List<Propuesta> getComponentesDirectos() {
        return Collections.emptyList();
    }
}
