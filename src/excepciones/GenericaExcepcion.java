package excepciones;

public class GenericaExcepcion extends Exception{

    private int codigoError;

    public GenericaExcepcion(int codigoError) {
        this.codigoError = codigoError;
    }

    public int getCodigoError() {
        return codigoError;
    }
}
