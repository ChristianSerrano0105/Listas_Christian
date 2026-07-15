import java.awt.image.BufferStrategy;
import java.util.Iterator;


public class ArrayList<E> implements Lista<E> {

    private static final int  MAX=5;
	private int indice=0;
	private Object[] datos=null;  



	public ArrayList() {

		this(MAX);

	}

	public ArrayList(int tam) {

		if(tam<0){
			throw new IllegalArgumentException();
		}
		datos = new Object[tam];

	}

	private void asegurarGC(){

		for(int i=0;i<datos.length;i++){
			datos[i]=null;
		}
	}

	@Override
	public void agregarElemento(E e) {

		Object[] aux=null;
		if(!(indice<datos.length-1)){

			aux = new Object[datos.length+datos.length/2];
			System.arraycopy(datos,0,aux,0,datos.length);
			//DEBEMOS ELIMINAR TODAS LAS REFERENCIAS...DEJAR LOS OBJETOS EN EL "LIMBO"
			asegurarGC();
			datos = aux;

		}
		datos[indice] = e;
		indice++;
	}

	@Override
	public void agregarInicio(E e) {
		Object[] auxobj=null;
		System.out.println(indice);
		if(indice<datos.length-1){
			System.arraycopy(datos,0,datos,1,indice+1);
		}else{
			auxobj = new Object[datos.length+datos.length/2];
			System.arraycopy(datos,0,auxobj,1,datos.length);
			//DEBEMOS ELIMINAR TODAS LAS REFERENCIAS...DEJAR LOS OBJETOS EN EL "LIMBO"
			asegurarGC();
			datos = auxobj;

		}
		datos[0] = e;
		indice++;

	}

	@Override
	public void agregarFinal(E e) {
		agregarElemento(e);

	}

	@Override
	public void agregarPosicion(E e, int posicion) {
		Object[] auxobj=null;
		if(!(posicion<0 || posicion > numElementos())){
			if(!(indice < datos.length-1)){
				auxobj = new Object[datos.length+datos.length/2];
				System.arraycopy(datos,0,auxobj,0,datos.length);
				//DEBEMOS ELIMINAR TODAS LAS REFERENCIAS...DEJAR LOS OBJETOS EN EL "LIMBO"
				asegurarGC();
				datos=auxobj;
			}	
			System.arraycopy(datos,posicion,datos,posicion+1,indice-posicion);
			datos[posicion] = e;
			indice++;
		}else{
			throw new IndexOutOfBoundsException();
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public E eliminarElemento() {
		if(!esVacia()){
			E aux =  null;
			aux = (E)datos[indice-1];
			indice--;
			return aux;
		}
		throw new NullPointerException();
	}

	@SuppressWarnings("unchecked")
	@Override
	public E eliminarElementoInicio() {
		if(!esVacia()){
			E aux =  null;
			aux = (E)datos[0];
			System.arraycopy(datos,1,datos,0,indice);
			indice--;
			return aux;
		}
		throw new NullPointerException();
	}

	@Override
	public E eliminarElementoFinal() {
		return eliminarElemento();
	}

	@SuppressWarnings("unchecked")
	@Override
	public E eliminarElementoPosicion(int posicion) {
		if(!(posicion<0 || posicion > (numElementos()-1))){

			E aux =  null;
			aux = (E)datos[posicion];
			System.arraycopy(datos,posicion+1,datos,posicion,indice-posicion);
			indice--;
			return aux;
		}else{
			
			throw new IndexOutOfBoundsException();
		}

	}

	@Override
	public boolean esVacia() {

		return(indice==0);
	}

	@Override
	public int numElementos() {
		return indice;
	}

	@Override
	public void limpiarLista() {
		indice = 0;
		asegurarGC();

	}


	@SuppressWarnings("unchecked")
	@Override
	public E[] convertirArreglo() {
		Object[] aux = new Object[indice];	
		System.arraycopy(datos,0,aux,0,indice);
		return  (E[])aux;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E consultar(int posicion) {
		if(!(posicion<0 || posicion >= numElementos())){
			
			return (E)datos[posicion];
			
		}else{
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public int busquedaLineal(E e){
		
		if(esVacia()){
			throw new NullPointerException();
		}else{
			for(int i=0; i<this.indice; i++){
				if(datos[i].equals(e)){
					return i;
				}
			}
			return -1;
		}
	}


    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            int i=0;
            @Override
            public boolean hasNext() {
                return i<indice;
            }

            @Override
            public E next() {
                @SuppressWarnings("unchecked")
                E aux=(E)datos[i];
                i++;
                return aux;
            }
            
        };
    }


}

