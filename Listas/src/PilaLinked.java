import java.util.Iterator;
import java.util.NoSuchElementException;

public class PilaLinked<E> implements Pila<E> {
    
    private final Lista<E> elementos;

    public PilaLinked (){
        elementos = new LinkedList <E>();
    }  
    @Override
    public void apilar(E e){
        elementos.agregarFinal(e);
    }

    @Override
    public E desapilar(){
        if(esVacia()){
            throw new NoSuchElementException("La pila esta vacia");
        }
        return elementos.eliminarElementoFinal();
    }

    @Override
    public E consultarCima(){
        if(esVacia()){
            throw new NoSuchElementException("La pila esta vacia.");
        }
        int ultimaPosicion=elementos.numElementos()-1;
        return elementos.consultar(ultimaPosicion);
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
    public Iterator<E> iterator() {
        return elementos.iterator();
    }
}
