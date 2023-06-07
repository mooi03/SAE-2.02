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
    public TreeMap<Integer,Boolean> estPossible(List<Integer> listFini) {
        TreeMap<Integer,Boolean> fin = new TreeMap<>() ;
        for ( int e : dicoGraphe.keySet()){
            fin.put(e,dicoGraphe.get(e).estPossible(listFini)) ;
        }
        return fin ;
    }
    public String toString() {
        return "Graphe{" +
                "dicoGraphe=" + dicoGraphe +
                '}';
    }
}

