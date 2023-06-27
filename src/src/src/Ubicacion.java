package src;

import java.util.HashMap;
import java.util.Map;

public class Ubicacion {
    public int id;
    public String descripcion;
    public String direccion;
    Map<String, Integer> exits = new HashMap<>();
    public Ubicacion(int id, String descripcion){
        this.id=id;
        this.descripcion=descripcion;
        this.exits=new HashMap<String,Integer>();
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void addExit(String direccion, int idUbicacion){
        exits.put(direccion,idUbicacion);
    }


    public Map<String, Integer> getExits() {
        return exits;
    }
}