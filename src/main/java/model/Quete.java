package model;

import java.util.Scanner;
/**
 * La classe Quete représente une quête avec ses attributs tels que le numéro, la position, les préconditions,
 * la durée, l'expérience et l'intitulé.
 */
public class Quete {
    private int numero ;
    private Position pos ;
    private Precond precond ;
    private int duree ;
    private int experience ;
    private String intitule ;
    /**
     * Constructeur de la classe Quete qui initialise les attributs à partir d'une ligne donnée.
     *
     * @param ligne La ligne contenant les informations de la quête séparées par des '|'.
     */
    public Quete(String ligne) {

        Scanner scanner = new Scanner(ligne).useDelimiter("\\|");

        while (scanner.hasNext()) {

            numero = scanner.nextInt();

            pos = new Position( scanner.next() ) ; /// on crée un objet de la classe Position

            precond = new Precond( scanner.next() );

            duree = scanner.nextInt();

            experience = scanner.nextInt();

            intitule = scanner.next();
        }

    }
    /**
     * Retourne une représentation sous forme de chaîne de caractères de la quête.
     *
     * @return Une chaîne de caractères représentant la quête.
     */
    public String toString() {
        return numero + "-" + pos + "-" + precond + "-" + duree + "-" + experience + "-" + intitule ;
    }
    /**
     * Retourne le numéro de la quête.
     *
     * @return Le numéro de la quête.
     */
    public int getNumero() {
        return numero ;
    }
    /**
     * Retourne les préconditions de la quête.
     *
     * @return Les préconditions de la quête.
     */
    public Precond getPrecond() {
        return precond ;
    }
    /**
     * Retourne la position de la quête.
     *
     * @return La position de la quête.
     */
    public Position getPos(){return pos ;}
    /**
     * Retourne l'expérience de la quête.
     *
     * @return L'expérience de la quête.
     */
    public int getExperience(){return experience ;}
    /**
     * Retourne la durée de la quête.
     *
     * @return La durée de la quête.
     */
    public int getDuree(){ return duree ;}
}