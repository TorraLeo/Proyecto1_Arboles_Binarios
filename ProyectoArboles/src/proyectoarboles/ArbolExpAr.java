package proyectoarboles;


/**
 *
 * @author Equipo 10
 */

public class ArbolExpAr {

    NodoA raiz;

    public ArbolExpAr() {
        raiz = null;
    }

    public ArbolExpAr(String cadena) {
        raiz = crearArbol(cadena);
    }

    public void vaciar() {
        raiz = null;
    }

    public void crearNodo(Object dato) {
        raiz = new NodoA(dato);
    }

    public NodoA crearSubArbol(NodoA d2, NodoA d1, NodoA padre) {
        padre.izq = d1;
        padre.der = d2;
        return padre;
    }

    public boolean vacio() {
        return raiz == null;
    }

    private String postOrden(NodoA subArbol, String c) {
        String cadena = "";
        if (subArbol != null) {
            cadena = c + postOrden(subArbol.izq, c) + postOrden(subArbol.der, c) + subArbol.dato.toString() + "\n";

        }
        return cadena;
    }

    public String toString() {
        String cadena = "";
        cadena = postOrden(raiz, cadena);
        return cadena;
    }

    private int determinarPrioridad(char c) {
        int p = 100;
        switch (c) {
            case '^': {
                p = 30;
                break;
            }

            case '*': {
                p = 20;
                break;
            }
            case '/': {
                p = 20;
                break;
            }

            case '+': {
                p = 10;
                break;
            }

            case '-': {
                p = 10;
                break;
            }

            default: {
                p = 0;
                break;
            }

        }
        return p;
    }

    private boolean operador(char c) {
        boolean resultado;
        switch (c) {

            case '(': {
                resultado = true;
                break;
            }

            case ')': {
                resultado = true;
                break;
            }

            case '^': {
                resultado = true;
                break;
            }

            case '*': {
                resultado = true;
                break;
            }

            case '/': {
                resultado = true;
                break;
            }

            case '+': {
                resultado = true;
                break;
            }

            case '-': {
                resultado = true;
                break;
            }

            default: {
                resultado = false;
                break;
            }
        }
        return resultado;
    }

    private NodoA crearArbol(String cadena) {

        Pila operadores;
        Pila expresiones;

        NodoA token;

        NodoA op1;
        NodoA op2;
        NodoA op;

        operadores = new Pila();
        expresiones = new Pila();

        char caracter;

        for (int i = 0; i < cadena.length(); i++) {
            caracter = cadena.charAt(i);
            token = new NodoA(caracter);
            if (!operador(caracter)) {
                expresiones.insercion(token);
            } else {
                switch (caracter) {
                    case '(': {
                        operadores.insercion(token);
                        break;
                    }

                    case ')': {
                        while (!operadores.vacia() && !operadores.topePila().dato.equals('(')) {
                            op2 = expresiones.pop();
                            op1 = expresiones.pop();
                            op = operadores.pop();
                            op = crearSubArbol(op2, op1, op);
                            expresiones.insercion(op);
                        }
                        operadores.pop();
                        break;
                    }

                    default:
                        while (!operadores.vacia() && determinarPrioridad(caracter) <= determinarPrioridad(operadores.topePila().dato.toString().charAt(0))) {
                            op2 = expresiones.pop();
                            op1 = expresiones.pop();
                            op = operadores.pop();
                            op = crearSubArbol(op2, op1, op);
                            expresiones.insercion(op);
                        }
                        operadores.insercion(token);

                }
            }
        }
        while (!operadores.vacia()) {
            op2 = expresiones.pop();
            op1 = expresiones.pop();
            op = operadores.pop();
            op = crearSubArbol(op2, op1, op);
            expresiones.insercion(op);
        }

        op = expresiones.pop();
        return op;
    }//fin metodo

    private double evalua(NodoA subarbol) {
        double a = 0;
        if (!operador(subarbol.dato.toString().charAt(0))) {
            return Double.parseDouble(subarbol.dato.toString());
        } else {
            switch (subarbol.dato.toString().charAt(0)) {

                case '^': {
                    a += Math.pow(evalua(subarbol.izq), evalua(subarbol.der));
                    break;
                }

                case '*': {
                    a += evalua(subarbol.izq) * evalua(subarbol.der);
                    break;
                }

                case '/': {
                    a += evalua(subarbol.izq) / evalua(subarbol.der);
                    break;
                }
                
                case '+': {
                    a += evalua(subarbol.izq) + evalua(subarbol.der);
                    break;
                }
                
                case '-': {
                    a += evalua(subarbol.izq) - evalua(subarbol.der);
                    break;
                }  
            }
            return a;
        }
    }

    public double evaluaExpresion() {
        return evalua(raiz);
    }

}