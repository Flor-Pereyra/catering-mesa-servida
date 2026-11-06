package ar.edu.unahur.obj2.catering.gestion;

import ar.edu.unahur.obj2.catering.propuestas.Menu;
import ar.edu.unahur.obj2.catering.propuestas.Propuesta;

public class AgregarPropuestaAMenu implements Modificacion {
    private Menu menu;
    private Propuesta propuestaAgregar;

    public AgregarPropuestaAMenu(Menu menu, Propuesta propuestaAgregar) {
        this.menu = menu;
        this.propuestaAgregar = propuestaAgregar;
    }

    @Override
    public void aplicar() {
        menu.agregarComponente(propuestaAgregar);
    }

    @Override
    public void revertir() {
        menu.quitarComponente(propuestaAgregar);
    }
}
