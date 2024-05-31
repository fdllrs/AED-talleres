package aed;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    private Nodo minimo;
    private Nodo maximo;
    private int cardinal;

    private Nodo raiz;

    private class Nodo {
        private T valor;

        private Nodo raiz;
        private Nodo izq;
        private Nodo der;


        private Nodo(T v){
            valor = v;
        }

    }

    public ABB() {
        cardinal = 0;
    }

    private boolean esHoja(Nodo nodo){
        return (nodo.izq == null && nodo.der == null);
    }

    private boolean tieneUnHijo(Nodo nodo){
        return (nodo.izq == null || nodo.der == null) && !(esHoja(nodo));
    }


    private Nodo sucesor(Nodo nodo){
        Nodo res = nodo;

        //caso hay arbol derecho
        if(nodo.der != null){
            res = nodo.der;
            while(res.izq != null){
                res = res.izq;
            }
            
        }
        //caso arbol izquierdo
        else{
            res = res.raiz;
            while(res != null && nodo.valor.compareTo(res.valor) > 0){
                res = res.raiz;
            }
        }
        return res;
        }


    private Nodo busquedaRecursiva(Nodo actual, T elem){
        if (actual == null || actual.valor.compareTo(elem) == 0){ return actual;}

        if (elem.compareTo(actual.valor) > 0){
            if(actual.der == null){return actual;}
           return busquedaRecursiva(actual.der, elem);
        } 
        
        else{
            if(actual.izq == null){return actual;}
            return busquedaRecursiva(actual.izq, elem);
        }

    }


    private void actualizarMaximoYMinimo(Nodo nodo){
        if(nodo.valor.compareTo(maximo.valor) > 0){
            maximo = nodo;
        }
        if(nodo.valor.compareTo(minimo.valor) < 0){
            minimo = nodo;
        }
    }


    public int cardinal() {
        return cardinal;
    }

    public T minimo(){
        return minimo.valor;
    }

    public T maximo(){
        return maximo.valor;
    }

    public void insertar(T elem){
        if(pertenece(elem)) { return;}

        Nodo nodo = new Nodo(elem);
        //caso especial para el primer nodo.
        if(raiz == null){
            cardinal++;
            raiz = nodo;
            
            maximo = raiz;
            minimo = raiz;
            return;
        }

        Nodo posicion =  busquedaRecursiva(this.raiz, elem);

        if (posicion.valor == elem){
            return;}
        
        actualizarMaximoYMinimo(nodo);


        //ubico el nuevo nodo.
        if (elem.compareTo(posicion.valor) > 0){
            posicion.der = nodo;
            nodo.raiz = posicion;

        } else{
            posicion.izq = nodo;
            nodo.raiz = posicion;
        }

        cardinal++;

    }

    public boolean pertenece(T elem){
        Nodo res = busquedaRecursiva(raiz, elem);

        if (res == null){ return false;}

        return res.valor.compareTo(elem) == 0;
    }



    public void eliminar(T elem){
        Nodo nodo = busquedaRecursiva(raiz, elem);

        if(nodo.valor.compareTo(elem) != 0){return;}

        
        if(esHoja(nodo)){
            cardinal--;
            if(nodo == raiz){raiz = null;}
            
            if(nodo.raiz.izq == nodo){nodo.raiz.izq = null;}
            else if(nodo.raiz.der == nodo){nodo.raiz.der = null;}

            nodo.raiz = null;
            

            return;
        }

        if(tieneUnHijo(nodo)){
            cardinal--;
            
            Nodo hijo;
            if(nodo.der != null){hijo = nodo.der;}
            else{hijo = nodo.izq;}
            
            if(nodo == raiz){
                raiz = hijo;
                return;
            }
            else{
                hijo.raiz = nodo.raiz;
            }


            if(nodo.raiz.izq == nodo){nodo.raiz.izq = hijo;}
            else if(nodo.raiz.der == nodo){nodo.raiz.der = hijo;}


            nodo.raiz = null;
            nodo.izq = null;
            nodo.der = null;
            return;
        }

        
        
        Nodo sucesor = sucesor(nodo);
        eliminar(sucesor.valor);
        
        nodo.valor = sucesor.valor;
    }

    public String toString(){
        StringBuffer buffer = new StringBuffer();
        Iterador<T> it = iterador();
        buffer.append("{");
        while (it.haySiguiente()) {
            buffer.append(it.siguiente().toString());
            buffer.append(",");
        }
        buffer.append(it.siguiente().toString());

        buffer.append("}");

        return buffer.toString();


    }

    private class ABB_Iterador implements Iterador<T> {
        private Nodo actual = minimo;

        public boolean haySiguiente() {
            return (actual != maximo);
        }
    
        public T siguiente() {
            Nodo prev = actual;
            actual = sucesor(actual);
            return prev.valor;
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

}
