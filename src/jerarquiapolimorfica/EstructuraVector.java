package jerarquiapolimorfica;

import encapsuladores.Estado;
import excepciones.GenericaExcepcion;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Vector;

public class EstructuraVector implements EstructuraGenerica{

    Vector<Estado> estados = new Vector<>();

    byte numeroEstadosIntroduciodos = 0;

    @Override
    public void insertarEstado(Estado estado) {
        estado.setIdEstado(numeroEstadosIntroduciodos + 1);
        estados.addElement(estado);
        numeroEstadosIntroduciodos++;
    }

    @Override
    public Estado getEstado(Estado estado) throws GenericaExcepcion {
        if (estado.getIdEstado() < 1 || estado.getIdEstado() > numeroEstadosIntroduciodos)
            throw new GenericaExcepcion(-30);
        return estados.elementAt((estado.getIdEstado())-1);
    }

    @Override
    public String getConjuntoEstados() {
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###,##0",decimalFormatSymbols);
        decimalFormatSymbols.setDecimalSeparator(',');
        decimalFormatSymbols.setGroupingSeparator('.');

        StringBuffer aglutinadoADevolver = new StringBuffer();
        Estado estado;
        for (int i = 0; i < estados.size(); i++) {
            estado = estados.elementAt(i);
            aglutinadoADevolver.append(String.format("%3s",Integer.toString(estado.getIdEstado())));
            aglutinadoADevolver.append(" ");
            aglutinadoADevolver.append(String.format("%-30s",estado.getNombre()));
            aglutinadoADevolver.append(" ");
            aglutinadoADevolver.append(String.format("%15s",decimalFormat.format(estado.getNumeroHabitantes())));
            aglutinadoADevolver.append("\n");
        }
        return new String(aglutinadoADevolver);
    }

    @Override
    public int getNumeroEstados() {
        return numeroEstadosIntroduciodos;
    }

    @Override
    public void salvarDatos() throws Exception {

    }
}
