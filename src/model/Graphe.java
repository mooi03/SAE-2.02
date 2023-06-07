package model;

import java.util.List;
import java.util.TreeMap;

public class Graphe {
    private TreeMap<Integer,Precond> dicoGraphe = new TreeMap<>();
    public Graphe(List<Quete> quetes){
        for ( Quete point : quetes ){
            dicoGraphe.put(point.getNumero(), point.getPrecond()) ;
        }
    }
    public String toString() {
        return "Graphe{" +
                "dicoGraphe=" + dicoGraphe +
                '}';
    }
}

