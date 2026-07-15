import java.util.Iterator;
import java.util.NoSuchElementException;

public class ColaLinked<E> implements Cola<E>{

    private final Lista<E> elementos;

    public ColaLinked(){
        elementos = new LinkedList<E>();
    }

    @Override
    public void encolar(E elemento){
        elementos.agregarFinal(elemento);
    }

    @Override
    public E desencolar(){
        if(esVacia()) throw new NoSuchElementException("La cola está vacia");
        return elementos.eliminarElementoInicio();
    }

    @Override
    public E consultarFrente(){
        if(esVacia()) throw new NoSuchElementException("La cola está vacia");
        return elementos.consultar(0);
    }

    @Override
    public boolean esVacia(){
        return elementos.esVacia();
    }

    @Override
    public int numElementos(){
        return elementos.numElementos();
    }

    @Override
    public void limpiar(){
        elementos.limpiarLista();
    }

    @Override
    public Iterator<E> iterator(){
        return elementos.iterator();
    }
}
