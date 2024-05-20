// package aed;

// import java.util.*;

// public class ListaEnlazada<T> implements Secuencia<T> {
//     private Nodo primero;
//     private Nodo ultimo;
//     private int longitud;

//     private class Nodo {
//         T valor;
//         Nodo siguiente;
//         Nodo anterior;

//         Nodo(T elem){
//             this.valor = elem;
//             this.siguiente = null;
//             this.anterior = null;
//         }
//     }

//     public ListaEnlazada() {
//         this.primero = null;
//         this.ultimo = null;
//         this.longitud = 0;
//     }

//     public int longitud() {
//         return longitud;
//     }

//     public void agregarAtras(T elem) {
//         Nodo nuevoNodo = new Nodo(elem);
//         longitud++;
//         if (primero == null){
//             primero = nuevoNodo;
//             ultimo = nuevoNodo;
//         } else {
//             ultimo.siguiente = nuevoNodo;
//             nuevoNodo.anterior = ultimo;
//             ultimo = nuevoNodo;
//         }
//     }

//     public void agregarAdelante(T elem) {
//         Nodo nuevoNodo = new Nodo(elem);
//         longitud ++;
//         if (primero == null){
//             primero = nuevoNodo;
//             ultimo = nuevoNodo;
//         } else {
//             primero.anterior = nuevoNodo;
//             nuevoNodo.siguiente = primero;
//             primero = nuevoNodo;
//         }
//     }

//     public T obtener(int i) {
//         Nodo actual = primero;
//         for (int j = 0; j < i; j++){
//             actual = actual.siguiente;
//         }
//         return actual.valor;
//     }

//     public void eliminar(int i) {
//         Nodo actual = primero;
//         Nodo previo = primero;
//         if (i == 0) {
//             primero = primero.siguiente;
//             longitud-=1;
//         }
//         else {
//             for(int j = 0; j < i; j++){
//                 previo = actual;
//                 actual = actual.siguiente;
//             }
//             previo.siguiente = actual.siguiente;
//             actual = null;
//             longitud-=1;
//         }
//     }

//     public void modificarPosicion(int indice, T elem) {
//         Nodo actual = primero;
//         Nodo previo = primero;
//         Nodo nuevoNodo = new Nodo(elem);
//         for(int j = 0; j < indice; j++){
//             previo = actual;
//             actual = actual.siguiente;
//         }
//         if (indice == 0){
//             primero = nuevoNodo;
//         }
//         else {
//             previo.siguiente = nuevoNodo;
//             nuevoNodo.siguiente = actual.siguiente;
//         }
//     }

//     public ListaEnlazada<T> copiar() {
//         ListaEnlazada<T> nuevaLista = new ListaEnlazada<>();
//         Nodo actual = this.primero;
//         while (actual != null){
//             nuevaLista.agregarAtras(actual.valor);
//             actual = actual.siguiente;
//         }
//         return nuevaLista;
//     }

//     public ListaEnlazada(ListaEnlazada<T> lista) {
//         this.longitud = lista.longitud;
//         this.primero = lista.primero;
//         this.ultimo = lista.ultimo;

//     }

//     @Override
//     public String toString() {
//         StringBuffer sBuffer = new StringBuffer();
//         Nodo actual = this.primero;
//         sBuffer.append("[");
//         for (int j=0; j < longitud-1; j++){
//             sBuffer.append(actual.valor);
//             sBuffer.append(", ");
//             actual = actual.siguiente;
//         }
//         sBuffer.append(actual.valor);
//         sBuffer.append("]");
//         return sBuffer.toString();
//     }

//     private class ListaIterador implements Iterador<T> {
//     	Nodo puntero;

//         public ListaIterador(){
//             puntero = primero;
//         }

//         public boolean haySiguiente() {
// 	        return puntero.siguiente != null;
//         }
        
//         public boolean hayAnterior() {
// 	        return puntero.anterior != null;
//         }

//         public T siguiente() {
//             puntero = puntero.siguiente;
//             return puntero.valor;
//         }
        

//         public T anterior() {
// 	        puntero = puntero.anterior;
//             return puntero.valor;
//         }
//     }

//     public Iterador<T> iterador() {
//         return new ListaIterador();
//     }

// }
