package jerarquiapolimorfica;

import encapsuladores.Estado;
import excepciones.GenericaExcepcion;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class EstructuraXML implements EstructuraGenerica{

    Document documento;
    Element raiz;
    byte numeroEstadosIntroducidos = 0;

    public EstructuraXML(){

    }

    @Override
    public void insertarEstado(Estado estado) {

    }

    @Override
    public Estado getEstado(Estado estado) throws GenericaExcepcion {
        return null;
    }

    @Override
    public String getConjuntoEstados() {
        return null;
    }

    @Override
    public int getNumeroEstados() {
        return 0;
    }

    @Override
    public void salvarDatos() throws Exception {

    }
}
