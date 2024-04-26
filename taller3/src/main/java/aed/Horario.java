package aed;

public class Horario {

    private int _hora;
    private int _minutos;


    public Horario(int hora, int minutos) {
        _hora = hora;
        _minutos = minutos;
    }

    public int hora() {
        return _hora;
    }

    public int minutos() {
        return _minutos;
    }

    @Override
    public String toString() {
         StringBuffer buffer = new StringBuffer();

        buffer.append(_hora);
        buffer.append(":");
        buffer.append(_minutos);

        return buffer.toString();

    }

    @Override
    public boolean equals(Object otro) {
      boolean esClaseHorario = otro instanceof Horario;

      if (!esClaseHorario) return false;

        Horario otroHorario = (Horario) otro;

      return otroHorario.hora() == this.hora()
      && otroHorario.minutos() == this.minutos();

    }

}
