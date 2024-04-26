package aed;

import java.util.Arrays;

class ArregloRedimensionableDeRecordatorios implements SecuenciaDeRecordatorios {

    private Recordatorio[] _arreglo = new Recordatorio[0];


    public ArregloRedimensionableDeRecordatorios() {
    }
    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        this._arreglo = vector._arreglo;
    }

    public int longitud() {
        return this._arreglo.length;
    }

    public void agregarAtras(Recordatorio i) {
        Recordatorio[] nuevoArreglo = Arrays.copyOf(this._arreglo, longitud()+1);
        nuevoArreglo[longitud()] = i;
        this._arreglo = nuevoArreglo.clone();
    }

    public Recordatorio obtener(int i) {
        return this._arreglo[i];
    }

    public void quitarAtras() {
        Recordatorio[] nuevoArreglo = Arrays.copyOf(this._arreglo, longitud()-1);
        this._arreglo = nuevoArreglo.clone();
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
        Recordatorio[] nuevoArreglo = Arrays.copyOf(this._arreglo, longitud());
        nuevoArreglo[indice] = valor;
        this._arreglo = nuevoArreglo.clone();

    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        return new ArregloRedimensionableDeRecordatorios(this);
    }

}
