package org.example.kataoptionalstreams.benchmark;

import java.util.Optional;

public class OrElseVsOrElseGetSimple {
    public static void main(String[] args) {

        System.out.println("===  Valeur présente ===");

        Optional<String> chat = Optional.of("Minou");

        String result1 = chat.orElse(log("orElse (valeur présente)"));
        System.out.println("Résultat orElse     : " + result1);

        String result2 = chat.orElseGet(() -> log("orElseGet (valeur présente)"));
        System.out.println("Résultat orElseGet  : " + result2);

        System.out.println("\n=== ❌ Valeur absente ===");

        Optional<String> chatVide = Optional.empty();

        String result3 = chatVide.orElse(log("orElse (vide)"));
        System.out.println("Résultat orElse     : " + result3);

        String result4 = chatVide.orElseGet(() -> log("orElseGet (vide)"));
        System.out.println("Résultat orElseGet  : " + result4);

        System.out.println("\n ===> Résumé d'exécution :");
        System.out.println("+----------------------+-------------------------+");
        System.out.println("| Méthode              | Appel de getNomParDefaut ?     |");
        System.out.println("+----------------------+-------------------------+");
        System.out.println("| orElse (valeur OK)   | ✅ Oui (inutile)         |");
        System.out.println("| orElseGet (valeur OK)| ❌ Non                  |");
        System.out.println("| orElse (vide)        | ✅ Oui                  |");
        System.out.println("| orElseGet (vide)     | ✅ Oui                  |");
        System.out.println("+----------------------+-------------------------+");
    }

    // Méthode de getNomParDefaut (simule une opération lente)
    public static String log(String message) {
        System.out.println("⚠️ Appel getNomParDefaut depuis : " + message);
        return "Nom par défaut";
    }
}
