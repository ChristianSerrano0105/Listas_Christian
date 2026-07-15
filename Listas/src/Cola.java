public interface Cola <E> extends Iterable<E>  {
    
    public void encolar (E elemento);

    E desencolar();
    E consultarFrente();
    boolean esVacia();
    int numElementos();
    void limpiar();
    
}
