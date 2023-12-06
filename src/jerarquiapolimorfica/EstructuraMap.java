package jerarquiapolimorfica;

import encapsuladores.Estado;
import excepciones.GenericaExcepcion;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class EstructuraMap implements EstructuraGenerica{

    Map<Integer, Estado> estados = new LinkedHashMap<>();

    byte numeroEstadosIntroducidos = 0;

    @Override
    public void insertarEstado(Estado estado) {
        estado.setIdEstado(numeroEstadosIntroducidos + 1);
        estados.put(estado.getIdEstado(),estado);
        numeroEstadosIntroducidos++;
    }

    @Override
    public Estado getEstado(Estado estado) throws GenericaExcepcion {
        if (estado.getIdEstado() < 1 || estado.getIdEstado() > numeroEstadosIntroducidos)
            throw new GenericaExcepcion(-30);
        return estados.get(estado.getIdEstado());
    }

    @Override
    public String getConjuntoEstados() {
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###,##0",decimalFormatSymbols);
        decimalFormatSymbols.setDecimalSeparator(',');
        decimalFormatSymbols.setGroupingSeparator('.');

        StringBuffer aglutinadoADevolver = new StringBuffer();
        Iterator iteratorEstados = estados.keySet().iterator();
        while(iteratorEstados.hasNext()){
            Integer keyEstado = (Integer) iteratorEstados.next();
            aglutinadoADevolver.append(String.format("%3s",Integer.toString(estados.get(keyEstado.intValue()).
                    getIdEstado())));
            aglutinadoADevolver.append(" ");
            aglutinadoADevolver.append(String.format("%-30s",(estados.get(keyEstado.intValue()).getNombre())));
            aglutinadoADevolver.append(" ");
            aglutinadoADevolver.append(String.format("%15s",decimalFormat.format((estados.get(keyEstado.intValue())).
                    getNumeroHabitantes())));
            aglutinadoADevolver.append("\n");
        }
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
