package proyectoarboles;

public class HeapBinario {

    private int d;
    /**
     * El numero de hijos que tendra cada nodo se define aqui *
     */
    private int tamañoHeap;
    private int[] heap;

    /**
     * Constructor de la clase que inicializa nuestro heap con el tamaño por default*
     */
    public HeapBinario(int capacidad) {
        this.d = 2;
        tamañoHeap = 0;
        heap = new int[capacidad + 1];
    }

    /**
     * Funcion que revisara si el heap se encuentra vacio *
     */
    public boolean estaVacio() {
        return tamañoHeap == 0;
    }

    /**
     * Funcion que revisara si el heap se encuentra lleno *
     */
    public boolean estaLleno() {
        return tamañoHeap == heap.length;
    }

    /**
     * Funcion para obtener el indice del padre en i usando maxHeap*
     */
    public int padre(int i) {
        return (i - 1) / d;
    }

    /**
     * Funcion para obtener el indice del hijo izquierdo usando maxHeap*
     */
    public int hijoIzq(int i) {
        return (d * i + 1);
    }

    /**
     * Funcion para obtener el indice del hijo derecho usando maxHeap*
     */
    public int hijoDere(int i) {
        return (d * i) + d;
    }

    /**
     * Funcion para comprobar si nuestro nodo es rama*
     */
    public boolean esRama(int i) {

        if (i > (tamañoHeap / d) && i <= tamañoHeap) {
            return true;
        }

        return false;
    }

    /**
     * Funcion para intercambiar los nodos*
     */
    public void intercambia(int fi, int si) {
        int aux;
        aux = heap[fi];
        heap[fi] = heap[si];
        heap[si] = aux;
    }

    /**
     * Agrega la clave con esta funcion al arbol de heap maximo cuyo algoritmo
     * de insercion es el siguiente incrementar el tamaño del heap manten el
     * ultimo elemento al final del heap Realizar heapify del fondo al tope del
     * arbol
     */
    public void agregarClave(int x) {
        heap[tamañoHeap] = x;
        int actual = tamañoHeap;
        while (heap[actual] > heap[padre(actual)]) {
            intercambia(actual, padre(actual));
            actual = padre(actual);
        }
        tamañoHeap++;
    }

    /**
     * Muestra Recorrido de Heap del arbol*
     */
    public void mostrarArbol() {
        // si el heap es de 1 solo elemento entonces imprimelo como padre
        if (heap.length == 1) {
            System.out.println("Nodo Padre: " + heap[0]);
        }

        for (int i = 0; i < tamañoHeap / d; i++) {

            System.out.print(" Nodo Padre : " + heap[i]);

            if (hijoIzq(i)
                    < tamañoHeap) // if para revisar que el nodo no este fuera del heap
            {
                System.out.print(" Nodo Hijo Izquierdo "
                        + heap[hijoIzq(i)]);
            }
            if (hijoDere(i)
                    < tamañoHeap) // If para revisar que el indice del nodo derecho no este fuera del heap
            {
                System.out.print(" Nodo Hijo Derecho: "
                        + heap[hijoDere(i)]);
            }

            System.out.println(); //Nueva linea
        }

    }

    /**
     * Borra la Clave del indice especificado algoritmo Copia el primer elemento
     * en una variable llamada llave Copia el ultimo elemento a la primer
     * posicion llama a mantener heap al borrar
     *
     */
    public int borrarClave(int x) {
        int llave = heap[x];
        heap[x] = heap[tamañoHeap - 1];
        tamañoHeap--;
        heapifyMaximo(x);
        return llave;
    }

    /**
     * Mantener el heap al borrar un elemento empleando el proceso de heapify
     * maximo, conseguiendo asi que los elementos mayores se conserven aun
     * cuando se emplea el operador borrar. Al hacer la siguiente funcion
     * mantenemos la estructura de heap al no detener el heapífy en el arbol,
     * siendo los padres siempre mayores o iguales a sus hijos
     *
     */
    public void heapifyMaximo(int x) {
        int aux = heap[x];
        int hijo;
        while (hijoIzq(x) < tamañoHeap) {
            hijo = heap[hijoIzq(x)] > heap[hijoDere(x)] ? hijoIzq(x) : hijoDere(x);
            if (aux < heap[hijo]) {
                heap[x] = heap[hijo];
            } else {
                break;
            }
            x = hijo;
            heap[x] = aux;
        }
    }

    /**
     * Imprimimos el Heap como un arreglo Se recorre el arreglo de Heap con cada
     * elemento obteniendo el heap como un arreglo en vez de arbol
     *
     */
    public void imprimirHeapArreglo() {
        System.out.print("\n Heap Maximo hecho arreglo = ");
        for (int i = 0; i < tamañoHeap; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

}