package ar.edu.unahur.obj2.catering.gestion;

import ar.edu.unahur.obj2.catering.propuestas.Menu;
import ar.edu.unahur.obj2.catering.propuestas.Propuesta;

public class QuitarPropuestaDeMenu implements Modificacion {
    private Menu menu;
    private Propuesta propuestaQuitar;

    public QuitarPropuestaDeMenu(Menu menu, Propuesta propuestaQuitar) {
        this.menu = menu;
        this.propuestaQuitar = propuestaQuitar;
    }

    @Override
    public void aplicar() {
        menu.quitarComponente(propuestaQuitar);
    }

    @Override
    public void revertir() {
        menu.agregarComponente(propuestaQuitar);
    }
}
