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

        lugares.add(new Lugar("Instituto Tecnologico de Hermosillo","Av. Tecnologico col. Sahuaro",
                29.097282,-110.996411,TipoLugar.EDUCACION,2606500,"ith.mx","Excelente escuela",4));

        lugares.add(new Lugar("INTERCHAT","Pitahaya #6 col.Nuevo Sahuaripa",29.061361,-109.236947,
                TipoLugar.COMPRAS,3430538,"interchat.com","Excelente servicio",5));

        return lugares;
    }

}
