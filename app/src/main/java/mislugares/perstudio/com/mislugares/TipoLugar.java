package mislugares.perstudio.com.mislugares;


public enum TipoLugar {

    OTROS ("Otros",5),
    RESTAURANTE ("Restaurante",2),
    BAR("Bar",6),
    COPAS("Copas",0),
    ESPECTACULOS("Espectaculos",0),
    HOTEL("Hotel",0),
    COMPRAS("Compras",0),
    EDUCACION("Educacion",0),
    DEPORTE("Deporte",0),
    NATURALEZA("Naturaleza",0),
    GASOLINERA("Gasolonera",0);

    private final String texto;
    private final int recurso;

    TipoLugar(String texto, int recurso){
        this.texto = texto;
        this.recurso = recurso;
    }

    public String getTexto() {
        return texto;
    }

    public int getRecurso() {
        return recurso;
    }
}
