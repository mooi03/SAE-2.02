package model;
import java.util.ArrayList;
import java.util.List;
/**
 * La classe Joueur représente un joueur avec ses quêtes à réalisé, ses quêtes terminnées, son expérience, ses coordonées et le temps écoulé.
 */
public class Joueur {

    private List<Quete> queteARealise ;
    private ArrayList <Integer> queteFini ;
    private int chExperience ;
    private Position coordonnees ;
    private int Temps ;
    /**
     * Constructeur de la class Joueur qui initialise le joueur avec les quêtes données.
     *
     * @param quete La liste des quêtes à réalisé.
     */
    public Joueur( List<Quete> quete){
        queteARealise = quete ;
        queteFini = new ArrayList<Integer>() ;
        Temps = 0 ;
        chExperience = 0 ;
        coordonnees = new Position(0,0) ;
    }
    /**
     * Effectue une quête donnée en indiquant son numéro.
     *
     * @param numeroQuete Le numéro de la quête à réalisé.
     * @return Une chaîne de caractères décrivant les détails de la quête effectuée.
     */
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
    /**
     * Retourne la liste des quêtes terminées par le joueurs.
     *
     * @return La liste des quêtes terminées.
     */
    public ArrayList<Integer> getQueteFini() {
        return queteFini ;
    }
    /**
     * Retourne la liste des quêtes à réaliser par le joueurs.
     *
     * @return La liste des quêtes à réalisé.
     */
    public List<Quete> getQueteARealise() {
        return queteARealise ;
    }
    /**
     * Retourne l'expérience actuelle du joueur.
     *
     * @return L'expérience du joueur.
     */
    public int getChExperience() {
        return chExperience ;
    }
    /**
     * Retourne les coordonnées actuelles du joueur.
     *
     * @return Les coordonnées du joueur.
     */
    public Position getCoordonnees() {
        return coordonnees ;
    }
    /**
     * Retourne le temps total écoulé depuis le début du jeu.
     *
     * @return Le temps écoulé en secondes.
     */
    public int getTemps() {
        return Temps ;
    }
}
