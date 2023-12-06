package encapsuladores;

public class Estado implements java.io.Serializable{

    private int idEstado;
    private String nombre;
    private int numeroHabitantes;

    public Estado() {
    }

    public Estado(int idEstado, String nombre, int numeroHabitantes) {
        this.idEstado = idEstado;
        this.nombre = nombre;
        this.numeroHabitantes = numeroHabitantes;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroHabitantes() {
        return numeroHabitantes;
    }

    public void setNumeroHabitantes(int numeroHabitantes) {
        this.numeroHabitantes = numeroHabitantes;
    }

    @Override
    public boolean equals(Object obj) {
        boolean iguales = false;
        if (obj instanceof Estado){
            Estado estado = (Estado) obj;

            if ((this.idEstado == estado.idEstado) && (this.nombre.equals(estado.nombre)) && (this.numeroHabitantes ==
                    estado.numeroHabitantes)){
                iguales = true;
            }
        }
        return iguales;
    }

    @Override
    public int hashCode() {
        return idEstado + nombre.hashCode() + numeroHabitantes;
    }
}
