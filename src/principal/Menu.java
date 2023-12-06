package principal;

import encapsuladores.Estado;
import excepciones.GenericaExcepcion;
import jerarquiapolimorfica.EstructuraGenerica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {

    String estructurasDatos[] = {"Array","List","Vector","Map","Set","XML"};
    private EstructuraGenerica estructuraGenerica;
    int estructuraDatosActiva = 1;

    public void ejecutarMenu(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            estructuraGenerica = (EstructuraGenerica) (Class.forName("jerarquiapolimorfica.Estructura"+
                    estructurasDatos[estructuraDatosActiva - 1])).newInstance();

            byte opcion;

            do {
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println("Estructura de datos activa : "+estructurasDatos[estructuraDatosActiva - 1]);
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println("1.- Cambio de estructura de datos");
                System.out.println("2.- Insertar estada");
                System.out.println("3.- Visualizar estado");
                System.out.println("4.- Visualizar todos los estados");
                System.out.println("5.- Finalizar");
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println("Seleccione opcion : ");
                opcion = (byte) Integer.parseInt(bufferedReader.readLine());

                switch(opcion){
                    case 1: cambiarEstructura();
                    break;
                    case 2: insertarEstado();
                    break;
                    case 3: visualizarEstado();
                    break;
                    case 4: visualizarConjuntoEstados();
                    break;
                    case 5: visualizarNumeroEstados();
                    break;
                }

                if (opcion == 6 && estructuraDatosActiva == 6)
                    estructuraGenerica.salvarDatos();
            }while (opcion != 6);
        }catch (GenericaExcepcion genericaExcepcion){
            switch (genericaExcepcion.getCodigoError()){
                case -30:
                    System.out.println("Identificador d estado no encontrado");
                    break;
            }
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    public void cambiarEstructura()throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int nuevaEstructura = 0;
        do {
            for (int i = 0; i < estructurasDatos.length; i++) {
                System.out.println((i+1)+" - "+estructurasDatos[i]);
                System.out.println("Introduzca tipo de estructura : ");
                nuevaEstructura = Integer.parseInt(bufferedReader.readLine());
            }
        }while (nuevaEstructura < 1 || nuevaEstructura > estructurasDatos.length);

        if (estructuraDatosActiva == 6)
            estructuraGenerica.salvarDatos();
        estructuraDatosActiva = nuevaEstructura;
        estructuraGenerica = (EstructuraGenerica) (Class.forName("jerarquiapolimorfica.Estructura"+
                estructurasDatos[estructuraDatosActiva - 1])).newInstance();
    }

    public void insertarEstado() throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Estado estado = new Estado();

        System.out.println("Introduzca nombre del estado : ");
        estado.setNombre(bufferedReader.readLine());

        System.out.println("Introduzca numero de habitantes : ");
        estado.setNumeroHabitantes(Integer.parseInt(bufferedReader.readLine()));

        estructuraGenerica.insertarEstado(estado);
    }

    private void visualizarEstado() throws IOException, GenericaExcepcion {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Estado estado = new Estado();

        System.out.println("Introduzaca identificador de estado : ");
        estado.setIdEstado(Integer.parseInt(bufferedReader.readLine()));

        estado = estructuraGenerica.getEstado(estado);
        System.out.println("Identificador de estado : "+estado.getIdEstado());
        System.out.println("Nombre: "+estado.getNombre());
        System.out.println("Numero de habitantes: "+estado.getNumeroHabitantes());
    }

    private void visualizarConjuntoEstados() throws IOException{
        String informacionConjuntoEstados = estructuraGenerica.getConjuntoEstados();
        System.out.println(informacionConjuntoEstados);
    }

    private void visualizarNumeroEstados(){
        System.out.println("Hay registrados un total de: "+estructuraGenerica.getNumeroEstados()+" estados");
    }
}
