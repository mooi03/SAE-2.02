package model;
import java.util.Scanner;

public class Precond {
    private int condition0 ;
    private int condition1 ;
    private int condition2 ;
    private int condition3 ;

    public Precond (int cond0, int cond1 , int cond2 , int cond3 ){
        condition0 = cond0;
        condition1 = cond1 ;
        condition2 = cond2 ;
        condition3 = cond3 ;
    }
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

    public String toString() {
        return "(" + condition0 + ","+ condition1 + ","+ condition2 + ","+ condition3 + ")" ;
    }
    /*
    * argument objet de class precond
    * methode compareTo qui compare un objet precond avec this et si this diférrent de l'objet renvoie true sinon false
    * return boolean
    * */
    public boolean compareTo (Precond comparPrecond) {
        if (this.condition0 != comparPrecond.condition0 || this.condition1 != comparPrecond.condition1 || this.condition2 != comparPrecond.condition2 || this.condition3 != comparPrecond.condition3 ){
            return true ;
        }
        else {
            return false ;
        }
    }
}
