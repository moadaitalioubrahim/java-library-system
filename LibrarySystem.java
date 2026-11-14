import java.util.ArrayList;
import java.util.Scanner;

abstract class Element {
    private String id;
    private String titre;

    public Element(String id, String titre) {
        this.id = id;
        this.titre = titre;
    }

    public String getTitre() { return titre; }
    
    public abstract void afficherDetails();
}

class Livre extends Element {
    private String auteur;

    public Livre(String id, String titre, String auteur) {
        super(id, titre); 
        this.auteur = auteur;
    }

    @Override
    public void afficherDetails() {
        System.out.println("[Livre] ID: " + getTitre() + " | Titre: " + getTitre() + " | Auteur: " + auteur);
    }
}

class Magazine extends Element {
    private int numero;

    public Magazine(String id, String titre, int numero) {
        super(id, titre);
        this.numero = numero;
    }

    @Override
    public void afficherDetails() {
        System.out.println("[Magazine] Titre: " + getTitre() + " | Numéro: " + numero);
    }
}

public class LibrarySystem {
    private static ArrayList<Element> bibliotheque = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("📚 Bienvenue dans le Système de Gestion de Bibliothèque !");

        while (running) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Ajouter un Livre");
            System.out.println("2. Ajouter un Magazine");
            System.out.println("3. Afficher tout le catalogue");
            System.out.println("4. Quitter");
            System.out.print("Votre choix : ");

            int choix = scanner.nextInt();
            scanner.nextLine(); 

            switch (choix) {
                case 1:
                    System.out.print("Entrez le titre du livre : ");
                    String titreLivre = scanner.nextLine();
                    System.out.print("Entrez l'auteur : ");
                    String auteur = scanner.nextLine();
                    bibliotheque.add(new Livre("L" + bibliotheque.size(), titreLivre, auteur));
                    System.out.println("✅ Livre ajouté !");
                    break;
                case 2:
                    System.out.print("Entrez le titre du magazine : ");
                    String titreMag = scanner.nextLine();
                    System.out.print("Entrez le numéro : ");
                    int numero = scanner.nextInt();
                    bibliotheque.add(new Magazine("M" + bibliotheque.size(), titreMag, numero));
                    System.out.println("✅ Magazine ajouté !");
                    break;
                case 3:
                    System.out.println("\n--- CATALOGUE ---");
                    if (bibliotheque.isEmpty()) {
                        System.out.println("La bibliothèque est vide.");
                    } else {
                        for (Element e : bibliotheque) {
                            e.afficherDetails();
                        }
                    }
                    break;
                case 4:
                    running = false;
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide.");
            }
        }
        scanner.close();
    }
}
