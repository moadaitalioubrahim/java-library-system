import java.util.ArrayList;
import java.util.Scanner;

// 1. Classe Abstraite (Le concept général)
abstract class Element {
    private String id;
    private String titre;

    public Element(String id, String titre) {
        this.id = id;
        this.titre = titre;
    }

    public String getTitre() { return titre; }
    
    // Méthode abstraite : chaque enfant devra l'implémenter
    public abstract void afficherDetails();
}

// 2. Héritage : Un Livre est un Element
class Livre extends Element {
    private String auteur;

    public Livre(String id, String titre, String auteur) {
        super(id, titre); // Appel du constructeur parent
        this.auteur = auteur;
    }

    @Override
    public void afficherDetails() {
        System.out.println("[Livre] ID: " + getTitre() + " | Titre: " + getTitre() + " | Auteur: " + auteur);
    }
}

// 3. Héritage : Un Magazine est aussi un Element
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

// 4. Classe Principale (Le programme)
public class LibrarySystem {
    // On utilise une ArrayList (comme dans ton cours de Java)
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
            scanner.nextLine(); // Consommer le retour à la ligne

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
                            // Polymorphisme : la bonne méthode afficherDetails() est appelée
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