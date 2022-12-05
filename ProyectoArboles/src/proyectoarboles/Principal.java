package proyectoarboles;

/**
 *
 * @author Equipo 10
 */
import java.util.LinkedList;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int salida = 1;

        do {
            System.out.println("");
            System.out.println("Menu");

            System.out.println("1)Árbol AVL");
            System.out.println("2)Heap");
            System.out.println("3)Árbol de Expresión Aritmética");
            System.out.println("4)Salir");
            int opc = entrada.nextInt();

            switch (opc) {// inicio sutch opc1

                case 1: {//------------------------------Arboles AVL--------------------------------

                    int salida1 = 1;
                    ArbolAVL arbolTemp1 = null;
                    LinkedList<Nodo> lista1 = new LinkedList<Nodo>();

                    System.out.println("--Creación de árbol AVL--");

                    System.out.println("inicialice la raíz de su árbol");
                    System.out.println("Valor de la raíz: ");
                    int temp1 = entrada.nextInt();
                    ;
                    System.out.println("Hijo izquierdo: ");
                    int temp2 = entrada.nextInt();
                    ;
                    System.out.println("Hijo derecho: ");
                    int temp3 = entrada.nextInt();
                    ;

                    Nodo t2 = new Nodo(temp2);
                    Nodo t3 = new Nodo(temp3);
                    Nodo t1 = new Nodo(temp1, t2, t3);

                    arbolTemp1 = new ArbolAVL(t1);

                    System.out.println("cuantos nodos desea crear? ");
                    int cantidad = entrada.nextInt();
                    lista1.add(t2);
                    lista1.add(t3);

                    for (int i = 0; i < cantidad; i++) {
                        System.out.println("valor del nodo: ");
                        int valorTemp = entrada.nextInt();
                        lista1.add(i, new Nodo(valorTemp));
                        arbolTemp1.insercion(lista1.get(i), arbolTemp1);
                    }
                    System.out.println("Arbol creado con éxito ");
                    

                    do {

                        System.out.println("\n---Árbol AVL---");
                        System.out.println("1)Agregar clave");
                        System.out.println("2)Buscar un valor");
                        System.out.println("3)Eliminar clave");
                        System.out.println("4)Mostrar árbol");
                        System.out.println("5)Regresar al menú anterior");
                        int opc1 = entrada.nextInt();

                        switch (opc1) {

                            case 1: {

                                System.out.println("\n-Agregar dato-");
                                System.out.println("valor del nodo: ");
                                lista1.add(new Nodo(entrada.nextInt()));

                                arbolTemp1.insercion(lista1.getLast(), arbolTemp1);
                                System.out.println("Dato agregado con éxito ");

                                break;
                            }

                            case 2: {

                                break;
                            }

                            case 3: {

                                break;
                            }

                            case 4: {
                                System.out.println("\n-Árbol creado-");
                                arbolTemp1.avl();
                                break;
                            }

                            case 5: {
                                salida1 = 0;
                                break;
                            }

                            default: {
                                System.out.println("Opcion incorrecta");
                                break;
                            }

                        }
                    } while (salida1 != 0);
                    break;
                }

                case 2: {//------------------------------Arboles Heap--------------------------------
                    System.out.println("\n---Heap---");
                    //Inicializacion de objeto tipo Scanner que leera las entradas 
                    Scanner lector = new Scanner(System.in);
                    System.out.println("Heap Binario con menú y sus operaciones\n\n");
                    System.out.println("Ingresa el tamaño del heap, toma en cuenta que empieza desde 0 el indice");
                    /**
                     * Objeto de heap binario *
                     */
                    HeapBinario hb = new HeapBinario(lector.nextInt());

                    char ch;

                    do {
                        System.out.println("\nOperaciones de Heap\n");
                        System.out.println("1. Agregar Clave ");
                        System.out.println("2. Eliminar Clave");
                        System.out.println("3. Mostrar Arbol");
                        //A través de una variable llamada eleccion creamos el lector de los proximos enteros
                        // que seran evaluados en el switch como operadores del arbol
                        int eleccion = lector.nextInt();
                        switch (eleccion) {
                            case 1:
                                if (hb.estaLleno()) {
                                    System.out.println("Has alcanzado el limite maximo de elementos");
                                } else {
                                    System.out.println("Escribe el valor de la clave que quieres agregar");
                                    hb.agregarClave(lector.nextInt());
                                }

                                break;
                            case 2:
                                if (hb.estaVacio()) {
                                    System.out.println("No hay elemento que borrar en un heap vacio");
                                } else {
                                    System.out.println("Escribe el indice(ind) de la clave que quieres borrar");
                                    hb.borrarClave(lector.nextInt());
                                }

                                break;
                            case 3:
                                if (hb.estaVacio()) {
                                    System.out.println("El Heap Binario se encuentra vacio");
                                } else {
                                    hb.mostrarArbol();
                                }
                                break;
                            default:
                                System.out.println("Entrada incorrecta \n ");
                                break;
                        }
                        hb.imprimirHeapArreglo();

                        System.out.println("\nQuieres continuar escribe (s/n) \n");
                        ch = lector.next().charAt(0);
                    } while (ch == 'S' || ch == 's');
                    break;
                }

                case 3: {//------------------------------Arboles expresión aritmética--------------------------------
                    System.out.println("\n---Árbol de Expresión Aritmética---");
                    break;
                }

                case 4: {
                    System.out.println("\nGracias por utilizar el programa :D\n");
                    salida = 0;
                    break;
                }

                default: {
                    System.out.println("\nOpcion incorrecta");
                    break;
                }
            }// fin switch opc1

        } while (salida != 0); //condicion menu principal
    }

}

