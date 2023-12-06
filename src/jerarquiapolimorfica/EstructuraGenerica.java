package jerarquiapolimorfica;

import encapsuladores.Estado;
import excepciones.GenericaExcepcion;

public interface EstructuraGenerica {

    void insertarEstado(Estado estado);
    Estado getEstado(Estado estado) throws GenericaExcepcion;
    String getConjuntoEstados();
    int getNumeroEstados();
    void salvarDatos() throws Exception;
}
