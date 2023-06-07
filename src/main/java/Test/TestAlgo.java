package Test;

import model.Algo;

public class TestAlgo {
    public static void main(String[] args) {
     Algo test = new Algo();
     System.out.println(test.GlouEfficace("scenario_test.txt"));
     System.out.println("\n\n---------------autre test--------------");
     System.out.println(test.GlouExhaustive("scenario_test.txt"));
    }
}
