import model.Algo;
import model.Precond;

public class Main {
    public static void main(String[] args) {
        Algo nes = new Algo() ;
        nes.GlouExhaustive("scenario_10.txt");
        nes.GlouEfficace("scenario_10.txt");
    }
}
