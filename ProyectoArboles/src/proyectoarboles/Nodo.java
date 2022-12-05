package proyectoarboles;

import java.util.LinkedList;

public class Nodo {

    int valor;
    Nodo izq = null;
    Nodo der = null;
    int nivel;

    public Nodo() {
        izq = der = null;
    }

    public Nodo(int data) {
        this(data, null, null);
    }

    public Nodo(int data, Nodo lt, Nodo rt) {
        valor = data;
        izq = lt;
        der = rt;
    }

    public void setIzq(Nodo izq) {
        this.izq = izq;
    }

    public void setDer(Nodo der) {
        this.der = der;
    }

    public LinkedList preOrden(LinkedList visitados, Nodo coso) {
        if (coso != null) {
            visitados.add(coso);
            if (coso.izq != null) {
                coso.izq.preOrden(visitados, coso.izq);
            }
            if (coso.der != null) {
                coso.der.preOrden(visitados, coso.der);
            }
        }
        return visitados;
    }

    public LinkedList inOrden(LinkedList visitados, Nodo coso) {
        if (coso != null) {
            if (coso.izq != null) {
                coso.izq.inOrden(visitados, coso.izq);
            }
            visitados.add(coso);
            if (coso.der != null) {
                coso.der.inOrden(visitados, coso.der);
            }
        }
        return visitados;
    }
    
    public LinkedList postOrden(LinkedList visitados, Nodo coso) {
        if (coso != null) {
            if (coso.izq != null) {
                coso.izq.postOrden(visitados, coso.izq);
            }
            if (coso.der != null) {
                coso.der.postOrden(visitados, coso.der);
            }
            visitados.add(coso);
        }
        return visitados;
    }
    
    @Override
    public String toString() {
        return "valor= " + valor + " nivel= " + nivel;
    }
}
