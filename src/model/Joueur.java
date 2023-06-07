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
    public String faireQuete(int numeroQuete){
        String str = "" ;
        Quete queteChoisie = null ;
        int numDansList = Integer.MIN_VALUE ;
        int i = 0 ;
        for (Quete quete : queteARealise){  /// on vas chercher la quete que l'on doit faire dans la liste de quete que l'on a en champ
            if (quete.getNumero() == numeroQuete) {
                queteChoisie  = quete;
                numDansList = i ;
            }
            i++ ;
        }
        queteFini.add(numeroQuete);
        queteARealise.remove(numDansList) ;
        int tempsDeplacement = coordonnees.compareTo(queteChoisie.getPos());
        Temps += tempsDeplacement ;
        str = str + "\n \n----------- quete : " + queteChoisie.getNumero() + " -----------" ;
        str = str + "\n position : " + coordonnees.toString() + " -> " + queteChoisie.getPos().toString() + "\n temps déplacement : " + tempsDeplacement + "\n temps de la quête :" + queteChoisie.getDuree();
        coordonnees.setPosition(queteChoisie.getPos().getChPosX(),queteChoisie.getPos().getChPosY());
        if (numeroQuete != 0){
            chExperience += queteChoisie.getExperience();
            str = str + "\n xp de la quête : " + queteChoisie.getExperience() + " xp" ;
        }
        else {
            str = str + "\n xp minimum : " + queteChoisie.getExperience() + " xp" ;
        }
        Temps += queteChoisie.getDuree() ;
        str = str + "\n temps total : " + Temps + "\n xp total : " + chExperience + " xp";
        return str ;
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
