package model;

import java.util.Scanner;
/**
 * La classe Position représente une position avec ses coordonnées en x et y.
 */
public class Position {
    /**
     * Constructeur de la classe Position avec des int.
     *
     * @param x La coordonnée x.
     * @param y La coordonnée y.
     */
    private int chPosX ;
    private int chPosY ;
    public Position(int x, int y) {
        chPosX = x ;
        chPosY = y ;
    }
    /**
     * Constructeur de la classe Position avec un str.
     *
     * @param str La chaîne de caractères représentant la position.
     */
    public Position(String str){
        String totem = str ;
        totem = totem.replace("(", ""); /// on suprime les parentèses et espaces
        totem = totem.replace(")", "");
        totem = totem.replace(" ", "");
        Scanner sc = new Scanner(totem).useDelimiter(","); /// on met en place un scanner qui va nous prendre les deux coordonné une à une
        String extrait = sc.next();
        int pos1 = Integer.parseInt(extrait); /// on transforme la coordonée qui est un str en int
        chPosX = pos1 ;
        extrait = sc.next() ;
        int pos2 = Integer.parseInt(extrait);
        chPosY = pos2 ;
    }
    /**
     * Retourne la coordonnée x de la position.
     *
     * @return La coordonnée x.
     */
    public int getChPosX() {
        return chPosX ;
    }
    /**
     * Retourne la coordonnée y de la position.
     *
     * @return La coordonnée y.
     */
    public int getChPosY() {
        return chPosY ;
    }
    /**
     * change la position.
     *
     * @param x La coordonnée  x.
     * @param y La coordonnée  y.
     */
    public void setPosition (int x , int y){
        chPosX = x ;
        chPosY = y ;
    }
    /**
     * Compare pos avec une autre pos et retourne la différence donc de temps nécessaire.
     *
     * @param comparPos La position à comparer avec this.
     * @return int la différence donc de temps nécessaire..
     */
    public int compareTo(Position comparPos) {
        int diffX = this.chPosX - comparPos.chPosX;
        int diffY = this.chPosY - comparPos.chPosY;
        if (diffX < 0) {
            diffX = -diffX;
        }
        if (diffY < 0) {
            diffY = -diffY;
        }
        int totaltemps = diffX + diffY;
        return totaltemps;
    }
    /**
     * Retourne un String de la position.
     *
     * @return String de la position.
     */
    public String toString() {
        return "(" + chPosX + "--" + chPosY + ")" ;
    }
}
