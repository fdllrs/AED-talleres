package aed;

public class Fecha {

    private int _dia;
    private int _mes;

    public Fecha(int dia, int mes) {
        _dia = dia;
        _mes = mes;
    }

    public Integer dia() {
        return _dia;
    }

    public Integer mes() {
        return _mes;
    }

    @Override
    public String toString() {
        StringBuffer sbuffer = new StringBuffer();

        sbuffer.append(Integer.toString(_dia));
        sbuffer.append("/");
        sbuffer.append(Integer.toString(_mes));
        
        return sbuffer.toString();
    }

    @Override
    public boolean equals(Object otra) {
        
        boolean esClaseFecha = otra instanceof Fecha;

        if(!(esClaseFecha)){
            return false;
        }

        Fecha otraFecha = (Fecha) otra;

        return _dia == otraFecha.dia()
            && _mes == otraFecha.mes();

    }

    public void incrementarDia() {
        
        _dia = _dia + 1;

        if(_dia > diasEnMes(_mes)){
            _dia = 1;
            _mes = _mes + 1;
        };

        if (_mes == 13) _mes = 1;
        
    }

    private int diasEnMes(int mes) {
        int dias[] = {
                // ene, feb, mar, abr, may, jun
                31, 28, 31, 30, 31, 30,
                // jul, ago, sep, oct, nov, dic
                31, 31, 30, 31, 30, 31
        };
        return dias[mes - 1];
    }
}