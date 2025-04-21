package org.example.kataoptionalstreams.combined;

import java.util.*;

public class ProxiadOptionalStream {
    public static void main(String[] args) {
        System.out.println("========= COMBINER Optional + Stream =========");

        //  Liste d'Optionals simulant des noms (valeurs présentes ou absentes)
        List<Optional<String>> noms = List.of(
                Optional.of("Proxiad"),
                Optional.empty(),
                Optional.of("Chat"),
                Optional.empty()
        );

        //  Traitement avec Stream
        List<String> valides = noms.stream()
                .flatMap(Optional::stream)             //  Supprime les Optionals vides
                .map(String::toUpperCase)              //  Transforme en MAJUSCULES
                .toList();         //  Collecte en List<String>

        //  Affichage
        System.out.println("\n Valeurs extraites et transformées :");
        valides.forEach(nom -> System.out.println("- " + nom));

        // 📊 Résumé des opérations
        System.out.println("\n📊 Résumé des fonctions utilisées (Optional + Stream) :");
        System.out.println("+----------------------+--------------------------------------------+");
        System.out.println("| Méthode              | Description                                |");
        System.out.println("+----------------------+--------------------------------------------+");
        System.out.println("| Optional::stream()   | Supprime automatiquement les vides         |");
        System.out.println("| map(String::toUpperCase) | Transforme chaque nom en majuscules     |");
        System.out.println("| collect(Collectors.toList()) | Regroupe les résultats dans une List |");
        System.out.println("+----------------------+--------------------------------------------+");

        System.out.println("========= FIN DU TRAITEMENT =========");
    }
}
