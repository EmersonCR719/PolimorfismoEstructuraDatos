package jerarquiapolimorfica;

import encapsuladores.Estado;
import excepciones.GenericaExcepcion;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;

public class EstructuraSet implements EstructuraGenerica{

    Set<Estado> estados = new LinkedHashSet<>();

    byte numeroEstadosIntroducidos = 0;

    @Override
    public void insertarEstado(Estado estado) {
        estado.setIdEstado(numeroEstadosIntroducidos + 1);
        estados.add(estado);
        numeroEstadosIntroducidos++;
    }

    @Override
    public Estado getEstado(Estado estado) throws GenericaExcepcion {
        if (estado.getIdEstado() < 1 || estado.getIdEstado() > numeroEstadosIntroducidos)
            throw new GenericaExcepcion(-30);

        Estado estadoADevolver = null;
        boolean encontrado = false;
        Iterator iteratorEstados = estados.iterator();
        while (iteratorEstados.hasNext() && !encontrado){
            estadoADevolver = (Estado) iteratorEstados.next();
            if (estadoADevolver.getIdEstado() == estado.getIdEstado())
                encontrado = true;
        }
        return estadoADevolver;
    }

    @Override
    public String getConjuntoEstados() {
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###,##0",decimalFormatSymbols);
        decimalFormatSymbols.setDecimalSeparator(',');
        decimalFormatSymbols.setGroupingSeparator('.');

        StringBuffer aglutinadoADevolver = new StringBuffer();
        Enumeration enumerationEstados = Collections.enumeration(estados);
        while (enumerationEstados.hasMoreElements()){
            Estado estado = (Estado) enumerationEstados.nextElement();
            aglutinadoADevolver.append(String.format("%3s",Integer.toString(estado.getIdEstado())));
            aglutinadoADevolver.append(" ");
            aglutinadoADevolver.append(String.format("%-30s",estado.getNombre()));
            aglutinadoADevolver.append(" ");
            aglutinadoADevolver.append(String.format("%15s",decimalFormat.format(estado.getNumeroHabitantes())));
            aglutinadoADevolver.append("\n");
        }
        if (aglutinadoADevolver.length() == 0)
            return "No hay estados aún";

        return new String(aglutinadoADevolver);
    }

    @Override
    public int getNumeroEstados() {
        return numeroEstadosIntroducidos;
    }

    @Override
    public void salvarDatos() throws Exception {

    }
}
