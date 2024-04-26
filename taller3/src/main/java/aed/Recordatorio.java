package aed;

public class Recordatorio {

    private String _mensaje;
    private Fecha _fecha;
    private Horario _horario;


    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        _mensaje = new String(mensaje);
        _fecha = new Fecha(fecha.dia(), fecha.mes());
        _horario = new Horario(horario.hora(), horario.minutos());
    }

    public Horario horario() {
        return new Horario(_horario.hora(), _horario.minutos());
    }

    public Fecha fecha() {
        return new Fecha(_fecha.dia(), _fecha.mes());
    }

    public String mensaje() {
        return new String(_mensaje);
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();

        buffer.append(_mensaje);
        buffer.append(" @ ");
        buffer.append(_fecha.toString());
        buffer.append(" ");
        buffer.append(_horario.toString());

        return buffer.toString();
    }

    @Override
    public boolean equals(Object otro) {
        boolean esClaseRecordatorio = otro instanceof Recordatorio;

        if (!esClaseRecordatorio) return false;

        Recordatorio otroRecordatorio = (Recordatorio) otro;

        return 
        this.mensaje().equals(otroRecordatorio.mensaje()) &&
        this.fecha().equals(otroRecordatorio.fecha()) &&
        this.horario().equals(otroRecordatorio.horario());
    }

}
