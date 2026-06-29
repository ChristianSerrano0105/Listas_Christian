public interface Lista<E> extends Iterable<E> {

  //Recuerden implementar todos los métodos en ArrayList.
	/**
	 * Agrega un elemento al final de la coleccion
	 * @param e Elemento que se agregara a la coleccion
	 */
	public void agregarElemento(E e);
	/**
	 * Agrega un elemento al inicio de la coleccion
	 * @param e Elemento que se agregara a la coleccion
	 */
	public void agregarInicio(E e);	
	/**
	 * Agrega un elemento al final de la coleccion
	 * @param e Elemento que se agregara a la coleccion
	 */
	public void agregarFinal(E e);
	/**
	 * Agrega un elemento en una determinada posicion
	 * @param e Elemento que se agregara a la coleccion
	 * @param posicion La posicion del elemento que se va agregar
	 */
	public void agregarPosicion(E e,int posicion);
	/**
	 * Elimina un elemento del final de la coleccion
	 * @param e Elemento que se eliminara la coleccion
	 */
	public E eliminarElemento();
	/**
	 * Elimina un elemento del inicio de la coleccion
	 * @param e Elemento que se eliminara la coleccion
	 */
	public E eliminarElementoInicio();
	/**
	 * Elimina un elemento del final de la coleccion
	 * @param e Elemento que se eliminara la coleccion
	 */
	public E eliminarElementoFinal();
	/**
	 * Elimina un elemento de un determinada posicion
	 * @param posicion La posicion del elemento a eliminar
	 */
	public E eliminarElementoPosicion(int posicion);

	/**
	 * Regresa verdadero si la coleccion es vacia
	 */
	public boolean esVacia();

	/**
	 * Regresa el numero de elementos  de la coleccion
	 */
	public int  numElementos();

	/**
	 * Elimina todos los elementos de la lista
	 */
	public void  limpiarLista();

	/**
	 * Regresa la coleccion como un arreglo
	 */
	public E[]  convertirArreglo();
	
	/**
	 * Regresa el elemento en una posicion particular
	 * @param posicion Posicion del elemento a regresar
	 */
	public E consultar(int posicion);
	
}