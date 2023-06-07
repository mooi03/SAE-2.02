package Test;

import model.Joueur;
import model.Quete;
import model.Scan;

import java.io.File;
import java.util.List;
import java.util.TreeMap;

public class TestJoueur {
    public static void main(String[] args) {
        File scenario = new File("src" + File.separator + "scenario" + File.separator + "scenario_test.txt");
        TreeMap <Integer,Quete> mapTeste = new TreeMap<>() ;
        List<Quete> quetes = Scan.Lecture(scenario);
        for(Quete e : quetes){
            mapTeste.put(e.getNumero(), e) ;
        }
        for(int e : mapTeste.keySet()){
            Joueur tim = new Joueur(quetes);
            int dureeDeplacement = tim.getCoordonnees().compareTo(mapTeste.get(e).getPos());
            tim.faireQuete(e) ;
            if (e != 0) {
                if ((tim.getChExperience() == mapTeste.get(e).getExperience()) && (tim.getTemps() == mapTeste.get(e).getDuree() + dureeDeplacement) && (tim.getCoordonnees().compareTo(mapTeste.get(e).getPos()) == 0)) {
                    System.out.println("ça marche pour " + e);
                } else {
                    System.out.println("ça marche pas pour " + e);
                }
            }
            else {
                if ((tim.getChExperience() == 0) && (tim.getTemps() == mapTeste.get(e).getDuree() + dureeDeplacement) && (tim.getCoordonnees().compareTo(mapTeste.get(e).getPos()) == 0)){
                    System.out.println("ça marche pour " + e +" qui est la quête final");
                }
                else {
                    System.out.println("ça marche pas pour " + e +" qui est la quête final") ;
                }
                }

        }
    }
}
