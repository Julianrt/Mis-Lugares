package mislugares.perstudio.com.mislugares;

import java.util.ArrayList;
import java.util.List;

public class Lugares {

    protected static List<Lugar> vectorLugares = ejemploLugares();

    public Lugares(){
        vectorLugares = ejemploLugares();
    }
    static Lugar elementos(int id){
        return vectorLugares.get(id);
    }
    static void anyade(Lugar lugar){
        vectorLugares.add(lugar);
    }
    static int nuevo(){
        Lugar lugar = new Lugar();
        vectorLugares.add(lugar);
        return vectorLugares.size()-1;
    }
    static void borrar(int id){
        vectorLugares.remove(id);
    }
    public static int size(){
        return vectorLugares.size();
    }
    public static ArrayList<Lugar> ejemploLugares(){
        ArrayList<Lugar> lugares = new ArrayList<Lugar>();

        lugares.add(new Lugar("ITH","Av. Tecnologico col. Sahuaro",-0.166093,38.995656,
                TipoLugar.EDUCACION,634106,"google.com","Excelente escuela",3));
        lugares.add(new Lugar("INTERCHAT","Pitahaya #6 col.Nuevo Sahuaripa",29.061361,-109.236947,
                TipoLugar.COMPRAS,634106,"interchat.com","Excelente servicio",10));

        return lugares;
    }

}
