package ar.edu.unahur.obj2.catering.gestion;

import ar.edu.unahur.obj2.catering.excepciones.NadaParaRevertirException;
import java.util.List;
import java.util.Stack;

public class GestorDeCarta {
    private Stack<Modificacion> historial = new Stack<>();

    public void aplicarModificacion(Modificacion modificacion) {
        modificacion.aplicar();
        historial.push(modificacion);
    }

    public void aplicarLote(List<Modificacion> lote) {
        Stack<Modificacion> aplicadasConExito = new Stack<>();
        try {
            for (Modificacion mod : lote) {
                mod.aplicar();
                aplicadasConExito.push(mod);
            }
           
            for (Modificacion mod : aplicadasConExito) {
                historial.push(mod);
            }
        } catch (RuntimeException e) {
            
            while (!aplicadasConExito.isEmpty()) {
                aplicadasConExito.pop().revertir();
            }
            throw e; 
        }
    }

    public void revertirUltima() {
        if (historial.isEmpty()) {
            throw new NadaParaRevertirException("No hay modificaciones para revertir en el historial.");
        }
        Modificacion ultima = historial.pop();
        ultima.revertir();
    }
}
