package model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Algo {
    public static void GlouEfficace(String nom_fichier) {
        // On recupère un des scénario présent dans le package scenario, qui possède le même de quand on l'apelle dans la méthode
        File scenario = new File("src" + File.separator + "scenario" + File.separator + nom_fichier);
        List<Quete> quetes = Scan.Lecture(scenario); // toutes les quêtes sont mises dans une liste
        Graphe graphe = new Graphe(quetes); // créer un ditionnaire avec les quêtes en clés et en valeur les préconditions
        Joueur joueur = new Joueur(quetes); // Initialise la position du joueur en 0 0, créer des listes pour les quetes a réalisées et finies et initialise l'exp et le temps
        int xpQueteFin = 0;
        // on cherche le nombre d'exp qui nous faut pour réaliser la quête finale
        for (Quete quete : quetes) {
            if (quete.getNumero() == 0) {
                xpQueteFin = quete.getExperience();
            }
        }
        Boolean continu = true;
        while (continu) {
            TreeMap<Integer, Integer> distance = new TreeMap<>();
            // initialise un dictionnaire avec les quêtes qu'il doit réalisé et leur distance par rapport au joueur
            for (Quete e : joueur.getQueteARealise()) {
                distance.put(e.getNumero(), e.getPos().compareTo(joueur.getCoordonnees())); // on met tout ce que l'on doit mettre dans distance
            }
            // va créer un dictionnaire de toutes les quêtes qui sont réalisable ou non, de cette facon : numeroquete, false ou true
            TreeMap<Integer, Boolean> Possible = graphe.estPossible(joueur.getQueteFini()); // exemple d'une clé du dictionnaire : 4, true
            // va stocker toutes les numéros quêtes impossibles a ce moment
            ArrayList<Integer> memoire = new ArrayList<>();
            for (int x = 0; x < Possible.size(); x++) {
                if (!Possible.get(x)) { // si la clé située a cet indice est false, il ajoute a la mémoire
                    memoire.add(x); // pour l'instant dans meoire il y a que les quetes irréalisables
                }
            }
            for (int e : memoire) {// On supprimes les quêtes de la listes distance qui ne peuvent pas être réalisés pour le moment
                distance.remove(e);
            }
            if (distance.containsKey(0) && (joueur.getChExperience() >= xpQueteFin)) { // si le joueur a les préconditions pour la quête 0 et si il a assez d'exp
                System.out.println(joueur.faireQuete(0)); // on fais la quete finale
                continu = false; // on arrête la boucle
                System.out.println("\n\n----------- bilan fin -----------\n ça a donc pris : " + joueur.getTemps() + "\n il a fait les quetes " + joueur.getQueteFini() + "\n et a gagner " + joueur.getChExperience() + " xp");
            } else { /// si le joueur ne peux pas faire la quête finale car pas assez d'xp ou précondition non remplie
                int memoireChiffre = Integer.MAX_VALUE;
                int memoireNumero = -1;
                distance.remove(0); /// car comme la précondition est pas respectée ou que l'xp est insuffisant, on peut pas faire la quête 0
                for (int e : distance.keySet()) {
                    if (distance.get(e) < memoireChiffre) { /// on choisie la quête la plus proche du joueur
                        memoireNumero = e;
                        memoireChiffre = distance.get(e);
                    }
                }
                System.out.println(joueur.faireQuete(memoireNumero));
            }
        }
    }
}