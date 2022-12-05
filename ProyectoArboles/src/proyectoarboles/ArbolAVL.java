package proyectoarboles;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Clase de Árbol AVL *
 */
public class ArbolAVL {

    Nodo root;

    public ArbolAVL() {
        root = null;
    }

    public ArbolAVL(int valor) {
        root = new Nodo(valor);
    }

    public ArbolAVL(Nodo raiz) {
        this.root = raiz;
    }

    protected void insertar(Nodo n, Nodo coso, ArbolAVL arbol) {
        Nodo raiz = arbol.root;
        if (n.valor < raiz.valor && coso.valor < raiz.valor) {
            if (coso.valor < n.valor && n.izq == null && coso.insertado == false) {
                n.izq = coso;
                coso.insertado = true;
            } else if (coso.valor > n.valor && n.der == null && coso.insertado == false) {
                n.der = coso;
                coso.insertado = true;
            }
        } else if (n.valor > raiz.valor && coso.valor > raiz.valor) {
            if (coso.valor < n.valor && n.izq == null && coso.insertado == false) {
                n.izq = coso;
                coso.insertado = true;
            }
            if (coso.valor > n.valor && n.der == null && coso.insertado == false) {
                n.der = coso;
                coso.insertado = true;
            }
        }
    }

    public void insercion(Nodo coso, ArbolAVL arbol) {
        Nodo r = root;
        Queue<Nodo> queue = new LinkedList();
        if (r != null) {
            queue.add(r);
            while (!queue.isEmpty()) {
                r = (Nodo) queue.poll();
                insertar(r, coso, arbol);
                if (r.izq != null) {
                    queue.add(r.izq);
                }
                if (r.der != null) {
                    queue.add(r.der);
                }
            }
        }
    }

    protected void visit(Nodo n) {
        System.out.println(n);
    }

    public void breadthFrist() {
        Nodo r = root;
        Queue<Nodo> queue = new LinkedList();
        if (r != null) {
            queue.add(r);
            while (!queue.isEmpty()) {

                r = (Nodo) queue.poll();
                visit(r);

                if (r.izq != null) {
                    queue.add(r.izq);
                }
                if (r.der != null) {
                    queue.add(r.der);
                }
            }
        }
    }

    public void nivel() {
        //evaluar si es avl
        // si lo es, no hace nada

        Nodo r = root;
        int nivel = 0;
        int contador = 1;
        int cuentaElementos = 0;
        int nuloSigNivel = 0;
        Queue<Nodo> queue = new LinkedList();
        if (r != null) {
            queue.add(r);
            while (!queue.isEmpty()) {
                r = (Nodo) queue.poll();
                cuentaElementos += 1;
                r.nivel = nivel;

                if (r.izq != null) {
                    queue.add(r.izq);
                }
                if (r.izq == null) {
                    nuloSigNivel += 1;
                }
                if (r.der != null) {
                    queue.add(r.der);
                }
                if (r.der == null) {
                    nuloSigNivel += 1;
                }
                if (contador == cuentaElementos) {
                    cuentaElementos = 0;
                    cuentaElementos += nuloSigNivel;
                    nuloSigNivel = 0;
                    nivel += 1;
                    contador = (int) Math.pow(2, nivel);
                }
            }
        }
    }
    
    public boolean avl(){
        Nodo r = root;
        Queue<Nodo> queue = new LinkedList();
        if (r != null) {
            queue.add(r);
            while (!queue.isEmpty()) {

                r = (Nodo) queue.poll();

                if (r.izq != null) {
                    queue.add(r.izq);
                    if((r.izq.nivel)-(r.nivel) > 1 ){
                        return false;
                    }
                }
                if (r.der != null) {
                    queue.add(r.der);
                    if((r.der.nivel)-(r.nivel) > 1 ){
                        return false;
                    }
                }
            }
        }
            return true;
    }

    public void rotaciones() {
        //evalua que tipo de rotación debe hacer y manda llamar el método
    }

    public void IzqIzq() {
    }

    public void DerDer() {
    }

    public void IzqDer() {
    }

    public void DerIzq() {
    }

    
       public boolean busqueda(int buscado) {
        Nodo r = root;
        Queue<Nodo> queue = new LinkedList();
        boolean encontrado = false;
        if (r != null) {
            queue.add(r);
            while (!queue.isEmpty()) {
                r = (Nodo) queue.poll();
                if (r.valor == buscado) {
                    encontrado = true;
                    System.out.println("valor: " + r.valor);
                }
                if (r.izq != null) {
                    queue.add(r.izq);
                }
                if (r.der != null) {
                    queue.add(r.der);
                }

            }
        }
        return encontrado == true;
    }
}
