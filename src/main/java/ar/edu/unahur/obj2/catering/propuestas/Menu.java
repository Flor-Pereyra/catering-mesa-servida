package ar.edu.unahur.obj2.catering.propuestas;

import ar.edu.unahur.obj2.catering.excepciones.DescuentoInvalidoException;
import ar.edu.unahur.obj2.catering.excepciones.PropuestaNoIncluidaException;
import java.util.ArrayList;
import java.util.List;

public class Menu implements Propuesta {
    private String nombre;
    private double descuentoPorcentaje; 
    private List<Propuesta> componentes;

    public Menu(String nombre, double descuentoPorcentaje, List<Propuesta> componentes) {
        if (descuentoPorcentaje < 0 || descuentoPorcentaje > 100) {
            throw new DescuentoInvalidoException("El descuento debe estar entre 0 y 100.");
        }
        this.nombre = nombre;
        this.descuentoPorcentaje = descuentoPorcentaje;
        this.componentes = new ArrayList<>(componentes);
    }

    public void agregarComponente(Propuesta propuesta) {
        this.componentes.add(propuesta);
    }

    public void quitarComponente(Propuesta propuesta) {
        if (!this.componentes.contains(propuesta)) {
            throw new PropuestaNoIncluidaException(propuesta.descripcion() + " no está en ese menú");
        }
        this.componentes.remove(propuesta);
    }

    @Override
    public double precio() {
        double sumaTotalComponentes = componentes.stream().mapToDouble(Propuesta::precio).sum();
        return sumaTotalComponentes - (sumaTotalComponentes * (descuentoPorcentaje / 100.0));
    }

    @Override
    public String descripcion() {
        return this.nombre;
    }

    @Override
    public int cantidadServicios() {
        return componentes.stream().mapToInt(Propuesta::cantidadServicios).sum();
    }

    @Override
    public boolean incluye(String nombreServicio) {
        return componentes.stream().anyMatch(c -> c.incluye(nombreServicio));
    }

    @Override
    public List<Propuesta> getComponentesDirectos() {
        return this.componentes;
    }
}
