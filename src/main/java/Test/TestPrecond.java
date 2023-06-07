package Test;
import model.Precond;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


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
    // on arrive pas a improté junit donc voir sur l'autre version pas ihm
    /*
    @Test
    public void TestEstPossible() {
        int w = 14;
        int x = 12;
        int y = 21;
        int z = 17;
        Precond precond1 = new Precond("(0,0,0,0)");
        Precond precond2 = new Precond("(0,0,"+y+",0)");
        Precond precond3 = new Precond("("+w+",0,0,0)");
        Precond precond4 = new Precond("(0,0,"+y+","+z+")");
        Precond precond5 = new Precond("("+w+",0,"+y+",0)");
        Precond precond6 = new Precond("("+w+","+x+",0,0)");
        Precond precond7 = new Precond("("+w+",0,"+y+","+z+")");
        Precond precond8 = new Precond("("+w+","+x+","+y+",0)");
        Precond precond9 = new Precond("("+w+","+x+","+y+","+z+")");

        List<Integer> ListeVide = new ArrayList<>();
        List<Integer> listZ = new ArrayList<>(Arrays.asList(z));
        List<Integer> listY = new ArrayList<>(Arrays.asList(y));
        List<Integer> listYZ = new ArrayList<>(Arrays.asList(y, z));
        List<Integer> listX = new ArrayList<>(Arrays.asList(x));
        List<Integer> listXZ = new ArrayList<>(Arrays.asList(x, z));
        List<Integer> listXY = new ArrayList<>(Arrays.asList(x, y));
        List<Integer> listXYZ = new ArrayList<>(Arrays.asList(x, y, z));
        List<Integer> listW = new ArrayList<>(Arrays.asList(w));
        List<Integer> listWZ = new ArrayList<>(Arrays.asList(w, z));
        List<Integer> listWY = new ArrayList<>(Arrays.asList(w, y));
        List<Integer> listWYZ = new ArrayList<>(Arrays.asList(w, y, z));
        List<Integer> listWX = new ArrayList<>(Arrays.asList(w, x));
        List<Integer> listWXZ = new ArrayList<>(Arrays.asList(w, x, z));
        List<Integer> listWXY = new ArrayList<>(Arrays.asList(w, x, y));
        List<Integer> listWXYZ = new ArrayList<>(Arrays.asList(w, x, y, z));

        //Test Classe1
        assertTrue(precond1.estPossible(ListeVide)); //vide

        //Test Classe2 Y
        assertFalse(precond2.estPossible(ListeVide)); //vide
        assertTrue(precond2.estPossible(listY)); //1 condition

        //Test Classe3 W
        assertFalse(precond3.estPossible(ListeVide)); //vide
        assertTrue(precond3.estPossible(listW)); //1 condition

        // Test Classe4 YZ
        assertFalse(precond4.estPossible(ListeVide)); //vide
        assertTrue(precond4.estPossible(listY)); //1 condition
        assertTrue(precond4.estPossible(listYZ)); //2 conditions

        // Test Classe5 WY
        assertFalse(precond5.estPossible(ListeVide)); //vide
        assertFalse(precond5.estPossible(listW)); //1 condition
        assertFalse(precond5.estPossible(listY)); //1 condition
        assertTrue(precond5.estPossible(listWY)); //2 conditions

        // Test Classe6 WX
        assertFalse(precond6.estPossible(ListeVide)); //vide
        assertTrue(precond6.estPossible(listW)); //1 condition
        assertTrue(precond6.estPossible(listX)); //1 condition
        assertTrue(precond6.estPossible(listWX)); //2 condition

        // Test Classe7 WYZ
        assertFalse(precond7.estPossible(ListeVide)); //vide
        assertFalse(precond7.estPossible(listW)); //1 condition
        assertFalse(precond7.estPossible(listY)); //1 condition
        assertFalse(precond7.estPossible(listZ)); //1 condition
        assertFalse(precond7.estPossible(listYZ)); //2 condition dans le même duo
        assertTrue(precond7.estPossible(listWY)); //2 condition dans des duo differents
        assertTrue(precond7.estPossible(listWZ)); //2 condition dans des duo differents
        assertTrue(precond7.estPossible(listWYZ)); //3 conditions

        // Test Classe9 WXYZ
        assertFalse(precond9.estPossible(ListeVide)); //vide
        assertFalse(precond9.estPossible(listW)); //1 condition
        assertFalse(precond9.estPossible(listX)); //1 condition
        assertFalse(precond9.estPossible(listY)); //1 condition
        assertFalse(precond9.estPossible(listZ)); //1 condition
        assertFalse(precond9.estPossible(listYZ)); //2 condition dans le même duo
        assertFalse(precond9.estPossible(listWX)); //2 condition dans le même duo
        assertTrue(precond9.estPossible(listWY)); //2 condition dans des duo differents
        assertTrue(precond9.estPossible(listWZ)); //2 condition dans des duo differents
        assertTrue(precond9.estPossible(listXZ)); //2 condition dans des duo differents
        assertTrue(precond9.estPossible(listXY)); //2 condition dans des duo differents
        assertTrue(precond9.estPossible(listWYZ)); //3 conditions
        assertTrue(precond9.estPossible(listWXY)); //3 conditions
        assertTrue(precond9.estPossible(listWXZ)); //3 conditions
        assertTrue(precond9.estPossible(listXYZ)); //3 conditions
        assertTrue(precond9.estPossible(listWXYZ)); //4 conditions
    }*/
}