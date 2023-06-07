package model;

import java.util.List;
import java.util.TreeMap;

public class Graphe {
    private TreeMap<Integer,Precond> dicoGraphe = new TreeMap<>();
    /**
     * Initialise un graphe à partir d'une liste de quêtes.
     *
     * @param quetes La liste des quêtes à utiliser pour construire le graphe.
     */
    public Graphe(List<Quete> quetes){
        for ( Quete point : quetes ){
            dicoGraphe.put(point.getNumero(), point.getPrecond()) ;
        }
    }
    /**
     * Vérifie si les quêtes du graphe sont réalisables en fonction des quêtes déjà terminées.
     *
     * @param listFini La liste des quêtes déjà terminées.
     * @return Un TreeMap associant chaque numéro de quête à une valeur booléenne indiquant si elle est réalisable.
     */
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

