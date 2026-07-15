public class PruebaColecciones {

    public static void main(String[] args) {

        //==========================================================
        // PILA IMPLEMENTADA CON ARRAYLIST
        //==========================================================

        System.out.println("===== PILA CON ARRAYLIST =====");

        // Se declara la variable utilizando la interfaz Pila.
// Esto significa que el compilador únicamente permitirá utilizar
// los métodos definidos en la interfaz Pila.
//
// Aunque el objeto creado es de la clase PilaArray y ésta utiliza
// internamente una Lista (ArrayList o LinkedList), dichos métodos
// permanecen ocultos para el usuario.
//
// Gracias a esto NO es posible ejecutar operaciones que romperían
// el comportamiento de una pila, por ejemplo:
//
// pila.agregarPosicion(10, 2);      // Error de compilación
// pila.eliminarElementoInicio();    // Error de compilación
// pila.consultar(3);                // Error de compilación
//
// El usuario solamente puede utilizar las operaciones propias de
// una pila:
//
// pila.apilar(...);
// pila.desapilar();
// pila.consultarCima();
//
// Este principio se conoce como "programar contra la interfaz y
// no contra la implementación", ya que la interfaz controla qué
// operaciones están disponibles para el usuario.

        Pila<Integer> pilaA = new PilaArray<>();

        pilaA.apilar(10);
        pilaA.apilar(20);
        pilaA.apilar(30);

        System.out.println("Elemento en la cima: "
                + pilaA.consultarCima());

        while (!pilaA.esVacia()) {
            System.out.println("Desapilando: "
                    + pilaA.desapilar());
        }

        /*
         * Las siguientes instrucciones NO compilan porque esos métodos
         * pertenecen a Lista y NO forman parte de la interfaz Pila.
         */

        // pilaA.agregarPosicion(50,1);
        // pilaA.eliminarElementoInicio();
        // pilaA.consultar(0);


        //==========================================================
        // PILA IMPLEMENTADA CON LINKEDLIST
        //==========================================================

        System.out.println("\n===== PILA CON LINKEDLIST =====");

        /*
         * Observe que únicamente cambiamos la implementación interna.
         *
         * El resto del código permanece exactamente igual.
         *
         * Esto demuestra que programamos utilizando la interfaz Pila
         * y no una implementación específica.
         */
        Pila<Integer> pilaL = new PilaLinked<>();
                

        pilaL.apilar(100);
        pilaL.apilar(200);
        pilaL.apilar(300);

        System.out.println("Elemento en la cima: "
                + pilaL.consultarCima());

        while (!pilaL.esVacia()) {
            System.out.println("Desapilando: "
                    + pilaL.desapilar());
        }


        //==========================================================
        // COLA IMPLEMENTADA CON ARRAYLIST
        //==========================================================

        System.out.println("\n===== COLA CON ARRAYLIST =====");

        /*
         * De forma similar, la variable es de tipo Cola.
         *
         * Aunque internamente utilice una Lista, únicamente estarán
         * disponibles las operaciones propias de una cola.
         */
        Cola<String> colaA = new ColaArray<>();

        colaA.encolar("Ana");
        colaA.encolar("Luis");
        colaA.encolar("Pedro");

        System.out.println("Elemento al frente: "
                + colaA.consultarFrente());

        while (!colaA.esVacia()) {
            System.out.println("Desencolando: "
                    + colaA.desencolar());
        }

        /*
         * Estas instrucciones tampoco compilan porque pertenecen a
         * la interfaz Lista y no a la interfaz Cola.
         */

        // colaA.agregarInicio("Carlos");
        // colaA.agregarPosicion("Laura",2);
        // colaA.eliminarElementoFinal();


        //==========================================================
        // COLA IMPLEMENTADA CON LINKEDLIST
        //==========================================================

         System.out.println("\n===== COLA CON LINKEDLIST =====");

        /*
         * Nuevamente únicamente cambiamos la implementación interna.
         * Todo el código que utiliza la cola permanece igual.
         */
        Cola<String> colaL = new ColaLinked<>();

        colaL.encolar("María");
        colaL.encolar("José");
        colaL.encolar("Laura");

        System.out.println("Elemento al frente: "
                + colaL.consultarFrente());

        while (!colaL.esVacia()) {
            System.out.println("Desencolando: "
                    + colaL.desencolar());
        }

        //==========================================================
        // CONCLUSIÓN
        //==========================================================

        /*
         * Observe que para cambiar de ArrayList a LinkedList solamente
         * fue necesario modificar UNA línea de código:
         *
         *      new ArrayList<>()
         *
         * por
         *
         *      new LinkedList<>()
         *
         * El resto del programa no sufrió ninguna modificación.
         *
         * Esto es posible porque el código trabaja utilizando las
         * interfaces Pila y Cola, y no depende de una implementación
         * específica.
         */
    }
}