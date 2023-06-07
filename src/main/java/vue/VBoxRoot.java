package vue;

import controleur.Controleur;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class VBoxRoot extends VBox {
    private static HBoxConteneur chHboxConteneur;
    private static Controleur chControleur = new Controleur(chHboxConteneur);
    Label labelJour = new Label("SAE algo: niveau 1");
    public VBoxRoot() {
        getStyleClass().add("espaces");
        chHboxConteneur = new HBoxConteneur();
        ScrollPane scrollPane = getChHboxConteneur().getScrollPane();

        getChildren().addAll(labelJour,chHboxConteneur,scrollPane);
    }
    public static Controleur getControleur() {
        return chControleur;
    }

    public static HBoxConteneur getChHboxConteneur() {
        return chHboxConteneur;
    }

}
