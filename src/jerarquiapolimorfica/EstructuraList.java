package jerarquiapolimorfica;

import encapsuladores.Estado;
import excepciones.GenericaExcepcion;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;

public class EstructuraList implements EstructuraGenerica{

    List<Estado> estados = new ArrayList<>();

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
        return estados.get((estado.getIdEstado())-1);
    }

    @Override
    public String getConjuntoEstados() {
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###,##0",decimalFormatSymbols);
        decimalFormatSymbols.setDecimalSeparator(',');
        decimalFormatSymbols.setGroupingSeparator('.');

        StringBuffer aglutinadoADevolver = new StringBuffer();
        for (int i = 0; i < estados.size(); i++) {
            aglutinadoADevolver.append(String.format("%3s",Integer.toString((estados.get(i)).getIdEstado())));
            aglutinadoADevolver.append(" ");
            aglutinadoADevolver.append(String.format("%-30s",(estados.get(i)).getNombre()));
            aglutinadoADevolver.append(" ");
            aglutinadoADevolver.append(String.format("%15s",decimalFormat.format((estados.get(i)).
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
