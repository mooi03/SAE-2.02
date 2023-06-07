import model.Algo;
import model.Precond;

public class Main {
    public static void main(String[] args) {
        Algo nes = new Algo() ;
        System.out.println(nes.GlouExhaustive("scenario_10.txt"));
        System.out.println(nes.GlouEfficace("scenario_10.txt"));
    }
}
