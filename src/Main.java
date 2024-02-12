import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Tableaux pour les noms et les scores

        int[] tabInt = new int[10];
        String[] tabString = new String[10];

        tabInt[0] = 150;
        tabInt[1] = 50;
        tabInt[2] = 100;
        tabInt[3] = 100;
        tabInt[4] = 75;
        tabInt[5] = 200;
        tabInt[6] = 80;
        tabInt[7] = 130;
        tabInt[8] = 170;
        tabInt[9] = 110;

        tabString[0] = "Belo";
        tabString[1] = "Gigi";
        tabString[2] = "Elie";
        tabString[3] = "Sou";
        tabString[4] = "Vivi";
        tabString[5] = "Paul";
        tabString[6] = "Pierre";
        tabString[7] = "Lionel";
        tabString[8] = "Jacques";
        tabString[9] = "Marcel";


        // Création de l'objet Scanner
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            // Affichage du menu
            System.out.println("\nSélectionner une option");
            System.out.println("1 : Visualiser les scores");
            System.out.println("2 : Modifier tous les scores");
            System.out.println("3 : Modifier un score spécifique");
            System.out.println("4 : Addition");
            System.out.println("5 : Soustraction");
            System.out.println("6 : Quitter");
            System.out.print("Entrez votre choix (1-6): ");

            //choix = scanner.nextInt();


            while (!scanner.hasNextInt()) {
                System.out.println("Entrée non valide. Veuillez entrer un nombre.");
                scanner.next();
                System.out.print("Entrez votre choix (1-6): ");
            }
            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    afficherScores(tabString, tabInt);
                    break;
                case 2:
                    modifierScores(scanner, tabString, tabInt);
                    break;
                case 3:
                    modifierScoreSpecifique(scanner, tabString, tabInt);
                    break;
                case 4:
                    execute(scanner, 1);
                    break;
                case 5:
                    execute(scanner, 2);
                    break;
                case 6:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix non valide. Veuillez réessayer.");
            }
        } while (choix != 6);

        scanner.close();
    }

    private static void afficherScores(String[] noms, int[] scores) {
        System.out.println("\nScores:");
        for (int i = 0; i < noms.length; i++) {
            System.out.printf("%s a un score de %d points.\n", noms[i], scores[i]);
        }
    }

    private static void modifierScores(Scanner scanner, String[] noms, int[] scores) {
        for (int i = 0; i < noms.length; i++) {
            System.out.println("Entrez le score de " + noms[i] + " : ");
            scores[i] = scanner.nextInt();
        }
    }

    private static void modifierScoreSpecifique(Scanner scanner, String[] noms, int[] scores) {


        System.out.println("Entrez le nom pour modifier le score:");
        String nom = scanner.next();
        boolean trouve = false;
        for (int i = 0; i < noms.length; i++) {
            if (noms[i].equalsIgnoreCase(nom)) {  // Je boucle jusqu'à ce qu'un entier soit entré
                System.out.println("Entrez le nouveau score de " + noms[i] + " : ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Entrée non valide. Veuillez entrer un nombre.");
                    scanner.next();
                }
                scores[i] = scanner.nextInt();
                trouve = true;
                break;
            }
        }
        if (!trouve) {
            System.out.println("Nom non trouvé.");
        }
    }
    //private static void execute(Scanner scanner, int operation) {

        // Je demande à l'utilisateur d'entrer le premier nombre
       // System.out.println("Entrez le premier nombre : ");
       // int var1 = scanner.nextInt();

        // Je demande à l'utilisateur d'entrez le deuxième nombre
       // System.out.println("Entrez le deuxième nombre : ");
       // int var2 = scanner.nextInt();

       // switch (operation) {
         //   case 1:
          //      System.out.println("Le résultat de l'addition est : " + (var1 + var2));
          //      break;
          //  case 2:
            //    System.out.println("Le résultat de la soustraction est : " + (var1 - var2));
           //     break;
        //}


   // }

    private static void execute(Scanner scanner, int operation) {

        // Je demande à l'utilisateur d'entrer le premier nombre
        int var1 = lireEntier(scanner, "Entrez le premier nombre : ");

        // Je demande à l'utilisateur d'entrez le deuxième nombre
        int var2 = lireEntier(scanner, "Entrez le deuxième nombre : ");

        switch (operation) {
            case 1:
                System.out.println("Le résultat de l'addition est : " + (var1 + var2));
                break;
            case 2:
                System.out.println("Le résultat de la soustraction est : " + (var1 - var2));
                break;
        }
    }

    private static int lireEntier(Scanner scanner, String message) {
        System.out.println(message);
        while (!scanner.hasNextInt()) {
            System.out.println("Entrée non valide. Veuillez entrer un nombre.");
            scanner.next();
        }
        return scanner.nextInt();
    }



}
