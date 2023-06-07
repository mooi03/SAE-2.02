package controleur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import model.Algo;
import vue.HBoxConteneur;

public class Controleur implements EventHandler<ActionEvent> {
    private HBoxConteneur hboxConteneur;

    public Controleur(HBoxConteneur hboxConteneur) {
        this.hboxConteneur = hboxConteneur;
    }

    @Override
    public void handle(ActionEvent event) {
        String scenarioChoisi = hboxConteneur.getScenarioChoisi();
        if (event.getSource() instanceof Button button) {
            String buttonText = button.getText();

            switch (buttonText) {
                case "Solution efficace":
                    String resultatEfficace = Algo.GlouEfficace(scenarioChoisi);
                    hboxConteneur.afficherResultatQuete(resultatEfficace);
                    break;
                case "Solution exhaustive":
                    String resultatExhaustif = Algo.GlouExhaustive(scenarioChoisi);
                    hboxConteneur.afficherResultatQuete(resultatExhaustif);
                    break;
            }
        }
    }
}
