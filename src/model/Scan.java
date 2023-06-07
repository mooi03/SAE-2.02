package model ;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Scan {
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
