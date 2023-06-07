package vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;

public class ApplicationAlgo extends Application {
    public void start(Stage stage){
        VBox root = new VBoxRoot();
        Scene scene = new Scene(root,1300,380);
        File[] fichierCss = new File("css").listFiles();
        if (fichierCss != null) {
            for (File fichier : fichierCss) {
                scene.getStylesheets().add(fichier.toURI().toString());
            }
        }
        stage.setScene(scene);
        stage.setTitle("SAE exploration algo");
        stage.show();
    }
    public static void main (String [] args) {
        Application.launch(args);
    }
}
