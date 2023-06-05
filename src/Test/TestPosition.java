package Test;

import model.Position;

public class TestPosition  {
        public static void main(String[] args) {
    // on instancie dans des tableau les valeurs qu'on a renseignées sur le dossier de tests
    int[] x1 = {0,0,0,0,2,2,2,2,2,2,2,2};
    int[] y1 = {0,0,0,0,2,2,2,2,2,2,2,2};
    int[] x2 = {0,1,0,1,1,3,1,3,2,2,1,3};
    int[] y2 = {0,0,1,1,1,3,3,1,3,1,2,2};
    int [] resultatsattendus = {0,1,1,2,2,2,2,2,1,1,1,1};
    // on teste pour le nombre d'indices dans x1 (communs a y1,x2 et y2)
    for (int i = 0; i < x1.length; i++) {
        Position positionactuelle = new Position(x1[i],y1[i]);
        Position positioncompare = new Position(x2[i],y2[i]);
        int resultat = positionactuelle.compareTo(positioncompare);
        if (resultat != resultatsattendus[i]) {
            System.out.println("Il y a une erreur pour le test" + (i + 1));
        }
        else {
            System.out.println("Le test" + (i + 1) + " est bon");
        }
    }
}
}