package Test;
import model.Algo ;

public class TestAlgo {
    public static void main(String[] args) {
     Algo test = new Algo();
     test.GlouEfficace("scenario_test.txt") ;
     System.out.println("\n\n---------------autre test--------------");
     test.GlouExhaustive("scenario_test.txt");
    }
}
