package model;

import java.util.Scanner;

public class Quete {
    private int numero ;
    private Position pos ;
    private Precond precond ;
    private int duree ;
    private int experience ;
    private String intitule ;
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
    public String toString() {
        return numero + "-" + pos + "-" + precond + "-" + duree + "-" + experience + "-" + intitule ;
    }
    public int getNumero() {
        return numero ;
    }
    public Precond getPrecond() {
        return precond ;
    }
    public Position getPos(){return pos ;}
    public int getExperience(){return experience ;}
    public int getDuree(){ return duree ;}
}