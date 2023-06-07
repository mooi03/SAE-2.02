package Test;

import model.Graphe;
import model.Position;
import model.Quete;
import model.Scan;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class TestGraphe {
    public static void main(String[] args) {
        File scenario = new File("src" + File.separator + "scenario" + File.separator + "scenario_test.txt");
        List<Quete> quetes = Scan.Lecture(scenario);
        Graphe test = new Graphe(quetes) ;
        ArrayList <Integer> testList = new ArrayList<>() ;
        if ( (!test.estPossible(testList).get(0)) && (test.estPossible(testList).get(1)) && (!test.estPossible(testList).get(2)) && (!test.estPossible(testList).get(3))){
            System.out.println("c'est bon pour 1");
        }
        testList.add(1);
        if ( (!test.estPossible(testList).get(0)) && (test.estPossible(testList).get(1)) && (test.estPossible(testList).get(2)) && (!test.estPossible(testList).get(3))){
            System.out.println("c'est bon pour 2");
        }
        testList.add(2);
        if ( (!test.estPossible(testList).get(0)) && (test.estPossible(testList).get(1)) && (test.estPossible(testList).get(2)) && (test.estPossible(testList).get(3))){
            System.out.println("c'est bon pour 3");
        }
        testList.add(3);
        if ( (test.estPossible(testList).get(0)) && (test.estPossible(testList).get(1)) && (test.estPossible(testList).get(2)) && (test.estPossible(testList).get(3))){
            System.out.println("c'est bon pour 4");
        }
        testList.remove(2);
        if ( (!test.estPossible(testList).get(0)) && (test.estPossible(testList).get(1)) && (test.estPossible(testList).get(2)) && (test.estPossible(testList).get(3))){
            System.out.println("c'est bon pour 5");
        }
    }
}
