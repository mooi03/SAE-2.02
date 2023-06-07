package model ;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
/**
 * La classe Scan fournit des méthodes pour la lecture de fichiers contenant des quêtes.
 */
public class Scan {
    /**
     * Lit le contenu d'un fichier et retourne une liste de quêtes.
     *
     * @param fichier Le fichier à lire.
     * @return Une liste de quêtes.
     */
    public static List<Quete> Lecture (File fichier) {
        List<Quete> quetes = new ArrayList<>() ;

        try {

            java.util.Scanner scanner = new java.util.Scanner(fichier);

            while (scanner.hasNext ()) {

                Quete quete = new Quete(scanner.nextLine());
                quetes.add(quete) ;
            }
        }

        catch (FileNotFoundException e) {

            System.err.println(e.getMessage());

        }
        return quetes;

    }
}
