package proyectoarboles;

public class Pila {

    private NodoB tope;

    public Pila() {
        tope = null;
    }

    public void insercion(NodoA coso) {
        NodoB nuevo = new NodoB(coso);
        nuevo.next = tope;
        tope = nuevo;
    }

    public boolean vacia() {
        return tope == null;
    }

    public NodoA topePila() {
        return tope.dato;
    }
    
    public void vaciarPila(){
    tope = null;
    }
    
    public NodoA pop(){
        
        NodoA temp =null;
        if(!vacia()){
        temp = tope.dato;
        tope = tope.next;
        }
        return temp;
    }
    
    
}

