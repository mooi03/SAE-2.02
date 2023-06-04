package Test;

import model.Precond;

public class TestPrecond {
    public static void main(String[] args) {
        String[] strTest = {"()", "((2,3),(1,))", "((4,),(5,))", "((2,3),)", "((2,),)", "((8,),(7,4))"};
        Precond[] presondTest = {new Precond(0, 0, 0, 0), new Precond(2, 3, 1, 0), new Precond(4, 0, 5, 0), new Precond(2, 3, 0, 0), new Precond(2, 0, 0, 0), new Precond(8, 0, 7, 4)};
        for (int i = 0 ; i < 6 ; i++ ){
            Precond compPrecond = new Precond(strTest[i]) ;
            System.out.println(compPrecond);
            System.out.println(presondTest[i]);
            if (compPrecond.compareTo(presondTest[i])){
                System.out.println("le cas " + i + " ne marche pas");
            }
            else {
                System.out.println("le cas " + i + " marche bien");
            }
        }
    }
}
