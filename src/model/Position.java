package model;

import java.util.Scanner;

public class Position {
    private int chPosX ;
    private int chPosY ;
    public Position(int x, int y) {
        chPosX = x ;
        chPosY = y ;
    }
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
    public int getChPosX() {
        return chPosX ;
    }
    public int getChPosY() {
        return chPosY ;
    }
    public void setPosition (int x , int y){
        chPosX = x ;
        chPosY = y ;
    }
    public int compareTo(Position comparPos) {
        System.out.println("position actuelle :"+this.chPosX+" "+this.chPosY+" doit aller en "+ comparPos.chPosX +" "+ comparPos.chPosY ) ;
        int diffX = this.chPosX - comparPos.chPosX;
        int diffY = this.chPosY - comparPos.chPosY;

        if (diffX < 0) {
            diffX = -diffX;
        }
        if (diffY < 0) {
            diffY = -diffY;
        }
        System.out.println("il a bougé de " + diffX+" cases en X");
        System.out.println("il a bougé de "+diffY+" cases en Y");

        int totaltemps = diffX + diffY;
        return totaltemps;
    }


    public String toString() {
        return "(" + chPosX + "--" + chPosY + ")" ;
    }
}
