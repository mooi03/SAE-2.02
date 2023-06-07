package vue;

import controleur.Controleur;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class HBoxConteneur extends HBox {
    ComboBox<String> comboScenario;
    private ScrollPane scrollPane;
    private TextArea textArea;
    public HBoxConteneur() {
        getStyleClass().add("espaces");
        File[] cheminscenario = new File("src/main/java/scenario").listFiles();

        if (cheminscenario != null) {
            String[] listenomscenarios = new String[cheminscenario.length];
            for (int i = 0; i < cheminscenario.length; i++) {
                listenomscenarios[i] = cheminscenario[i].getName();
            }
            comboScenario = peupleComboBox(listenomscenarios);
            comboScenario.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    String selectedScenario = comboScenario.getSelectionModel().getSelectedItem();
                    System.out.println("Scénario sélectionné : " + selectedScenario);
                }
            });


            VBox boxbouton = new VBox();
            Button solefficace = new Button("Solution efficace");
            Button solexhaustive = new Button("Solution exhaustive");
            boxbouton.getChildren().addAll(solefficace,solexhaustive);

            // Créer le ScrollPane et TextArea pour afficher le résultat de la quête
            textArea = new TextArea();
            textArea.setEditable(false);
            scrollPane = new ScrollPane(textArea);
            scrollPane.setFitToWidth(true);

            // Ajouter le ScrollPane à la VBox
            getChildren().addAll(comboScenario, boxbouton);


            solefficace.setOnAction(new Controleur(this));
            solexhaustive.setOnAction(new Controleur(this));
        }
    }
    private ComboBox<String> peupleComboBox(String[] strings) {
        ComboBox<String> comboBox = new ComboBox<>();
        for (String string : strings) {
            comboBox.getItems().add(string);
        }
        return comboBox;
    }
    public String getScenarioChoisi() {
        System.out.println(comboScenario.getSelectionModel().getSelectedItem());
        return comboScenario.getSelectionModel().getSelectedItem();
    }
    public void afficherResultatQuete(String resultatQuete) {
        textArea.setText(resultatQuete);
    }

    public ScrollPane getScrollPane() {
        return scrollPane;
    }

}
