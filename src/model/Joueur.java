package model;
import java.util.ArrayList;
import java.util.List;

public class Joueur {

    private List<Quete> queteARealise ;
    private ArrayList <Integer> queteFini ;
    private int chExperience ;
    private Position coordonnees ;
    private int Temps ;

    public Joueur( List<Quete> quete){
        queteARealise = quete ;
        queteFini = new ArrayList<Integer>() ;
        Temps = 0 ;
        chExperience = 0 ;
        coordonnees = new Position(0,0) ;
    }
    public ArrayList<Integer> getQueteFini() {
        return queteFini ;
    }
    public List<Quete> getQueteARealise() {
        return queteARealise ;
    }
    public int getChExperience() {
        return chExperience ;
    }
    public Position getCoordonnees() {
        return coordonnees ;
    }
    public int getTemps() {
        return Temps ;
    }
}
