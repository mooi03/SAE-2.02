package model;
import java.util.List;
import java.util.Scanner;
/**
 * La classe Precond représente les préconditions d'une quête, définies par quatre conditions.
 */
public class Precond {
    private int condition0 ;
    private int condition1 ;
    private int condition2 ;
    private int condition3 ;
    /**
     * Constructeur de la classe Precond quicrée les préconditions avec les valeurs.
     *
     * @param cond0 La première condition.
     * @param cond1 La deuxième condition.
     * @param cond2 La troisième condition.
     * @param cond3 La quatrième condition.
     */
    public Precond (int cond0, int cond1 , int cond2 , int cond3 ){
        condition0 = cond0;
        condition1 = cond1 ;
        condition2 = cond2 ;
        condition3 = cond3 ;
    }
    /**
     * Constructeur de la classe Precond qui initialise les précondition avec str.
     *
     * @param str des précondition.
     */
    public Precond (String str) {
        String precond = str ;
        int[] tabprecond = new int[4];
        precond = precond.replace("(", "");
        precond = precond.replace(")", "");
        precond = precond.replace(" ", "");
        Scanner sc = new Scanner(precond).useDelimiter(",");
        int i = 0;
        while (sc.hasNext()) {
            String extrait = sc.next();
            if (!extrait.equals("")){
                tabprecond[i] = Integer.parseInt(extrait);
            }
            i++;
        }
        condition0 = tabprecond [0] ;
        condition1 = tabprecond [1] ;
        condition2 = tabprecond [2] ;
        condition3 = tabprecond [3] ;
    }

    /**
     * Vérifie si les préconditions des quêtes sont remplies en fonction des quêtes déjà terminées.
     *
     * @param listFini liste des quêtes déjà finis
     * @return true si les deux duo de préconditions des quêtes ont au moins une quête réalisée, sinon false
     */
    public boolean estPossible(List<Integer> listFini) {
        int[] duoCond1 = {condition0,condition1} ;
        int[] duoCond2 = {condition2,condition3} ;
        int add1 = condition0 + condition1 ;
        int add2 = condition2 + condition3 ;
        // Pour traiter le cas de la toute première quête
        if (add1 == 0 && add2 == 0){
            return true ;
        }
        // on met a jour la valeur des précondition pour des quêtes déjà faites
        for (Integer e : listFini) {
            for (int i = 0 ; i < 2 ; i++){
                if (duoCond1[i] == e){
                    duoCond1[i] = 0 ;
                }
                if (duoCond2[i] == e){
                    duoCond2[i] = 0 ;
                }
            }
        }
        int nvDuo1 = duoCond1[0]+duoCond1[1] ;
        int nvDuo2 = duoCond2[0]+duoCond2[1] ;
        // Vérifie si les valeurs des duo de précondition a changé (ce qui voudrait dire qu'une des 2 quête est réalisé)
        if ((add1 > nvDuo1 || nvDuo1 == 0) && (add2 > nvDuo2 || nvDuo2 == 0)){
            return true ;
        }
        else {
            return false ;
        }
    }
    /**
     * Retourne une représentation sous forme de str des préconditions.
     *
     * @return Une chaîne de caractères représentant les préconditions.
     */
    public String toString() {
        return "(" + condition0 + ","+ condition1 + ","+ condition2 + ","+ condition3 + ")" ;
    }
    /**
     * Compare les précondition de 2 objets Preconb.
     *
     * @param comparPrecond L'objet Precond à comparer avec this.
     * @return true si les préconditions sont différentes, sinon false.
     */
    public boolean compareTo (Precond comparPrecond) {
        if (this.condition0 == comparPrecond.condition0 || this.condition1 == comparPrecond.condition1 || this.condition2 == comparPrecond.condition2 || this.condition3 == comparPrecond.condition3 ){
            return true ;
        }
        else {
            return false ;
        }
    }
}
