package org.example.kataoptionalstreams.optional;

import java.util.Optional;

public class ChatOptional {
    public static void main(String[] args) {
        System.out.println("========= TEST DES MÉTHODES OPTIONAL =========");

        // 👇 Création d'un Optional contenant une valeur
        Optional<String> nomChat = Optional.ofNullable("Minou");

        // 1. Tester la présence de valeur avec isPresent() + get()
        if (nomChat.isPresent()) {
            System.out.println("[isPresent + get] Le chat est présent : " + nomChat.get());
        }

        // 2. Utiliser ifPresent pour afficher la valeur si elle existe
        nomChat.ifPresent(n -> System.out.println("[ifPresent] Nom du chat : " + n));

        // 3. Fournir une valeur par défaut avec orElse()
        String nom1 = nomChat.orElse("Sans nom");
        System.out.println("[orElse] Résultat : " + nom1);

        // 4. Fournir une valeur générée dynamiquement avec orElseGet()
        String nom2 = nomChat.orElseGet(() -> "Nom par défaut");
        System.out.println("[orElseGet] Résultat : " + nom2);

        // 5. Lancer une exception si la valeur est absente
        try {
            String nom3 = nomChat.orElseThrow(() -> new RuntimeException("Pas de chat !"));
            System.out.println("[orElseThrow] Résultat : " + nom3);
        } catch (Exception e) {
            System.out.println("[orElseThrow] Exception levée : " + e.getMessage());
        }

        // 6. Transformer la valeur présente avec map()
        Optional<Integer> longueur = nomChat.map(String::length);
        System.out.println("[map] Longueur du nom : " + longueur.orElse(0));

        // 7. Déplier un Optional imbriqué avec flatMap()
        Optional<Optional<String>> optOpt = Optional.of(Optional.of("Proxiad"));
        optOpt.flatMap(o -> o).ifPresent(valeur ->
                System.out.println("[flatMap] Valeur imbriquée : " + valeur)
        );

        // 🟢 Résumé des méthodes utilisées
        System.out.println("\n📊 Résumé des méthodes Optional :");
        System.out.println("+-------------------+--------------------------------------------+");
        System.out.println("| Méthode           | Description                                |");
        System.out.println("+-------------------+--------------------------------------------+");
        System.out.println("| isPresent()       | Vérifie si une valeur est présente         |");
        System.out.println("| ifPresent()       | Exécute une action si valeur présente      |");
        System.out.println("| orElse()          | Retourne la valeur ou une valeur par défaut|");
        System.out.println("| orElseGet()       | Exécute un Supplier si vide                |");
        System.out.println("| orElseThrow()     | Lance une exception si vide                |");
        System.out.println("| map()             | Transforme la valeur présente              |");
        System.out.println("| flatMap()         | Déplie un Optional imbriqué                |");
        System.out.println("+-------------------+--------------------------------------------+");

        System.out.println("========= FIN DES TESTS =========");
    }
}
