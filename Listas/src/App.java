public class App {

    public static void main(String[] args) {

        //Lista<Integer> lista = new ArrayList<>();
        Lista<Integer> lista = new LinkedList<>();

        System.out.println("===== LISTA RECIEN CREADA =====");
        System.out.println("¿Está vacía? " + lista.esVacia());       // true
        System.out.println("Elementos: " + lista.numElementos());    // 0

        System.out.println("\n===== AGREGAR ELEMENTOS =====");
        lista.agregarElemento(10);
        lista.agregarFinal(20);
        lista.agregarFinal(30);

        System.out.println("Lista esperada: 10 20 30");
        imprimir(lista);

        System.out.println("\n===== AGREGAR AL INICIO =====");
        lista.agregarInicio(5);

        System.out.println("Lista esperada: 5 10 20 30");
        imprimir(lista);

        System.out.println("\n===== AGREGAR EN POSICION =====");
        lista.agregarPosicion(15, 2);

        System.out.println("Lista esperada: 5 10 15 20 30");
        imprimir(lista);

        System.out.println("\n===== CONSULTAR =====");
        System.out.println("consultar(0), esperado 5: " + lista.consultar(0));
        System.out.println("consultar(2), esperado 15: " + lista.consultar(2));
        System.out.println("consultar(4), esperado 30: " + lista.consultar(4));

        System.out.println("\n===== ELIMINAR INICIO =====");
        System.out.println("Eliminado esperado 5: " + lista.eliminarElementoInicio());
        System.out.println("Lista esperada: 10 15 20 30");
        imprimir(lista);

        System.out.println("\n===== ELIMINAR FINAL =====");
        System.out.println("Eliminado esperado 30: " + lista.eliminarElementoFinal());
        System.out.println("Lista esperada: 10 15 20");
        imprimir(lista);

        System.out.println("\n===== ELIMINAR POSICION =====");
        System.out.println("Eliminado esperado 15: " + lista.eliminarElementoPosicion(1));
        System.out.println("Lista esperada: 10 20");
        imprimir(lista);

        System.out.println("\n===== ELIMINAR ELEMENTO =====");
        System.out.println("Eliminado esperado 20: " + lista.eliminarElemento());
        System.out.println("Lista esperada: 10");
        imprimir(lista);

        System.out.println("\n===== CONVERTIR A ARREGLO =====");

        Object[] arreglo = lista.convertirArreglo();

        System.out.print("Arreglo esperado: 10\nResultado: ");
        for (Object elemento : arreglo) {
            System.out.print(elemento + " ");
        }

        System.out.println("\n\n===== LIMPIAR LISTA =====");
        lista.limpiarLista();

        System.out.println("¿Está vacía? esperado true: " + lista.esVacia());
        System.out.println("Elementos esperado 0: " + lista.numElementos());
        imprimir(lista);
    }

    public static void imprimir(Lista<Integer> lista) {
        System.out.print("Resultado: ");

        for (Integer elemento : lista) {
            System.out.print(elemento + " ");
        }

        System.out.println();
        System.out.println("Número de elementos: " + lista.numElementos());
    }
}
