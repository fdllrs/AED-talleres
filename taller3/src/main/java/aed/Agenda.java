package aed;

public class Agenda {

    private Fecha _fechaActual;
    private ArregloRedimensionableDeRecordatorios _recordatorios;


    public Agenda(Fecha fechaActual) {
        this._fechaActual = new Fecha(fechaActual.dia(), fechaActual.mes());
        _recordatorios = new ArregloRedimensionableDeRecordatorios();
    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
        _recordatorios.agregarAtras(recordatorio);

    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();

        buffer.append(fechaActual());
        buffer.append("\n=====\n");
        for (int i = 0; i < _recordatorios.longitud(); i++) {
            if(fechaActual().equals(_recordatorios.obtener(i).fecha())){
                buffer.append(_recordatorios.obtener(i).toString());
                buffer.append("\n");
        }
        }
        return buffer.toString();
    }

    public void incrementarDia() {
        _fechaActual.incrementarDia();

    }

    public Fecha fechaActual() {
        return new Fecha(_fechaActual.dia(), _fechaActual.mes());
    }

}
