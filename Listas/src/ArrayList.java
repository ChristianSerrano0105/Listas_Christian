
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
	public int busquedaLinealRecursiva(E e) {
		return busquedaRecursivaHelper(e, 0);
	}

	private int busquedaRecursivaHelper(E e, int index) {
		if (index >= indice) return -1;
		if (datos[index].equals(e)) return index;
		return busquedaRecursivaHelper(e, index + 1);
	}

	@SuppressWarnings("unchecked")
	@Override
	public int busquedaBinaria(E e) {
		
		Comparable<E> comp = (Comparable<E>) e;
		int inicio = 0;
		int fin = indice - 1;

		while (inicio <= fin) {
			int medio = inicio + (fin - inicio) / 2;
			int cmp = comp.compareTo((E) datos[medio]);

			if (cmp == 0) return medio;
			if (cmp > 0) inicio = medio + 1;
			else fin = medio - 1;
		}
		return -1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void ordenaInsercion() {
		for (int i = 1; i < indice; i++) {
			E clave = (E) datos[i];
			int j = i - 1;
			Comparable<E> comp = (Comparable<E>) clave;

			while (j >= 0 && comp.compareTo((E) datos[j]) < 0) {
				datos[j + 1] = datos[j];
				j--;
			}
			datos[j + 1] = clave;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void ordenaMerge() {
		if (indice <= 1) return;
		Object[] temp = new Object[indice];
		mergeSortHelper(0, indice - 1, temp);
	}

	@SuppressWarnings("unchecked")
	private void mergeSortHelper(int inicio, int fin, Object[] temp) {
		if (inicio >= fin) return;
		int medio = inicio + (fin - inicio) / 2;
		mergeSortHelper(inicio, medio, temp);
		mergeSortHelper(medio + 1, fin, temp);

		
		int i = inicio, j = medio + 1, k = inicio;
		while (i <= medio && j <= fin) {
			Comparable<E> comp = (Comparable<E>) datos[i];
			if (comp.compareTo((E) datos[j]) <= 0) {
				temp[k++] = datos[i++];
			} else {
				temp[k++] = datos[j++];
			}
		}
		while (i <= medio) temp[k++] = datos[i++];
		while (j <= fin) temp[k++] = datos[j++];
		for (i = inicio; i <= fin; i++) datos[i] = temp[i];
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

